package sda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import sda.dto.Product;
import org.springframework.web.bind.annotation.*;
import sda.service.ProductService;

import java.util.List;

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
	public String showProductPage(Model model){
		List<Product> products = productService.getAll();
		model.addAttribute("products", products);
		return "product";
	}

	@RequestMapping(value = "/product/add", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute Product product) {
		productService.add(product);
		return "redirect:/product";
	}

	@RequestMapping(value = "/product/remove/{id}", method = RequestMethod.POST)
	public String deleteProduct(@PathVariable("id") Long id){
		productService.remove(id);
		return "redirect:/product";
	}


}
