import React from "react";
import { uniqueId } from "lodash";

import { withStyles } from "@material-ui/core/styles";
import Table from "@material-ui/core/Table";
import TableBody from "@material-ui/core/TableBody";
import TableCell from "@material-ui/core/TableCell";
import TableHead from "@material-ui/core/TableHead";
import TableRow from "@material-ui/core/TableRow";
import AppBar from "@material-ui/core/AppBar";
import Toolbar from "@material-ui/core/Toolbar";
import Typography from "@material-ui/core/Typography";
import MenuItem from "@material-ui/core/MenuItem/MenuItem";
import TextField from "@material-ui/core/TextField/TextField";
import Grid from "@material-ui/core/Grid/Grid";
import Button from "@material-ui/core/Button/Button";

const styles = () => ({
  root: {
    width: "100%",
    overflowX: "auto"
  },
  table: {
    minWidth: 700
  }
});

const columns = [
  { title: "Инвентарный номер",         key: uniqueId(), property: "propertyNumber" },
  { title: "Название",                  key: uniqueId(), property: "caption" },
  { title: "Адрес здания",              key: uniqueId(), property: "building" },
  { title: "Комната",                   key: uniqueId(), property: "room" },
  { title: "Результат инвентаризации",  key: uniqueId(), property: "result" }
];

class ResultInventoryListTable extends React.Component {
  constructor(props) {
    super(props);
  }

  handleBuildingChange() {

  }

  handleRoomChange() {

  }

  render() {
    return (
      <React.Fragment>
        <AppBar position="static" color="default">
          <Toolbar>
            <Typography variant="h6" color="inherit">
              Результаты инвентаризации
            </Typography>
          </Toolbar>
          <Toolbar>
            <Grid container spacing={32}>
              <Grid item>
                <TextField
                  id="standard-select-buildings"
                  select
                  label="Здание"
                  onChange={this.handleBuildingChange()}

                  helperText="Выберете здание"
                  margin="normal"
                >
                  {this.props.buildings.map((option, index) => (
                    <MenuItem key={index} value={option}>
                      {option}
                    </MenuItem>
                  ))}
                </TextField>
              </Grid>
              <Grid item>
                <TextField
                  id="standard-select-room"
                  select
                  label="Комната"
                  onChange={this.handleRoomChange()}

                  helperText="Выберете комнату"
                  margin="normal"
                >
                  {this.props.rooms.map((option, index) => (
                    <MenuItem key={index} value={option}>
                      {option}
                    </MenuItem>
                  ))}
                </TextField>
              </Grid>
              <Grid>
                <Button>
                  Сохранить изменения
                </Button>
                <Button>
                  Закончить инвентаризацию
                </Button>
              </Grid>
            </Grid>
          </Toolbar>
        </AppBar>
        <Table className={this.props.classes.table}>
          <TableHead>
            <TableRow>
              {columns.map(column => (
                <TableCell key={ column.key }>{ column.title }</TableCell>
              ))}
            </TableRow>
          </TableHead>
          <TableBody>
            {this.props.data && this.props.data.map(row => (
              <TableRow key={row.id}>
                <TableCell scope="row">
                  {row.objectProperty.propertyNumber}
                </TableCell>
                <TableCell scope="row">
                  {row.objectProperty.caption}
                </TableCell>
                <TableCell scope="row">
                  {row.objectProperty.room.building.address}
                </TableCell>
                <TableCell scope="row">
                  {row.objectProperty.room.number}
                </TableCell>
                <TableCell scope="row">
                  {row.result}
                </TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </React.Fragment>
    );
  }
};

export default withStyles(styles)(ResultInventoryListTable);
