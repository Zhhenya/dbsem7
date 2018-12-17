import React from "react";
import ExpansionPanel from "@material-ui/core/ExpansionPanel/ExpansionPanel";
import ExpansionPanelSummary from "@material-ui/core/ExpansionPanelSummary/ExpansionPanelSummary";
import ExpandMoreIcon from "@material-ui/icons/ExpandMore";
import Typography from "@material-ui/core/Typography/Typography";
import ExpansionPanelDetails from "@material-ui/core/ExpansionPanelDetails/ExpansionPanelDetails";
import WorkerStatusRequestListForm from "./WorkerStatusRequestListForm";
import { RequestStatus } from "../../request/RequestStatus";
import withStyles from "@material-ui/core/styles/withStyles";
import { uniqueId } from "lodash";

const RequestPanels = [
  {status: RequestStatus.WAITING, heading: "Отправлено на обработку", id: uniqueId()},
  {status: RequestStatus.APPROVED, heading: "Одобрено на выполнение", id: uniqueId()},
  {status: RequestStatus.PROCESSING, heading: "Выполняется", id: uniqueId()},
  {status: RequestStatus.READY, heading: "Готово", id: uniqueId()},
];

const WorkerRequestByStatusForm = props => {
  const { classes } = props;
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
            <WorkerStatusRequestListForm status={panel.status} />
          </ExpansionPanelDetails>
        </ExpansionPanel>
      ))}
    </React.Fragment>
  );
};

export default withStyles(null)(WorkerRequestByStatusForm);
