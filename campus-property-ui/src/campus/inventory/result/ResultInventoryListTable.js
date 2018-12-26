import React, { Component } from "react";
import { uniqueId } from "lodash";

import { withStyles } from "@material-ui/core/styles";
import Table from "@material-ui/core/Table";
import TableBody from "@material-ui/core/TableBody";
import TableCell from "@material-ui/core/TableCell";
import TableHead from "@material-ui/core/TableHead";
import TableRow from "@material-ui/core/TableRow";
import Toolbar from "@material-ui/core/Toolbar";
import Typography from "@material-ui/core/Typography";
import Button from "@material-ui/core/Button/Button";
import { FieldArray, Form, Formik } from "formik";
import InputField from "../../../components/InputField";
import ObjectPropertyDialog from "../../objectProperty/ObjectPropertyDialog";
import * as request from "../../../commons/request";
import stateProvider from "../../../commons/stateProvider";
import SimpleAlertDialog from "../../../commons/dialog/SimpleAlertDialog";

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
  { title: "Состояние", key: uniqueId(), property: "state" },
  { title: "Название", key: uniqueId(), property: "caption" },
  { title: "Адрес здания", key: uniqueId(), property: "building" },
  { title: "Комната", key: uniqueId(), property: "room" },
  { title: "Результат инвентаризации", key: uniqueId(), property: "result" }
];

class ResultInventoryListTable extends Component {
  state = {
    selectedRecord: null,
    cancelled: false,
    error: null
  };
  openObjectForm = selectedRecord => {
    this.setState({ selectedRecord });
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
    const { onSave, data, editable } = this.props;
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
                selectedRecord: null
              });
            }}
            open={Boolean(selectedRecord)}
            property={selectedRecord.objectProperty}
            onCancel={(object) => this.cancelObject(object, selectedRecord.result)}
          />
        )}
        <Formik
          initialValues={{ data: data }}
          onSubmit={onSave}
          render={() => (
            <Form>
              <Toolbar>
                <Typography variant="h6" color="inherit">
                  Результаты инвентаризации
                </Typography>
                <div style={{ flexGrow: 1 }} />
                {editable && (
                  <Button variant="contained" color="primary" type="submit">
                    Сохранить изменения
                  </Button>
                )}
              </Toolbar>
              <Table className={this.props.classes.table}>
                <TableHead>
                  <TableRow>
                    {columns.map(column => (
                      <TableCell key={column.key}>{column.title}</TableCell>
                    ))}
                  </TableRow>
                </TableHead>
                <TableBody>
                  <FieldArray
                    name="data"
                    render={() =>
                      data &&
                      data.length > 0 &&
                      data.map((row, index) => (
                        <TableRow
                          key={row.id}
                          onDoubleClick={() =>
                            this.openObjectForm(row)
                          }
                        >
                          <TableCell scope="row">
                            {row.objectProperty.propertyNumber}
                          </TableCell>
                          <TableCell scope="row">
                            {row.objectProperty.state}
                          </TableCell>
                          <TableCell scope="row">
                            {row.objectProperty.caption}
                          </TableCell>
                          <TableCell scope="row">
                            {row.objectProperty.room.building.address}
                          </TableCell>
                          <TableCell scope="row">
                            {row.objectProperty.room.number}
                          </TableCell>
                          <TableCell scope="row">
                            {!editable ? (
                              row.result
                            ) : (
                              <InputField name={`data[${index}]result`} />
                            )}
                          </TableCell>
                        </TableRow>
                      ))
                    }
                  />
                </TableBody>
              </Table>
            </Form>
          )}
        />
      </>
    );
  }
}

export default withStyles(styles)(ResultInventoryListTable);
