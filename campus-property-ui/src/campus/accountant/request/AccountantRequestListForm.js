import React from "react";
import Typography from "@material-ui/core/es/Typography/Typography";
import AccountantRequestsByStatusForm from "./AccountantRequestsByStatusForm";
import Toolbar from "@material-ui/core/Toolbar/Toolbar";

const AccountantRequestListForm = () => (
  <>
    <Toolbar>
      <Typography variant="h6" color="inherit">
        Заявки работников
      </Typography>
    </Toolbar>
    <AccountantRequestsByStatusForm />
  </>
);

export default AccountantRequestListForm;
