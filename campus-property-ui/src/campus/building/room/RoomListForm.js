import React, { Component } from "react";
import SimpleAlertDialog from "../../../commons/dialog/SimpleAlertDialog";
import Typography from "@material-ui/core/es/Typography/Typography";
import Button from "@material-ui/core/es/Button/Button";
import AddIcon from "@material-ui/icons/Add";
import { withStyles } from "@material-ui/core";
import RoomTable from "./RoomTable";
import * as request from "../../../commons/request";
import { withRouter } from "react-router";
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

class RoomListForm extends Component {
  state = {
    rooms: [],
    deleted: false,
    error: null
  };

  componentDidMount() {
    this.fetchRooms();
  }

  fetchRooms = () => {
    const { buildingId } = this.props;
    request
      .get("/room/all/" + buildingId)
      .then(rooms => {
        this.setState({ rooms });
      })
      .catch(error => {
        this.setState({ error });
      });
  };

  deleteRoom = id => {
    request
      .post("/room/delete", id)
      .then(() => {
        this.setState({ deleted: true });
        this.fetchRooms();
      })
      .catch(error => {
        this.setState({ error });
      });
  };

  openCreateRoomForm = () => {
    const { buildingId } = this.props;
    this.props.history.push("/room/create/" + buildingId);
  };

  render() {
    const { classes } = this.props;
    const { rooms, deleted, error } = this.state;
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
            title="Комната удалена"
            onClose={() => {
              this.setState({ deleted: false });
            }}
            open={deleted}
          />
        )}
        <Toolbar>
          <Typography variant="h6" color="inherit">
            Комнаты
          </Typography>
          <div style={{ flexGrow: 1 }} />
          <Button
            variant="contained"
            color="primary"
            onClick={this.openCreateRoomForm}
          >
            Добавить новую комнату
            <AddIcon className={classes.rightIcon} />
          </Button>
        </Toolbar>
        {rooms.length ? (
          <RoomTable data={rooms} onDelete={this.deleteRoom} />
        ) : (
          <Typography className={classes.margin} variant={"body1"}>
            В здании нет комнат
          </Typography>
        )}
      </>
    );
  }
}

export default withStyles(styles)(withRouter(RoomListForm));
