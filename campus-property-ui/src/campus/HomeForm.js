import React from "react";
import stateProvider from "../commons/stateProvider";
import Roles from "./enums/Roles";
import { WorkerHomeForm } from "./worker";
import { AccountantHomeForm } from "./accountant";
import { OfficerHomeForm } from "./officer";

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
    case Roles.OFFICER:
      return <OfficerHomeForm />;
    default:
      return null;
  }
};

export default HomeForm;
