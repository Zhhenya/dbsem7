import React, {Component} from "react";
import withStyles from "@material-ui/core/styles/withStyles";
import Grid from "@material-ui/core/Grid";
import Card from "@material-ui/core/Card";
import CardContent from "@material-ui/core/CardContent";
import Button from "@material-ui/core/Button";


class AccountantLetterForm extends Component {


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
                    </CardContent>
                </Card>
            </Grid>
        );
    }
}


export default withStyles(null)(AccountantLetterForm);

