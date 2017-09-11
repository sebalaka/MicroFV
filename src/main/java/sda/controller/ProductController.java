package sda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import sda.dto.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sda.service.ProductService;

/**
 * Created by RENT on 2017-09-08.
 */
@Controller
public class ProductController {

	private ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@RequestMapping(value = "/product",method = RequestMethod.GET)
	public String addProductPage(){
		return "product";
	}

	@RequestMapping(value = "/product/add", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute Product product, Model model) {
		Long id = productService.add(product);
		if(id!=null){
			model.addAttribute("hasBeenAdded",true);
		}
		//model.addAttribute("allProducts",);
		return "product";
	}

	@RequestMapping(value = "/product/remove/{id}")
	public ResponseEntity deleteProduct(@PathVariable("id") Long id){
		productService.remove(id);
		return new ResponseEntity(HttpStatus.OK);
	}

	@RequestMapping(value = "/product/all", method = RequestMethod.GET)
	public ResponseEntity<Iterable<Product>> getAll() {
		Iterable<Product> allProduct = productService.getAll();
		return new ResponseEntity<>(allProduct, HttpStatus.OK);
	}

}
