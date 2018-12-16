import React, { Component } from "react";
import { withStyles } from "@material-ui/core/styles";
import { uniqueId } from "lodash";
import Table from "@material-ui/core/Table";
import TableBody from "@material-ui/core/TableBody";
import TableCell from "@material-ui/core/TableCell";
import TableHead from "@material-ui/core/TableHead";
import TableRow from "@material-ui/core/TableRow";
import RequestRecordListDialog from "../../request/record/RequestRecordListDialog";
import Button from "@material-ui/core/Button/Button";
import { RequestStatus } from "../../request/RequestStatus";

const styles = theme => ({
  root: {
    width: "100%",
    overflowX: "auto"
  },
  table: {
    minWidth: 700
  }
});

const columns = [
  { title: "Номер", key: uniqueId(), property: "id" },
  { title: "Содержание", key: uniqueId(), property: "content" },
  { title: "Тип", key: uniqueId(), property: "type" },
  { title: "Состояние", key: uniqueId(), property: "state" },
  {
    title: "Сотрудник университета",
    key: uniqueId(),
    property: "universityWorker"
  },
  {
    title: "Сотрудник хоз. части",
    key: uniqueId(),
    property: "economicOfficer"
  },
  { title: "Бухгалтер", key: uniqueId(), property: "accountant" }
];

const ApprovedButton = props => {
  const { classes, onClick } = props;
  return (
    <Button
      variant="contained"
      color="secondary"
      className={classes.button}
      onClick={onClick}
    >
      Одобрить
    </Button>
  );
};

class AccountantRequestListTable extends Component {
  state = {
    openRecords: false,
    selectedRequest: null
  };
  render() {
    const { classes, data, status, onApprove } = this.props;
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
                        onClick={() => onApprove(row.id)}
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
