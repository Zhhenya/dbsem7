import axios from "axios";
import state from "./state";

export const get = url =>
  new Promise((resolve, reject) => {
    axios.get("/request/list").then(response => {
      switch (response.status) {
        case 200:
          resolve(response.data);
          break;
        case 401:
          state.authorized = false;
          reject(new Error("unauthorized"));
          break;
        default:
          reject(new Error("smth goes wrong"));
      }
    });
  });
