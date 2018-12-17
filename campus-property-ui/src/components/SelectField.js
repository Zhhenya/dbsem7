import React from "react";
import { Field, getIn } from "formik";
import MenuItem from "@material-ui/core/MenuItem/MenuItem";
import TextField from "@material-ui/core/TextField/TextField";

const SelectField = props => {
  const { classes, name, values, label } = props;
  return (
    <Field
      name={name}
      render={({ field, form }) => {
        const errorText = getIn(form.errors, name);
        return (
          <TextField
            select
            label={label}
            SelectProps={{
              MenuProps: {
                className: classes.menu
              }
            }}
            error={Boolean(errorText)}
            helperText={errorText}
            margin="normal"
            {...field}
          >
            {values.map((option, index) => (
              <MenuItem key={index} value={option}>
                {option}
              </MenuItem>
            ))}
          </TextField>
        );
      }}
    />
  );
};

export default SelectField;
