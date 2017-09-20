package sda.dto;

import java.util.List;

/**
 * Created by RENT on 2017-09-18.
 */
public class InvoiceRequest {

	private Invoice invoice;
	private Customer customer;
	private List<Product> products;

	public InvoiceRequest() {
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
