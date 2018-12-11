import React from "react";
import RequestListForm from "./request/RequestListForm";
import LoginForm from "./security/LoginForm";
import { Route, Switch } from "react-router";

const AppRouter = () => {
  return(
    <Switch>
      <Route path='/request/list' component={RequestListForm}/>
      <Route path='/login' component={LoginForm}/>
    </Switch>
  );
};
export default AppRouter;