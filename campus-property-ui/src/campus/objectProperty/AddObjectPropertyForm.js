import React, {Component} from "react";
import * as request from "../../commons/request";
import * as Yup from "yup";
import stateProvider from "../../commons/stateProvider";
import SimpleAlertDialog from "../../commons/dialog/SimpleAlertDialog";
import {Form, Formik} from "formik";
import Grid from "@material-ui/core/Grid";
import FormGroup from "@material-ui/core/FormGroup";
import FormControl from "@material-ui/core/FormControl";
import InputField from "../../components/InputField";
import Divider from "@material-ui/core/Divider";
import Button from "@material-ui/core/Button";
import AutocompleteSelectField from "../../components/AutocompleteSelectField";
import withStyles from "@material-ui/core/styles/withStyles";
import {withRouter} from "react-router";


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
    propertyNumber: "",
    caption: "",
    maker: "",
    date: null,
    cost: "",
};

const VALIDATION_SCHEMA = Yup.object().shape({
    propertyNumber: Yup.number().required("Поле не может быть пустым"),
    caption: Yup.string().required("Поле не может быть пустым"),
    maker: Yup.string().required("Поле не может быть пустым"),
    date: Yup.date().required("Поле не может быть пустым"),
    cost: Yup.number().required("Поле не может быть пустым"),
});


class AddObjectPropertyForm extends Component {
    state = {
        rooms: [],
        buildings: [],
        states: [],
        economicOfficers: [],
        success: false,
        error: null
    };

    componentDidMount() {
        this.fetchObjectRooms();
        this.fetchObjectBuilding();
        this.fetchObjectState();
        this.fetchObjectEconomicOfficers();
    }

    fetchObjectRooms = () => {
        request
            .get("object/room")
            .then(room => this.setState({room}));
    };

    fetchObjectBuilding = () => {
        request
            .get("object/building")
            .then(buildings => this.setState({buildings}));
    };

    fetchObjectState = () => {
        request
            .get("object/state")
            .then(states => this.setState({states}));
    };

    fetchObjectEconomicOfficers = () => {
        request
            .get("object/economicOfficers")
            .then(economicOfficers => this.setState({economicOfficers}));
    };


    createAddObjectRequest = requestObj => {
        console.log(requestObj);
        request
            .post("object/add", {
                ...requestObj,
                accountant: {id: stateProvider.user.id}
            })
            .then(() => {
                this.setState({success: true});
            })
            .catch(reason => {
                console.log(reason);
                this.setState({error: reason});
            });
    };

    closeFormThenSuccess = () => {
        this.props.history.push("/");
    };

    closeErrorDialog = () => {
        this.setState({error: null});
    };

    render() {
        const {classes} = this.props;
        const {rooms, buildings, states, economicOfficers, success, error} = this.state;
        return (
            <React.Fragment>
                {success && (
                    <SimpleAlertDialog
                        title="Объект добавлен"
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
                    onSubmit={this.createAddObjectRequest}
                    render={({values}) => (
                        <Form className={classes.container}>
                            <Grid container spacing={16} justify="flex-start">
                                <Grid item xs={6}>
                                    <FormGroup>
                                        <FormControl className={classes.margin} fullWidth>
                                            <InputField
                                                name="contentPropertyNumber"
                                                label="Инвентарный номер"
                                                classes={classes}
                                                multiline
                                                fullWidth
                                            />
                                        </FormControl>
                                        <FormControl className={classes.margin} fullWidth>
                                            <InputField
                                                name="contentCaption"
                                                label="Название"
                                                classes={classes}
                                                multiline
                                                fullWidth
                                            />
                                        </FormControl>
                                        <FormControl className={classes.margin} fullWidth>
                                            <InputField
                                                name="contentMaker"
                                                label="Поставщик"
                                                classes={classes}
                                                multiline
                                                fullWidth
                                            />
                                        </FormControl>
                                        <FormControl className={classes.margin} fullWidth>
                                            <InputField
                                                name="contentDate"
                                                label="Дата приобритения"
                                                classes={classes}
                                                multiline
                                                fullWidth
                                            />
                                        </FormControl>
                                        <FormControl className={classes.margin} fullWidth>
                                            <InputField
                                                name="contentCost"
                                                label="Стоимость"
                                                classes={classes}
                                                multiline
                                                fullWidth
                                            />
                                        </FormControl>
                                    </FormGroup>
                                </Grid>
                                <Grid container spacing={16} alignContent="flex-end">
                                    <Grid item xs={4}>
                                        <FormControl className={classes.margin} style={{width: "35%"}}>
                                            <AutocompleteSelectField
                                                name={`number`}
                                                options={rooms}
                                                displayLabel="Комната"
                                                label="room"
                                                placeholder="Введите номер комнаты"
                                            />
                                        </FormControl>
                                        <FormControl className={classes.margin} style={{width: "35%"}}>
                                            <AutocompleteSelectField
                                                name={`address`}
                                                options={buildings}
                                                displayLabel="Адрес здания"
                                                label="building"
                                                placeholder="Введите адрес здания"
                                            />
                                        </FormControl>
                                        <FormControl className={classes.margin} style={{width: "35%"}}>
                                            <AutocompleteSelectField
                                                name={`s_name`}
                                                options={states}
                                                displayLabel="Состояние"
                                                label="state"
                                                placeholder="Выберите состояние"
                                            />
                                        </FormControl>
                                        <FormControl className={classes.margin} style={{width: "35%"}}>
                                            <AutocompleteSelectField
                                                name={`EO_name`}
                                                options={economicOfficers}
                                                displayLabel="Материально ответственное лицо"
                                                label="economicOfficer"
                                                placeholder="Выберите списка"
                                            />
                                        </FormControl>
                                    </Grid>
                                </Grid>
                                <Grid container justify="center">
                                    <Grid item xs={12}>
                                        <Divider variant="middle"/>
                                        <Button
                                            fullWidth
                                            className={classes.button}
                                            type="submit"
                                            variant="text"
                                            size="large"
                                        >
                                            Добавить объект
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

export default withStyles(styles)(withRouter(AddObjectPropertyForm));
