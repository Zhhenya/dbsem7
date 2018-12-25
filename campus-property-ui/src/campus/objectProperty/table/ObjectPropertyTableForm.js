import React, { Component } from "react";
import Button from "@material-ui/core/Button/Button";
import ObjectFilterForm from "./filter/ObjectFilterDrawer";
import Typography from "@material-ui/core/es/Typography/Typography";
import FilterList from "@material-ui/icons/FilterList";
import AddIcon from "@material-ui/icons/Add";
import ObjectPropertyTable from "./ObjectPropertyTable";
import * as request from "../../../commons/request";
import { withStyles } from "@material-ui/core";
import { isEqual } from "lodash";
import SimpleAlertDialog from "../../../commons/dialog/SimpleAlertDialog";
import { withRouter } from "react-router";
import Toolbar from "@material-ui/core/Toolbar/Toolbar";

const styles = theme => ({
  root: {
    flexGrow: 1
  },
  margin: {
    margin: theme.spacing.unit * 4
  },
  button: {
    margin: theme.spacing.unit * 4
  },
  rightIcon: {
    marginLeft: theme.spacing.unit
  }
});

const INITIAL_FILTER = {
  caption: null,
  numberGreater: null,
  numberLess: null,
  maker: null,
  dateLater: null,
  dateEarlier: null,
  costGreater: null,
  costLess: null,
  room: null,
  building: null,
  state: null,
  officer: null,
  accountant: null
};

class ObjectPropertyTableForm extends Component {
  state = {
    filter: INITIAL_FILTER,
    objects: [],
    isFilterVisible: false,
    error: null
  };

  componentDidMount() {
    this.fetchFilteredData();
  }

  componentDidUpdate(prevProps, prevState, snapshot) {
    if (!isEqual(prevState.filter, this.state.filter)) {
      this.fetchFilteredData();
    }
  }

  fetchFilteredData = () => {
    request
      .post("object/filtered", this.state.filter)
      .then(objects => {
        this.setState({ objects });
      })
      .catch(error => {
        this.setState({ error });
      });
  };

  changeFilterVisibility = () => {
    this.setState({ isFilterVisible: !this.state.isFilterVisible });
  };

  createObject = () => {
    this.props.history.push("/object/add");
  };

  render() {
    const { filter, objects, isFilterVisible, error } = this.state;
    const { classes } = this.props;
    return (
      <>
        {error && (
          <SimpleAlertDialog
            open={error}
            title="Произошла ошибка"
            content={error}
            onClose={() => {
              this.setState({ error: null });
            }}
          />
        )}
        <ObjectFilterForm
          open={isFilterVisible}
          filter={filter}
          onClose={this.changeFilterVisibility}
          onSubmit={filter => {
            this.setState({ filter });
          }}
        />
        <Toolbar>
          <Typography variant="h6" color="inherit">
            Объекты учета
          </Typography>
          <div style={{ flexGrow: 1 }} />
          <Button
            variant="contained"
            color="primary"
            onClick={this.changeFilterVisibility}
            className={classes.button}
          >
            Фильтр
            <FilterList className={classes.rightIcon} />
          </Button>
          <Button
            variant="contained"
            color="primary"
            onClick={this.createObject}
            className={classes.button}
          >
            Зарегистрировать новый объект
            <AddIcon className={classes.rightIcon} />
          </Button>
        </Toolbar>
        <ObjectPropertyTable data={objects} />
      </>
    );
  }
}

export default withStyles(styles)(withRouter(ObjectPropertyTableForm));
