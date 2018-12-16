import React, {Component} from "react";
import {Component} from "react";
import request from "../../commons/request";
import withStyles from "@material-ui/core/styles/withStyles";
import Grid from "@material-ui/core/Grid";
import Card from "@material-ui/core/Card";
import CardContent from "@material-ui/core/CardContent";
import {Form, Formik} from "formik";
import FormGroup from "@material-ui/core/FormGroup";
import Button from "@material-ui/core/Button";


class LetterForm extends Component {


    render() {
        const {classes} = this.props;
        return (
            <Grid container justify="center">
                <Card className={classes.card}>
                    <CardContent>
                        <Button
                            variant="contained"
                            className={classes.button}
                            type="submit"
                        >
                            Отправить сообщение
                        </Button>

                        <h2>
                            {this.state.result === true ? "SUCCESS" : this.state.result}
                        </h2>
                    </CardContent>
                </Card>
            </Grid>
        );
    }
}


export default withStyles(styles)(LetterForm);

