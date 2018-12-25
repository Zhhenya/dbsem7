import React, { Component } from "react";
import { Form, Formik } from "formik";
import Grid from "@material-ui/core/Grid/Grid";
import FormGroup from "@material-ui/core/FormGroup/FormGroup";
import FormControl from "@material-ui/core/FormControl/FormControl";
import InputField from "../../components/InputField";
import AutocompleteSelectField from "../../components/AutocompleteSelectField";
import Divider from "@material-ui/core/Divider/Divider";
import Button from "@material-ui/core/Button/Button";
import * as Yup from "yup";
import { withStyles } from "@material-ui/core";
import * as request from "../../commons/request";
import SimpleAlertDialog from "../../commons/dialog/SimpleAlertDialog";
import { withRouter } from "react-router";
import stateProvider from "../../commons/stateProvider";
import CircularProgress from "@material-ui/core/CircularProgress/CircularProgress";
import { isEqual } from "lodash";

const styles = theme => ({
  root: {
    flexGrow: 1
  },
  container: {
    flexWrap: "wrap"
  },
  margin: {
    margin: theme.spacing.unit
  },
  button: {
    margin: theme.spacing.unit
  }
});

const INITIAL_VALUE = {
  propertyNumber: null,
  caption: "",
  maker: "",
  date: null,
  cost: null,
  room: null,
  state: null,
  economicOfficer: null,
  accountant: null
};

const VALIDATION_SCHEMA = Yup.object().shape({
  propertyNumber: Yup.string().required("Поле не может быть пустым"),
  caption: Yup.string().required("Поле не может быть пустым"),
  maker: Yup.string().required("Поле не может быть пустым"),
  date: Yup.date().required("Поле не может быть пустым"),
  cost: Yup.number().required("Поле не может быть пустым"),
  room: Yup.object().required("Поле не может быть пустым"),
  economicOfficer: Yup.object().required("Поле не может быть пустым"),
  state: Yup.string().required("Поле не может быть пустым"),
});

class ObjectPropertyForm extends Component {
  state = {
    loading: false,
    rooms: [],
    buildings: [],
    states: [],
    officers: [],
    success: false,
    error: null,
    loadingRooms: false,
    selectedBuilding: this.props.initialValues
      ? this.props.initialValues.building
      : null
  };

  componentDidMount() {
    this.fetchOptions();
  }

  componentDidUpdate(prevProps, prevState, snapshot) {
    const { selectedBuilding } = this.state;
    const { selectedBuilding: prevBuilding } = prevState;
    if (!isEqual(selectedBuilding, prevBuilding)) {
      this.fetchObjectRooms();
    }
  }

  fetchOptions = () => {
    this.setState({ loading: true });
    Promise.all([
      this.fetchObjectEconomicOfficers(),
      this.fetchObjectBuilding(),
      this.fetchObjectState()
    ]).then(() => {
      this.setState({ loading: false });
      this.fetchObjectRooms();
    });
  };

  fetchObjectRooms = () => {
    const { selectedBuilding } = this.state;
    if (!selectedBuilding) {
      return;
    }
    this.setState({ loadingRooms: true });
    request.get("/room/all/" + selectedBuilding.id).then(rooms => {
      this.setState({ rooms, loadingRooms: false });
    });
  };

  fetchObjectBuilding = () =>
    new Promise(resolve => {
      request.get("building/all").then(buildings => {
        this.setState({ buildings });
        resolve();
      });
    });

  fetchObjectState = () =>
    new Promise(resolve => {
      request.get("object/state/all").then(states => {
        this.setState({ states });
        resolve();
      });
    });

  fetchObjectEconomicOfficers = () =>
    new Promise(resolve => {
      request.get("officer/all").then(officers => {
        this.setState({ officers });
        resolve();
      });
    });

  save = requestObj => {
    request
      .post("object/save", {
        ...requestObj,
        accountant: { id: stateProvider.user.id }
      })
      .then(() => {
        this.setState({ success: true });
      })
      .catch(error => {
        this.setState({ error });
      });
  };

  changeBuilding = value => {
    this.setState({ selectedBuilding: value });
    this.setState({ loadingRooms: true });
    request.get("/room/all/" + value.id).then(rooms => {
      this.setState({ rooms, loadingRooms: false });
    });
  };

  closeFormThenSuccess = () => {
    this.props.history.goBack();
  };

  closeErrorDialog = () => {
    this.setState({ error: null });
  };
  render() {
    const { classes, initialValues } = this.props;
    const {
      rooms,
      buildings,
      states,
      officers,
      success,
      error,
      loading,
      loadingRooms
    } = this.state;
    if (loading) {
      return <CircularProgress className={classes.progress} />;
    }
    return (
      <>
        {success && (
          <SimpleAlertDialog
            title="Объект сохранен"
            onClose={this.closeFormThenSuccess}
            open={success !== null}
          />
        )}
        {error && (
          <SimpleAlertDialog
            title="Произошла ошибка"
            content={error}
            onClose={this.closeErrorDialog}
            open={error !== null}
          />
        )}
        <Formik
          initialValues={initialValues || INITIAL_VALUE}
          validationSchema={VALIDATION_SCHEMA}
          onSubmit={this.save}
          render={() => (
            <Form className={classes.container}>
              <Grid container spacing={16} justify="space-around">
                <Grid item xs={6}>
                  <FormGroup>
                    <FormControl className={classes.margin} fullWidth>
                      <InputField
                        name="propertyNumber"
                        label="Инвентарный номер"
                        classes={classes}
                        multiline
                        fullWidth
                      />
                    </FormControl>
                    <FormControl className={classes.margin} fullWidth>
                      <InputField
                        name="caption"
                        label="Название"
                        classes={classes}
                        multiline
                        fullWidth
                      />
                    </FormControl>
                    <FormControl className={classes.margin} fullWidth>
                      <InputField
                        name="maker"
                        label="Поставщик"
                        classes={classes}
                        multiline
                        fullWidth
                      />
                    </FormControl>
                    <FormControl className={classes.margin} fullWidth>
                      <FormGroup>
                        <InputField
                          name="date"
                          label="Дата приема"
                          type="date"
                          InputLabelProps={{ shrink: true }}
                        />
                      </FormGroup>
                    </FormControl>
                    <FormControl className={classes.margin} fullWidth>
                      <InputField
                        name="cost"
                        label="Стоимость"
                        classes={classes}
                        multiline
                        fullWidth
                      />
                    </FormControl>
                  </FormGroup>
                </Grid>
                <Grid item xs={6}>
                  <FormGroup>

                  <FormControl
                    className={classes.margin}
                  >
                    <AutocompleteSelectField
                      name="building"
                      options={buildings}
                      displayLabel="Адрес здания"
                      label="address"
                      placeholder="Введите адрес здания"
                      onChange={value => {
                        this.changeBuilding(value.value);
                      }}
                    />
                  </FormControl>
                  <FormControl
                    className={classes.margin}
                  >
                    {loadingRooms ? (
                      <CircularProgress className={classes.progress} />
                    ) : (
                      <AutocompleteSelectField
                        name="room"
                        options={rooms}
                        label="number"
                        displayLabel="Комната"
                        placeholder="Введите номер комнаты"
                      />
                    )}
                  </FormControl>
                  <FormControl
                    className={classes.margin}
                  >
                    <AutocompleteSelectField
                      name="state"
                      options={states}
                      displayLabel="Состояние"
                      placeholder="Выберите состояние"
                    />
                  </FormControl>
                  <FormControl
                    className={classes.margin}
                  >
                    <AutocompleteSelectField
                      name="economicOfficer"
                      options={officers}
                      displayLabel="Материально ответственное лицо"
                      label="name"
                      placeholder="Выберите списка"
                    />
                  </FormControl>
                  </FormGroup>
                </Grid>
                <Grid container justify="center">
                  <Grid item xs={12}>
                    <Divider variant="middle" />
                    <Button
                      fullWidth
                      className={classes.button}
                      type="submit"
                      variant="text"
                      size="large"
                    >
                      Сохранить объект
                    </Button>
                  </Grid>
                </Grid>
              </Grid>
            </Form>
          )}
        />
      </>
    );
  }
}

export default withStyles(styles)(withRouter(ObjectPropertyForm));
