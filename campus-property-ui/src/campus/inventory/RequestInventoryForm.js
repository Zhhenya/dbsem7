import React, { Component } from "react";
import request from "../../commons/request";
import RequestInventoryTable from "./RequestInventoryTable"

class RequestInventoryForm extends Component{
    state = {
        data: []
    };

    componentDidMount() {
        this.fetchTableData();
    }

    fetchTableData = () =>
        request.get("/inventory").then(data => {
            this.setState({ data });
        });
    render() {
        return <RequestInventoryTable data={this.state.data} />;
    }
}

export default RequestInventoryForm;
