import { Link } from "react-router-dom";
import Button from "@material-ui/core/es/Button/Button";
import React from "react";
import Grid from "@material-ui/core/Grid/Grid";
import Toolbar from "@material-ui/core/Toolbar/Toolbar";
import Typography from "@material-ui/core/es/Typography/Typography";
import AccountantRequestsByStatusForm from "./request/AccountantRequestsByStatusForm";

const date = () => {
  const dateNow = new Date(Date.now());
  return (
    dateNow.getDay() + "." + dateNow.getMonth() + "." + dateNow.getFullYear()
  );
};

const AccountantHomeForm = () => (
  <>
    <Toolbar>
      <Typography variant="h4" color="inherit">
        Сегодня {date()}
      </Typography>
    </Toolbar>
  </>
);

export default AccountantHomeForm;
