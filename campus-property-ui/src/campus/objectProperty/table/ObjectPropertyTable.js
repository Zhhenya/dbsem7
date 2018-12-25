import { uniqueId } from "lodash";
import React, { Component } from "react";
import Table from "@material-ui/core/Table";
import TableHead from "@material-ui/core/TableHead";
import TableRow from "@material-ui/core/TableRow";
import TableCell from "@material-ui/core/TableCell";
import TableBody from "@material-ui/core/TableBody";
import { withStyles } from "@material-ui/core";
import RequestRecordListDialog from "../../request/record/RequestRecordListDialog";
import { withRouter } from "react-router";
import CopyIcon from "@material-ui/icons/FileCopy";
import IconButton from "@material-ui/core/IconButton/IconButton";
import { NoPrint, Print } from "react-easy-print";

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
  { title: "Инвентарный номер", key: uniqueId(), property: "propertyNumber" },
  { title: "Название", key: uniqueId(), property: "caption" },
  { title: "Поставщик", key: uniqueId(), property: "maker" },
  { title: "Дата приобритения", key: uniqueId(), property: "date" },
  { title: "Стоимость", key: uniqueId(), property: "cost" },
  { title: "Комната", key: uniqueId(), property: "room" },
  { title: "Адрес здания", key: uniqueId(), property: "building" },
  { title: "Состояние", key: uniqueId(), property: "state" },
  {
    title: "Материально ответственное лицо",
    key: uniqueId(),
    property: "economicOfficer"
  },
  { title: "Принимающий бухгалтер", key: uniqueId(), property: "accountant" }
];

class ObjectPropertyTable extends Component {
  state = {
    openRecords: false,
    selectedRequest: null
  };

  editObject = id => {
    this.props.history.push("/object/edit/" + id);
  };

  copyObject = id => {
    this.props.history.push("/object/copy/" + id);
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
          <Print single name="objectPropertyTable">
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
                      onDoubleClick={() => this.editObject(row.id)}
                    >
                      <TableCell component="th" scope="row">
                        {row.propertyNumber}
                      </TableCell>
                      <TableCell component="th" scope="row">
                        {row.caption}
                      </TableCell>
                      <TableCell component="th" scope="row">
                        {row.maker}
                      </TableCell>
                      <TableCell component="th" scope="row">
                        {row.date}
                      </TableCell>
                      <TableCell component="th" scope="row">
                        {row.cost}
                      </TableCell>
                      <TableCell component="th" scope="row">
                        {row.room.number}
                      </TableCell>
                      <TableCell component="th" scope="row">
                        {row.room.building.address}
                      </TableCell>
                      <TableCell component="th" scope="row">
                        {row.state}
                      </TableCell>
                      <TableCell component="th" scope="row">
                        {row.economicOfficer.name}
                      </TableCell>
                      <TableCell component="th" scope="row">
                        {row.accountant.name}
                      </TableCell>
                      <NoPrint>
                        <TableCell component="th" scope="row">
                          <IconButton
                            className={classes.margin}
                            aria-label="Copy"
                            onClick={() => this.copyObject(row.id)}
                          >
                            <CopyIcon />
                          </IconButton>
                        </TableCell>
                      </NoPrint>
                    </TableRow>
                  ))}
              </TableBody>
            </Table>
          </Print>
      </React.Fragment>
    );
  }
}

export default withStyles(styles)(withRouter(ObjectPropertyTable));
