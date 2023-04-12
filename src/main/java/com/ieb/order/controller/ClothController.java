package com.ieb.order.controller;

import com.ieb.order.entity.Cloth;
import com.ieb.order.service.ClothService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/cloth")
@Slf4j
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class ClothController {

    private final ClothService service;

    @Autowired
    public ClothController(ClothService service) {
        this.service = service;
    }

    @GetMapping("/sorted")
    public ResponseEntity<List<Cloth>> getSortedCloths(
            @RequestParam("salesUnitsWeight") double salesUnitsWeight,
            @RequestParam("stockWeight") double stockWeight) {

        try {
            List<Cloth> cloths = service.findAllSorted(salesUnitsWeight, stockWeight);

            if (cloths != null && !cloths.isEmpty()) {
                return ResponseEntity.ok(cloths);
            } else {
                return ResponseEntity.noContent().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
}
