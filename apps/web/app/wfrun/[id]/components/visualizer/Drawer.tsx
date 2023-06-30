import React from 'react';
import { Button } from "ui"

export const Drawer = ({output, thread, data, properties, onToggleSideBar}:any) => {
    
    return <div className="drawer">

        <h2 style={{
            paddingBottom:'8px',
            paddingTop:'8px',
            fontSize:"20px"
        }} >WfSpec Properties</h2>
        <div className="frame">
            <label>THREADSPEC</label>
            <div className="input">{data?.entrypointThreadName}</div>

            {output ? <div >
                <label>TYPE</label>
                <div className="input">{output.type}</div>
            </div> : undefined}

        </div>

        <div className="table">
            <table>
                <caption>ThreadSpec Variables</caption>
                <thead>
                    <tr>
                        <th>NAME</th>
                        <th>TYPE</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>A</td>
                        <td>B</td>
                    </tr>
                    <tr>
                        <td>A</td>
                        <td>B</td>
                    </tr>
                </tbody>
            </table>
            
        </div>
        {
            properties && properties.failures.length > 0 && <div className="table">
                    <table>
                        <caption>Failures</caption>
                        <thead>
                            <tr>
                                <th>NAME</th>
                                <th>MESSAGE</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                properties.failures.map((failItem, index) => <React.Fragment>
                                    <tr key={`${failItem.failureCode}-${index}`}>
                                        <td>{failItem.failureName}</td>
                                        <td className="message">{failItem.message}</td>
                                    </tr>
                                    <tr>
                                        <td className='th' colSpan={2}>OUTPUT</td>
                                    </tr>
                                    <tr>
                                        <td colSpan={2}>
                                            <Button className='color-primary' onClick={(e) => {e
                                                e.preventDefault();
                                                onToggleSideBar(true)
                                            }}>Exception Log</Button>
                                        </td>
                                    </tr>
                                    </React.Fragment>)
                            }
                        </tbody>
                    </table>
                </div>
        }
    </div>
}