import {uniqueId} from "lodash";
import React, { Component } from "react";
import Table from "@material-ui/core/Table";
import TableHead from "@material-ui/core/TableHead";
import TableRow from "@material-ui/core/TableRow";
import TableCell from "@material-ui/core/TableCell";
import TableBody from "@material-ui/core/TableBody";
import {withStyles} from "@material-ui/core";
import RequestRecordListDialog from "../request/record/RequestRecordListDialog";


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

class ObjectPropertyTable extends Component{
    state = {
        openRecords: false,
        selectedRequest: null
    };

    render() {
        const { classes, data} = this.props;
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
                                    {row.state}
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

export default withStyles(styles)(ObjectPropertyTable);
