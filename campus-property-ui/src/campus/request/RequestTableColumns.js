import { uniqueId } from "lodash";

export default [
  { title: "Номер", key: uniqueId(), property: "id" },
  { title: "Содержание", key: uniqueId(), property: "content" },
  { title: "Тип", key: uniqueId(), property: "type" },
  { title: "Состояние", key: uniqueId(), property: "state" },
  {
    title: "Сотрудник университета",
    key: uniqueId(),
    property: "universityWorker"
  },
  {
    title: "Сотрудник хоз. части",
    key: uniqueId(),
    property: "economicOfficer"
  },
  { title: "Бухгалтер", key: uniqueId(), property: "accountant" }
];
