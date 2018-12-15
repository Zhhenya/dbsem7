import React, { Component } from "react";
import stateProvider from "../../commons/stateProvider";
import * as request from "../../commons/request";
import PropTypes from "prop-types";
import { RequestStatus } from "./RequestStatus";
import RequestListTable from "./RequestListTable";
import Typography from "@material-ui/core/es/Typography/Typography";

class StatusRequestListForm extends Component {
  state = {
    requests: []
  };

  componentDidMount() {
    this.fetchProcessingRequestList();
  }

  fetchProcessingRequestList = () => {
    request
      .get("request/" + this.props.status + "/list/" + stateProvider.user.id)
      .then(requests => this.setState({ requests }));
  };

  render() {
    const { requests } = this.state;
    if (!requests || !requests.length) {
      return (<Typography variant="subtitle1">Нет заявок</Typography>)
    }
    return <RequestListTable data={requests} />;
  }
}

StatusRequestListForm.propTypes = {
  state: PropTypes.oneOf(Object.values(RequestStatus))
};

export default StatusRequestListForm;
