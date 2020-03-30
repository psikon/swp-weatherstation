import React from 'react';

import Temperature from './charts/temperature';
import Wind from './charts/wind';
import './history.css';

const history = (props) => {

    if (props.history) {
        return (
          <div className="history__charts">
            <Temperature label="Temperature" data={props.history} />
            <Wind label="Wind" data={props.history} />
          </div>
        )
      }
      return null;
}

export default history;