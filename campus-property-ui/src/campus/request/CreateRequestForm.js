import React, { Component } from "react";
import { Form, Formik } from "formik";
import FormGroup from "@material-ui/core/FormGroup/FormGroup";
import FormControl from "@material-ui/core/FormControl/FormControl";
import withStyles from "@material-ui/core/styles/withStyles";
import InputLabel from "@material-ui/core/InputLabel/InputLabel";
import InputField from "../../components/InputField";
import SelectField from "../../components/SelectField";
import Grid from "@material-ui/core/Grid/Grid";
import Button from "@material-ui/core/Button/Button";
import RequestRecordListForm from "./RequestRecordListForm";
import Divider from "@material-ui/core/Divider/Divider";
import * as Yup from "yup";
import * as request from "../../commons/request";
import stateProvider from "../../commons/stateProvider";

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
      note: Yup.string().required("Required")
    })
  ),
  content: Yup.string().required("Required"),
  type: Yup.string().required("Required")
});

class CreateRequestForm extends Component {
  state = {
    requestTypes: []
  };

  componentDidMount() {
    this.fetchRequestTypes();
  }

  fetchRequestTypes = () => {
    request
      .get("request/type/list")
      .then(requestTypes => this.setState({ requestTypes }));
  };

  createRequest = requestObj => {
    console.log(requestObj);
    request.post("request/create", {
      ...requestObj,
      universityWorker: { id: stateProvider.user.id }
    });
  };

  render() {
    const { classes } = this.props;
    return (
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
                    <InputLabel htmlFor="input-with-icon-adornment">
                      Тип запроса
                    </InputLabel>
                    <SelectField
                      name="type"
                      values={this.state.requestTypes}
                      classes={classes}
                    />
                  </FormControl>
                </FormGroup>
              </Grid>
              <Grid item xs={5}>
                <RequestRecordListForm
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
    );
  }
}

export default withStyles(styles)(CreateRequestForm);
