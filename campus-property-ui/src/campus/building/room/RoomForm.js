import React, { Component } from "react";
import SimpleAlertDialog from "../../../commons/dialog/SimpleAlertDialog";
import Grid from "@material-ui/core/Grid/Grid";
import { Form, Formik } from "formik";
import FormGroup from "@material-ui/core/es/FormGroup/FormGroup";
import InputField from "../../../components/InputField";
import Button from "@material-ui/core/es/Button/Button";
import { withStyles } from "@material-ui/core";
import * as PropTypes from "prop-types";
import * as request from "../../../commons/request";
import { withRouter } from "react-router";

const styles = theme => ({
  container: {
    flexWrap: "wrap"
  },
  formGroup: {
    margin: theme.spacing.unit * 4,
    width: "100%"
  },
  button: {
    margin: 10
  },
  input: {
    minWidth: "50%"
  }
});

const INITIAL_ROOM = building => ({
  id: null,
  number: "",
  floor: "",
  building: building
});

class RoomForm extends Component {
  state = {
    saved: false,
    error: null
  };

  saveRoom = room => {
    request
      .post("/room/save", room)
      .then(() => {
        this.setState({
          saved: true
        });
        this.props.history.goBack();
      })
      .catch(error => {
        this.setState({ error });
      });
  };

  render() {
    const { classes, initialValues, building } = this.props;
    const { saved, error } = this.state;
    return (
      <>
        {error && (
          <SimpleAlertDialog
            title="Произошла ошибка"
            content={error}
            onClose={() => {
              this.setState({ error: null });
            }}
            open={error !== null}
          />
        )}
        {saved && (
          <SimpleAlertDialog
            title="Комната сохранена"
            onClose={() => {
              this.setState({ saved: false });
            }}
            open={saved}
          />
        )}
        <Grid container>
          <Grid item xs={12}>
            <Formik
              initialValues={initialValues || INITIAL_ROOM(building)}
              onSubmit={this.saveRoom}
              render={() => (
                <Form className={classes.container}>
                  <FormGroup className={classes.formGroup}>
                    <InputField
                      name="number"
                      label="Номер"
                      className={classes.input}
                    />
                    <InputField
                      name="floor"
                      label="Этаж"
                      className={classes.input}
                    />
                    <Button
                      variant="contained"
                      color="primary"
                      type="submit"
                      className={classes.button}
                    >
                      Сохранить
                    </Button>
                  </FormGroup>
                </Form>
              )}
            />
          </Grid>
        </Grid>
      </>
    );
  }
}

RoomForm.propTypes = {
  initialValues: PropTypes.object,
  building: PropTypes.object
};

export default withStyles(styles)(withRouter(RoomForm));
