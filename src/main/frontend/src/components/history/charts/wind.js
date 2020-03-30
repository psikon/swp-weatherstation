import React from 'react'
import { LineChart, Line, XAxis, YAxis, Tooltip, CartesianGrid, Label } from 'recharts';
import CustomizedAxisTick from './CustomAxisTicks';

const wind = (props) => {
    return ( 
        <div className="charts">    
            <h3>{props.label}</h3>
            <LineChart
                width={500} height={450} data={props.data}
                margin={{ top: 20, right: 20, bottom: 40, left: 20 }}>
                <XAxis dataKey={(x) => {
                    return new Date(x.time * 1000).toLocaleDateString();
                }} tick={<CustomizedAxisTick/>} />
                <YAxis type="number">
                    <Label value="km/h" position="insideTopLeft" />
                </YAxis>
                <Tooltip />
                <CartesianGrid stroke="#f5f5f5" />
                <Line type="monotoneX" name="Speed" dataKey="speed" stroke="#0000ff" />
            </LineChart>
        </div>)
}

export default wind;