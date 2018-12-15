import React from "react";
import { Field } from "formik";
import Select from "@material-ui/core/Select/Select";
import MenuItem from "@material-ui/core/MenuItem/MenuItem";

const SelectField = props => {
  const { name, values, label } = props;
  return (
    <Field
      name={name}
      render={({ field }) => {
        return (
          <Select {...field}>
            {values.map((value, index) => (
              <MenuItem key={index} value={value}>
                {label ? value[label] : value}
              </MenuItem>
            ))}
          </Select>
        );
      }}
    />
  );
};

export default SelectField;
