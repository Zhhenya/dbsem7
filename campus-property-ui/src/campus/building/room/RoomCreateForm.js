import React, { Component } from "react";
import * as request from "../../../commons/request";
import RoomForm from "./RoomForm";

class RoomCreateForm extends Component {
  state = {
    building: null,
    error: null
  };

  componentDidMount() {
    const { id } = this.props.match.params;
    this.fetchBuilding(id);
  }

  componentDidUpdate(prevProps, prevState, snapshot) {
    const { id } = this.props.match.params;
    const { id: prevId } = prevProps.match.params;
    if (id !== prevId) {
      this.fetchBuilding(id);
    }
  }

  fetchBuilding = id => {
    request
      .get("building/" + id)
      .then(building => {
        this.setState({ building });
      })
      .catch(error => {
        this.setState({ error });
      });
  };

  render() {
    const { building } = this.state;
    if (!building) {
      return null;
    }
    return <RoomForm building={building} />;
  }
}

export default RoomCreateForm;
