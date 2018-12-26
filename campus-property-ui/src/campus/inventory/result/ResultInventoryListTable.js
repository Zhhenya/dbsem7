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
    selectedObject: null
  };
  openObjectForm = selectedObject => {
    this.setState({ selectedObject });
  };

  render() {
    const { onSave, data, editable } = this.props;
    const { selectedObject } = this.state;
    return (
      <>
        {selectedObject && (
          <ObjectPropertyDialog
            onClose={() => {
              this.setState({
                selectedObject: null
              });
            }}
            open={Boolean(selectedObject)}
            property={selectedObject}
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
                            this.openObjectForm(row.objectProperty)
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
