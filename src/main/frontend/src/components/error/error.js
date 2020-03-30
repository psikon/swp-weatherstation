import React from 'react';
import './error.css';

const error = (props) => {

    return (
        <div className ="error">
            <h2>{props.message}</h2>
        </div>
    )
}

export default error;