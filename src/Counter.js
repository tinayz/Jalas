import React, { Component } from 'react';
 
class Counter extends Component {
 
    constructor() {
        super();
        this.state = {
            count: 0
        }
    }

    
 
    increment() {
        console.log("salam",this.state.count)
        this.setState({count: this.state.count + 1});
    }
 
    decrement() {
        console.log("salam",this.state.count)
        this.setState({count: this.state.count - 1});
    }
 
    render() {
        return (
            <div className="Counter">
              <p>
                <button onClick={() => this.increment()}>Agree</button>
                Count: {this.state.count}
                
                <button onClick={() => this.decrement()}>Disagree</button>
              </p>
            </div>
             
        );
    }
 
}
 
export default Counter;