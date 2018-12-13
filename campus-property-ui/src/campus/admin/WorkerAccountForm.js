import React, { Component } from "react";
import Card from "@material-ui/core/Card/Card";
import CardContent from "@material-ui/core/CardContent/CardContent";
import { Form, Formik } from "formik";
import FormGroup from "@material-ui/core/FormGroup/FormGroup";
import FormControl from "@material-ui/core/FormControl/FormControl";
import InputLabel from "@material-ui/core/InputLabel/InputLabel";
import InputField from "../../components/InputField";
import Button from "@material-ui/core/Button/Button";
import Grid from "@material-ui/core/Grid/Grid";
import request from "../../commons/request";
import SelectField from "../../components/SelectField";
import withStyles from "@material-ui/core/styles/withStyles";

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

class WorkerAccountForm extends Component {
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

  createAccount = userDetails => {
    this.setState({ result: null });
    request
      .post("/account/create", userDetails)
      .then(result => {
        console.log(result);
        this.setState({ result });
      })
      .catch(reason => this.setState({ result: reason.toString() }));
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
                  <FormControl className={classes.margin}>
                    <InputLabel htmlFor="input-with-icon-adornment">
                      ФИО
                    </InputLabel>
                    <InputField name="name" classes={classes} />
                  </FormControl>
                  <FormControl className={classes.margin}>
                    <InputLabel htmlFor="input-with-icon-adornment">
                      Логин
                    </InputLabel>
                    <InputField name="login" classes={classes} />
                  </FormControl>
                  <FormControl className={classes.margin}>
                    <InputLabel htmlFor="input-with-icon-adornment">
                      Пароль
                    </InputLabel>
                    <InputField
                      name="password"
                      type="password"
                      classes={classes}
                    />
                  </FormControl>
                  <FormControl className={classes.margin}>
                    <InputLabel htmlFor="input-with-icon-adornment">
                      Роль
                    </InputLabel>
                    <SelectField name="role" values={this.state.roles} />
                  </FormControl>
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

export default withStyles(styles)(WorkerAccountForm);
