import React, { Component } from "react";
import Button from "@material-ui/core/Button/Button";
import ObjectFilterForm from "./filter/ObjectFilterDrawer";
import Grid from "@material-ui/core/Grid/Grid";
import Typography from "@material-ui/core/es/Typography/Typography";
import AddIcon from "@material-ui/core/SvgIcon/SvgIcon";
import ObjectPropertyTable from "../ObjectPropertyTable";
import * as request from "../../../commons/request";
import { withStyles } from "@material-ui/core";
import { isEqual } from "lodash";

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
    isFilterVisible: true
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
      .catch(reason => {
        console.log(reason);
      });
  };

  changeFilterVisibility = () => {
    this.setState({ isFilterVisible: !this.state.isFilterVisible });
  };

  render() {
    const { filter, objects, isFilterVisible } = this.state;
    const { classes } = this.props;
    return (
      <React.Fragment>
        <ObjectFilterForm
          open={isFilterVisible}
          filter={filter}
          onClose={this.changeFilterVisibility}
          onSubmit={filter => {
            this.setState({ filter });
          }}
        />
        <Grid
          className={classes.root}
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
          <Grid item xs={2}>
            <Button
              variant="contained"
              color="primary"
              onClick={this.changeFilterVisibility}
              className={classes.button}
            >
              Фильтр
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

export default withStyles(null)(ObjectPropertyTableForm);
