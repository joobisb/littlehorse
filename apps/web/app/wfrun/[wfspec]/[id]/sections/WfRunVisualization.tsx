import { Button, Label } from 'ui'
import { WfRunVisualizer } from '../components/visualizer/WfRunVisualizer'

export const WfRunVisualization = ({ wfspec, id }: any) => {
	return (
		<section>
			<div className='between'>
				<h2>WfRun visualization</h2>
			</div>

			<WfRunVisualizer id={id} wfspec={wfspec} />
		</section>
	)
}
