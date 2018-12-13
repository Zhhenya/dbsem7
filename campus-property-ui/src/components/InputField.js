import React from "react";
import Input from "@material-ui/core/Input/Input";
import { Field } from "formik";

const InputField = props => {
  const { classes, name, type } = props;
  return (
    <Field
      name={name}
      render={({ field }) => (
        <Input
          type={type}
          className={classes.input}
          inputProps={{
            "aria-label": "Description"
          }}
          {...field}
        />
      )}
    />
  );
};

export default InputField;
