import React from "react";
import RequestListForm from "./request/RequestListForm";
import LoginForm from "./security/LoginForm";
import { Route, Switch } from "react-router";
import AdminCreateForm from "./security/AdminCreateForm";
import WorkerAccountForm from "./admin/WorkerAccountForm";

const AppRouter = () => {
  return (
    <Switch>
      <Route exact path="/admin/create" component={AdminCreateForm} />
      <Route exact path="/request/list" component={RequestListForm} />
      <Route exact path="/login" component={LoginForm} />
      <Route exact path="/admin/create/account" component={WorkerAccountForm} />
    </Switch>
  );
};
export default AppRouter;
