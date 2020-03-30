import React from 'react';
import "./weatherInput.css";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faSearch } from '@fortawesome/free-solid-svg-icons'

const weatherInput = (props) => {

    const handleKeyPress = (event) => {
        if (event.key === 'Enter') {
            props.searchHandler();
        }
    }

    return (
        <div className="weatherInput">
            <input className="weatherInput__text" type="text" onChange={props.inputChanged} onKeyPress={handleKeyPress}/>
            <button className="weatherInput__button" type="submit" onClick={props.searchHandler}><FontAwesomeIcon icon={faSearch} /></button>
        </div>
    )
}

export default weatherInput;