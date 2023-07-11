import Link from 'next/link'
import React from 'react'
import Breadcrumbs from '../../../../components/Breadcrumbs'
import { WfRunVisualization } from './sections/WfRunVisualization'
import WfSpec from '../../../wfspec/[id]/[version]/page'

const WfRun = ({ params }: { params: { wfspec: string; id: string } }) => {
	return (
		<>
			<h1>
				<span className='lighter'>WfRun</span> <span className='line'>|</span>{' '}
				{params.id.charAt(0).toUpperCase() + params.id.slice(1)}{' '}
			</h1>

			<Breadcrumbs
				pwd={[
					{
						title: 'Cluster Overview',
						href: '/'
					},
					{
						title: `WfRun: ${
							params.id.charAt(0).toUpperCase() + params.id.slice(1)
						}`,
						active: true
					}
				]}
			/>

			<WfRunVisualization id={params.id} wfspec={params.wfspec} />
		</>
	)
}
export default WfRun
