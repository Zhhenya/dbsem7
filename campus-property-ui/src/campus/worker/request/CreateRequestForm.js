import React, { Component } from "react";
import { Form, Formik } from "formik";
import FormGroup from "@material-ui/core/FormGroup/FormGroup";
import FormControl from "@material-ui/core/FormControl/FormControl";
import withStyles from "@material-ui/core/styles/withStyles";
import InputField from "../../../components/InputField";
import SelectField from "../../../components/SelectField";
import Grid from "@material-ui/core/Grid/Grid";
import Button from "@material-ui/core/Button/Button";
import RequestRecordListForm from "../../request/record/RequestRecordListForm";
import Divider from "@material-ui/core/Divider/Divider";
import * as Yup from "yup";
import * as request from "../../../commons/request";
import stateProvider from "../../../commons/stateProvider";
import SimpleAlertDialog from "../../../commons/dialog/SimpleAlertDialog";
import { withRouter } from "react-router";

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
  content: "",
  type: "",
  requestRecordList: []
};

const VALIDATION_SCHEMA = Yup.object().shape({
  requestRecordList: Yup.array().of(
    Yup.object().shape({
      note: Yup.string().required("Поле не может быть пустым")
    })
  ),
  content: Yup.string().required("Поле не может быть пустым"),
  type: Yup.string().required("Поле не может быть пустым")
});

class CreateRequestForm extends Component {
  state = {
    requestTypes: [],
    objects: [],
    success: false,
    error: null
  };

  componentDidMount() {
    this.fetchRequestTypes();
    this.fetchObjectPropertyList();
  }

  fetchRequestTypes = () => {
    request.get("request/type/list").then(requestTypes => {
      this.setState({ requestTypes });
    });
  };

  fetchObjectPropertyList = () => {
    request.get("object/list").then(objects => this.setState({ objects }));
  };

  createRequest = requestObj => {
    console.log(requestObj);
    request
      .post("request/create", {
        ...requestObj,
        universityWorker: { id: stateProvider.user.id }
      })
      .then(() => {
        this.setState({ success: true });
      })
      .catch(reason => {
        console.log(reason);
        this.setState({ error: reason });
      });
  };

  closeFormThenSuccess = () => {
    this.props.history.push("/");
  };

  closeErrorDialog = () => {
    this.setState({ error: null });
  };

  render() {
    const { classes } = this.props;
    const { requestTypes, objects, success, error } = this.state;
    return (
      <React.Fragment>
        {success && (
          <SimpleAlertDialog
            title="Заявка успешно создана"
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
          initialValues={INITIAL_VALUE}
          validationSchema={VALIDATION_SCHEMA}
          onSubmit={this.createRequest}
          render={({ values }) => (
            <Form className={classes.container}>
              <Grid container spacing={16} justify="space-around">
                <Grid item xs={6}>
                  <FormGroup>
                    <FormControl className={classes.margin} fullWidth>
                      <InputField
                        name="content"
                        label="Содержание запроса"
                        classes={classes}
                        multiline
                        fullWidth
                      />
                    </FormControl>
                    <FormControl className={classes.margin} fullWidth>
                      <SelectField
                        name="type"
                        label="Тип запроса"
                        values={requestTypes}
                        classes={classes}
                      />
                    </FormControl>
                  </FormGroup>
                </Grid>
                <Grid item xs={5}>
                  <RequestRecordListForm
                    objects={objects}
                    name="requestRecordList"
                    values={values}
                    classes={classes}
                  />
                </Grid>
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
                    Создать заявку
                  </Button>
                </Grid>
              </Grid>
            </Form>
          )}
        />
      </React.Fragment>
    );
  }
}

export default withStyles(styles)(withRouter(CreateRequestForm));
