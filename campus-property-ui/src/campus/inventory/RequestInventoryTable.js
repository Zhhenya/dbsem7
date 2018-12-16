import {uniqueId} from "lodash";
import React, { Component } from "react";
import Table from "@material-ui/core/Table";
import TableHead from "@material-ui/core/TableHead";
import TableRow from "@material-ui/core/TableRow";
import TableCell from "@material-ui/core/TableCell";
import TableBody from "@material-ui/core/TableBody";
import {withStyles} from "@material-ui/core";


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
    { title: "ID", key: uniqueId(), property: "id"},
    { title: "Инвентарный номер", key: uniqueId(), property: "propertyNumber" },
    { title: "Название", key: uniqueId(), property: "caption" },
    { title: "Поставщик", key: uniqueId(), property: "maker" },
    { title: "Дата приобритения", key: uniqueId(), property: "date" },
    { title: "Стоимость", key: uniqueId(), property: "cost"},
    { title: "Комната", key: uniqueId(), property: "room"},
    { title: "Состояние", key: uniqueId(), property: "state"},
    { title: "Материально ответственное лицо", key: uniqueId(), property: "economicOfficer" },
    { title: "Принимающий бухгалтер", key: uniqueId(), property: "accountant"}
];

class RequestInventoryTable extends Component{
    state = {
        openRecords: false,
        selectedRequest: null
    };

    render() {
        const { classes, data} = this.props;
        return (
            <React.Fragment>
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
                                    {row.state}
                                </TableCell>
                                <TableCell component="th" scope="row">
                                    {row.date}
                                </TableCell>
                                <TableCell component="th" scope="row">
                                    {row.economicOfficer.name}
                                </TableCell>
                                <TableCell component="th" scope="row">
                                    {row.room}
                                </TableCell>
                                <TableCell component="th" scope="row">
                                    {row.cost}
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

export default withStyles(styles)(RequestInventoryTable);
