import React from "react";
import Table from "@material-ui/core/Table/Table";
import TableRow from "@material-ui/core/TableRow/TableRow";
import TableCell from "@material-ui/core/TableCell/TableCell";
import TableHead from "@material-ui/core/TableHead/TableHead";
import { uniqueId } from "lodash";
import TableBody from "@material-ui/core/TableBody/TableBody";
import * as PropTypes from "prop-types";

const columns = [
  { title: "Содержание", key: uniqueId(), property: "note" },
  {
    title: "Инвентарный номер объекта",
    key: uniqueId(),
    property: "objectNumber"
  }
];

const RequestRecordList = props => {
  const { records } = props;
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
        {records &&
          records.map(row => (
            <TableRow key={row.id}>
              <TableCell component="th" scope="row">
                {row.note}
              </TableCell>
              <TableCell component="th" scope="row">
                {(row.objectProperty && row.objectProperty.propertyNumber) ||
                  ""}
              </TableCell>
            </TableRow>
          ))}
      </TableBody>
    </Table>
  );
};

RequestRecordList.propTypes = {
  records: PropTypes.array
};

export default RequestRecordList;
