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
import List from "@material-ui/core/List/List";
import ListItemLink from "../../components/ListItemLink";

const styles = theme => ({
    root: {
        marginTop: theme.spacing.unit * 3,
        overflowX: "auto"
    },
    table: {
        minWidth: 700
    }
});

const InventoryListTable = props => {
    const { classes, data } = props;
    return (
        <React.Fragment>
            <AppBar position="static" color="default">
                <Toolbar>
                    <Grid container justify={"flex-start"}>
                        <Typography variant="h6" color="inherit">
                            Список инвентаризаций
                        </Typography>
                    </Grid>
                    <Grid container justify={"flex-end"}>
                        <Button variant="contained" color="primary" className={classes.button}>
                            Начать новую инвентаризацию
                        </Button>
                    </Grid>
                </Toolbar>
            </AppBar>
            <List>
                {
                    data && data.map(
                        row => {
                            const date = new Date(Date.parse(row.date));
                            const outDate = date.getDate() + '.' + date.getMonth() + '.' + date.getFullYear();
                            return (
                                <ListItemLink href={"#/inventory/" + row.id + "/result-inventory/"} key={row.id}>
                                    Инвентаризация от {outDate}
                                </ListItemLink>
                            )
                        }
                    )
                }
            </List>

        </React.Fragment>
    );
};

export default withStyles(styles)(InventoryListTable);
