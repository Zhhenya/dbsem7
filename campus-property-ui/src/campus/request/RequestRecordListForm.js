import React from "react";
import { FieldArray } from "formik";
import InputField from "../../components/InputField";
import FormGroup from "@material-ui/core/FormGroup/FormGroup";
import FormControl from "@material-ui/core/es/FormControl/FormControl";
import IconButton from "@material-ui/core/IconButton/IconButton";
import DeleteIcon from "@material-ui/icons/Delete";
import AddIcon from "@material-ui/icons/Add";
import Fab from "@material-ui/core/Fab/Fab";
import { uniqueId } from "lodash";

const RequestRecordListForm = props => {
  const { classes, name, values } = props;
  return (
    <FieldArray
      name={name}
      render={arrayHelpers => (
        <div>
          {values[name].map((value, index) => (
            <FormGroup row key={value.id}>
              <FormControl className={classes.margin} style={{ width: "50%" }}>
                <InputField
                  multiline
                  classes={classes}
                  label="Строка заявки"
                  name={`${name}[${index}]note`}
                />
              </FormControl>
              <FormControl className={classes.margin} style={{ width: "35%" }}>
                <InputField
                  classes={classes}
                  name={`${name}[${index}]objectProperty.propertyNumber`}
                  label="Инвентарный номер объекта"
                />
              </FormControl>
              <IconButton
                className={classes.margin}
                aria-label="Delete"
                onClick={() => arrayHelpers.remove(index)}
              >
                <DeleteIcon />
              </IconButton>
            </FormGroup>
          ))}
          <Fab
            color="primary"
            variant="extended"
            aria-label="Add"
            className={classes.button}
            onClick={() =>
              arrayHelpers.push({
                note: "",
                objectProperty: { propertyNumber: "" },
                id: uniqueId()
              })
            }
          >
            <AddIcon />
            Добавить предмет к заявке
          </Fab>
        </div>
      )}
    />
  );
};

export default RequestRecordListForm;
