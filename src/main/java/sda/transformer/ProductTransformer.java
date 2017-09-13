package sda.transformer;

import sda.dto.Product;
import sda.entity.ProductEntity;
import org.springframework.stereotype.Component;

/**
 * Created by RENT on 2017-09-08.
 */
@Component
public class ProductTransformer {

	public ProductEntity transform (Product product){
		ProductEntity productEntity = new ProductEntity();
		productEntity.setId(product.getId());
		productEntity.setName(product.getName());
		productEntity.setCategory(product.getCategory());
		productEntity.setCode(product.getCode());
		productEntity.setPrice(product.getPrice());
		productEntity.setAmount(product.getAmount());
		return productEntity;
	}

	public Product transformToProduct(ProductEntity productEntity) {
		Product product = new Product();
		product.setId(productEntity.getId());
		product.setName(productEntity.getName());
		product.setCategory(productEntity.getCategory());
		product.setCode(productEntity.getCode());
		product.setPrice(productEntity.getPrice());
		product.setAmount(productEntity.getAmount());
		return product;
	}


}
