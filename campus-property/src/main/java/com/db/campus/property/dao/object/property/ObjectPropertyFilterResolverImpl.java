package com.db.campus.property.dao.object.property;

import com.db.campus.property.dao.*;
import com.db.campus.property.dto.*;
import com.db.campus.property.entity.ObjectPropertyEntity;
import com.db.campus.property.exception.BuildingNotFoundException;
import com.db.campus.property.exception.RoomNotFoundException;
import com.db.campus.property.exception.WorkerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ObjectPropertyFilterResolverImpl implements ObjectPropertyFilterResolver {

    private final RoomRepository roomRepository;
    private final BuildingRepository buildingRepository;
    private final StateRepository stateRepository;
    private final EconomicOfficerRepository economicOfficerRepository;
    private final AccountantRepository accountantRepository;
    private PropertyCriteriaBuilder propertyCriteriaBuilder;


    @Autowired
    public ObjectPropertyFilterResolverImpl(RoomRepository roomRepository,
                                            BuildingRepository buildingRepository, StateRepository stateRepository,
                                            EconomicOfficerRepository economicOfficerRepository,
                                            AccountantRepository accountantRepository) {
        this.roomRepository = roomRepository;
        this.buildingRepository = buildingRepository;
        this.stateRepository = stateRepository;
        this.economicOfficerRepository = economicOfficerRepository;
        this.accountantRepository = accountantRepository;
    }

    @Override
    public List<Predicate> resolve(ObjectPropertyFilterDto filterDto,
                                   CriteriaBuilder criteriaBuilder,
                                   Root<ObjectPropertyEntity> propertyEntity) {
        propertyCriteriaBuilder = new PropertyCriteriaBuilderImpl(criteriaBuilder, propertyEntity);
        return Stream.of(resolveCaption(filterDto.getCaption()),
                         resolveNumber(filterDto.getNumberGreater(), filterDto.getNumberLess()),
                         resolveMaker(filterDto.getMaker()),
                         resolveDate(filterDto.getDateLater(), filterDto.getDateEarlier()),
                         resolveCost(filterDto.getCostGreater(), filterDto.getCostLess()),
                         resolveRoom(filterDto.getRoom()),
                         resolveBuilding(filterDto.getBuilding()),
                         resolveState(filterDto.getState()),
                         resolveOfficer(filterDto.getOfficer()),
                         resolveAccountant(filterDto.getAccountant()))
                     .filter(Objects::nonNull)
                     .collect(Collectors.toList());
    }

    private Predicate resolveCaption(String caption) {
        if (caption == null || caption.isEmpty()) {
            return null;
        }
        return propertyCriteriaBuilder.buildCaptionCriteria(caption);
    }

    private Predicate resolveNumber(String numberGreater, String numberLess) {
        if (numberGreater == null || numberGreater.isEmpty()) {
            numberGreater = "0";
        }
        if (numberLess == null || numberLess.isEmpty()) {
            numberLess = String.valueOf(Long.MAX_VALUE);
        }
        return propertyCriteriaBuilder.buildPropertyNumberCriteria(numberGreater, numberLess);
    }

    private Predicate resolveMaker(String maker) {
        if (maker == null || maker.isEmpty()) {
            return null;
        }
        return propertyCriteriaBuilder.buildMakerCriteria(maker);
    }

    private Predicate resolveDate(Date dateLater, Date dateEarlier) {
        if (dateLater == null || dateEarlier == null) {
            return null;
        }
        return propertyCriteriaBuilder.buildDateCriteria(dateLater, dateEarlier);
    }

    private Predicate resolveCost(Double costGreater, Double costLess) {
        if (costGreater == null) {
            costGreater = 0.0;
        }
        if (costLess == null) {
            costLess = Double.MAX_VALUE;
        }
        return propertyCriteriaBuilder.buildCostCriteria(costGreater, costLess);
    }

    private Predicate resolveRoom(RoomDto roomDto) {
        if (roomDto == null) {
            return null;
        }
        return propertyCriteriaBuilder.buildRoomCriteria(
                roomRepository.findById(roomDto.getId())
                              .orElseThrow(() -> new RoomNotFoundException(roomDto.getNumber())));
    }

    private Predicate resolveBuilding(BuildingDto buildingDto) {
        if (buildingDto == null) {
            return null;
        }
        return propertyCriteriaBuilder.buildBuildingCriteria(
                buildingRepository.findById(buildingDto.getId())
                                  .orElseThrow(() -> new BuildingNotFoundException(buildingDto.getAddress())));
    }

    private Predicate resolveState(String state) {
        if (state == null || state.isEmpty()) {
            return null;
        }
        return propertyCriteriaBuilder.buildStateCriteria(stateRepository.findByName(state));
    }

    private Predicate resolveOfficer(EconomicOfficerDto officerDto) {
        if (officerDto == null) {
            return null;
        }
        return propertyCriteriaBuilder.buildOfficerCriteria(
                economicOfficerRepository.findById(officerDto.getId())
                                         .orElseThrow(() -> new WorkerNotFoundException(officerDto.getName())));
    }

    private Predicate resolveAccountant(AccountantDto accountantEntity) {
        if (accountantEntity == null) {
            return null;
        }
        return propertyCriteriaBuilder.buildAccountantCriteria(
                accountantRepository.findById(accountantEntity.getId())
                                    .orElseThrow(() -> new WorkerNotFoundException(accountantEntity.getName())));
    }

}
