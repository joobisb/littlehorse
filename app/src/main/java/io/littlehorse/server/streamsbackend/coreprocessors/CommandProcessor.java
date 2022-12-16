package io.littlehorse.server.streamsbackend.coreprocessors;

import io.littlehorse.common.LHConfig;
import io.littlehorse.common.model.LHSerializable;
import io.littlehorse.common.model.command.Command;
import io.littlehorse.server.streamsbackend.taskqueue.GodzillaTaskQueueManager;
import java.time.Duration;
import org.apache.kafka.streams.processor.PunctuationType;
import org.apache.kafka.streams.processor.api.Processor;
import org.apache.kafka.streams.processor.api.ProcessorContext;
import org.apache.kafka.streams.processor.api.Record;

public class CommandProcessor
    implements Processor<String, Command, String, CommandProcessorOutput> {

    private ProcessorContext<String, CommandProcessorOutput> ctx;
    private CommandProcessorDaoImpl dao;
    private LHConfig config;
    private GodzillaTaskQueueManager godzilla;

    public CommandProcessor(LHConfig config, GodzillaTaskQueueManager godzilla) {
        this.config = config;
        this.godzilla = godzilla;
    }

    @Override
    public void init(final ProcessorContext<String, CommandProcessorOutput> ctx) {
        this.ctx = ctx;
        dao = new CommandProcessorDaoImpl(this.ctx, config, godzilla);
        ctx.schedule(
            Duration.ofMillis(100),
            PunctuationType.WALL_CLOCK_TIME,
            dao::broadcastChanges
        );
        ctx.schedule(
            Duration.ofSeconds(60),
            PunctuationType.WALL_CLOCK_TIME,
            dao::clearOldResponses
        );
    }

    @Override
    public void process(final Record<String, Command> commandRecord) {
        try {
            Command command = commandRecord.value();
            dao.setCommand(command);
            LHSerializable<?> response = command.process(dao, config);
            if (command.hasResponse() && command.commandId != null) {
                dao.saveResponse(response, command);
            }
            dao.commitChanges();
        } catch (Exception exn) {
            exn.printStackTrace();
            dao.abortChanges();
            // Should we have a DLQ? I don't think that makes sense...the internals
            // of a database like Postgres don't have a DQL for their WAL.
        }
    }
}
