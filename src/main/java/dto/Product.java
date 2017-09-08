package dto;

import java.math.BigDecimal;

/**
 * Created by RENT on 2017-09-08.
 */
public class Product {

	private String name;
	private String category;
	private BigDecimal price;

	public Product(){
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}
