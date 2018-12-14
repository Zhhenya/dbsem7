import React, { Component } from "react";
import Grid from "@material-ui/core/Grid/Grid";
import Button from "@material-ui/core/es/Button/Button";
import AddIcon from "@material-ui/icons/Add";
import ProcessingRequestListForm from "../request/ProcessingRequestListForm";
import { withRouter } from "react-router";
import withStyles from "@material-ui/core/styles/withStyles";
import Typography from "@material-ui/core/es/Typography/Typography";

const styles = theme => ({
  margin: {
    margin: theme.spacing.unit
  },
  button: {
    padding: theme.spacing.unit
  },
  rightIcon: {
    marginLeft: theme.spacing.unit
  }
});

class WorkerHomeForm extends Component {
  openCreateRequestForm = () => {
    this.props.history.push("/request/create");
  };

  render() {
    const { classes } = this.props;
    return (
      <Grid
        container
        direction="row"
        justify="space-around"
        alignItems="center"
      >
        <Grid item xs={10}>
          <Typography className={classes.margin}>
            <h2>Заявки в работе</h2>
          </Typography>
        </Grid>
        <Grid item xs>
          <Button
            fullWidth
            variant="contained"
            color="primary"
            onClick={this.openCreateRequestForm}
            className={classes.button}
          >
            Создать заявку
            <AddIcon className={classes.rightIcon} />
          </Button>
        </Grid>
        <Grid item xs={12}>
          <ProcessingRequestListForm />
        </Grid>
      </Grid>
    );
  }
}

export default withStyles(styles)(withRouter(WorkerHomeForm));
