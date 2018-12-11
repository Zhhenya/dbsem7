import React from "react";
import { withStyles } from "@material-ui/core/styles";
import { uniqueId } from "lodash";
import Table from "@material-ui/core/Table";
import TableBody from "@material-ui/core/TableBody";
import TableCell from "@material-ui/core/TableCell";
import TableHead from "@material-ui/core/TableHead";
import TableRow from "@material-ui/core/TableRow";
import AppBar from "@material-ui/core/AppBar";
import Toolbar from "@material-ui/core/Toolbar";
import Typography from "@material-ui/core/Typography";
import Paper from "@material-ui/core/Paper";

const styles = theme => ({
    root: {
        width: '100%',
        marginTop: theme.spacing.unit * 3,
        overflowX: 'auto',
    },
    table: {
        minWidth: 700,
    },
});

const columns = [
    {title: "Содержание", key: uniqueId(), property: "content"},
    {title: "Тип", key: uniqueId(), property: "type"},
    {title: "Состояние", key: uniqueId(), property: "state"},
    {title: "Сотрудник университета", key: uniqueId(), property: "universityWorker"},
    {title: "Сотрудник хоз. части", key: uniqueId(), property: "economicOfficer"},
    {title: "Бухгалтер", key: uniqueId(), property: "accountant"},
    {title: "Записи", key: uniqueId(), property: "records"},
];

const RequestListTable = (props) => {
    const {classes, data} = props;
    return (
        <Paper className={classes.root}>
            <AppBar position="static" color="default">
                <Toolbar>
                    <Typography variant="h6" color="inherit">
                        "Список заявок"
                    </Typography>
                </Toolbar>
            </AppBar>
            <Table className={classes.table}>
                <TableHead>
                    <TableRow>
                        {columns.map(column => <TableCell key={column.key}>{column.title}</TableCell>)}
                    </TableRow>
                </TableHead>
                <TableBody>
                    {data && data.map(row => <TableRow key={row.id}>
                                {columns.map((column, index) =>
                                    <TableCell key={index} component="th" scope="row">
                                        {row[column.property]}
                                        </TableCell>)}
                            </TableRow>
                        )
                    }
                </TableBody>
            </Table>
        </Paper>
    );
};

export default withStyles(styles)(RequestListTable);