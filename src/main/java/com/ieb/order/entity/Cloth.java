package com.ieb.order.entity;

import com.ieb.order.dto.Stock;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Cloth {

    public Cloth(String name, Integer salesUnits, Stock stock){
        this.name = name;
        this.salesUnits = salesUnits;
        this.stock = stock;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer salesUnits;
    @Embedded
    private Stock stock;

}
