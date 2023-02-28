package ru.softwareDesign.Core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.softwareDesign.Core.models.Accounts;

import java.util.List;
import java.util.Optional;


public interface AccountsRepository extends CrudRepository<Accounts, Long> {
    //public Optional<Accounts> searchByCode(String code);
      public Accounts searchByCode(String code);
      public void deleteByCode(String code);


      
}
