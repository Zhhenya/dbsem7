import request from "../../commons/request";
import state from "../../commons/stateProvider";

const createAdmin = () => {
  request.get("/admin/create");
};

const AdminCreateForm = () => {
  createAdmin();
  state.authorized = false;
  return null;
};

export default AdminCreateForm;
