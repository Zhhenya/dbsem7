import React, {Component} from "react";
import * as request from "../../commons/request";
import SimpleAlertDialog from "../../commons/dialog/SimpleAlertDialog";
import {Form, Formik} from "formik";
import Grid from "@material-ui/core/Grid";
import FormGroup from "@material-ui/core/FormGroup";
import FormControl from "@material-ui/core/FormControl";
import InputField from "../../components/InputField";
import AutocompleteSelectField from "../../components/AutocompleteSelectField";
import Divider from "@material-ui/core/Divider";
import Button from "@material-ui/core/Button";

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

class LetterForm extends Component {
    state = {
        emailAddress: "",
        success: false,
        error: null
    };

    componentDidMount() {
        this.fetchEmail();
    }

    fetchEmail = () => {
        request.get("accountant/sendEmail").then(requestTypes => {
            this.setState({requestTypes});
        });
    };

    render() {
        const {classes} = this.props;
        const {rooms, buildings, states, economicOfficers, success, error} = this.state;
        return (
            <React.Fragment>
                {success && (
                    <SimpleAlertDialog
                        title="Сообщение отправлено"
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
            </React.Fragment>
        );
    }
}