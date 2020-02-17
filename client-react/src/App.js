import React, { Component } from 'react';
import { HashRouter as Router, Route, Link, NavLink } from 'react-router-dom';
import SignUpForm from './components/SignUpForm';
import SignInForm from './components/SignInForm';

import './App.css';

class App extends Component {
  constructor(props){
    super(props);
    this.state = {token: "", email: "", password: "", values: [], error: ""};
  }
  
  onSignIn = () => {
    fetch("http://localhost:8080/signIn", //Check with Kamal about this routing!
     {headers: {'Accept': 'application/json', 'Content-type': 'application/json'},
    method: "POST",
    body: JSON.stringify({email: this.state.email, password: this.state.password})
    }).then(
      res => res.headers.get("authorization")
    ).then(
      token => {
      if(token){
        this.setState({ ...this.state, token: token});
      }else{
        this.setState({ ...this.state, error: "Unable to sign in using that email and password"});
      }
    });


    //Temporary test block
    if(this.state.token != ""){
      console.log("sign in success");
    }else{
      console.log("sign in failed");
    }
  }

  onSignUp = () =>{
    fetch("http://localhost:8080/signUp")
  }

  //Get email value from user when changed
  onEmailChange = (e) => this.setState({...this.state, email: e.target.value});

  //Get password value from user when changed
  onPasswordChange = (e) => this.setState({ ...this.state, password: e.target.value});


  onGetValues = () => {
    fetch("values url", {
      headers: {'Authorization' : this.state.token}
    }).then(
      res => res.json()
    ).then(
      json => this.setState({...this.state, values: json})
    );
  }

  render() {
    return (
      <Router basename="/react-auth-ui/">
        <div className="App">
          <div className="App__Aside"></div>
          <div className="App__Form">
            <div className="PageSwitcher">
                <NavLink to="/sign-in" activeClassName="PageSwitcher__Item--Active" className="PageSwitcher__Item">Sign In</NavLink>
                <NavLink exact to="/" activeClassName="PageSwitcher__Item--Active" className="PageSwitcher__Item">Sign Up</NavLink>
              </div>

              <div className="FormTitle">
                  <NavLink to="/sign-in" activeClassName="FormTitle__Link--Active" className="FormTitle__Link">Sign In</NavLink> or <NavLink exact to="/" activeClassName="FormTitle__Link--Active" className="FormTitle__Link">Sign Up</NavLink>
              </div>

              <Route exact path="/" component={SignUpForm}>
              </Route>
              <Route path="/sign-in" component={SignInForm}>
              </Route>
          </div>

        </div>
      </Router>
    );
  }
}

export default App;
