import React from "react";
import { Field } from "formik";
import TextField from "@material-ui/core/TextField/TextField";

const InputField = props => {
  const { classes, name, ...other } = props;
  return (
    <Field
      name={name}
      render={({ field }) => (
        <TextField
          className={classes.textField}
          margin="normal"
          {...field}
          {...other}
        />
      )}
    />
  );
};

export default InputField;
