import React from "react";
import { observer } from "mobx-react";
import { HashRouter } from "react-router-dom";
import AppRouter from "./campus/AppRouter";
import Auth from "./commons/Auth";
import AppWrapper from "./campus/AppWrapper";

const App = () => (
  <HashRouter>
    <Auth>
      <AppWrapper>
        <AppRouter />
      </AppWrapper>
    </Auth>
  </HashRouter>
);
export default observer(App);
