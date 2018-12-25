import React, { Component } from "react";
import Typography from "@material-ui/core/es/Typography/Typography";
import BuildingTable from "./BuildingTable";
import * as request from "../../commons/request";
import SimpleAlertDialog from "../../commons/dialog/SimpleAlertDialog";
import { withStyles } from "@material-ui/core";
import Button from "@material-ui/core/es/Button/Button";
import AddIcon from "@material-ui/icons/Add";
import { withRouter } from "react-router";
import Toolbar from "@material-ui/core/Toolbar/Toolbar";

const styles = theme => ({
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
      <>
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
        <Toolbar>
          <Typography variant="h6" color="inherit">
            Здания кампуса
          </Typography>
          <div style={{ flexGrow: 1 }} />
          <Button
            variant="contained"
            color="primary"
            onClick={this.openCreateBuildingForm}
          >
            Добавить новое здание
            <AddIcon className={classes.rightIcon} />
          </Button>
        </Toolbar>
        <BuildingTable data={buildings} onDelete={this.deleteBuilding} />
      </>
    );
  }
}

export default withStyles(styles)(withRouter(BuildingListForm));
