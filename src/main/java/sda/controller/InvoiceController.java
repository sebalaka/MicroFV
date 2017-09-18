package sda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sda.dto.Customer;
import sda.dto.Invoice;
import sda.service.InvoiceService;

import java.util.List;

/**
 * Created by RENT on 2017-09-18.
 */
@Controller
public class InvoiceController {

	private InvoiceService invoiceService;

	@Autowired
	public InvoiceController(InvoiceService invoiceService) {
		this.invoiceService = invoiceService;
	}

	@RequestMapping(value = "/invoice",method = RequestMethod.GET)
	public String showInvoicePage(Model model){
		List<Invoice> invoices = invoiceService.getAll();
		model.addAttribute("invoices", invoices);
		return "invoices";
	}

	@RequestMapping(value = "/invoice/new", method = RequestMethod.POST)
	public String addCustomer(@ModelAttribute Invoice invoice){
		invoiceService.add(invoice);
		return "redirect:/invoice";
	}

	@RequestMapping(value = "/invoice/addcustomer", method = RequestMethod.POST)
	public String addCustomer(@ModelAttribute Customer customer){
		invoiceService.addcustomer(customer);
		return "redirect:/invoice";
	}
}
