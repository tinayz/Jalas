import axios from 'axios';
import React, { Component } from 'react';
import logo from './logo.svg';
import ReactDOM from 'react-dom';
import Counter from './Counter';
import Room from './Room';
import {BrowserRouter as Router ,Route,Link} from 'react-router-dom';
import './App.css';

const url =" ";


class Dashboard extends React.Component {
  constructor() {
    super();
    this.state = {
        roomArray: []
    }
}

  fetchRequest = ()=>{
    // fetch('')
    // .then(res => res.json())
    // .then(
    //   (result)=>{
    //     this.setState({
    //       roomArray: result.items
    //     });
    //   },
    //   (error) => {
    //     console.log(error)
    //     this.setState({
    //       error
    //     });
    //   }
    // )
    this.setState({roomArray:['otagh1', 'otagh2', 'otagh400', 'otagh403']})
  }

  render() {
    return (
      <form className="vote-form">
        <Router>
        <h1>MeetingName</h1>
        <div onClick="fetchRequest()">
        <li><p>Option1: <Link to= "/room" params={{roomArray:this.state.roomArray}}> Wednesday 98.09.10 15:30-16:30 </Link></p>
        <Route path='/room' component={Room} /></li>
        </div>
        <div><Counter /></div>
        <div onClick="fetchRequest()" params={{roomArray:this.state.roomArray}}>
        <li><p>Option2: <Link to= "/room" >Saturday  98.09.13 14:30-15:30</Link></p>
        <Route path='/room' component={Room} /></li>
        </div>
        <div><Counter /></div>
        <div onClick="fetchRequest()" params={{roomArray:this.state.roomArray}}>
        <li><p>Option3: <Link to= "/room">Sunday    98.09.14 12:00-14:00</Link></p>
        <Route path='/room' component={Room} /></li>
        </div>
        <div><Counter /></div>
        </Router>
      </form>
    );
  }
}

export default Dashboard;

