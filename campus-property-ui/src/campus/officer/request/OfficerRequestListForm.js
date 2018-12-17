import React from "react";
import Grid from "@material-ui/core/Grid/Grid";
import Typography from "@material-ui/core/es/Typography/Typography";
import OfficerRequestsByStatusForm from "./OfficerRequestsByStatusForm";
import withStyles from "@material-ui/core/styles/withStyles";

const styles = theme => ({
  root: {
    flexGrow: 1
  },
  margin: {
    margin: theme.spacing.unit * 4
  }
});

const OfficerRequestListForm = props => {
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
          <OfficerRequestsByStatusForm />
        </Grid>
      </Grid>
    </React.Fragment>
  );
};

export default withStyles(styles)(OfficerRequestListForm);
