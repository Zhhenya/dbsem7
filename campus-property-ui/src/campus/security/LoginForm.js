import React from "react";
import { Form, Formik } from "formik";
import FormControl from "@material-ui/core/FormControl/FormControl";
import InputLabel from "@material-ui/core/InputLabel/InputLabel";
import { withStyles } from "@material-ui/core";
import Button from "@material-ui/core/Button/Button";
import Card from "@material-ui/core/Card/Card";
import CardContent from "@material-ui/core/CardContent/CardContent";
import Grid from "@material-ui/core/Grid/Grid";
import FormGroup from "@material-ui/core/FormGroup/FormGroup";
import request from "../../commons/request";
import InputField from "../../components/InputField";

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

const login = user => {
  request.get("/loginRequest/" + user.login + "/" + user.password);
};

const LoginForm = props => {
  const { classes } = props;
  return (
    <Grid container justify="center">
      <Card className={classes.card}>
        <CardContent>
          <Formik initialValues={{ login: "", password: "" }} onSubmit={login}>
            <Form className={classes.container}>
              <FormGroup>
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

export default withStyles(styles)(LoginForm);
