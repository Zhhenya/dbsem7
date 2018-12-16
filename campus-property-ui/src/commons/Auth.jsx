import React from "react";
import { observer } from "mobx-react";
import { withRouter } from "react-router-dom";
import state from "./stateProvider";
import LoginForm from "../campus/security/LoginForm";
import * as request from "./request";

const fetchLoggedInUser = () => {
  request.get("/loggedIn").then(user => {
    state.user = user;
    console.log(user);
  });
};

const Auth = ({ children }) => {
  if (!state.user && state.authorized) {
    fetchLoggedInUser();
    return null;
  }
  return state.authorized ? children : <LoginForm />;
};

export default withRouter(observer(Auth));
