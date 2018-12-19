import {uniqueId} from "lodash";

export default [
    {title: "Инвентарный номер", key: uniqueId(), property: "propertyNumber"},
    {title: "Название", key: uniqueId(), property: "caption"},
    {title: "Поставщик", key: uniqueId(), property: "maker"},
    {title: "Дата приобритения", key: uniqueId(), property: "date"},
    {title: "Стоимость", key: uniqueId(), property: "cost"},
    {title: "Комната", key: uniqueId(), property: "room"},
    {title: "Адрес здания", key: uniqueId(), property: "building"},
    {title: "Состояние", key: uniqueId(), property: "state"},
    {title: "Материально ответственное лицо", key: uniqueId(), property: "economicOfficer"},
    {title: "Принимающий бухгалтер", key: uniqueId(), property: "accountant"}
]