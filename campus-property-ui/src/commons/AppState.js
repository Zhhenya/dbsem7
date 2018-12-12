import { extendObservable } from "mobx";

class AppState {
  constructor() {
    extendObservable(this, {
      authorized: true
    });
  }
}

export default AppState;
