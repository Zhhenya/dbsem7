import React from "react";
import Typography from "@material-ui/core/es/Typography/Typography";
import OfficerRequestsByStatusForm from "./OfficerRequestsByStatusForm";
import Toolbar from "@material-ui/core/Toolbar/Toolbar";

const styles = theme => ({
  root: {
    flexGrow: 1
  },
  margin: {
    margin: theme.spacing.unit * 4
  }
});

const OfficerRequestListForm = () => (
  <>
    <Toolbar>
      <Typography variant="h6" color="inherit">
        Заявки работников
      </Typography>
      <div style={{ flexGrow: 1 }} />
    </Toolbar>
    <OfficerRequestsByStatusForm />
  </>
);

export default OfficerRequestListForm;
