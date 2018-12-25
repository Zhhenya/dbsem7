import React, { Component } from "react";
import request from "../../../commons/request";
import ResultInventoryListTable from "./ResultInventoryListTable";
import Grid from "@material-ui/core/Grid/Grid";
import TextField from "@material-ui/core/TextField/TextField";
import MenuItem from "@material-ui/core/MenuItem/MenuItem";
import { isEqual } from "lodash";
import Typography from "@material-ui/core/es/Typography/Typography";
import Button from "@material-ui/core/es/Button/Button";
import AddIcon from "@material-ui/core/SvgIcon/SvgIcon";
import { withStyles } from "@material-ui/core";

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

class ResultInventoryListForm extends Component {
  state = {
    buildings: [],
    rooms: [],
    data: [],
    selectedBuilding: null,
    selectedRoom: null
  };

  constructor(props) {
    super(props);
  }

  componentDidMount() {
    this.fetchBuildings();
  }

  componentDidUpdate(prevProps, prevState, snapshot) {
    const { selectedBuilding, selectedRoom } = this.state;
    const {
      selectedBuilding: prevSelectedBuilding,
      selectedRoom: prevSelectedRoom
    } = prevState;
    if (!isEqual(selectedBuilding, prevSelectedBuilding)) {
      this.fetchRooms(selectedBuilding);
      return;
    }
    if (!isEqual(selectedRoom, prevSelectedRoom)) {
      this.fetchTableData();
    }
  }

  fetchBuildings() {
    request.get("/building/all").then(buildings => {
      this.setState({ buildings });
    });
  }

  fetchTableData = () => {
    const { selectedRoom } = this.state;
    const { inventoryId } = this.props.match.params;
    request
      .get("/inventory/" + inventoryId + "/result-inventory/" + selectedRoom.id)
      .then(data => {
        this.setState({ data });
      });
  };

  fetchRooms = building => {
    request.get("/room/all/" + building.id).then(rooms => {
      this.setState({ rooms, selectedRoom: null });
    });
  };

  changeBuilding = () => event => {
    this.setState({ selectedBuilding: event.target.value, data: [] });
  };

  changeRoom = () => event => {
    this.setState({ selectedRoom: event.target.value, data: [] });
  };

  render() {
    const { classes } = this.props;
    const {
      buildings,
      rooms,
      data,
      selectedBuilding,
      selectedRoom
    } = this.state;
    return (
      <>
        <Grid
          className={classes.root}
          container
          justify="space-between"
          alignItems="center"
          spacing={24}
        >
          <Grid item xs>
            <Typography variant="h3" gutterBottom className={classes.margin}>
              Инвентаризация
            </Typography>
          </Grid>
          <Grid item xs={2}>
            <Button
              variant="contained"
              color="primary"
              onClick={this.save}
              className={classes.button}
            >
              Сохранить изменения
              <AddIcon className={classes.rightIcon} />
            </Button>
          </Grid>
          <Grid item xs={2}>
            <Button
              variant="contained"
              color="primary"
              onClick={this.finish}
              className={classes.button}
            >
              Завершить инветаризацию
              <AddIcon className={classes.rightIcon} />
            </Button>
          </Grid>
        </Grid>
        <Grid container spacing={32}>
          <Grid item>
            <form>
              <TextField
                id="standard-select-buildings"
                select
                value={selectedBuilding || ""}
                label="Здание"
                onChange={this.changeBuilding()}
                helperText="Выберите здание"
                margin="normal"
              >
                {buildings.map(building => (
                  <MenuItem key={building.id} value={building}>
                    {building.address}
                  </MenuItem>
                ))}
              </TextField>
            </form>
          </Grid>
          <Grid item>
            <TextField
              id="standard-select-room"
              select
              label="Комната"
              value={selectedRoom || ""}
              onChange={this.changeRoom()}
              helperText="Выберите комнату"
              margin="normal"
            >
              {rooms.map(room => (
                <MenuItem key={room.id} value={room}>
                  {room.number}
                </MenuItem>
              ))}
            </TextField>
          </Grid>
        </Grid>
        <Grid container>
          <Grid item>
            <ResultInventoryListTable data={data} />
          </Grid>
        </Grid>
      </>
    );
  }
}

export default withStyles(styles)(ResultInventoryListForm);
