import React from "react";
import { observer } from "mobx-react";
import { HashRouter } from "react-router-dom";
import AppRouter from "./campus/AppRouter";
import Auth from "./commons/Auth";

const App = () => (
  <HashRouter>
    <Auth>
      <AppRouter />
    </Auth>
  </HashRouter>
);
export default observer(App);
