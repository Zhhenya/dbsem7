package com.db.campus.property.dao;

import com.db.campus.property.dto.CancellationProtocolRecordDto;

import java.util.List;

public interface StoredProcedureProvider {

    void callInitInventory();

    List<CancellationProtocolRecordDto> protocol();

}
