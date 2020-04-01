import React, { Component } from 'react';
import axios from 'axios';

import Weather from './components/weather/weather';
import WeatherInput from './components/weatherInput/weatherInput'
import History from './components/history/history';
import Error from './components/error/error';
import './App.css';

class App extends Component {

  state = {
    location: "",
    history: "",
    icon: null,
    weatherData: null,
    historyData: null, 
    error: "",
  }

  handleSearch= (event) => {
    let input = event.target.value;
    this.setState({
      location : input,
    })
  }

  searchLocationHandler = () => {
    axios.get(`http://localhost:8080/search/${this.state.location}`)
      .then(res => {
        const data = res.data;
        this.setState({ 
          weatherData: data,
          error: null });
      }).catch(err => {
        this.setState({
          error: "Location not found",
          weatherData: null,
          historyData: null
      })
      })

    axios.get(`http://localhost:8080/history/${this.state.location}`)
      .then(res => {
        const historyData = res.data;
        this.setState({ historyData });
      });
  }

  render () {

    return(
      <div className="App">
        <header className="main-header">
          <div className="main-header__brand">
            <p >SWP-4</p>
          </div>
        </header>
        <section id="search">
          <div className="search">
            <h2>WeatherStation</h2>
            <WeatherInput 
              inputChanged={this.handleSearch}
              searchHandler={this.searchLocationHandler}/>
            <div className="searchResult">
              {this.state.weatherData ? <Weather weather={this.state.weatherData}/> : null}       
              {this.state.error ? <Error message={this.state.error} /> : null}
            </div>
          </div>
        </section>
        <section id="history">
          {this.state.historyData ? <History history={this.state.historyData} /> : null}
        </section>
  </div>);
  }
   
}

export default App;
