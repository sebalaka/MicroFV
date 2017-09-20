package sda;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sda.dao.CustomerRepository;
import sda.dao.ProductRepository;
import sda.dto.Product;
import sda.entity.CustomerEntity;
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
			// save a few of products
			repository.save(new ProductEntity(1L, "Blah", "T-Shirt", "TS_BL_XL", new BigDecimal(34.99), 5));
			repository.save(new ProductEntity(2L, "Bubu", "T-Shirt", "TS_WH_L", new BigDecimal(44.99), 5));
			repository.save(new ProductEntity(3L, "Gugu", "T-Shirt", "TS_BK_L", new BigDecimal(32.99), 5));
			repository.save(new ProductEntity(4L, "Lala", "T-Shirt", "TS_RD_M", new BigDecimal(29.99), 5));
			repository.save(new ProductEntity(5L, "Bobo", "T-Shirt", "TS_YL_S", new BigDecimal(24.99), 5));
		};
	}

	@Bean
	public CommandLineRunner populateCustomers(CustomerRepository repository){
		return (args) -> {
			// save a few of customers
			repository.save(new CustomerEntity(1L, "Sony", "234-55-66-543", "ul. Pierwsza 1, 30-123, Krakow", "607123123", "firma@gmail.com"));
			repository.save(new CustomerEntity(2L, "Samsung", "877-98-09-987", "ul. Druga 1, 32-456, Krakow", "595595959", "szajka@biuro.pl"));
			repository.save(new CustomerEntity(3L, "LG", "T-Shirt", "ul. Trzecia 1, 32-789, Krakow", "600000006", "gang@ulica.pl"));
			repository.save(new CustomerEntity(4L, "AOL", "T-Shirt", "ul. Czwarta 1, 30-012, Krakow", "501273456", "eko@polska.pl"));
			repository.save(new CustomerEntity(5L, "IBM", "T-Shirt", "ul. Piata 1, 31-345, Krakow", "656565656", "kalzon@pizza.pl"));
		};
	}
}

