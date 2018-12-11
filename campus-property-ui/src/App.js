import React, { Component } from "react";
import RequestListForm from "./campus/RequestListForm";

class App extends Component {
  state = {
    text: "initialText"
  };

  render() {
    return (
      <RequestListForm />
    );
  }
}

export default App;
