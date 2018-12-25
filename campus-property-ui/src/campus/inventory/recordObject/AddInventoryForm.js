import React, { Component } from "react";
import * as request from "../../../commons/request";

class AddInventoryForm extends Component{
    state = {
        rooms: [],
        objects: [],
        success: false,
        error: null
    };

    componentDidMount() {
        this.fetchRequestTypes();
      //  this.fetchObjectPropertyList();
    }

    fetchRequestTypes = () => {
        request
            .get("inventory/room")
            .then(room => this.setState({ room }));
    };

    // fetchObjectPropertyList = () => {
    //     request.get("object/list").then(objects => this.setState({ objects }));
    // };


}