import React, { Component } from "react";
import stateProvider from "../../commons/stateProvider";
import * as request from "../../commons/request";
import PropTypes from "prop-types";
import { RequestStatus } from "../request/RequestStatus";
import RequestListTable from "./WorkerRequestListTable";
import Typography from "@material-ui/core/es/Typography/Typography";

class WorkerStatusRequestListForm extends Component {
  state = {
    requests: []
  };

  componentDidMount() {
    this.fetchRequestListOfWorker();
  }

  fetchRequestListOfWorker = () => {
    request
      .get("request/" + this.props.status + "/list/worker/" + stateProvider.user.id)
      .then(requests => this.setState({ requests }));
  };

  render() {
    const { requests } = this.state;
    if (!requests || !requests.length) {
      return <Typography variant="subtitle1">Нет заявок</Typography>;
    }
    return (
      <RequestListTable
        data={requests}
        {...this.props}
      />
    );
  }
}

WorkerStatusRequestListForm.propTypes = {
  state: PropTypes.oneOf(Object.values(RequestStatus))
};

export default WorkerStatusRequestListForm;
