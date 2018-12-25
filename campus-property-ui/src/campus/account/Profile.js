import React, { Component } from "react";
import { Form, Formik } from "formik";
import stateProvider from "../../commons/stateProvider";
import InputField from "../../components/InputField";
import Button from "@material-ui/core/es/Button/Button";
import * as request from "../../commons/request";
import Roles from "../enums/Roles";
import * as Yup from "yup";
import SimpleAlertDialog from "../../commons/dialog/SimpleAlertDialog";
import FormGroup from "@material-ui/core/es/FormGroup/FormGroup";
import Grid from "@material-ui/core/Grid/Grid";
import { withStyles } from "@material-ui/core";
import { withRouter } from "react-router";

const styles = theme => ({
  container: {
    flexWrap: "wrap"
  },
  formGroup: {
    margin: theme.spacing.unit,
    width: "100%"
  },
  button: {
    margin: 10
  }
});

const VALIDATION_SCHEMA = Yup.object().shape({
  name: Yup.string().required("Поле не может быть пустым")
});

class Profile extends Component {
  state = {
    success: false,
    error: null
  };

  saveUserName = user => {
    this.save(user, Roles[user.role].toLowerCase());
  };

  save = (user, role) => {
    request
      .post(role + "/save", user)
      .then(() => {
        this.setState({ success: true });
      })
      .catch(error => {
        this.setState({ error });
      });
  };
  render() {
    const { classes } = this.props;
    const { success, error } = this.state;
    const user = stateProvider.user;
    return (
      <React.Fragment>
        {success && (
          <SimpleAlertDialog
            title="Имя сохранено"
            open={success}
            onClose={() => {
              this.props.history.push("/");
            }}
          />
        )}
        {error && (
          <SimpleAlertDialog
            content={error}
            open={error}
            title="Не удалось сохранить изменения"
            onClose={() => {
              this.setState({ error: null });
            }}
          />
        )}
        <Grid container justify="center" className={classes.container}>
          <Grid item xs={6}>
            <Formik
              initialValues={user}
              validationSchema={VALIDATION_SCHEMA}
              onSubmit={this.saveUserName}
              render={() => (
                <Form>
                  <FormGroup className={classes.formGroup}>
                    <InputField name="name" label="ФИО" fullWidth />
                    <Button
                      variant="contained"
                      color="primary"
                      type="submit"
                      className={classes.button}
                    >
                      Изменить имя
                    </Button>
                  </FormGroup>
                </Form>
              )}
            />
          </Grid>
        </Grid>
      </React.Fragment>
    );
  }
}

export default withStyles(styles)(withRouter(Profile));
