import { RequestStatus } from "./RequestStatus";
import { uniqueId } from "lodash";

export default [
  {
    status: RequestStatus.WAITING,
    heading: "Отправлено на обработку",
    id: uniqueId()
  },
  {
    status: RequestStatus.APPROVED,
    heading: "Одобрено на выполнение",
    id: uniqueId()
  },
  { status: RequestStatus.PROCESSING, heading: "Выполняется", id: uniqueId() },
  { status: RequestStatus.READY, heading: "Готово", id: uniqueId() }
]