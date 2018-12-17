import React, { Component } from "react";
import request from "../../commons/request";
import RequestInventoryTable from "./ObjectPropertyTable"

class ObjectPropertyForm extends Component{
    state = {
        data: []
    };

    componentDidMount() {
        this.fetchTableData();
    }

    fetchTableData = () =>
        request.get("/objectProperty").then(data => {
            this.setState({ data });
        });
    render() {
        return <RequestInventoryTable data={this.state.data} />;
    }
}

export default ObjectPropertyForm;
