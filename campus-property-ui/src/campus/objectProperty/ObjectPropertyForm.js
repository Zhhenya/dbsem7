import React, { Component } from "react";
import request from "../../commons/request";
import ObjectPropertyTable from "./ObjectPropertyTable";

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
        return <ObjectPropertyTable data={this.state.data} />;
    }
}

export default ObjectPropertyForm;
