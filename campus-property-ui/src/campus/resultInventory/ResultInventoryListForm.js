import React, { Component } from "react";
import request from "../../commons/request";
import ResultInventoryListTable from "./ResultInventoryListTable"

class ResultInventoryListForm extends Component{
  state = {
    data: []
  };

  componentDidMount() {
    this.fetchTableData();
  }

  fetchTableData = () =>
    request.get("/result-inventory/list").then(data => {
      this.setState({ data });
    });

  render() {
    return <ResultInventoryListTable data={this.state.data} />;
  }
}

export default ResultInventoryListForm;
