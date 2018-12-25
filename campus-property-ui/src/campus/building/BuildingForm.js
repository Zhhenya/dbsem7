import React, { Component } from "react";
import { Form, Formik } from "formik";
import Grid from "@material-ui/core/Grid/Grid";
import InputField from "../../components/InputField";
import Button from "@material-ui/core/es/Button/Button";
import FormGroup from "@material-ui/core/es/FormGroup/FormGroup";
import * as PropTypes from "prop-types";
import * as request from "../../commons/request";
import SimpleAlertDialog from "../../commons/dialog/SimpleAlertDialog";
import { withStyles } from "@material-ui/core";
import { withRouter } from "react-router";
import RoomListForm from "./room/RoomListForm";

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

const INITIAL_BUILDING = {
  id: null,
  address: ""
};

class BuildingForm extends Component {
  state = {
    saved: false,
    error: null
  };

  submitBuilding = building => {
    request
      .post("building/save", building)
      .then(() => {
        this.setState({ saved: true });
        this.props.history.goBack();
      })
      .catch(error => {
        this.setState({ error });
      });
  };

  render() {
    const { classes, initialValues } = this.props;
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
            title="Адрес здания сохранен"
            onClose={() => {
              this.setState({ saved: false });
            }}
            open={saved}
          />
        )}
        <Grid container>
          <Grid item xs={12}>
            <Formik
              initialValues={initialValues || INITIAL_BUILDING}
              onSubmit={this.submitBuilding}
              render={() => (
                <Form className={classes.container}>
                  <FormGroup className={classes.formGroup} row>
                    <InputField
                      name="address"
                      label="Адрес"
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
        {this.props.match.params.id && (
          <Grid>
            <Grid item xs={12}>
              <RoomListForm buildingId={this.props.match.params.id} />
            </Grid>
          </Grid>
        )}
      </>
    );
  }
}

BuildingForm.propTypes = {
  initialValues: PropTypes.object
};

export default withStyles(styles)(withRouter(BuildingForm));
