import React, { Component } from "react";
import TableHead from "@material-ui/core/TableHead/TableHead";
import TableRow from "@material-ui/core/TableRow/TableRow";
import TableCell from "@material-ui/core/TableCell/TableCell";
import TableBody from "@material-ui/core/TableBody/TableBody";
import Table from "@material-ui/core/Table/Table";
import { uniqueId } from "lodash";
import { withStyles } from "@material-ui/core";
import ObjectPropertyDialog from "../objectProperty/ObjectPropertyDialog";
import * as request from "../../commons/request";
import stateProvider from "../../commons/stateProvider";
import SimpleAlertDialog from "../../commons/dialog/SimpleAlertDialog";

const columns = [
  { title: "Причина", key: uniqueId(), property: "reason" },
  {
    title: "Инвентарный номер",
    key: uniqueId(),
    property: "object.numberProperty"
  },
  { title: "Название", key: uniqueId(), property: "object.caption" }
];

class CancellationRecordTable extends Component {
  state = {
    selectedProperty: null,
    cancelled: false,
    error: null
  };
  cancelObject = (property, reason) => {
    request
      .post("/cancellation/object", {
        object: property,
        reason: reason,
        accountant: stateProvider.user
      })
      .then(() => {
        this.setState({ cancelled: true });
      })
      .catch(error => {
        this.setState({ error });
      });
  };
  render() {
    const { classes, data } = this.props;
    const { selectedRecord, cancelled, error } = this.state;
    return (
      <>
        {cancelled && (
          <SimpleAlertDialog
            title="Объект списан"
            onClose={() => {
              this.setState({cancelled: false});
            }}
            open={Boolean(cancelled)}
          />
        )}
        {error && (
          <SimpleAlertDialog
            title="Произошла ошибка"
            content={error}
            onClose={() => {
              this.setState({error: null});
            }}
            open={Boolean(error)}
          />
        )}
        {selectedRecord && (
          <ObjectPropertyDialog
            onClose={() => {
              this.setState({
                objectDialogOpened: false,
                selectedRecord: null
              });
            }}
            open={Boolean(selectedRecord)}
            property={selectedRecord.object}
            onCancel={(object) => this.cancelObject(object, selectedRecord.result)}
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
                    this.setState({
                      selectedRecord: row
                    });
                  }}
                >
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
      </>
    );
  }
}

export default withStyles(null)(CancellationRecordTable);
