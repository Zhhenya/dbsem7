import React, { Component } from "react";
import { withStyles } from "@material-ui/core/styles";
import Table from "@material-ui/core/Table";
import TableBody from "@material-ui/core/TableBody";
import TableCell from "@material-ui/core/TableCell";
import TableHead from "@material-ui/core/TableHead";
import TableRow from "@material-ui/core/TableRow";
import RequestRecordListDialog from "../../request/record/RequestRecordListDialog";
import Button from "@material-ui/core/Button/Button";
import { RequestStatus } from "../../request/RequestStatus";
import RequestTableColumns from "../../request/RequestTableColumns";
import RequestType from "../../enums/RequestType";

const styles = theme => ({
  root: {
    width: "100%",
    overflowX: "auto"
  },
  table: {
    minWidth: 700
  }
});

const ApprovedButton = props => {
  const { classes, onClick, title } = props;
  return (
    <Button
      variant="contained"
      color="secondary"
      className={classes.button}
      onClick={onClick}
    >
      {title}
    </Button>
  );
};

class AccountantRequestListTable extends Component {
  state = {
    openRecords: false,
    selectedRequest: null
  };
  render() {
    const { classes, data, status, onApprove, onCancel } = this.props;
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
                  {status === RequestStatus.WAITING && (
                    <TableCell component="th" scope="row">
                      <ApprovedButton
                        classes={classes}
                        onClick={
                          row.type === RequestType.CANCELLATION
                            ? () => onCancel(row.id)
                            : () => onApprove(row.id)
                        }
                        title={
                          row.type === RequestType.CANCELLATION
                            ? "Списать"
                            : "Одобрить"
                        }
                      />
                    </TableCell>
                  )}
                </TableRow>
              ))}
          </TableBody>
        </Table>
      </React.Fragment>
    );
  }
}

export default withStyles(styles)(AccountantRequestListTable);
