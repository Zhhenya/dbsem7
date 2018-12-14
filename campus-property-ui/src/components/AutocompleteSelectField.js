import React from "react";
import PropTypes from "prop-types";
import { Field, withFormik } from "formik";
import Select from "react-select";

//оно не работает

const AutocompleteSelectField = props => {
  const { name, options: suggestions, label, setFieldValue, ...other } = props;
  const options = suggestions.map(suggestion => ({
    value: suggestion,
    label: suggestion[label]
  }));
  return (
    <Field
      name={name}
      render={({ field }) => {
        console.log(setFieldValue);
        return (
          <Select
            name={name}
            options={options}
            onChange={setFieldValue}
            {...field}
            {...other}
          />
        );
      }}
    />
  );
};

AutocompleteSelectField.propTypes = {
  options: PropTypes.array,
  value: PropTypes.object,
  name: PropTypes.string,
  placeholder: PropTypes.string
};

export default withFormik({
  displayName: "AutocompleteSelectField"
})(AutocompleteSelectField);
