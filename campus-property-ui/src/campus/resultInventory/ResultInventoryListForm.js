import React, { Component } from "react";
import request from "../../commons/request";
import ResultInventoryListTable from "./ResultInventoryListTable";

class ResultInventoryListForm extends Component {
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
    console.log(this.props.match.params);
    request
      .get(() => {
        if (this.props.match.params.roomId)
          return "/inventory/" +
            this.props.match.params.inventoryId +
            "/result-inventory/" +
            this.props.match.params.roomId
        else
          return "/inventory/" +
            this.props.match.params.inventoryId +
            "/result-inventory"
      }

      )
      .then(data => {
        this.setState({ data });
      });
  };

  render() {
    return <ResultInventoryListTable data={this.state.data} />;
  }
}

export default ResultInventoryListForm;
