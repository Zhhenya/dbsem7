import React, {Component} from "react";
import * as request from "../../commons/request";
import {Form} from "formik";
import Grid from "@material-ui/core/Grid";
import FormControl from "@material-ui/core/FormControl";
import AutocompleteSelectField from "../../components/AutocompleteSelectField";
import Divider from "@material-ui/core/Divider";
import Button from "@material-ui/core/Button";
import withStyles from "@material-ui/core/styles/withStyles";
import TextField from "@material-ui/core/TextField";

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
        emailAddress: [],
        success: false,
        error: null
    };

    componentDidMount() {
        this.fetchEmail();
    }

    fetchEmail = () => {
        request.get("officer/all").then(emailAddress => {
            this.setState({emailAddress});
        });
    };

    render() {
        const {classes} = this.props;
        const {emailAddress} = this.state;
        return (
            <React.Fragment>
                <Form className={classes.container}>
                    <Grid container spacing={15} justify="space-around">
                        <Grid item xs={6}>
                            <FormControl className={classes.margin} style={{width: "50%"}}>
                                <AutocompleteSelectField
                                    name="id"
                                    options={emailAddress}
                                    displayLabel="Получатель"
                                    label="email"
                                    placeholder="Введите адрес получателя"
                                />
                            </FormControl>
                            <FormControl>
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
                                    type="submit"
                                    variant="text"
                                    size="large"
                                >
                                    Отправить
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

export default withStyles(styles)(LetterForm);
