package com.ieb.order;

import com.ieb.order.dto.Stock;
import com.ieb.order.entity.Cloth;
import com.ieb.order.repository.ClothRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

/**
 * @author Isaias Espejo
 */
@SpringBootApplication
public class OrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}

	@Bean
	public CommandLineRunner initDatabase(ClothRepository clothRepository) {
		return args -> {
			// Comprobar si la base de datos está vacía
			if (clothRepository.count() == 0) {
				// Inicializar los productos
				List<Cloth> clothsByDefault = List.of(
						new Cloth("V-NECH BASIC SHIRT", 100, new Stock(4, 9, 0)),
						new Cloth("CONTRASTING FABRIC T-SHIRT", 50, new Stock(35, 9, 9)),
						new Cloth("RAISED PRINT T-SHIRT", 80, new Stock(20, 2, 20)),
						new Cloth("PLEATED T-SHIRT", 3, new Stock(25, 30, 10)),
						new Cloth("CONTRASTING LACE T-SHIRT", 650, new Stock(0, 1, 0)),
						new Cloth("SLOGAN T-SHIRT", 20, new Stock(9, 2, 5))
				);

				// Guardar los productos en la base de datos
				clothRepository.saveAll(clothsByDefault);
			}
		};
	}

}
