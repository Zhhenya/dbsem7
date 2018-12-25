import React from "react";
import { HashRouter } from "react-router-dom";
import AppRouter from "./campus/AppRouter";
import Auth from "./commons/Auth";
import AppWrapper from "./campus/AppWrapper";
import PrintProvider from "react-easy-print";

const App = () => (
  <HashRouter>
    <Auth>
      <AppWrapper>
        <PrintProvider>
          <AppRouter />
        </PrintProvider>
      </AppWrapper>
    </Auth>
  </HashRouter>
);
export default App;
