import React from "react";
import { observer } from "mobx-react";
import state from "./state";
import LoginForm from "../campus/security/LoginForm";

const Auth = ({ children }) => (state.authorized ? children : <LoginForm />);

export default observer(Auth);
