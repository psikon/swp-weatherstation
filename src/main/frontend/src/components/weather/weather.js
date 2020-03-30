import React from 'react';
import './weather.css';


const weather = (props) =>  {


    if (props.weather) {
        return (
            <div className="weather">
                 <div className="weather__icon">
                    <img src={`http://openweathermap.org/img/wn/${props.weather.icon}.png`} alt={props.weather.description}/>
                    <p>{props.weather.description}</p>
                </div>
                <div className="weather_text">
                    <h1 className="weather__title">{props.weather.name}, {props.weather.country}</h1>
                    <h2 className="weather__subtitle">({props.weather.latitude}, {props.weather.longitude})</h2>
                    <div className="weather__info">
                    
                        <div className="weather__temperature">
                            <p>Current: {props.weather.currentTemperature}°C</p>
                            <p>Min: {props.weather.tempMin}°C</p>
                            <p>Max: {props.weather.tempMax}°C</p>
                        </div>
                        <div className="weather__wind">
                            <p>Speed: {props.weather.speed}km/h</p>
                            <p>Deg: {props.weather.deg}°</p>
                        </div>
                    </div>
                </div>
               
            </div>
        )
    } 
    return null;
}

export default weather;