import React from "react";
import Dialog from "@material-ui/core/Dialog/Dialog";
import RequestRecordList from "./RequestRecordList";
import ClosableDialogTitle from "../../../commons/dialog/ClosableDialogTitle";
import DialogActions from "@material-ui/core/DialogActions/DialogActions";
import Button from "@material-ui/core/Button/Button";

const RequestRecordListDialog = props => {
  const { records, number, onClose, ...other } = props;
  return (
    <Dialog onClose={onClose} {...other} aria-labelledby="simple-dialog-title">
      <ClosableDialogTitle onClose={onClose} id="simple-dialog-title">
        Записи заявки #{number}
      </ClosableDialogTitle>
      <RequestRecordList records={records} />
      <DialogActions>
        <Button onClick={onClose} color="primary">
          Понятно
        </Button>
      </DialogActions>
    </Dialog>
  );
};

RequestRecordListDialog.propTypes = {
  ...RequestRecordList.propTypes,
  ...Dialog.propTypes
};

export default RequestRecordListDialog;
