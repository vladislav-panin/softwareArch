package ru.softwareDesign.Core.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Table(name = "history")
@Getter
@Setter
public class OperationHistory {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    /*@ManyToOne
    @JoinColumn(name = "forumId")*/
   // private Long AccountId; - Нужен стобец с айди счета, на котором осуществляется операция

    @Column(name = "operation") //сама операция
    private int operation;

    @Column(name = "code")
    private String code;



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
