import React, { Component } from "react";
import * as request from "../../commons/request";
import AccountantLetterForm from "./AccountantLetterForm";
import CircularProgress from "@material-ui/core/CircularProgress/CircularProgress";
import { withStyles } from "@material-ui/core";

class AccountantLetterFormWithInitial extends Component {
  state = {
    officer: null
  };

  componentDidMount() {
    console.log("here");
    this.fetchOfficer();
  }

  fetchOfficer = () => {
    const { id } = this.props.match.params;
    request.get("/officer/" + id).then(officer => {
      this.setState({ officer });
    });
  };
  render() {
    const { classes } = this.props;
    const { officer } = this.state;
    if (!officer) {
      return <CircularProgress className={classes.progress} />;
    }
    return (
      <AccountantLetterForm initialValues={{ content: "", officer: officer }} />
    );
  }
}

export default withStyles(null)(AccountantLetterFormWithInitial);
