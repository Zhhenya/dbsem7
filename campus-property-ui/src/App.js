import React, { Component } from "react";
import { Layout, DatePicker } from "antd";
import axios from "axios";

const { Header, Content } = Layout;

class App extends Component {
  state = {
    text: "initialText"
  };

  componentDidMount() {
    axios.get("/hello").then(({ data }) => this.setState({ text: data }));
  }

  render() {
    return (
      <Layout theme="light">
        <Header theme="light">
          {this.state.text}
        </Header>
        <Content theme="light">
          <DatePicker/>
        </Content>
      </Layout>
    );
  }
}

export default App;
