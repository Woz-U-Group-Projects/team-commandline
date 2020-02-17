import React, { Component } from "react";
import { BrowserRouter as Router } from "react-router-dom";
import { connect } from "react-redux";
import BaseRouter from "./routes";
import * as actions from "./store/actions/auth";
import "semantic-ui-css/semantic.min.css";
import CustomLayout from "./containers/Layout";

class App extends Component {
<<<<<<< HEAD
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
=======
  componentDidMount() {
    this.props.onTryAutoSignup();
>>>>>>> be97f9303695865ad74a84dd91a303594d0ab5ec
  }

  render() {
    return (
      <Router>
        <CustomLayout {...this.props}>
          <BaseRouter />
        </CustomLayout>
      </Router>
    );
  }
}

const mapStateToProps = state => {
  return {
    isAuthenticated: state.auth.token !== null
  };
};

const mapDispatchToProps = dispatch => {
  return {
    onTryAutoSignup: () => dispatch(actions.authCheckState())
  };
};

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(App);
