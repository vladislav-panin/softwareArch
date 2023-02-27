package ru.softwareDesign.Core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ru.softwareDesign.Core.models.OperationHistory;


public interface OperationHistoryRepository extends CrudRepository<OperationHistory, Long> {
}
