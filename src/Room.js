import React, { Component } from 'react';
import Axios from 'axios';


class Room extends Component {
    render() {
        const {roomArray} = this.props.match.params
        return(
            <div>
          <p>لیست اتاق‌های خالی</p>
        { roomArray &&roomArray.map(item=><option value="Ford">{item}</option>)}
          </div>
        );
    }
}

export default Room;