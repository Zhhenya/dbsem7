import React, { Component } from "react";
import TableHead from "@material-ui/core/TableHead/TableHead";
import TableRow from "@material-ui/core/TableRow/TableRow";
import TableCell from "@material-ui/core/TableCell/TableCell";
import TableBody from "@material-ui/core/TableBody/TableBody";
import Table from "@material-ui/core/Table/Table";
import { uniqueId } from "lodash";
import CancellationRecordListDialog from "./CancellationRecordListDialog";
import { withStyles } from "@material-ui/core";

const columns = [
  { title: "Номер", key: uniqueId(), property: "id" },
  { title: "Дата", key: uniqueId(), property: "date" },
  { title: "Бухгалтер", key: uniqueId(), property: "accountant" }
];

class CancellationActTable extends Component {
  state = {
    openRecords: false,
    selectedAct: null
  };

  render() {
    const { classes, data } = this.props;
    const { openRecords, selectedAct } = this.state;
    return (
      <>
        {selectedAct && openRecords && (
          <CancellationRecordListDialog
            open={openRecords}
            date={selectedAct.date}
            onClose={() => {
              this.setState({ openRecords: false, selectedAct: null });
            }}
            records={selectedAct.records}
          />
        )}
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
                    this.setState({ openRecords: true, selectedAct: row });
                  }}
                >
                  <TableCell component="th" scope="row">
                    {row.id}
                  </TableCell>
                  <TableCell component="th" scope="row">
                    {row.date}
                  </TableCell>
                  <TableCell component="th" scope="row">
                    {row.accountant.name}
                  </TableCell>
                </TableRow>
              ))}
          </TableBody>
        </Table>
      </>
    );
  }
}

export default withStyles(null)(CancellationActTable);
