import React, { Component } from "react";
import request from "../../commons/request";
import withStyles from "@material-ui/core/styles/withStyles";
import Grid from "@material-ui/core/Grid";
import Card from "@material-ui/core/Card";
import CardContent from "@material-ui/core/CardContent";
import { Form, Formik } from "formik";
import FormGroup from "@material-ui/core/FormGroup";
import Button from "@material-ui/core/Button";

const styles = theme => ({
  container: {
    display: "flex",
    flexWrap: "wrap"
  },
  margin: {
    margin: theme.spacing.unit
  },
  card: {
    minWidth: 275,
    margin: 24
  },
  button: {
    margin: 10
  }
});

const INITIAL_VALUE = {
  name: "",
  login: "",
  password: "",
  role: ""
};

class AccountantInventoryForm extends Component {
  state = {
    roles: [],
    result: null
  };

  componentDidMount() {
    this.fetchRoles();
  }

  fetchRoles = () => {
    request.get("/roles").then(roles => this.setState({ roles }));
  };

  render() {
    const { classes } = this.props;
    return (
      <Grid container justify="center">
        <Card className={classes.card}>
          <CardContent>
            <Formik initialValues={INITIAL_VALUE} onSubmit={this.createAccount}>
              <Form className={classes.container}>
                <FormGroup>
                  <Button
                    variant="contained"
                    className={classes.button}
                    type="submit"
                  >
                    Создать
                  </Button>
                </FormGroup>
              </Form>
            </Formik>
            <h2>
              {this.state.result === true ? "SUCCESS" : this.state.result}
            </h2>
          </CardContent>
        </Card>
      </Grid>
    );
  }
}

export default withStyles(styles)(AccountantInventoryForm);
