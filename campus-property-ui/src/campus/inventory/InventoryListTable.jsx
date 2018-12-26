import React from "react";

import { withStyles } from "@material-ui/core/styles";
import Button from "@material-ui/core/Button";
import Toolbar from "@material-ui/core/Toolbar";
import Typography from "@material-ui/core/Typography";
import List from "@material-ui/core/List/List";
import ListItemLink from "../../components/ListItemLink";
import * as request from "../../commons/request";
import { withRouter } from "react-router";
import Divider from "@material-ui/core/es/Divider/Divider";
import stateProvider from "../../commons/stateProvider";
import Roles from "../enums/Roles";

const styles = theme => ({
  root: {
    marginTop: theme.spacing.unit * 3,
    overflowX: "auto"
  },
  table: {
    minWidth: 700
  }
});

const start = props => {
  request.get("/inventory/init").then(inventoryId => {
    props.history.push(
      "/inventory/" + inventoryId + "/result-inventory/processing"
    );
  });
};

const canStart = () => stateProvider.user.role === Roles.OFFICER;

const InventoryListTable = props => {
  const { classes, data } = props;
  return (
    <React.Fragment>
      <Toolbar>
        <Typography variant="h6" color="inherit">
          Список инвентаризаций
        </Typography>
        <div style={{ flexGrow: 1 }} />
        {canStart() && (
          <Button
            variant="contained"
            color="primary"
            className={classes.button}
            onClick={() => start(props)}
          >
            Начать новую инвентаризацию
          </Button>
        )}
      </Toolbar>
      <Divider />
      <List>
        {data &&
          data.map(row => {
            const date = new Date(Date.parse(row.date));
            const outDate =
              date.getDate() + "." + date.getMonth() + "." + date.getFullYear();
            return (
              <ListItemLink
                href={"#/inventory/" + row.id + "/result-inventory/"}
                key={row.id}
              >
                Инвентаризация от {outDate}
              </ListItemLink>
            );
          })}
      </List>
    </React.Fragment>
  );
};

export default withStyles(styles)(withRouter(InventoryListTable));
