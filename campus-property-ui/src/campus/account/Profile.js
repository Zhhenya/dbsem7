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

const styles = theme => ({
  container: {
    display: "flex",
    flexWrap: "wrap"
  },
  margin: {
    margin: theme.spacing.unit
  },
  button: {
    margin: 10
  }
});

const VALIDATION_SCHEMA = Yup.object().shape({
  name: Yup.string().required("Поле не может быть пустым")
});

const saveUserName = user => {
  save(user, Roles[user.role]);
};

const save = (user, role) => {
  request
    .post(role + "/save")
    .then(() => {
      this.setState({ success: true });
    })
    .catch(error => {
      this.setState({ error });
    });
};

class Profile extends Component {
  state = {
    success: false,
    error: null
  };
  render() {
    const { classes } = this.props;
    const { success, error } = this.state;
    const user = stateProvider.user;
    return (
      <React.Fragment>
        {success && (
          <SimpleAlertDialog
            content="Имя сохранено"
            open={success}
            onClose={() => {
              this.setState({ success: false });
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
          <Formik
            initialValues={user}
            validationSchema={VALIDATION_SCHEMA}
            onSubmit={saveUserName}
            render={() => (
              <Form>
                <FormGroup className={classes.margin}>
                  <InputField name="name" label="ФИО" />
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
      </React.Fragment>
    );
  }
}

export default withStyles(styles)(Profile);
