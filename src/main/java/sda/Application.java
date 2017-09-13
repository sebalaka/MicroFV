package sda;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sda.dao.ProductRepository;
import sda.dto.Product;
import sda.entity.ProductEntity;

import java.math.BigDecimal;

/**
 * Created by RENT on 2017-09-11.
 */

@SpringBootApplication
public class Application {


	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	@Bean
	public CommandLineRunner populateProducts(ProductRepository repository){
		return (args) -> {
			// save a few of products        (Long id, String name, String category, String code, BigDecimal price, Integer amount)
			repository.save(new ProductEntity(1L, "Blah", "T-Shirt", "TS_BL_XL", new BigDecimal(34.99), 5));
			repository.save(new ProductEntity(2L, "Bubu", "T-Shirt", "TS_WH_L", new BigDecimal(44.99), 5));
			repository.save(new ProductEntity(3L, "Gugu", "T-Shirt", "TS_BK_L", new BigDecimal(32.99), 5));
			repository.save(new ProductEntity(4L, "Lala", "T-Shirt", "TS_RD_M", new BigDecimal(29.99), 5));
			repository.save(new ProductEntity(5L, "Bobo", "T-Shirt", "TS_YL_S", new BigDecimal(24.99), 5));
		};



	}

}

