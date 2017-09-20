package sda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sda.dto.Customer;
import sda.dto.Invoice;
import sda.dto.InvoiceRequest;
import sda.entity.CustomerEntity;
import sda.service.CustomerService;
import sda.service.InvoiceNumberGenerator;
import sda.service.InvoiceService;
import sda.transformer.CustomerTransformer;

import java.util.List;

/**
 * Created by RENT on 2017-09-18.
 */
@Controller
public class InvoiceController {

	private InvoiceService invoiceService;
	private InvoiceRequest invoiceRequest;
	private CustomerTransformer customerTransformer;
	private InvoiceNumberGenerator invoiceNumberGenerator;
	private CustomerService customerService;

	@Autowired
	public InvoiceController(InvoiceService invoiceService,
							 InvoiceNumberGenerator invoiceNumberGenerator,
							 CustomerService customerService) {
		this.invoiceService = invoiceService;
		this.invoiceNumberGenerator = invoiceNumberGenerator;
		this.customerService = customerService;
	}

	@RequestMapping(value = "/invoice", method = RequestMethod.GET)
	public String showInvoicePage(Model model){

		model.addAttribute("date", invoiceNumberGenerator.getDate());
		model.addAttribute("invoiceNum", invoiceNumberGenerator.getInvoiceNumber());
		//model.addAttribute("myCompanyName", ???);

		List<Customer> customers = customerService.getAll();
		model.addAttribute("customers", customers);

		return "/invoice";
	}

	@RequestMapping(value = "/invoice/new",method = RequestMethod.GET)
	public String newInvoice(Model model){

		List<Invoice> invoices = invoiceService.getAll();
		model.addAttribute("invoices", invoices);

		return "invoices";
	}


	//@RequestMapping(value = "/invoice/new", method = RequestMethod.POST)
	//public String addInvoice(@ModelAttribute Customer customer){


		// invoiceRequest = new InvoiceRequest();
		//customerTransformer = new CustomerTransformer();
		//invoiceRequest.setCustomer(customer);
		//invoiceService.add(new Invoice().setCustomer(customerTransformer.transform(customer)));


	//	return "redirect:/invoice";
	//}


}
