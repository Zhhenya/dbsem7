import React from "react";
import Grid from "@material-ui/core/Grid/Grid";
import Button from "@material-ui/core/es/Button/Button";
import { Link } from "react-router-dom";
import Typography from "@material-ui/core/es/Typography/Typography";
import Toolbar from "@material-ui/core/Toolbar/Toolbar";

const date = () => {
  const dateNow = new Date(Date.now());
  return (
    dateNow.getDay() + "." + dateNow.getMonth() + "." + dateNow.getFullYear()
  );
};

const OfficerHomeForm = () => (
  <Toolbar>
    <Typography variant="h4" color="inherit">
      Сегодня {date()}
    </Typography>
  </Toolbar>
);

export default OfficerHomeForm;
