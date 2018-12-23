import React, { Component } from "react";
import Grid from "@material-ui/core/Grid/Grid";
import Typography from "@material-ui/core/es/Typography/Typography";
import BuildingTable from "./BuildingTable";
import * as request from "../../commons/request";
import SimpleAlertDialog from "../../commons/dialog/SimpleAlertDialog";
import { withStyles } from "@material-ui/core";
import Button from "@material-ui/core/es/Button/Button";
import AddIcon from "@material-ui/icons/Add";
import { withRouter } from "react-router";

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

class BuildingListForm extends Component {
  state = {
    buildings: [],
    deleted: false,
    error: null
  };

  componentDidMount() {
    this.fetchBuildings();
  }

  fetchBuildings = () => {
    request
      .get("/building/all")
      .then(buildings => {
        this.setState({ buildings });
      })
      .catch(error => this.setState({ error }));
  };

  deleteBuilding = building => {
    request
      .post("/building/delete", building)
      .then(() => {
        this.setState({ deleted: true });
        this.fetchBuildings();
      })
      .catch(error => this.setState({ error }));
  };

  openCreateBuildingForm = () => {
    this.props.history.push("/building/create");
  };

  render() {
    const { classes } = this.props;
    const { buildings, deleted, error } = this.state;
    return (
      <React.Fragment>
        {error && (
          <SimpleAlertDialog
            title="Произошла ошибка"
            content={error}
            onClose={() => {
              this.setState({ error: null });
            }}
            open={error !== null}
          />
        )}
        {deleted && (
          <SimpleAlertDialog
            title="Здание удалено"
            onClose={() => {
              this.setState({ deleted: false });
            }}
            open={deleted}
          />
        )}
        <Grid
          className={classes.root}
          container
          justify="space-between"
          alignItems="center"
          spacing={24}
        >
          <Grid item xs>
            <Typography variant="h3" gutterBottom className={classes.margin}>
              Здания кампуса
            </Typography>
          </Grid>
          <Grid item xs={2}>
            <Button
              variant="contained"
              color="primary"
              onClick={this.openCreateBuildingForm}
              className={classes.button}
            >
              Добавить новое здание
              <AddIcon className={classes.rightIcon} />
            </Button>
          </Grid>
          <Grid item xs={12}>
            <BuildingTable data={buildings} onDelete={this.deleteBuilding} />
          </Grid>
        </Grid>
      </React.Fragment>
    );
  }
}

export default withStyles(styles)(withRouter(BuildingListForm));
