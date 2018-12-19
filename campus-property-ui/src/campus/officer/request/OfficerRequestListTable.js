import React, { Component } from "react";
import RequestRecordListDialog from "../../request/record/RequestRecordListDialog";
import Table from "@material-ui/core/Table/Table";
import TableHead from "@material-ui/core/TableHead/TableHead";
import TableRow from "@material-ui/core/TableRow/TableRow";
import RequestTableColumns from "../../request/RequestTableColumns";
import TableCell from "@material-ui/core/TableCell/TableCell";
import TableBody from "@material-ui/core/TableBody/TableBody";
import { RequestStatus } from "../../request/RequestStatus";
import Button from "@material-ui/core/Button/Button";
import withStyles from "@material-ui/core/styles/withStyles";

const styles = () => ({
  root: {
    width: "100%",
    overflowX: "auto"
  },
  table: {
    minWidth: 700
  }
});

const StartProcessingButton = props => {
  const { classes, onClick } = props;
  return (
    <Button
      variant="contained"
      color="primary"
      className={classes.button}
      onClick={onClick}
    >
      Начать выполнение
    </Button>
  );
};

const MarkAsReadyButton = props => {
  const { classes, onClick } = props;
  return (
    <Button
      variant="contained"
      color="secondary"
      className={classes.button}
      onClick={onClick}
    >
      Выполнено
    </Button>
  );
};

class OfficerRequestListTable extends Component {
  state = {
    openRecords: false,
    selectedRequest: null
  };
  render() {
    const { classes, data, status, onProcessing, onReady } = this.props;
    const { openRecords, selectedRequest } = this.state;
    return (
      <React.Fragment>
        {selectedRequest && openRecords && (
          <RequestRecordListDialog
            open={openRecords}
            onClose={() => {
              console.log("close");
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
                  {status === RequestStatus.APPROVED && (
                    <TableCell component="th" scope="row">
                      <StartProcessingButton
                        classes={classes}
                        onClick={() => onProcessing(row.id)}
                      />
                    </TableCell>
                  )}
                  {status === RequestStatus.PROCESSING && (
                    <TableCell component="th" scope="row">
                      <MarkAsReadyButton
                        classes={classes}
                        onClick={() => onReady(row.id)}
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

export default withStyles(styles)(OfficerRequestListTable);
