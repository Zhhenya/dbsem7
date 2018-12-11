import { extendObservable } from "mobx";

class AppState {
  constructor() {
    extendObservable(this, {
      authorized: false
    });
  }
}

export default AppState;
