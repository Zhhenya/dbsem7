import React, { Component } from "react";
import classNames from "classnames";
import AppBar from "@material-ui/core/AppBar/AppBar";
import Toolbar from "@material-ui/core/Toolbar/Toolbar";
import stateProvider from "../commons/stateProvider";
import IconButton from "@material-ui/core/IconButton/IconButton";
import MenuIcon from "@material-ui/icons/Menu";
import AccountCircle from "@material-ui/icons/AccountCircle";
import KeyboardBackspace from "@material-ui/icons/KeyboardBackspace";
import withStyles from "@material-ui/core/styles/withStyles";
import Paper from "@material-ui/core/es/Paper/Paper";
import Typography from "@material-ui/core/Typography/Typography";
import { withRouter } from "react-router";
import MenuDrawer from "./menu/MenuDrawer";
import CssBaseline from "@material-ui/core/CssBaseline/CssBaseline";
import Menu from "@material-ui/core/Menu/Menu";
import MenuItem from "@material-ui/core/MenuItem/MenuItem";
import * as request from "../commons/request";

const drawerWidth = 240;

const styles = theme => ({
  root: {
    display: "flex",
    flexGrow: 1
  },
  grow: {
    flexGrow: 1
  },
  appBar: {
    transition: theme.transitions.create(["margin", "width"], {
      easing: theme.transitions.easing.sharp,
      duration: theme.transitions.duration.leavingScreen
    })
  },
  appBarShift: {
    width: `calc(100% - ${drawerWidth}px)`,
    marginLeft: drawerWidth,
    transition: theme.transitions.create(["margin", "width"], {
      easing: theme.transitions.easing.easeOut,
      duration: theme.transitions.duration.enteringScreen
    })
  },
  paper: {
    height: "100vh"
  },
  menuButton: {
    marginLeft: 12,
    marginRight: 20
  },
  hide: {
    display: "none"
  },
  drawer: {
    width: drawerWidth,
    flexShrink: 0
  },
  drawerPaper: {
    width: drawerWidth
  },
  drawerHeader: {
    display: "flex",
    alignItems: "center",
    padding: "0 8px",
    ...theme.mixins.toolbar,
    justifyContent: "flex-end"
  },
  content: {
    flexGrow: 1,
    transition: theme.transitions.create("margin", {
      easing: theme.transitions.easing.sharp,
      duration: theme.transitions.duration.leavingScreen
    }),
    marginLeft: -drawerWidth
  },
  contentShift: {
    transition: theme.transitions.create("margin", {
      easing: theme.transitions.easing.easeOut,
      duration: theme.transitions.duration.enteringScreen
    }),
    marginLeft: 0
  },
  sectionDesktop: {
    display: "none",
    [theme.breakpoints.up("md")]: {
      display: "flex"
    }
  }
});

class AppWrapper extends Component {
  state = {
    currentLocation: undefined,
    anchorEl: null,
    isMenuOpen: false
  };

  static getDerivedStateFromProps(nextProps, prevState) {
    const {
      location: { pathname }
    } = nextProps;

    if (pathname !== prevState.currentLocation) {
      return {
        currentLocation: pathname,
        isMenuOpen: false
      };
    }

    return null;
  }

  isHome = () => this.props.location.pathname === "/";

  changeMenuVisible = () => {
    this.setState({ isMenuOpen: !this.state.isMenuOpen });
  };

  openAccountMenu = event => {
    this.setState({ anchorEl: event.currentTarget });
  };

  closeAccountMenu = () => {
    this.setState({ anchorEl: null });
  };

  logout = () => {
    request.post("/logoutRequest").then(() => {
      if (this.props.location.pathname !== "/") {
        this.props.history.replace("/");
      }
      stateProvider.authorized = false;
      stateProvider.user = null;
    });
  };

  openProfile = () => {
    this.props.history.push("/profile");
  };

  render() {
    const { classes, children } = this.props;
    const { anchorEl, isMenuOpen } = this.state;
    const auth = stateProvider.authorized;
    const name = (stateProvider.user && stateProvider.user.name) || "";
    const isAccountMenuOpen = Boolean(anchorEl);

    console.log({ props: this.props, state: this.state });

    return (
      <div className={classes.root}>
        <CssBaseline />
        <AppBar
          position="fixed"
          className={classNames(classes.appBar, {
            [classes.appBarShift]: isMenuOpen
          })}
        >
          <Toolbar disableGutters={!isMenuOpen}>
            {this.isHome() ? (
              <IconButton
                className={classNames(
                  classes.menuButton,
                  isMenuOpen && classes.hide
                )}
                color="inherit"
                aria-label="Menu"
                onClick={this.changeMenuVisible}
              >
                <MenuIcon />
              </IconButton>
            ) : (
              <IconButton
                color="inherit"
                className={classes.menuButton}
                onClick={this.props.history.goBack}
              >
                <KeyboardBackspace />
              </IconButton>
            )}
            <Typography
              className={classes.title}
              variant="h6"
              color="inherit"
              noWrap
            >
              Учет имущества университетского городка
            </Typography>
            <div className={classes.grow} />
            {auth && (
              <div className={classes.sectionDesktop}>
                <Typography
                  style={{ marginRight: 5, marginTop: 5 }}
                  className={classes.title}
                  variant="h6"
                  color="inherit"
                  noWrap
                >
                  {name}
                </Typography>
                <IconButton
                  aria-owns={isAccountMenuOpen ? "menu-appbar" : undefined}
                  aria-haspopup="true"
                  onClick={this.openAccountMenu}
                  color="inherit"
                >
                  <AccountCircle />
                </IconButton>
                <Menu
                  id="menu-appbar"
                  anchorEl={anchorEl}
                  anchorOrigin={{
                    vertical: "top",
                    horizontal: "right"
                  }}
                  transformOrigin={{
                    vertical: "top",
                    horizontal: "right"
                  }}
                  open={isAccountMenuOpen}
                  onClose={this.closeAccountMenu}
                >
                  <MenuItem onClick={this.openProfile}>Профиль</MenuItem>
                  <MenuItem onClick={this.logout}>Выйти</MenuItem>
                </Menu>
              </div>
            )}
          </Toolbar>
        </AppBar>
        <MenuDrawer
          classes={classes}
          open={isMenuOpen}
          onClose={this.changeMenuVisible}
        />
        <main
          className={classNames(classes.content, {
            [classes.contentShift]: isMenuOpen
          })}
        >
          <div className={classes.drawerHeader} />
          <Paper className={classes.paper}>{children}</Paper>
        </main>
      </div>
    );
  }
}

export default withStyles(styles)(withRouter(AppWrapper));
