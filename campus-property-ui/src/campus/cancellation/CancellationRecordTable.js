import React from "react";
import TableHead from "@material-ui/core/TableHead/TableHead";
import TableRow from "@material-ui/core/TableRow/TableRow";
import TableCell from "@material-ui/core/TableCell/TableCell";
import TableBody from "@material-ui/core/TableBody/TableBody";
import Table from "@material-ui/core/Table/Table";
import { uniqueId } from "lodash";
import { withStyles } from "@material-ui/core";

const columns = [
  { title: "Причина", key: uniqueId(), property: "reason" },
  {
    title: "Инвентарный номер",
    key: uniqueId(),
    property: "object.numberProperty"
  },
  { title: "Название", key: uniqueId(), property: "object.caption" }
];

const CancellationRecordTable = props => {
  const { classes, data } = props;
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
            <TableRow hover key={row.id}>
              <TableCell component="th" scope="row">
                {row.reason}
              </TableCell>
              <TableCell component="th" scope="row">
                {row.object.propertyNumber}
              </TableCell>
              <TableCell component="th" scope="row">
                {row.object.caption}
              </TableCell>
            </TableRow>
          ))}
      </TableBody>
    </Table>
  );
};

export default withStyles(null)(CancellationRecordTable);
