import request from "../../commons/request";
import state from "../../commons/stateProvider";

const createAdmin = () => request.get("/admin/create");

const AdminCreateForm = () => {
  console.log("here");
  createAdmin();
  state.authorized = false;
  return null;
};

export default AdminCreateForm;
