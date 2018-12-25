import React, {Component} from "react";
import withStyles from "@material-ui/core/styles/withStyles";
import Grid from "@material-ui/core/Grid";
import Button from "@material-ui/core/Button";
import * as request from "../../commons/request";
import {Form, Formik} from "formik";
import FormControl from "@material-ui/core/FormControl";
import AutocompleteSelectField from "../../components/AutocompleteSelectField";
import TextField from "@material-ui/core/TextField";
import Divider from "@material-ui/core/Divider";
import * as Yup from "yup";
import SimpleAlertDialog from "../../commons/dialog/SimpleAlertDialog";

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
};

const VALIDATION_SCHEMA = Yup.object().shape({
    content: Yup.string().required("Поле не может быть пустым"),
});


class AccountantLetterForm extends Component {
    state = {
        emailAddress: [],
        success: false,
    }

    componentDidMount() {
        this.fetchEmail();
    }

    closeFormThenSuccess = () => {
        this.props.history.push("/");
    };

    closeSuccessDialog = () => {
        this.setState({ success: true });
    };

    fetchEmail = () => {
        request.get("officer/all").then(emailAddress => {
            this.setState({emailAddress});
        });
    };

    render() {
        const {classes} = this.props;
        const {emailAddress, success} = this.state;
        return (
            <React.Fragment>
                {success && (
                    <SimpleAlertDialog
                        title="Письмо отправлено"
                        onClose={this.closeFormThenSuccess}
                        open={success !== null}
                    />
                )}
                <Formik
                    initialValues={INITIAL_VALUE}
                    validationSchema={VALIDATION_SCHEMA}
                    render={({values}) => (
                        <Form className={classes.container}>
                            <Grid container spacing={15} justify="flex-start">
                                <Grid item xs={6}>
                                    <FormControl className={classes.margin} style={{width: "100%"}}>
                                        <AutocompleteSelectField
                                            name="id"
                                            options={emailAddress}
                                            displayLabel="Получатель"
                                            label="email"
                                            placeholder="Введите адрес получателя"
                                        />
                                    </FormControl>
                                    <FormControl className={classes.margin} style={{width: "100%"}}>
                                        <TextField
                                            placeholder="Введите сообщение"
                                            multiline={true}
                                            rows={4}
                                            rowsMax={7}
                                        />
                                    </FormControl>
                                </Grid>
                                <Grid container justify="center">
                                    <Grid item xs={12}>
                                        <Divider variant="middle"/>
                                        <Button
                                            fullWidth
                                            className={classes.button}
                                            type="text"
                                            size="large"
                                            onClick={this.closeSuccessDialog}
                                        >
                                            Отправить
                                        </Button>
                                    </Grid>
                                </Grid>
                            </Grid>
                        </Form>
                    )}
                />
            </React.Fragment>
        );
    }
}


export default withStyles(styles)(AccountantLetterForm);

