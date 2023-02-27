package ru.softwareDesign.Core.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.softwareDesign.Core.Service.AccountsService;
import ru.softwareDesign.Core.Service.OperationHistoryService;
import ru.softwareDesign.Core.models.Accounts;
import ru.softwareDesign.Core.models.Amount;
import ru.softwareDesign.Core.models.OperationHistory;


import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/core")
public class AccountsController {

    private final AccountsService service;

    private final OperationHistoryService historyService;

    @GetMapping("/simple")
    public String simple(){
        return "Легкий GET запросик";
    }

    @PostMapping("/openAcc")
    public Accounts save(@RequestBody Accounts accounts) {return service.save(accounts);}
    @GetMapping("/showAll")
    public List<Accounts> listAll() {
        int i = 1;
        return service.listAll();
    }
/*
    @GetMapping(path="/get/{code}")
    public Optional<Accounts> searchByCode(@PathVariable String code) {
        return service.searchByCode(code);
    }
*/
    @GetMapping(path="/get/{code}")
    public Accounts searchByCode(@PathVariable String code) {return service.searchByCode(code);}

    @DeleteMapping(path="/deleteAccount/{code}")
    public Accounts deleteByCode(@PathVariable String code){return service.deleteByCode(code);}

    /* @GetMapping("changePlus/{code}") //Не робит, а почему?
    public Optional<Accounts> changeBalancePlus(@PathVariable String code, @RequestBody int amount)
    {

        Accounts acc = service.searchByCode(code); // тут лежит счет баланс которого хочу увеличить
        int balance = acc.getBalance();
        System.out.println("КРУТА");
        int result = balance + amount;
        acc.setBalance(result);// ставлю баланс какой мне нужно, дальше надо сохранить в бд результат
        return service.save(acc);


    }*/

    /*  @PatchMapping("changePlus/{code}")
    public Optional<Accounts> changeBalancePlus(@RequestBody Amount amount, @PathVariable String code)
    {

        Accounts acc = service.searchByCode(code); // тут лежит счет баланс которого хочу увеличить
        int balance = acc.getBalance();
        int result = balance + amount.value;
        acc.setBalance(result);// ставлю баланс какой мне нужно, дальше надо сохранить в бд результат
        OperationHistory operationHistory = new OperationHistory();
        operationHistory.setId(1L);
        operationHistory.setCode(code);
        operationHistory.setOperation(amount.value);
        historyService.save(operationHistory);
        return service.save(acc);


    }

    @GetMapping("/dimple")
    public String dimple(){
        return "ХОТЬ ЧТО ТО";
    }

    @PatchMapping ("changeMinus/{code}")
    public Optional<Accounts> changeBalanceMinus(@PathVariable String code, @RequestBody Amount amount)
    {

        Accounts acc = service.searchByCode(code); // тут лежит счет баланс которого хочу увеличить
        int balance = acc.getBalance();
        if(balance < amount.value)
           return service.save(acc);

        int result = balance - amount.value;
        acc.setBalance(result);// ставлю баланс какой мне нужно, дальше надо сохранить в бд результат


        return service.save(acc);
    }*/

    @PatchMapping("change/{code}")
    public Accounts changeBalance(@RequestBody Amount amount, @PathVariable String code)
    {

        Accounts acc = service.searchByCode(code); // тут лежит счет баланс которого хочу увеличить
        int balance = acc.getBalance();
        if(amount.value < 0)
        {
            if (-balance > amount.value)
            {
                return service.save(acc);
            }
        }
        int result = balance + amount.value;
        acc.setBalance(result);// ставлю баланс какой мне нужно, дальше надо сохранить в бд результат
        OperationHistory operationHistory = new OperationHistory();
       // operationHistory.setId(7L); //РЕШИТЬ ПРОБЛЕМУ С АВТОГЕНЕРАЦИЕЙ ID
        operationHistory.setCode(code);
        operationHistory.setOperation(amount.value);
        historyService.save(operationHistory);
        return service.save(acc);


    }


}
