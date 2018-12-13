import React, { Component } from "react";
import AppBar from "@material-ui/core/AppBar/AppBar";
import Toolbar from "@material-ui/core/Toolbar/Toolbar";
import stateProvider from "../commons/stateProvider";
import IconButton from "@material-ui/core/IconButton/IconButton";
import MenuIcon from "@material-ui/icons/Menu";
import AccountCircle from "@material-ui/icons/AccountCircle";
import withStyles from "@material-ui/core/styles/withStyles";
import Paper from "@material-ui/core/es/Paper/Paper";
import Typography from "@material-ui/core/Typography/Typography";
import Tooltip from "@material-ui/core/Tooltip/Tooltip";

const styles = theme => ({
  root: {
    flexGrow: 1
  },
  grow: {
    flexGrow: 1
  },
  menuButton: {
    marginLeft: -12,
    marginRight: 20
  },
  title: {
    display: "none",
    [theme.breakpoints.up("sm")]: {
      display: "block"
    }
  }
});

class AppWrapper extends Component {
  state = {
    anchorEl: null
  };

  render() {
    const { classes, children } = this.props;
    const { anchorEl } = this.state;
    const auth = stateProvider.authorized;
    const name = (stateProvider.user && stateProvider.user.name) || "";
    const open = Boolean(anchorEl);
    return (
      <AppBar position="static">
        <Toolbar>
          <IconButton
            className={classes.menuButton}
            color="inherit"
            aria-label="Menu"
          >
            <MenuIcon/>
          </IconButton>
          <Typography
            className={classes.title}
            variant="h6"
            color="inherit"
            noWrap
          >
            Учет имущества университетского городка
          </Typography>
          <div className={classes.grow}/>
          {auth && (
            <Tooltip disableFocusListener disableTouchListener title={name}>
              <IconButton
                aria-owns={open ? "menu-appbar" : undefined}
                aria-haspopup="true"
                color="inherit"
              >
                <AccountCircle/>
              </IconButton>
            </Tooltip>
          )}
        </Toolbar>
        <Paper>{children}</Paper>
      </AppBar>
    );
  }
}

export default withStyles(styles)(AppWrapper);
