package sda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sda.dto.Customer;
import sda.service.CustomerService;

import java.util.List;

/**
 * Created by RENT on 2017-09-13.
 */
@Controller
public class CustomerController {

	private CustomerService customerService;

	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@RequestMapping(value = "/customer",method = RequestMethod.GET)
	public String showCustomerPage(Model model){
		List<Customer> customers = customerService.getAll();
		model.addAttribute("customers", customers);
		return "customer";
	}

	@RequestMapping(value = "/customer/add", method = RequestMethod.POST)
	public String addCustomer(@ModelAttribute Customer customer){
		customerService.add(customer);
		return "redirect:/customer";
	}

	@RequestMapping(value = "/customer/remove/{id}", method = RequestMethod.POST)
	public String deleteCustomer(@PathVariable("id") Long id){
		customerService.remove(id);
		return "redirect:/customer";
	}
}
