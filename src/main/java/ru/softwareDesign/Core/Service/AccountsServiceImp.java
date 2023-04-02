package ru.softwareDesign.Core.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.softwareDesign.Core.models.Accounts;
import ru.softwareDesign.Core.repository.AccountsRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AccountsServiceImp implements AccountsService{
    private final AccountsRepository accountsRepository;



    public AccountsServiceImp(AccountsRepository accountsRepository) {
        this.accountsRepository = accountsRepository;
    }


    @Override
    public Accounts save(Accounts accounts) {
        accounts.setCode(UUID.randomUUID().toString()); //
        accounts.setBalance(0); //
        Accounts account = accountsRepository.save(accounts);
        return account;
    }

    @Override
    public List<Accounts> listAll() {
        return (List<Accounts>)accountsRepository.findAll() ;
    }
   /* @Override
    public Optional<Accounts> searchByCode(String code){
        return accountsRepository.searchByCode(code);
    }
*/
   @Override
   public Accounts searchByCode(String code){
       return accountsRepository.searchByCode(code);
   }

    @Override
    public void deleteByCode(String code){
        accountsRepository.deleteByCode(code);
    }

    //public Accounts deleteById(Long id){return accountsRepository.deleteById(id);}

   /* @Override
    public Optional<Accounts> changeBalancePlus(String code, int amount)
    {


    }

    @Override
    public Optional<Accounts> changeBalanceMinus(String code, int amount)
    {
        return "succeed";
    }
    */

}
