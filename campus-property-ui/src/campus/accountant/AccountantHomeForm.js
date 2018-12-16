import {Link} from "react-router-dom";
import Button from "@material-ui/core/es/Button/Button";
import React from "react";
import Grid from "@material-ui/core/Grid/Grid";

const LinkToRequests = props => (
    <Link to="/accountant/request/list" {...props} />
);
const LinkToInventory = props => (
    <Link to="/accountant/request/inventory" {...props} />
);
const LinkToLetter = props => (
    <Link to="/accountant/request/letter" {...props} />
);

const AccountantHomeForm = () => (
    <Grid>
        <Grid item xs>
            <Button variant="text" component={LinkToRequests}>
                Заявки
            </Button>
        </Grid>
        <Grid item xs={2}>
            <Button variant="text" component={LinkToInventory}>
                Инвентарь
            </Button>
        </Grid>
        <Grid item xs={12}>
            <Button variant="text" component={LinkToLetter}>
                Сообщение для взыскания средств
            </Button>
        </Grid>
    </Grid>
);

export default AccountantHomeForm;
