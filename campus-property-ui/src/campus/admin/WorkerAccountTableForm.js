import React, { Component } from "react";
import request from "../../commons/request";
import WorkerAccountTable from "./WorkerAccountTable";

class WorkerAccountTableForm extends Component {
  state = {
    data: []
  };

  componentDidMount() {
    this.fetchTableData();
  }

  fetchTableData = () =>
    request.get("/admin/users").then(data => {
      console.log(data);
      this.setState({ data });
    });

  render() {
    return <WorkerAccountTable data={this.state.data} />;
  }
}

export default WorkerAccountTableForm;
