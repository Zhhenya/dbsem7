import React from "react";
import Drawer from "@material-ui/core/Drawer/Drawer";
import Divider from "@material-ui/core/Divider/Divider";
import IconButton from "@material-ui/core/IconButton/IconButton";
import ChevronLeftIcon from "@material-ui/icons/ChevronLeft";
import stateProvider from "../../commons/stateProvider";
import AccountantMenu from "./AcountantMenu";
import Roles from "../enums/Roles";

const getMenuList = () => {
  switch (stateProvider.user.role) {
    case Roles.ACCOUNTANT:
      return <AccountantMenu />;
    default:
      return null;
  }
};

const MenuDrawer = props => {
  const { classes, onClose, ...other } = props;
  return (
    <Drawer
      className={classes.drawer}
      variant="persistent"
      classes={{
        paper: classes.drawerPaper
      }}
      anchor="left"
      {...other}
    >
      <div className={classes.drawerHeader}>
        <IconButton onClick={onClose}>
          <ChevronLeftIcon />
        </IconButton>
      </div>
      <Divider />
      {getMenuList()}
    </Drawer>
  );
};

export default MenuDrawer;
