import axios from "axios";
import state from "./state";

const process = (response, resolve, reject) => {
  switch (response.status) {
    case 200:
      state.authorized = true;
      resolve(response.data);
      break;
    case 401:
      state.authorized = false;
      reject(new Error("unauthorized"));
      break;
    default:
      reject(new Error("smth goes wrong"));
  }
};

export const get = (url, parameters) =>
  new Promise((resolve, reject) => {
    axios.get(url, parameters).then(response => {
      process(response, resolve, reject);
    });
  });

export const post = (url, parameters) =>
  new Promise((resolve, reject) => {
    axios.post(url, parameters).then(response => {
      resolve(response, resolve, reject);
    });
  });

export default {
  get: get,
  post: post
};
