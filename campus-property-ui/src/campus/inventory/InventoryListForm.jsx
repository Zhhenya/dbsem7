import React, { Component } from "react";
import request from "../../commons/request";
import InventoryListTable from "./InventoryListTable";

class InventoryListForm extends Component {
    state = {
        data: []
    };

    componentDidMount() {
        this.fetchTableData();
    }

    fetchTableData = () =>
        request.get("/inventory/").then(data => {
            console.log(data);
            this.setState({ data });
        });

    render() {
        return <InventoryListTable data={this.state.data} />;
    }
}

export default InventoryListForm;
