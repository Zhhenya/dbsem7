import React from "react";

import { withStyles } from "@material-ui/core/styles";
import TableHead from "@material-ui/core/TableHead/TableHead";
import TableRow from "@material-ui/core/TableRow/TableRow";
import TableCell from "@material-ui/core/TableCell/TableCell";
import TableBody from "@material-ui/core/TableBody/TableBody";
import Table from "@material-ui/core/Table/Table";
import { uniqueId } from "lodash";

const styles = theme => ({
  root: {
    marginTop: theme.spacing.unit * 3,
    overflowX: "auto"
  },
  table: {
    minWidth: 700
  }
});

const columns = [
  { title: "Логин", key: uniqueId(), property: "login" },
  { title: "Пароль", key: uniqueId(), property: "password" },
  { title: "Роль", key: uniqueId(), property: "role" }
]

const WorkerAccountTable = props => {
  const { classes, data } = props;
  return (
    <Table>
      <TableHead>
        <TableRow>
          {columns.map(column => (
            <TableCell key={column.key}>{column.title}</TableCell>
          ))}
        </TableRow>
      </TableHead>
      <TableBody>
        {data && data.map(row => (
          <TableRow key={row.id}>
            <TableCell scope="row">
              {row.login}
            </TableCell>
            <TableCell scope="row">
              {row.password}
            </TableCell>
            <TableCell scope="row">
              {row.role.name}
            </TableCell>
          </TableRow>
        ))}
      </TableBody>
    </Table>
  );
};

export default withStyles(styles)(WorkerAccountTable);
