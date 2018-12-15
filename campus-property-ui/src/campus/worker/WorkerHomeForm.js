import React, { Component } from "react";
import Grid from "@material-ui/core/Grid/Grid";
import Button from "@material-ui/core/es/Button/Button";
import AddIcon from "@material-ui/icons/Add";
import { withRouter } from "react-router";
import withStyles from "@material-ui/core/styles/withStyles";
import Typography from "@material-ui/core/es/Typography/Typography";
import RequestByStatusForm from "../request/RequestsByStatusForm";

const styles = theme => ({
  root: {
    flexGrow: 1
  },
  margin: {
    margin: theme.spacing.unit * 4
  },
  button: {
    margin: theme.spacing.unit * 4,
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
        className={classes.root}
        container
        direction="row"
        justify="space-between"
        alignItems="center"
        spacing={24}
      >
        <Grid item xs>
          <Typography variant="h3" gutterBottom className={classes.margin}>
            Мои заявки
          </Typography>
        </Grid>
        <Grid item xs={2}>
          <Button
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
          <RequestByStatusForm />
        </Grid>
      </Grid>
    );
  }
}

export default withStyles(styles)(withRouter(WorkerHomeForm));
