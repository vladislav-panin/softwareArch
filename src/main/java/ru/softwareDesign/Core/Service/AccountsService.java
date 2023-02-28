package ru.softwareDesign.Core.Service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import ru.softwareDesign.Core.models.Accounts;

import java.util.List;
import java.util.Optional;

public interface AccountsService {
    Accounts save(Accounts accounts);
    public List<Accounts> listAll();

  //  public Optional<Accounts> searchByCode(String code);

    public Accounts searchByCode(String code);

    public void deleteByCode(String code);

  //  public Optional<Accounts> changeBalancePlus(String code, int amount);

   // public Optional<Accounts> changeBalanceMinus(String code, int amount);

}
