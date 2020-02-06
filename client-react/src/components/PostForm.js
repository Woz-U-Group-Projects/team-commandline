import React, { Component } from 'react';
import { Link } from 'react-router-dom';

class PostForm extends React.Component {
    constructor(props) {
      super(props);
      // Set placeholder
      this.state = {
        value: '',
        contact: '',
        data = ''
      };
      // submit handling
      this.handleChange = this.handleChange.bind(this);
      this.handleSubmit = this.handleSubmit.bind(this);
    }
  
    handleChange(event) {
      this.setState({value: event.target.value});
    }
    
    handleSubmit(event) {
      alert('An Post was submitted: ' + this.state.value);
      event.preventDefault();
    }
  
    render() {
      return (
        <div className="FormCenter">
            <form onSubmit={this.handleSubmit} className="FormFields">
              <div className="FormField">
                <label className="FormField__Label" htmlFor="name">Title</label>
                <input type="text" id="value" className="FormField__Input" placeholder="Enter your Title" name="name" value={this.state.name} onChange={this.handleChange} />
              </div>
              <div className="FormField">
                <label className="FormField__Label" htmlFor="password">Password</label>
                <input type="text" id="name" className="FormField__Input" placeholder="Enter Author" name="name" value={this.state.name} onChange={this.handleChange} />
              </div>
              <div className="FormField">
                <label className="FormField__Label" htmlFor="email">E-Mail Address</label>
                <input type="email" id="contact" className="FormField__Input" placeholder="Enter your email" name="email" value={this.state.email} onChange={this.handleChange} />
              </div>

              <div className="FormField">
                  <button className="FormField__Button mr-20">Sign Up</button> <Link to="/sign-in" className="FormField__Link">I'm already member</Link>
              </div>
            </form>
          </div>
      );
    }
  }

  export default PostForm;