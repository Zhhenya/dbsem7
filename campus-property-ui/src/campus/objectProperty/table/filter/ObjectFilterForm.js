import React from "react";
import { Form, Formik } from "formik";
import FormGroup from "@material-ui/core/es/FormGroup/FormGroup";
import InputField from "../../../../components/InputField";
import AutocompleteSelectField from "../../../../components/AutocompleteSelectField";
import * as PropTypes from "prop-types";
import Typography from "@material-ui/core/es/Typography/Typography";
import Grid from "@material-ui/core/Grid/Grid";
import Divider from "@material-ui/core/Divider/Divider";
import Button from "@material-ui/core/Button/Button";

const ObjectFilterForm = props => {
  const {
    onSubmit,
    initial,
    makers,
    rooms,
    buildings,
    states,
    officers,
    accountants
  } = props;
  return (
    <Formik
      initialValues={initial}
      onSubmit={onSubmit}
      render={() => (
        <Form>
          <FormGroup>
            <InputField name="caption" label="Название содержит" />
            <Typography variant="caption">Инвентарный номер</Typography>
            <Grid container justify="space-between">
              <Grid item>
                <InputField name="numberGreater" label="Больше" />
              </Grid>
              <Grid item>
                <InputField name="numberLess" label="Меньше" />
              </Grid>
            </Grid>
            <AutocompleteSelectField
              name="maker"
              displayLabel="Изготовитель"
              options={makers}
              placeholder=""
            />
            <Typography style={{ marginTop: 10 }} variant="caption">
              Дата приобретения
            </Typography>
            <Grid container justify="space-between">
              <Grid item>
                <InputField
                  name="dateLater"
                  label="Позже"
                  type="date"
                  InputLabelProps={{ shrink: true }}
                />
              </Grid>
              <Grid item>
                <InputField
                  name="dateEarlier"
                  label="Раньше"
                  type="date"
                  InputLabelProps={{ shrink: true }}
                />
              </Grid>
            </Grid>
            <Typography variant="caption">Стоимость</Typography>
            <Grid container justify="space-between">
              <Grid item>
                <InputField name="costGreater" label="Дороже" />
              </Grid>
              <Grid item>
                <InputField name="costLess" label="Дешевле" />
              </Grid>
            </Grid>
            <AutocompleteSelectField
              name="room"
              label="number"
              displayLabel="Номер комнаты"
              options={rooms}
              placeholder=""
            />
            <AutocompleteSelectField
              name="building"
              label="address"
              options={buildings}
              displayLabel="Адрес здания"
              placeholder=""
            />
            <AutocompleteSelectField
              name="state"
              displayLabel="Состояние"
              options={states}
              placeholder=""
            />
            <AutocompleteSelectField
              name="officer"
              label="name"
              displayLabel="Работник хоз.части"
              options={officers}
              placeholder=""
            />
            <AutocompleteSelectField
              name="accountant"
              label="name"
              displayLabel="Принимающий бухгалтер"
              options={accountants}
              placeholder=""
            />
            <Divider />
            <Button type="submit" variant="contained" color="primary">
              Применить фильтры
            </Button>
          </FormGroup>
        </Form>
      )}
    />
  );
};

ObjectFilterForm.propTypes = {
  onSubmit: PropTypes.func,
  makers: PropTypes.array,
  rooms: PropTypes.array,
  buildings: PropTypes.array,
  states: PropTypes.array,
  officers: PropTypes.array,
  accountants: PropTypes.array
};

export default ObjectFilterForm;
