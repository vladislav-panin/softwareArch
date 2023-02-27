package ru.softwareDesign.Core.Service;

import org.springframework.stereotype.Service;
import ru.softwareDesign.Core.models.Accounts;
import ru.softwareDesign.Core.models.OperationHistory;
import ru.softwareDesign.Core.repository.AccountsRepository;
import ru.softwareDesign.Core.repository.OperationHistoryRepository;

import java.util.Optional;

@Service
public class OperationHistoryService {
    private final OperationHistoryRepository operationHistoryRepository;

    public OperationHistoryService(OperationHistoryRepository operationHistoryRepository) {
        this.operationHistoryRepository = operationHistoryRepository;
    }

    public Optional<OperationHistory> save(OperationHistory operationHistory) {
        return Optional.of(operationHistoryRepository.save(operationHistory));
    }
}
