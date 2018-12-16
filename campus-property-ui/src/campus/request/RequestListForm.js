import React, { Component } from "react";
import request from "../../commons/request";
import RequestListTable from "../worker/WorkerRequestListTable";

class RequestListForm extends Component {
  state = {
    data: []
  };

  componentDidMount() {
    this.fetchTableData();
  }

  fetchTableData = () =>
    request.get("/request/list").then(data => {
      this.setState({ data });
    });

  render() {
    return <RequestListTable data={this.state.data} />;
  }
}

export default RequestListForm;
