import React from "react";
import RequestListForm from "./request/RequestListForm";
import LoginForm from "./security/LoginForm";
import { Route, Switch } from "react-router";
import AdminCreateForm from "./security/AdminCreateForm";
import WorkerAccountForm from "./admin/WorkerAccountForm";
import HomeForm from "./HomeForm";
import { CreateRequestForm } from "./worker";
import { AccountantLetterForm, AccountantRequestListForm } from "./accountant";
import InventoryListForm from "./inventory/InventoryListForm";
import { OfficerRequestListForm } from "./officer";
import ObjectPropertyTableForm from "./objectProperty/table/ObjectPropertyTableForm";
import AddObjectPropertyForm from "./objectProperty/AddObjectPropertyForm";
import ResultInventoryListForm from "./inventory/result/ResultInventoryListForm";
import Profile from "./account/Profile";
import BuildingListForm from "./building/BuildingListForm";
import BuildingEditForm from "./building/BuildingEditForm";
import BuildingCreateForm from "./building/BuildingCreateForm";
import RoomEditForm from "./building/room/RoomEditForm";
import RoomCreateForm from "./building/room/RoomCreateForm";
import EditObjectPropertyForm from "./objectProperty/EditObjectPropertyForm";
import CopyObjectPropertyForm from "./objectProperty/CopyObjectPropertyForm";
import CancellationActListForm from "./cancellation/CancellationActListForm";
import CancellationProtocol from "./cancellation/CancellationProtocol";
import ProcessingInventory from "./inventory/result/ProcessingInventory";
import AccountantLetterFormWithInitial from "./accountant/AccountantLetterFormWithInitial";
import WorkerAccountTableForm from "./admin/WorkerAccountTableForm";

const AppRouter = () => {
  return (
    <Switch>
      <Route exact path="/" component={HomeForm} />

      <Route exact path="/profile" component={Profile} />

      <Route exact path="/admin/create" component={AdminCreateForm} />
      <Route exact path="/request/list" component={RequestListForm} />
      <Route
        exact
        path="/objectProperty/table"
        component={ObjectPropertyTableForm}
      />
      <Route exact path="/request/create" component={CreateRequestForm} />
      <Route exact path="/object/add" component={AddObjectPropertyForm} />
      <Route exact path="/object/edit/:id" component={EditObjectPropertyForm} />
      <Route exact path="/object/copy/:id" component={CopyObjectPropertyForm} />
      <Route exact path="/login" component={LoginForm} />
      <Route exact path="/inventory/" component={InventoryListForm} />
      <Route exact path="/admin/create/account" component={WorkerAccountForm} />
      <Route exact path="/admin/users" component={WorkerAccountTableForm} />
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
      <Route exact path="/accountant/letter" component={AccountantLetterForm} />
      <Route
        exact
        path="/accountant/letter/:id"
        component={AccountantLetterFormWithInitial}
      />
      <Route
        exact
        path="/cancellation/acts"
        component={CancellationActListForm}
      />
      <Route
        exact
        path="/inventory/:inventoryId/result-inventory/:roomId"
        component={ResultInventoryListForm}
      />
      <Route
        exact
        path="/cancellation/acts"
        component={CancellationActListForm}
      />
      <Route
        exact
        path="/cancellation/protocol"
        component={CancellationProtocol}
      />
      <Route
        exact
        path="/inventory/:inventoryId/result-inventory"
        component={ResultInventoryListForm}
      />
      <Route
        exact
        path="/inventory/:inventoryId/result-inventory/processing"
        component={ProcessingInventory}
      />
      <Route exact path="/building/list" component={BuildingListForm} />
      <Route exact path="/building/edit/:id" component={BuildingEditForm} />
      <Route exact path="/building/create" component={BuildingCreateForm} />
      <Route exact path="/room/edit/:id" component={RoomEditForm} />
      <Route exact path="/room/create/:id" component={RoomCreateForm} />
    </Switch>
  );
};
export default AppRouter;
