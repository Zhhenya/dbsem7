import { extendObservable } from "mobx";

class AppState {
  constructor() {
    extendObservable(this, {
      authorized: true,
      user: null
    });
  }
}

export default AppState;
