import React, {Component} from "react";
import axios from "axios";
import TestTable from "./campus/TestTable";

class App extends Component {
  state = {
    text: "initialText"
  };

  componentDidMount() {
    axios.get("/hello").then(({ data }) => this.setState({ text: data }));
  }

  render() {
    return (
      <TestTable title={this.state.text}/>
    );
  }
}

export default App;
