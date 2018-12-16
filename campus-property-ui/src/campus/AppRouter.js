import React from "react";
import RequestListForm from "./request/RequestListForm";
import LoginForm from "./security/LoginForm";
import { Route, Switch } from "react-router";
import AdminCreateForm from "./security/AdminCreateForm";
import WorkerAccountForm from "./admin/WorkerAccountForm";
import HomeForm from "./HomeForm";
import CreateRequestForm from "./request/CreateRequestForm";
import AccountantRequestListForm from "./accountant/AccountantRequestListForm";
import AccountantAccountForm from "./accountant/AccountantAccountForm";

const AppRouter = () => {
  return (
    <Switch>
      <Route exact path="/" component={HomeForm} />
      <Route exact path="/admin/create" component={AdminCreateForm} />
      <Route exact path="/request/list" component={RequestListForm} />
      <Route exact path="/request/create" component={CreateRequestForm} />
      <Route exact path="/login" component={LoginForm} />
      <Route exact path="/admin/create/account" component={WorkerAccountForm} />
      <Route exact path="/accountant" component={AccountantAccountForm} />
      <Route exact path="/accountant/request/list" component={AccountantRequestListForm} />
    </Switch>
  );
};
export default AppRouter;
