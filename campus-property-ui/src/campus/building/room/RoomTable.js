import React from "react";
import { uniqueId } from "lodash";
import Table from "@material-ui/core/Table/Table";
import TableHead from "@material-ui/core/TableHead/TableHead";
import TableRow from "@material-ui/core/TableRow/TableRow";
import TableCell from "@material-ui/core/TableCell/TableCell";
import TableBody from "@material-ui/core/TableBody/TableBody";
import IconButton from "@material-ui/core/IconButton/IconButton";
import * as PropTypes from "prop-types";
import { withStyles } from "@material-ui/core";
import { withRouter } from "react-router";
import DeleteIcon from "@material-ui/icons/Delete";

const columns = [
  { title: "Номер", key: uniqueId(), property: "number" },
  { title: "Этаж", key: uniqueId(), property: "floor" },
  { title: "", key: uniqueId(), property: "" }
];

const openEditForm = (props, roomId) => {
  props.history.push("/room/edit/" + roomId);
};

const RoomTable = props => {
  const { classes, data, onDelete } = props;
  return (
    <Table className={classes.table}>
      <TableHead>
        <TableRow>
          {columns.map(column => (
            <TableCell key={column.key}>{column.title}</TableCell>
          ))}
        </TableRow>
      </TableHead>
      <TableBody>
        {data &&
          data.map(row => (
            <TableRow
              hover
              key={row.id}
              onDoubleClick={() => {
                openEditForm(props, row.id);
              }}
            >
              <TableCell component="th" scope="row">
                {row.number}
              </TableCell>
              <TableCell component="th" scope="row">
                {row.floor}
              </TableCell>
              <TableCell component="th" scope="row">
                <IconButton
                  className={classes.margin}
                  aria-label="Delete"
                  onClick={() => onDelete(row)}
                >
                  <DeleteIcon />
                </IconButton>
              </TableCell>
            </TableRow>
          ))}
      </TableBody>
    </Table>
  );
};

RoomTable.propTypes = {
  data: PropTypes.array,
  onDelete: PropTypes.func
};

export default withStyles(null)(withRouter(RoomTable));
