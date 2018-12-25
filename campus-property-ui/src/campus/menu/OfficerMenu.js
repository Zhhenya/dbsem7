import React from "react";
import List from "@material-ui/core/List/List";
import ListItem from "@material-ui/core/ListItem/ListItem";
import ListItemIcon from "@material-ui/core/ListItemIcon/ListItemIcon";
import ListItemText from "@material-ui/core/ListItemText/ListItemText";
import Divider from "@material-ui/core/es/Divider/Divider";
import { Link } from "react-router-dom";
import Storage from "@material-ui/icons/Storage";
import Store from "@material-ui/icons/Store";
import EventNote from "@material-ui/icons/EventNote";
import Assignment from "@material-ui/icons/Assignment";

const LinkToRequests = props => <Link to="/officer/request/list" {...props} />;
const LinkToPropertyTable = props => (
  <Link to="/objectProperty/table" {...props} />
);
const LinkToBuildings = props => <Link to="/building/list" {...props} />;
const LinkToInventoryList = props => <Link to="/inventory" {...props} />;

const OfficerMenu = () => {
  return (
    <React.Fragment>
      <List>
        <ListItem button component={LinkToRequests}>
          <ListItemIcon>
            <EventNote />
          </ListItemIcon>
          <ListItemText primary={"Заявки"} />
        </ListItem>
      </List>
      <Divider />
      <List>
        <ListItem button component={LinkToPropertyTable}>
          <ListItemIcon>
            <Storage />
          </ListItemIcon>
          <ListItemText primary={"Инвентарь"} />
        </ListItem>
      </List>
      <Divider />
      <List>
        <ListItem button component={LinkToBuildings}>
          <ListItemIcon>
            <Store />
          </ListItemIcon>
          <ListItemText primary={"Здания"} />
        </ListItem>
      </List>
      <Divider />
      <List>
        <ListItem button component={LinkToInventoryList}>
          <ListItemIcon>
            <Assignment />
          </ListItemIcon>
          <ListItemText primary={"Результаты инвентаризаций"} />
        </ListItem>
      </List>
    </React.Fragment>
  );
};

export default OfficerMenu;
