import React, { Component } from "react";
import stateProvider from "../../commons/stateProvider";
import * as request from "../../commons/request";
import RequestListForm from "./RequestListForm";

const userId = (stateProvider.user && stateProvider.user.id) || 0;

class ProcessingRequestListForm extends Component {
  state = {
    requests: []
  };

  componentDidMount() {
    this.fetchProcessingRequestList();
  }

  fetchProcessingRequestList = () => {
    request
      .get("request/processing/list/" + userId)
      .then(requests => this.setState({ requests }));
  };

  render() {
    const { requests } = this.state;
    return <RequestListForm data={requests} />;
  }
}

export default ProcessingRequestListForm;
