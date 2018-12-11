import React, { Component } from "react";
import RequestListForm from "./campus/RequestListForm";
import axios from "axios";

class App extends Component {
  state = {
    text: "initialText"
  };

  componentDidMount() {
    axios.get("/hello");
  }

  render() {
    return (
      <RequestListForm />
    );
  }
}

export default App;
