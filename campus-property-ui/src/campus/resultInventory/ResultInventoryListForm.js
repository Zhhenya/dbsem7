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
    new Promise(
      (onSuccess) => {
        let url;
        if (this.props.match.params.roomId){
          let url = "/inventory/" +
            this.props.match.params.inventoryId +
            "/result-inventory/" +
            this.props.match.params.roomId;
          onSuccess(url);
        }
        else {
          url = "/inventory/" +
            this.props.match.params.inventoryId +
            "/result-inventory";
          onSuccess(url);
        }
      }
    ).then(
      (url) => {
        request
          .get(url)
          .then(data => {
            this.setState({ data });
          });
      }
    );

  };

  render() {
    return <ResultInventoryListTable data={this.state.data} />;
  }
}

export default ResultInventoryListForm;
