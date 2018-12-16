import stateProvider from "../commons/stateProvider";
import WorkerHomeForm from "./worker/WorkerHomeForm";
import Roles from "./enums/Roles";
import React from "react";
import AccountantHomeForm from "./accountant/AccountantHomeForm";

const HomeForm = () => {
  const { user } = stateProvider;
  if (!user) {
    return null;
  }
  console.log(user);

  switch (user.role) {
    case Roles.WORKER:
      return <WorkerHomeForm />;
    case Roles.ACCOUNTANT:
      return <AccountantHomeForm />;
    default:
      return null;
  }
};

export default HomeForm;
