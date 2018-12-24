import React, { Component } from "react";
import Dialog from "@material-ui/core/Dialog/Dialog";
import RoomForm from "./RoomForm";
import * as PropTypes from "prop-types";
import * as request from "../../../commons/request";

class RoomEditForm extends Component {
  state = {
    room: null,
    error: null
  };

  componentDidMount() {
    const { id } = this.props.match.params;
    this.fetchRoom(id);
  }

  componentDidUpdate(prevProps, prevState, snapshot) {
    const { id } = this.props.match.params;
    const { id: prevId } = prevProps.match.params;
    if (id !== prevId) {
      this.fetchBuilding(id);
    }
  }

  fetchRoom = id => {
    request
      .get("room/" + id)
      .then(room => {
        this.setState({ room });
      })
      .catch(error => {
        this.setState({ error });
      });
  };

  render() {
    const { room } = this.state;

    if (!room) {
      return null;
    }

    return <RoomForm initialValues={room} building={room.building} />;
  }
}

RoomEditForm.propTypes = {
  ...Dialog.propTypes,
  onSave: PropTypes.func
};

export default RoomEditForm;
