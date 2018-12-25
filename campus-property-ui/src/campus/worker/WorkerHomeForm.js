import React, { Component } from "react";
import Button from "@material-ui/core/es/Button/Button";
import AddIcon from "@material-ui/icons/Add";
import { withRouter } from "react-router";
import withStyles from "@material-ui/core/styles/withStyles";
import Typography from "@material-ui/core/es/Typography/Typography";
import WorkerRequestsByStatusForm from "./request/WorkerRequestsByStatusForm";
import Toolbar from "@material-ui/core/Toolbar/Toolbar";

const styles = theme => ({
  root: {
    flexGrow: 1
  },
  margin: {
    margin: theme.spacing.unit * 4
  },
  button: {
    margin: theme.spacing.unit * 4
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
      <>
        <Toolbar>
          <Typography variant="h6" color="inherit">
            Мои заявки
          </Typography>
          <div style={{ flexGrow: 1 }} />
          <Button
            variant="contained"
            color="primary"
            onClick={this.openCreateRequestForm}
          >
            Создать заявку
            <AddIcon className={classes.rightIcon} />
          </Button>
        </Toolbar>
        <WorkerRequestsByStatusForm />
      </>
    );
  }
}

export default withStyles(styles)(withRouter(WorkerHomeForm));
