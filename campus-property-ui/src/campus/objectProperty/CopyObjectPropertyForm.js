import React, { Component } from "react";
import * as request from "../../commons/request";
import ObjectPropertyForm from "./ObjectPropertyForm";

class CopyObjectPropertyForm extends Component {
  state = {
    object: null
  };

  componentDidMount() {
    const { id } = this.props.match.params;
    this.fetchObject(id);
  }

  fetchObject = id => {
    request.get("/object/" + id).then(object => {
      this.setState({ object });
    });
  };

  render() {
    const { object } = this.state;
    if (!object) {
      return null;
    }
    console.log(object);
    return (
      <ObjectPropertyForm
        initialValues={{ ...object, building: object.room.building, id: null }}
      />
    );
  }
}

export default CopyObjectPropertyForm;
