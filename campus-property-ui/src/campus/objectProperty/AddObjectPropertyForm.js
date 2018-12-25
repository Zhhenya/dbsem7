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
    propertyNumber: null,
    caption: "",
    maker: "",
    date: null,
    cost: null,
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
        loading: true,
        rooms: [],
        buildings: [],
        states: [],
        economicOfficers: [],
        success: false,
        error: null
    };

    componentDidMount() {
        this.fetchOptions();
    }

    fetchOptions = () => {
        this.setState({loading: true});
        Promise.all([
            this.fetchObjectEconomicOfficers(),
            this.fetchObjectBuilding(),
            this.fetchObjectRooms(),
            this.fetchObjectState()
        ]).then(() => {
            this.setState({loading: false});
        });
    };

    fetchObjectRooms = () => new Promise(resolve => {
        request.get("room/number/all").then(rooms => {
            rooms.unshift(null);
            this.setState({ rooms });
            resolve();
        });
    });

    fetchObjectBuilding = () =>
        new Promise(resolve => {
            request.get("building/all").then(buildings => {
                buildings.unshift(null);
                this.setState({buildings});
                resolve();
            });
        });

    fetchObjectState = () =>
        new Promise(resolve => {
        request.get("object/state/all").then(states => {
            console.log(states);
            states.unshift(null);
            this.setState({states});
            resolve();
        });
    });

    fetchObjectEconomicOfficers = () =>
        new Promise(resolve => {
            request.get("officer/all").then(officers => {
                officers.unshift(null);
                this.setState({officers});
                resolve();
            });
        });

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
                            <Grid container spacing={15} justify="space-around">
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
                                                    InputLabelProps={{shrink: true}}
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
                                    <FormControl className={classes.margin} style={{width: "50%"}}>
                                        <AutocompleteSelectField
                                            name="id"
                                            options={rooms}
                                            displayLabel="Комната"
                                            label="number"
                                            placeholder="Введите номер комнаты"
                                        />
                                    </FormControl>
                                    <FormControl className={classes.margin} style={{width: "50%"}}>
                                        <AutocompleteSelectField
                                            name="id"
                                            options={buildings}
                                            displayLabel="Адрес здания"
                                            label="address"
                                            placeholder="Введите адрес здания"
                                        />
                                    </FormControl>
                                    <FormControl className={classes.margin} style={{width: "50%"}}>
                                        <AutocompleteSelectField
                                            name="id"
                                            options={states}
                                            displayLabel="Состояние"
                                            label="state"
                                            placeholder="Выберите состояние"
                                        />
                                    </FormControl>
                                    <FormControl className={classes.margin} style={{width: "50%"}}>
                                        <AutocompleteSelectField
                                            name="id"
                                            options={economicOfficers}
                                            displayLabel="Материально ответственное лицо"
                                            label="name"
                                            placeholder="Выберите списка"
                                        />
                                    </FormControl>
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
