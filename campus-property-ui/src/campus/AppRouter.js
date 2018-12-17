import React from "react";
import RequestListForm from "./request/RequestListForm";
import LoginForm from "./security/LoginForm";
import { Route, Switch } from "react-router";
import AdminCreateForm from "./security/AdminCreateForm";
import WorkerAccountForm from "./admin/WorkerAccountForm";
import HomeForm from "./HomeForm";
import { CreateRequestForm } from "./worker";
import { AccountantInventoryForm, AccountantLetterForm, AccountantRequestListForm } from "./accountant";
import InventoryListForm from "./inventory/InventoryListForm";
import ObjectPropertyForm from "./objectProperty/ObjectPropertyForm";
import { OfficerRequestListForm } from "./officer";

const AppRouter = () => {
  return (
    <Switch>
      <Route exact path="/" component={HomeForm} />
      <Route exact path="/admin/create" component={AdminCreateForm} />
      <Route exact path="/request/list" component={RequestListForm} />
      <Route exact path="/objectProperty" component={ObjectPropertyForm} />
      <Route exact path="/request/create" component={CreateRequestForm} />
      <Route exact path="/login" component={LoginForm} />
      <Route exact path="/inventory/list" component={InventoryListForm} />
      <Route exact path="/admin/create/account" component={WorkerAccountForm} />
      <Route
        exact
        path="/officer/request/list"
        component={OfficerRequestListForm}
      />
      <Route
        exact
        path="/accountant/request/list"
        component={AccountantRequestListForm}
      />
      <Route
        exact
        path="/accountant/inventory"
        component={AccountantInventoryForm}
      />
      <Route exact path="/accountant/letter" component={AccountantLetterForm} />
    </Switch>
  );
};
export default AppRouter;
