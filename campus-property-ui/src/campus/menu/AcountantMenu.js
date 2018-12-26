import React from "react";
import List from "@material-ui/core/List/List";
import ListItem from "@material-ui/core/ListItem/ListItem";
import ListItemIcon from "@material-ui/core/ListItemIcon/ListItemIcon";
import ListItemText from "@material-ui/core/ListItemText/ListItemText";
import EventNote from "@material-ui/icons/EventNote";
import Storage from "@material-ui/icons/Storage";
import AddBox from "@material-ui/icons/AddBox";
import Mail from "@material-ui/icons/Mail";
import AssignmentLate from "@material-ui/icons/AssignmentLate";
import { Link } from "react-router-dom";
import Divider from "@material-ui/core/es/Divider/Divider";
import AssignmentTurnedIn from "@material-ui/icons/AssignmentTurnedIn"

const LinkToRequests = props => (
  <Link to="/accountant/request/list" {...props} />
);
const LinkToPropertyTable = props => (
  <Link to="/objectProperty/table" {...props} />
);
const LinkToObjectCreating = props => <Link to="/object/add" {...props} />;
const LinkToLetter = props => <Link to="/accountant/letter" {...props} />;
const LinkToActList = props => <Link to="/cancellation/acts" {...props} />;
const LinkToInventoryList = props => <Link to="/inventory" {...props} />;

const AccountantMenu = () => {
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
        <ListItem button component={LinkToObjectCreating}>
          <ListItemIcon>
            <AddBox />
          </ListItemIcon>
          <ListItemText primary={"Зарегистрировать новый объект"} />
        </ListItem>
      </List>
      <Divider />
      <List>
        <ListItem button component={LinkToLetter}>
          <ListItemIcon>
            <Mail />
          </ListItemIcon>
          <ListItemText primary={"Сообщение для взыскания средств"} />
        </ListItem>
      </List>
      <Divider />
      <List>
        <ListItem button component={LinkToInventoryList}>
          <ListItemIcon>
            <AssignmentTurnedIn />
          </ListItemIcon>
          <ListItemText primary={"Инвентаризации"} />
        </ListItem>
      </List>
      <Divider />
      <List>
        <ListItem button component={LinkToActList}>
          <ListItemIcon>
            <AssignmentLate />
          </ListItemIcon>
          <ListItemText primary={"Акты о списании"} />
        </ListItem>
      </List>
    </React.Fragment>
  );
};

export default AccountantMenu;
