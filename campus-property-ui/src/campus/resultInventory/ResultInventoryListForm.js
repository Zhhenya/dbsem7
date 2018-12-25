import React, { Component } from "react";
import request from "../../commons/request";
import ResultInventoryListTable from "./ResultInventoryListTable";

class ResultInventoryListForm extends Component{
  state = {
    data: []
  };

  constructor(props) {
    super(props);
  }

  componentDidMount() {
    this.fetchTableData();
  }

  fetchTableData = () => {
    request.get("/inventory/" + this.props.match.params.inventoryId + "/result-inventory/list").then(data => {
      this.setState({ data });
    })
  };

  render() {
    return <ResultInventoryListTable data={this.state.data} />;
  }
}

export default ResultInventoryListForm;
