package io.littlehorse.worker;

import java.time.Duration;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import io.littlehorse.common.LHConfig;
import io.littlehorse.common.model.event.TaskCompletedEvent;
import io.littlehorse.common.model.event.TaskScheduleRequest;
import io.littlehorse.common.model.event.TaskStartedEvent;
import io.littlehorse.common.model.event.WfRunEvent;
import io.littlehorse.common.proto.scheduler.WfRunEventPb.EventCase;
import io.littlehorse.common.util.LHProducer;
import io.littlehorse.common.util.LHUtil;
import io.littlehorse.scheduler.serde.TaskScheduleRequestDeserializer;

/**
 * This is a shortcut, obviously.
 */
public class TestWorker {
    private KafkaConsumer<String, TaskScheduleRequest> cons;
    private LHProducer prod;
    private ExecutorService threadPool;

    public TestWorker(LHConfig config) {
        this.prod = config.getProducer();
        this.cons = config.getKafkaConsumer(
            TaskScheduleRequestDeserializer.class
        );
        // this.cons.subscribe(Arrays.asList(
        //     "task1", "task2", "task3", "task4", "task5", "task6", "task7",
        //     "task8", "task9", "task10"
        // ));
        // this.cons.subscribe(Arrays.asList("task1"));
        this.cons.subscribe(Arrays.asList(
            System.getenv().getOrDefault("LHORSE_TASK_DEF_ID", "task1")
        ));
        this.threadPool = Executors.newFixedThreadPool(32);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            this.prod.close();
            this.cons.close();
            this.threadPool.shutdown();
        }));
    }

    public void run() {
        while(true) {
            ConsumerRecords<String, TaskScheduleRequest> records = cons.poll(
                Duration.ofMillis(50));
            records.forEach(this::processRequest);
        }
    }

    private void processRequest(ConsumerRecord<String, TaskScheduleRequest> r) {
        LHUtil.log("Processing for " + r.key() + " part " + r.partition());
        TaskScheduleRequest tsr = r.value();

        TaskStartedEvent se = new TaskStartedEvent();
        se.taskRunNumber = tsr.taskRunNumber;
        se.taskRunPosition = tsr.taskRunPosition;
        se.threadRunNumber = tsr.threadRunNumber;
        se.time = new Date();

        WfRunEvent event = new WfRunEvent();
        event.wfRunId = tsr.wfRunId;
        event.wfSpecId = tsr.wfSpecId;
        event.time = se.time;
        event.startedEvent = se;
        event.type = EventCase.STARTED_EVENT;

        prod.send(tsr.wfRunId, event, tsr.replyKafkaTopic);

        this.threadPool.submit(() -> { this.herdCats(tsr);});
    }

    private void herdCats(TaskScheduleRequest tsr) {
        TaskCompletedEvent ce = new TaskCompletedEvent();
        ce.taskRunNumber = tsr.taskRunNumber;
        ce.taskRunPosition = tsr.taskRunPosition;
        ce.threadRunNumber = tsr.threadRunNumber;
        ce.time = new Date();

        ce.success = true;
        ce.stderr = null;
        ce.stdout = ("Completed task " + tsr.taskDefName + " " + tsr.wfRunId)
            .getBytes();

        WfRunEvent event = new WfRunEvent();
        event.wfRunId = tsr.wfRunId;
        event.wfSpecId = tsr.wfSpecId;
        event.time = ce.time;
        event.completedEvent = ce;
        event.type = EventCase.COMPLETED_EVENT;

        LHUtil.log("Completing " + tsr.wfRunId);
        prod.send(tsr.wfRunId, event, tsr.replyKafkaTopic);
    }

    public static void doMain(LHConfig config) {
        TestWorker worker = new TestWorker(config);
        worker.run();
    }
}
