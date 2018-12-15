import { Link } from "react-router-dom";
import Button from "@material-ui/core/es/Button/Button";
import React from "react";

const LinkToRequests = props => (
  <Link to="/accountant/request/list" {...props} />
);

const AccountantHomeForm = () => (
  <Button variant="text" component={LinkToRequests}>
    Заявки
  </Button>
);

export default AccountantHomeForm;
