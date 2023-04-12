package com.ieb.order.service;

import com.ieb.order.entity.Cloth;
import com.ieb.order.repository.ClothRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class ClothService {

    private final ClothRepository repository;

    public ClothService(ClothRepository repository) {
        this.repository = repository;
    }

    public List<Cloth> findAllSorted(double salesUnitsWeight, double stockRatioWeight) {

        List<Cloth> cloths = repository.findAll();

        cloths.sort(Comparator.comparingDouble(c -> calculateScore((Cloth)c, salesUnitsWeight, stockRatioWeight)).reversed());

        return cloths;
    }

    //A la hora de ordenar he decidido generar una puntuación para cada prenda
    // Esta puntuación la genero multiplicando el peso por la característica a la que corresponde
    private double calculateScore(Cloth clothing, double salesUnitsWeight, double stockRatioWeight) {
        double salesUnitsScore = clothing.getSalesUnits() * salesUnitsWeight;
        double stockRatioScore = (clothing.getStock().getS()
                + clothing.getStock().getM() + clothing.getStock().getL()) * stockRatioWeight;
        return salesUnitsScore + stockRatioScore;
    }

}
