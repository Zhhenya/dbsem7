import React from "react";
import { Field, getIn } from "formik";
import TextField from "@material-ui/core/TextField/TextField";

const InputField = props => {
  const { classes, name, ...other } = props;

  return (
    <Field
      name={name}
      render={({ field, form }) => {
        const errorText = getIn(form.errors, name);
        return (
          <TextField
            margin="normal"
            error={Boolean(errorText)}
            helperText={errorText}
            {...field}
            {...other}
          />
        );
      }}
    />
  );
};

export default InputField;
