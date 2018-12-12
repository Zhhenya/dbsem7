import state from "./stateProvider";

const process = (response, resolve, reject) => {
  console.log(response);
  switch (response.status) {
    case 200:
      state.authorized = true;
      resolve(response.json());
      break;
    case 401:
    case 403:
      state.authorized = false;
      break;
    default:
      reject(new Error("smth goes wrong"));
  }
};

export const get = url =>
  new Promise((resolve, reject) => {
    fetch(url)
      .then(response => {
        process(response, resolve, reject);
      })
      .catch(error => console.log(error));
  });

export const post = (url, parameters) =>
  new Promise((resolve, reject) => {
    fetch(url, {
      method: "POST",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json"
      },
      body: JSON.stringify({ [parameters.name]: parameters.value })
    })
      .then(response => {
        process(response, resolve, reject);
      })
      .catch(error => console.log(error));
  });

export default {
  get: get,
  post: post
};
