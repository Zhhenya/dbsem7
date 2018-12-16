import React from "react";
import { uniqueId } from "lodash";

import { withStyles } from "@material-ui/core/styles";
import Grid from "@material-ui/core/Grid";
import Button from "@material-ui/core/Button";
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
        marginTop: theme.spacing.unit * 3,
        overflowX: "auto"
    },
    table: {
        minWidth: 700
    }
});

const columns = [
    { title: "Дата инвентаризации", key: uniqueId(), property: "date" },
    { title: "Список объектов", key: uniqueId(), property: "list_objects" }
];

const InventoryListTable = props => {
    const { classes, data } = props;
    return (
        <Paper className={classes.root}>
            <AppBar position="static" color="default">
                <Toolbar>
                    <Grid container justify={"flex-start"}>
                        <Typography variant="h6" color="inherit">
                            Список заявок
                        </Typography>
                    </Grid>
                    <Grid container justify={"flex-end"}>
                        <Button variant="contained" color="primary" className={classes.button}>
                            Начать новую инвентаризацию
                        </Button>
                    </Grid>
                </Toolbar>
            </AppBar>
            <Table className={classes.table}>
                <TableHead>
                    <TableRow>
                        {columns.map(column => (
                            <TableCell key={ column.key }>{ column.title }</TableCell>
                        ))}
                    </TableRow>
                </TableHead>
                    <TableBody>
                        {data && data.map(row => (
                            <TableRow key={row.id}>
                                <TableCell component="th" scope="row">
                                    {row.content}
                                </TableCell>
                                <TableCell component="th" scope="row">
                                    {row.type}
                                </TableCell>
                            </TableRow>
                        ))}
                    </TableBody>
            </Table>
        </Paper>
    );
};

export default withStyles(styles)(InventoryListTable);
