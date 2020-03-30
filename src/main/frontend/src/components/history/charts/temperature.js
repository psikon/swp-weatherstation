import React from 'react'
import { LineChart, Line, XAxis, YAxis, Tooltip, CartesianGrid, Label } from 'recharts';
import CustomizedAxisTick from './CustomAxisTicks';

const temperature = (props) => {

    return ( 
        <div className="charts">
            <h3>{props.label}</h3>
                <LineChart
                    width={500} height={400}
                    data={props.data}
                    margin={{ top: 20, right: 20, bottom: 40, left: 20 }}>
                    <XAxis dataKey={(x) => {
                        return new Date(x.time * 1000).toLocaleDateString();
                    }} tick={<CustomizedAxisTick/>} />
                    <YAxis type="number" >
                        <Label value="°C" position="insideTopLeft"/>
                    </YAxis>
                    <Tooltip />
                    <CartesianGrid stroke="#f5f5f5" />
                    <Line type="monotoneX" name="Current"dataKey="currentTemperature" stroke="#00bfa0" />
                    <Line type="monotoneX" name="Min" dataKey="tempMin" stroke="#00b0f0" />
                    <Line type="monotoneX" name="Max" dataKey="tempMax" stroke="#ff1744" />
                </LineChart>
        </div>);
}

export default temperature;