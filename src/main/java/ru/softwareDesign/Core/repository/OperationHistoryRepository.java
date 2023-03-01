package ru.softwareDesign.Core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ru.softwareDesign.Core.models.OperationHistory;

import java.util.List;
import java.util.UUID;


public interface OperationHistoryRepository extends CrudRepository<OperationHistory, UUID> {

    public List<OperationHistory>findOperationHistoriesByCode(String code);
}
