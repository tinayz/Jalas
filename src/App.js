import axios from 'axios';
import React, { Component } from 'react';
import logo from './logo.svg';
import ReactDOM from 'react-dom';
import Counter from './Counter';
import Room from './Room';
import {BrowserRouter as Router ,Route,Link,Switch} from 'react-router-dom';
import Dashboard from './Dashboard'
import './App.css';

const url =" ";


class App extends React.Component {


  render() {
    return (
        <Router>
        <Switch>
            <Route path="/room" component={Room}/>
            <Route path="/" component={Dashboard}/>

            </Switch>
        </Router>
    );
  }
}

export default App;

