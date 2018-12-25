import React from "react";
import Dialog from "@material-ui/core/Dialog/Dialog";
import ClosableDialogTitle from "../../commons/dialog/ClosableDialogTitle";
import DialogActions from "@material-ui/core/DialogActions/DialogActions";
import Button from "@material-ui/core/Button/Button";
import CancellationRecordTable from "./CancellationRecordTable";

const CancellationRecordListDialog = props => {
  const { records, date, onClose, ...other } = props;
  return (
    <Dialog onClose={onClose} {...other} aria-labelledby="simple-dialog-title">
      <ClosableDialogTitle onClose={onClose} id="simple-dialog-title">
        Записи акта о списании от {date}
      </ClosableDialogTitle>
      <CancellationRecordTable data={records} />
      <DialogActions>
        <Button onClick={onClose} color="primary">
          Понятно
        </Button>
      </DialogActions>
    </Dialog>
  );
};

export default CancellationRecordListDialog;
