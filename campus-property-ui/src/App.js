import React, { Component } from "react";
import { observer } from "mobx-react";
import { HashRouter } from "react-router-dom";
import AppRouter from "./campus/AppRouter";
import state from "./commons/stateProvider";
import Auth from "./commons/Auth";

class App extends Component {
  state = {
    text: "initialText"
  };

  componentDidMount() {
    /*axios.get("/hello").then(() => {
      state.authorized = true;
    });*/
  }

  render() {
    console.log(state.authorized);

    return (
      <HashRouter>
        <Auth>
          <AppRouter />
        </Auth>
      </HashRouter>
    );
  }
}

export default observer(App);
