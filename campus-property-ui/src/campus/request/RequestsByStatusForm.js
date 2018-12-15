import React from "react";
import ExpansionPanel from "@material-ui/core/ExpansionPanel/ExpansionPanel";
import ExpansionPanelSummary from "@material-ui/core/ExpansionPanelSummary/ExpansionPanelSummary";
import ExpandMoreIcon from "@material-ui/icons/ExpandMore";
import Typography from "@material-ui/core/Typography/Typography";
import ExpansionPanelDetails from "@material-ui/core/ExpansionPanelDetails/ExpansionPanelDetails";
import StatusRequestListForm from "./StatusRequestListForm";
import { RequestStatus } from "./RequestStatus";
import withStyles from "@material-ui/core/styles/withStyles";

const RequestByStatusForm = props => {
  const {classes} = props;
  return(
    <React.Fragment>
      <ExpansionPanel defaultExpanded>
        <ExpansionPanelSummary expandIcon={<ExpandMoreIcon />}>
          <Typography className={classes.heading}>Отправлено на обработку</Typography>
        </ExpansionPanelSummary>
        <ExpansionPanelDetails>
          <StatusRequestListForm status={RequestStatus.WAITING}/>
        </ExpansionPanelDetails>
      </ExpansionPanel>
      <ExpansionPanel defaultExpanded>
        <ExpansionPanelSummary expandIcon={<ExpandMoreIcon />}>
          <Typography className={classes.heading}>Одобрено на выполнение</Typography>
        </ExpansionPanelSummary>
        <ExpansionPanelDetails>
          <StatusRequestListForm status={RequestStatus.APPROVED}/>
        </ExpansionPanelDetails>
      </ExpansionPanel>
      <ExpansionPanel defaultExpanded>
        <ExpansionPanelSummary expandIcon={<ExpandMoreIcon />}>
          <Typography className={classes.heading}>Выполняется</Typography>
        </ExpansionPanelSummary>
        <ExpansionPanelDetails>
          <StatusRequestListForm status={RequestStatus.PROCESSING}/>
        </ExpansionPanelDetails>
      </ExpansionPanel>
      <ExpansionPanel defaultExpanded>
        <ExpansionPanelSummary expandIcon={<ExpandMoreIcon />}>
          <Typography className={classes.heading}>Готово</Typography>
        </ExpansionPanelSummary>
        <ExpansionPanelDetails>
          <StatusRequestListForm status={RequestStatus.READY}/>
        </ExpansionPanelDetails>
      </ExpansionPanel>
    </React.Fragment>
  );
};

export default withStyles(null)(RequestByStatusForm);