import React, { Component } from "react";
import Grid from "@material-ui/core/Grid/Grid";
import Typography from "@material-ui/core/es/Typography/Typography";
import CancellationActTable from "./CancellationActTable";
import * as request from "../../commons/request";
import CircularProgress from "@material-ui/core/CircularProgress/CircularProgress";
import { withStyles } from "@material-ui/core";

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

class CancellationActListForm extends Component {
  state = {
    acts: []
  };

  componentDidMount() {
    this.fetchActs();
  }

  fetchActs = () => {
    request.get("/cancellation/act/all").then(acts => {
      this.setState({ acts });
    });
  };

  render() {
    const { classes } = this.props;
    const { acts } = this.state;
    if (!acts) {
      return <CircularProgress className={classes.progress} />;
    }
    return (
      <Grid
        className={classes.root}
        container
        justify="space-between"
        alignItems="center"
        spacing={24}
      >
        <Grid item xs>
          <Typography variant="h3" gutterBottom className={classes.margin}>
            Акты о списании
          </Typography>
        </Grid>
        <Grid item xs={12}>
          <CancellationActTable data={acts} />
        </Grid>
      </Grid>
    );
  }
}

export default withStyles(styles)(CancellationActListForm);
