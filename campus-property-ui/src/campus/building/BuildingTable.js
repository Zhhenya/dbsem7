import React from "react";
import * as PropTypes from "prop-types";
import TableHead from "@material-ui/core/TableHead/TableHead";
import TableRow from "@material-ui/core/TableRow/TableRow";
import RequestTableColumns from "../request/RequestTableColumns";
import TableCell from "@material-ui/core/TableCell/TableCell";
import TableBody from "@material-ui/core/TableBody/TableBody";
import Table from "@material-ui/core/Table/Table";
import { uniqueId } from "lodash";
import DeleteIcon from "@material-ui/core/SvgIcon/SvgIcon";
import IconButton from "@material-ui/core/IconButton/IconButton";
import { withStyles } from "@material-ui/core";
import { withRouter } from "react-router";

const columns = [
  { title: "Номер", key: uniqueId(), property: "id" },
  { title: "Адрес", key: uniqueId(), property: "address" }
];

const BuildingTable = props => {
  const { classes, data, onDelete } = props;
  return (
    <Table className={classes.table}>
      <TableHead>
        <TableRow>
          {RequestTableColumns.map(column => (
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
                this.setState({ openRecords: true, selectedRequest: row });
              }}
            >
              <TableCell component="th" scope="row">
                {row.id}
              </TableCell>
              <TableCell component="th" scope="row">
                {row.address}
              </TableCell>
              <TableCell component="th" scope="row">
                <IconButton
                  className={classes.margin}
                  aria-label="Delete"
                  onClick={() => onDelete(row.id)}
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

BuildingTable.propTypes = {
  data: PropTypes.array,
  onDelete: PropTypes.func
};

export default withStyles(null)(withRouter(BuildingTable));
