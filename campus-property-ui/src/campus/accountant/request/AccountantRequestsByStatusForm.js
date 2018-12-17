import React, { Component } from "react";
import ExpansionPanel from "@material-ui/core/ExpansionPanel/ExpansionPanel";
import ExpansionPanelSummary from "@material-ui/core/ExpansionPanelSummary/ExpansionPanelSummary";
import ExpandMoreIcon from "@material-ui/icons/ExpandMore";
import Typography from "@material-ui/core/Typography/Typography";
import ExpansionPanelDetails from "@material-ui/core/ExpansionPanelDetails/ExpansionPanelDetails";
import { RequestStatus } from "../../request/RequestStatus";
import withStyles from "@material-ui/core/styles/withStyles";
import * as request from "../../../commons/request";
import stateProvider from "../../../commons/stateProvider";
import AccountantRequestListTable from "./AccountantRequestListTable";
import RequestPanels from "../../request/RequestPanels";

class AccountantRequestsByStatusForm extends Component {
  state = {
    [RequestStatus.WAITING]: [],
    [RequestStatus.APPROVED]: [],
    [RequestStatus.PROCESSING]: [],
    [RequestStatus.READY]: []
  };

  componentDidMount() {
    this.fetchRequestListOfAccountant();
  }

  fetchRequestListOfAccountant = () => {
    Object.values(RequestStatus).forEach(status => {
      this.fetchRequestListOfAccountantByStatus(status);
    });
  };

  fetchRequestListOfAccountantByStatus = status => {
    request
      .get("request/" + status + "/list/accountant/" + stateProvider.user.id)
      .then(requestList => {
        this.setState({ [status]: requestList });
      });
  };

  approveRequest = requestId => {
    request.post("/approveRequest", requestId).then(() => {
      this.fetchRequestListOfAccountant();
    });
  };

  render() {
    const { classes } = this.props;
    return (
      <React.Fragment>
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
                <AccountantRequestListTable
                  status={panel.status}
                  data={this.state[panel.status]}
                  onApprove={this.approveRequest}
                />
              )}
            </ExpansionPanelDetails>
          </ExpansionPanel>
        ))}
      </React.Fragment>
    );
  }
}

export default withStyles(null)(AccountantRequestsByStatusForm);
