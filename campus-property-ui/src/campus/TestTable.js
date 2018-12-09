import React from "react";
import {withStyles} from '@material-ui/core/styles';
import {uniqueId} from 'lodash';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import AppBar from '@material-ui/core/AppBar';
import Toolbar from '@material-ui/core/Toolbar';
import Typography from '@material-ui/core/Typography';
import Paper from '@material-ui/core/Paper';

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
    {title: "Column 1", key: uniqueId(), property: "column1"},
    {title: "Column 2", key: uniqueId(), property: "column2"},
    {title: "Column 3", key: uniqueId(), property: "column3"},
];

const data = [
    {id: uniqueId(), column1: "1", column2: "2", column3: "3"},
    {id: uniqueId(), column1: "4", column2: "5", column3: "6"},
    {id: uniqueId(), column1: "7", column2: "8", column3: "9"},
]

const TestTable = (props) => {
    const {classes, title} = props;
    return (
        <Paper className={classes.root}>
            <AppBar position="static" color="default">
                <Toolbar>
                    <Typography variant="h6" color="inherit">
                        {title}
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
                    {data.map(row => <TableRow key={row.id}>
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

export default withStyles(styles)(TestTable);