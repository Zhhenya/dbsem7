import React, { Component } from "react";
import request from "../../../commons/request";
import ResultInventoryListTable from "./ResultInventoryListTable";
import Grid from "@material-ui/core/Grid/Grid";
import TextField from "@material-ui/core/TextField/TextField";
import MenuItem from "@material-ui/core/MenuItem/MenuItem";
import { isEqual } from "lodash";
import Typography from "@material-ui/core/es/Typography/Typography";
import Button from "@material-ui/core/es/Button/Button";
import { withStyles } from "@material-ui/core";

const styles = theme => ({
  root: {
    flexGrow: 1,
    marginBottom: theme.spacing.unit
  },
  margin: {
    margin: theme.spacing.unit * 4,
    marginBottom: theme.spacing.unit
  },
  button: {
    margin: theme.spacing.unit * 4,
    marginBottom: theme.spacing.unit
  },
  rightIcon: {
    marginLeft: theme.spacing.unit
  },
  selectField: {
    marginLeft: theme.spacing.unit * 4,
    marginRight: theme.spacing.unit * 4
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
    if (!selectedRoom) {
      return;
    }
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

  saveResults = data => {
    request.post("/inventory/result/save", data.data).then(() => {
      this.fetchTableData();
    });
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
    if (!buildings.length) {
      return null;
    }
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
              onClick={this.finish}
              className={classes.button}
            >
              Завершить инветаризацию
            </Button>
          </Grid>
        </Grid>
        <Grid className={classes.root} container spacing={32}>
          <Grid item>
            <form>
              <TextField
                className={classes.selectField}
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
              className={classes.selectField}
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
        {data.length > 0 && (
          <Grid container>
            <Grid item xs={12}>
              <ResultInventoryListTable data={data} onSave={this.saveResults} />
            </Grid>
          </Grid>
        )}
      </>
    );
  }
}

export default withStyles(styles)(ResultInventoryListForm);
