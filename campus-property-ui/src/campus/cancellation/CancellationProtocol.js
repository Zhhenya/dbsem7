import React, { Component } from "react";
import * as request from "../../commons/request";
import TableHead from "@material-ui/core/TableHead/TableHead";
import TableRow from "@material-ui/core/TableRow/TableRow";
import TableCell from "@material-ui/core/TableCell/TableCell";
import TableBody from "@material-ui/core/TableBody/TableBody";
import Table from "@material-ui/core/Table/Table";
import { uniqueId } from "lodash";
import CircularProgress from "@material-ui/core/CircularProgress/CircularProgress";
import { Print, PrintProvider } from "react-easy-print";
import { withStyles } from "@material-ui/core";
import Grid from "@material-ui/core/Grid/Grid";
import Typography from "@material-ui/core/es/Typography/Typography";

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

const columns = [
  { title: "Дата списания", key: uniqueId() },
  { title: "Объект", key: uniqueId() },
  { title: "Причина", key: uniqueId() },
  { title: "Материально-ответственный", key: uniqueId() }
];

class CancellationProtocol extends Component {
  state = {
    protocolData: []
  };

  componentDidMount() {
    this.fetchProtocol();
  }

  fetchProtocol = () => {
    request.get("/cancellation/protocol").then(protocolData => {
      this.setState({
        protocolData: protocolData.map(data => ({ ...data, id: uniqueId() }))
      });
    });
  };

  render() {
    const { classes } = this.props;
    const { protocolData } = this.state;
    if (!protocolData) {
      return <CircularProgress className={classes.progress} />;
    }
    console.log(protocolData);
    return (
      <>
        <Grid
          container
          direction="row"
          justify="space-between"
          alignItems="center"
          spacing={24}
        >
          <Grid item xs>
            <Typography variant="h4" gutterBottom className={classes.margin}>
              Протокол о списании объектов имущества за год
            </Typography>
          </Grid>
        </Grid>
        <Grid
          container
          direction="row"
          justify="space-between"
          alignItems="center"
          spacing={24}
        >
          <Grid item xs={12}>
            <PrintProvider>
              <Print single name="cancellationProtocol">
                <Table className={classes.table}>
                  <TableHead>
                    <TableRow>
                      {columns.map(column => (
                        <TableCell key={column.key}>{column.title}</TableCell>
                      ))}
                    </TableRow>
                  </TableHead>
                  <TableBody>
                    {protocolData.map(row => (
                      <TableRow hover key={row.id}>
                        <TableCell component="th" scope="row">
                          {row.date}
                        </TableCell>
                        <TableCell component="th" scope="row">
                          {row.object}
                        </TableCell>
                        <TableCell component="th" scope="row">
                          {row.reason}
                        </TableCell>
                        <TableCell component="th" scope="row">
                          {row.officerName}
                        </TableCell>
                      </TableRow>
                    ))}
                  </TableBody>
                </Table>
              </Print>
            </PrintProvider>
          </Grid>
        </Grid>
      </>
    );
  }
}

export default withStyles(styles)(CancellationProtocol);
