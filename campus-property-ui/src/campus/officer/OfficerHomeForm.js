import React from "react";
import Grid from "@material-ui/core/Grid/Grid";
import Button from "@material-ui/core/es/Button/Button";
import { Link } from "react-router-dom";

const LinkToRequests = props => <Link to="/officer/request/list" {...props} />;

const OfficerHomeForm = () => (
  <Grid>
    <Grid item xs>
      <Button variant="text" component={LinkToRequests}>
        Заявки
      </Button>
    </Grid>
  </Grid>
);

export default OfficerHomeForm;
