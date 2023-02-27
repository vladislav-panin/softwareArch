package ru.softwareDesign.Core.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;

import java.io.Serializable;
import java.math.BigDecimal;
import java.rmi.server.UID;
import java.util.UUID;
import java.util.logging.Logger;

@Entity
@NoArgsConstructor
@Table(name = "accounts" )
@Getter
@Setter
public class Accounts
{

    // private static final Logger log = LogManager.getLogger();

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "code") //номер счета
    private String code;

    @Column(name = "owner") //владелец счета - возможно стоит юзать айди
    private String owner;

    @Column(name = "balance") //баланс
  //  private BigDecimal balance = new BigDecimal(0.0); // начальное значение 0.0
    private int balance;



    public String toString()
    {
        String str = "none";
        ObjectMapper mapper = new ObjectMapper();
        try
        {
            str = mapper.writeValueAsString(this);
        }
        catch (Exception ex)
        {
            System.out.println(ex);
          //  log.error("Ошибка при попытке конвертации объекта типа юзер в стринг " + ex.getMessage());
        }
        return str;
    }







}

