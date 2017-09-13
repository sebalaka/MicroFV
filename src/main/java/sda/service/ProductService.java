package sda.service;

import sda.dao.ProductRepository;
import sda.dto.Product;
import sda.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sda.transformer.ProductTransformer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RENT on 2017-09-08.
 */
@Service
public class ProductService {

	private ProductRepository productRepository;
	private ProductTransformer productTransformer;

	@Autowired
	public ProductService(ProductRepository productRepository, ProductTransformer productTransformer) {
		this.productRepository = productRepository;
		this.productTransformer = productTransformer;
	}

	public Long add(Product product){
		if(product.getName().isEmpty()){
			return null;
		} else {
			ProductEntity productEntity = productRepository.save(productTransformer.transform(product));
			return productEntity.getId();
		}
	}

	public void remove(Long id){
		productRepository.delete(id);
	}

	public List<Product> getAll() {
		Iterable<ProductEntity> all = productRepository.findAll();
		List<Product> result = new ArrayList<>();
		for(ProductEntity productEntity : all){
			result.add(productTransformer.transformToProduct(productEntity));
		}
		return result;
	}

//	public List<Product> getAll() {
//		Iterable<ProductEntity> all = productRepository.findAll();
//		List<Product> result = new ArrayList<>();
//		for(ProductEntity productEntity : all){
//			result.add(productTransformer.transformToProduct(productEntity));
//		}
//		return result;
//	}
}
