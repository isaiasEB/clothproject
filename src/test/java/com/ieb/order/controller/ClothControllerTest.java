package com.ieb.order.controller;

import com.ieb.order.dto.Stock;
import com.ieb.order.entity.Cloth;
import com.ieb.order.service.ClothService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClothControllerTest {

    @Mock
    private ClothService service;

    @InjectMocks
    private ClothController controller;

    private List<Cloth> cloths;

    double salesUnitsWeight = 0.7;
    double stockWeight = 0.3;

    @BeforeEach
    public void init() {
        cloths = Arrays.asList(
                new Cloth( "V-NECH BASIC SHIRT", 100, new Stock(4, 9, 0)),
                new Cloth( "CONTRASTING FABRIC T-SHIRT", 50, new Stock(35, 9, 9)),
                new Cloth( "RAISED PRINT T-SHIRT", 80, new Stock(20, 2, 20)),
                new Cloth( "PLEATED T-SHIRT", 3, new Stock(25, 30, 10)),
                new Cloth( "CONTRASTING LACE T-SHIRT", 650, new Stock(0, 1, 0)),
                new Cloth( "SLOGAN T-SHIRT", 20, new Stock(9, 2, 5))
        );
    }

    @Test
    public void findAllSorteTest() {

        when(service.findAllSorted(salesUnitsWeight, stockWeight)).thenReturn(cloths);

        ResponseEntity<List<Cloth>> response = controller.getSortedCloths(salesUnitsWeight, stockWeight);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(cloths);

    }

    @Test
    public void findAllSorteNoContentTest() {

        when(service.findAllSorted(salesUnitsWeight, stockWeight)).thenReturn(null);

        ResponseEntity<List<Cloth>> response = controller.getSortedCloths(salesUnitsWeight, stockWeight);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);

    }

    @Test
    public void findAllSorteInternalErrorTest() {

        when(service.findAllSorted(salesUnitsWeight, stockWeight)).thenThrow(new RuntimeException("Test exception"));

        ResponseEntity<List<Cloth>> response = controller.getSortedCloths(salesUnitsWeight, stockWeight);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);

    }
}