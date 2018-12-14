import stateProvider from "../commons/stateProvider";
import { WorkerHomeForm } from "./worker/WorkerHomeForm";
import Roles from "./enums/Roles";
import React from "react";

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
      return null;
    default:
      return null;
  }
};

export default HomeForm;
