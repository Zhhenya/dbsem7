import React, { Component } from "react";
import axios from "axios";
import RequestListTable from "./RequestListTable";

class RequestListForm extends Component {
  state = {
    data: []
  };

  componentDidMount() {
    this.fetchTableData();
  }

  fetchTableData = () =>
    axios.get("/request/list").then(response => {
      console.log(response);
      this.setState({ data: response.data });
    });

  render() {
    return <RequestListTable data={this.state.data} />;
  }
}

export default RequestListForm;
