import state from "./stateProvider";

const process = (response, resolve, reject) => {
  switch (response.status) {
    case 200:
      state.authorized = true;
      if (response) {
        response
          .json()
          .then(value => {
            resolve(value);
          })
          .catch(() => {
            resolve("SUCCESS");
          });
      }
      break;
    case 401:
    case 403:
      state.authorized = false;
      state.user = null;
      break;
    default:
      response.json().then(value => {
        reject(value.message);
      });
  }
};

export const get = url =>
  new Promise((resolve, reject) => {
    fetch(url)
      .then(response => {
        process(response, resolve, reject);
      })
      .catch(reason => {
        reject(reason);
      });
  });

export const post = (url, parameters) =>
  new Promise((resolve, reject) => {
    fetch(url, {
      method: "POST",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json"
      },
      body: JSON.stringify(parameters)
    })
      .then(response => {
        process(response, resolve, reject);
      })
      .catch(reason => {
        reject(reason);
      });
  });

export default {
  get: get,
  post: post
};
