import React, { Component } from "react";
import Button from "@material-ui/core/Button/Button";
import ObjectFilterForm from "./filter/ObjectFilterDrawer";
import Grid from "@material-ui/core/Grid/Grid";
import Typography from "@material-ui/core/es/Typography/Typography";
import FilterList from "@material-ui/icons/FilterList";
import AddIcon from "@material-ui/icons/Add";
import ObjectPropertyTable from "./ObjectPropertyTable";
import * as request from "../../../commons/request";
import { withStyles } from "@material-ui/core";
import { isEqual } from "lodash";
import SimpleAlertDialog from "../../../commons/dialog/SimpleAlertDialog";
import { withRouter } from "react-router";

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
      <React.Fragment>
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
        <Grid
          container
          direction="row"
          justify="space-between"
          alignItems="center"
          spacing={24}
        >
          <Grid item xs>
            <Typography variant="h3" gutterBottom className={classes.margin}>
              Объекты учета
            </Typography>
          </Grid>
          <Grid item xs={1}>
            <Button
              variant="contained"
              color="primary"
              onClick={this.changeFilterVisibility}
              className={classes.button}
            >
              Фильтр
              <FilterList className={classes.rightIcon} />
            </Button>
          </Grid>
          <Grid item xs={3}>
            <Button
              variant="contained"
              color="primary"
              onClick={this.createObject}
              className={classes.button}
            >
              Зарегистрировать новый объект
              <AddIcon className={classes.rightIcon} />
            </Button>
          </Grid>
          <Grid item xs={12}>
            <ObjectPropertyTable data={objects} />
          </Grid>
        </Grid>
      </React.Fragment>
    );
  }
}

export default withStyles(styles)(withRouter(ObjectPropertyTableForm));
