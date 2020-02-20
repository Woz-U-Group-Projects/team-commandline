import React from "react";
import { Route } from "react-router-dom";
import Hoc from "./hoc/hoc";

import Login from "./containers/Login";
import Signup from "./containers/Signup";
import HomepageLayout from "./containers/Home";
import BlogList from "./containers/BlogList";
import PostForm from "./containers/PostForm";


const BaseRouter = () => (
  <Hoc>
    <Route exact path="/bloglist" component={BlogList} />
    <Route path="/login" component={Login} />
    <Route path="/signup" component={Signup} />
    <Route path="/postform" component={PostForm} />
    <Route exact path="/" component={HomepageLayout} />
  </Hoc>
);

export default BaseRouter;
