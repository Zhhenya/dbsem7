import React, { Component } from "react";
import { withStyles } from "@material-ui/core/styles";
import Table from "@material-ui/core/Table";
import TableBody from "@material-ui/core/TableBody";
import TableCell from "@material-ui/core/TableCell";
import TableHead from "@material-ui/core/TableHead";
import TableRow from "@material-ui/core/TableRow";
import RequestRecordListDialog from "../../request/record/RequestRecordListDialog";
import RequestTableColumns from "../../request/RequestTableColumns";

const styles = theme => ({
  root: {
    width: "100%",
    overflowX: "auto"
  },
  table: {
    minWidth: 700
  }
});

class WorkerRequestListTable extends Component {
  state = {
    openRecords: false,
    selectedRequest: null
  };
  render() {
    const { classes, data } = this.props;
    const { openRecords, selectedRequest } = this.state;
    return (
      <React.Fragment>
        {selectedRequest && openRecords && (
          <RequestRecordListDialog
            open={openRecords}
            onClose={() => {
              this.setState({ openRecords: false });
            }}
            records={selectedRequest.requestRecordList}
            number={selectedRequest.id}
          />
        )}
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
                    {row.content}
                  </TableCell>
                  <TableCell component="th" scope="row">
                    {row.type}
                  </TableCell>
                  <TableCell component="th" scope="row">
                    {row.state}
                  </TableCell>
                  <TableCell component="th" scope="row">
                    {row.universityWorker.name}
                  </TableCell>
                  <TableCell component="th" scope="row">
                    {row.economicOfficer.name}
                  </TableCell>
                  <TableCell component="th" scope="row">
                    {row.accountant.name}
                  </TableCell>
                </TableRow>
              ))}
          </TableBody>
        </Table>
      </React.Fragment>
    );
  }
}

export default withStyles(styles)(WorkerRequestListTable);
