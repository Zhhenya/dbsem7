package com.db.campus.property.converter;

import com.db.campus.property.dto.CancellationActDto;
import com.db.campus.property.entity.CancellationActEntity;
import com.db.campus.property.service.DateFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CancellationActConverter extends CampusPropertyConverter<CancellationActEntity, CancellationActDto> {

    private final DateFormatter dateFormatter;
    private final AccountantConverter accountantConverter;
    private final CancellationRecordConverter cancellationRecordConverter;

    @Autowired
    public CancellationActConverter(DateFormatter dateFormatter,
                                    AccountantConverter accountantConverter,
                                    CancellationRecordConverter cancellationRecordConverter) {
        this.dateFormatter = dateFormatter;
        this.accountantConverter = accountantConverter;
        this.cancellationRecordConverter = cancellationRecordConverter;
    }

    @Override
    public CancellationActDto convert(CancellationActEntity value) {
        CancellationActDto dto = new CancellationActDto();
        dto.setId(value.getId());
        dto.setDate(dateFormatter.format(value.getDate()));
        dto.setAccountant(accountantConverter.convert(value.getAccountant()));
        dto.setRecords(cancellationRecordConverter.convertAll(value.getCancellationRecords()));
        return dto;
    }
}
