import React from "react";
import { Field, getIn } from "formik";
import TextField from "@material-ui/core/TextField/TextField";
import * as PropTypes from "prop-types";

const InputField = props => {
  const { name, ...other } = props;

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

InputField.propTypes = {
  ...TextField.propTypes,
  name: PropTypes.string
};

export default InputField;
