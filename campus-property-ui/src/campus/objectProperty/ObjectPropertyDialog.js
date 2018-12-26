import React from "react";
import Dialog from "@material-ui/core/Dialog/Dialog";
import DialogContent from "@material-ui/core/DialogContent/DialogContent";
import DialogActions from "@material-ui/core/DialogActions/DialogActions";
import Button from "@material-ui/core/Button/Button";
import ObjectPropertyForm from "./ObjectPropertyForm";
import { withRouter } from "react-router";
import ClosableDialogTitle from "../../commons/dialog/ClosableDialogTitle";
import * as request from "../../commons/request";
import stateProvider from "../../commons/stateProvider";
import Roles from "../enums/Roles";

const editObject = (props, id) => {
  props.history.push("/object/edit/" + id);
};

const mail = (props, id) => {
  props.history.push("/accountant/letter/" + id);
};

const ObjectPropertyDialog = props => {
  const { open, onClose, property, onCancel } = props;
  return (
    <Dialog
      open={open}
      onClose={onClose}
      aria-labelledby="alert-dialog-title"
      aria-describedby="alert-dialog-description"
    >
      <ClosableDialogTitle onClose={onClose} id="alert-dialog-title">
        Объект имущества
      </ClosableDialogTitle>
      <DialogContent>
        <ObjectPropertyForm readOnly initialValues={property} />
      </DialogContent>
      <DialogActions>
        {stateProvider.user.role === Roles.ACCOUNTANT && (
          <Button
            onClick={() => editObject(props, property.id)}
            color="primary"
          >
            Редактировать
          </Button>
        )}
        <Button
          color="primary"
          onClick={() => mail(props, property.economicOfficer.id)}
        >
          Связаться с материально-ответственным лицом
        </Button>
        {stateProvider.user.role === Roles.ACCOUNTANT && (
          <Button color="primary" onClick={() => onCancel(property)}>
            Списать
          </Button>
        )}
      </DialogActions>
    </Dialog>
  );
};

export default withRouter(ObjectPropertyDialog);
