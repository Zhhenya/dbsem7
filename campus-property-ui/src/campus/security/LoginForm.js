import React from "react";
import { Form, Formik } from "formik";
import FormControl from "@material-ui/core/FormControl/FormControl";
import { withStyles } from "@material-ui/core";
import Button from "@material-ui/core/Button/Button";
import Card from "@material-ui/core/Card/Card";
import CardContent from "@material-ui/core/CardContent/CardContent";
import Grid from "@material-ui/core/Grid/Grid";
import FormGroup from "@material-ui/core/FormGroup/FormGroup";
import request from "../../commons/request";
import InputField from "../../components/InputField";
import { withRouter } from "react-router";

const styles = theme => ({
  root: {
    display: "flex",
    flexWrap: "wrap"
  },
  marginNormal: {
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

const login = (user, props) => {
  request.post("/loginRequest", user).then(() => {
    if (this.props.location.pathname !== "/") {
      this.props.history.replace("/");
    }
  });
};

const LoginForm = props => {
  const { classes } = props;
  return (
    <Grid container justify="center">
      <Card className={classes.card}>
        <CardContent>
          <Formik
            initialValues={{ login: "", password: "" }}
            onSubmit={user => {
              login(user, props);
            }}
          >
            <Form className={classes.root}>
              <FormGroup>
                <FormControl className={classes.marginNormal}>
                  <InputField name="login" classes={classes} label="Логин"/>
                </FormControl>
                <FormControl className={classes.marginNormal}>
                  <InputField
                    name="password"
                    type="password"
                    label="Пароль"
                    classes={classes}
                  />
                </FormControl>
                <Button
                  variant="contained"
                  className={classes.button}
                  type="submit"
                >
                  Войти
                </Button>
              </FormGroup>
            </Form>
          </Formik>
        </CardContent>
      </Card>
    </Grid>
  );
};

export default withStyles(styles)(withRouter(LoginForm));
