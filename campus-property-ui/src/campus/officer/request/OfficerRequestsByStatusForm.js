import React, { Component } from "react";
import { RequestStatus } from "../../request/RequestStatus";
import * as request from "../../../commons/request";
import stateProvider from "../../../commons/stateProvider";
import RequestPanels from "../../request/RequestPanels";
import ExpansionPanel from "@material-ui/core/ExpansionPanel/ExpansionPanel";
import ExpansionPanelSummary from "@material-ui/core/ExpansionPanelSummary/ExpansionPanelSummary";
import ExpandMoreIcon from "@material-ui/core/SvgIcon/SvgIcon";
import Typography from "@material-ui/core/Typography/Typography";
import ExpansionPanelDetails from "@material-ui/core/ExpansionPanelDetails/ExpansionPanelDetails";
import withStyles from "@material-ui/core/styles/withStyles";
import OfficerRequestListTable from "./OfficerRequestListTable";

class OfficerRequestsByStatusForm extends Component {
  state = {
    [RequestStatus.WAITING]: [],
    [RequestStatus.APPROVED]: [],
    [RequestStatus.PROCESSING]: [],
    [RequestStatus.READY]: []
  };

  componentDidMount() {
    this.fetchRequestListOfOfficer();
  }

  fetchRequestListOfOfficer = () => {
    Object.values(RequestStatus).forEach(status => {
      this.fetchRequestListOfOfficerByStatus(status);
    });
  };

  fetchRequestListOfOfficerByStatus = status => {
    request
      .get("request/" + status + "/list/officer/" + stateProvider.user.id)
      .then(requestList => {
        this.setState({ [status]: requestList });
      });
  };

  startRequestProcessing = requestId => {
    request.post("/request/startProcessing", requestId).then(() => {
      this.fetchRequestListOfOfficer();
    });
  };

  markRequestAsReady = requestId => {
    request.post("/request/markAsReady", requestId).then(() => {
      this.fetchRequestListOfOfficer();
    });
  };

  render() {
    const { classes } = this.props;
    return (
      <>
        {RequestPanels.map(panel => (
          <ExpansionPanel key={panel.id} defaultExpanded>
            <ExpansionPanelSummary expandIcon={<ExpandMoreIcon />}>
              <Typography className={classes.heading}>
                {panel.heading}
              </Typography>
            </ExpansionPanelSummary>
            <ExpansionPanelDetails>
              {!this.state[panel.status] || !this.state[panel.status].length ? (
                <Typography variant="subtitle1">Нет заявок</Typography>
              ) : (
                <OfficerRequestListTable
                  status={panel.status}
                  data={this.state[panel.status]}
                  onProcessing={this.startRequestProcessing}
                  onReady={this.markRequestAsReady}
                />
              )}
            </ExpansionPanelDetails>
          </ExpansionPanel>
        ))}
      </>
    );
  }
}

export default withStyles(null)(OfficerRequestsByStatusForm);
