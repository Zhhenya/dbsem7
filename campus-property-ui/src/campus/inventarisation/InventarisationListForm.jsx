import React, { Component } from "react";
import request from "../../commons/request";
import InventarisationListTable from "./InventarisationListTable";

class InventarisationListForm extends Component {
    state = {
        data: []
    };

    componentDidMount() {
        this.fetchTableData();
    }

    fetchTableData = () =>
        request.get("/inventarisation/list").then(data => {
            this.setState({ data });
        });

    render() {
        return <InventarisationListTable data={this.state.data} />;
    }
}

export default InventarisationListForm;
