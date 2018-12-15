import React from "react";
import Grid from "@material-ui/core/Grid/Grid";
import Typography from "@material-ui/core/es/Typography/Typography";
import RequestByStatusForm from "../request/RequestsByStatusForm";
import withStyles from "@material-ui/core/styles/withStyles";

const AccountantRequestListForm = props => {
  const { classes } = props;
  return (
    <React.Fragment>
      <Grid
        className={classes.root}
        container
        justify="space-between"
        alignItems="center"
        spacing={24}
      >
        <Grid item xs>
          <Typography variant="h3" gutterBottom className={classes.margin}>
            Заявки работников
          </Typography>
        </Grid>
        <Grid item xs={12}>
          <RequestByStatusForm all approving/>
        </Grid>
      </Grid>
    </React.Fragment>
  );
};

export default withStyles(null)(AccountantRequestListForm);
