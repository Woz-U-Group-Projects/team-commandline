import React from 'react';
import './App.css';
import Nav from './components/Nav';
import Post from './components/Post';
import {BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import PostForm from './components/PostForm';
function App() {
  return (
    <Router>
    <div className="App">
      <Nav />
      <Switch>
      <Route path="/" exact component={Home}/>
      <Route path="/Post" component={Post}/>
      <Route path="/PostForm" component={PostForm}/>
      </Switch>
    </div>
    </Router>
  ); 
}

const Home = () => (
  <div>
    <h1>Home Page</h1>
  </div>
)

export default App;