package sda.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by RENT on 2017-09-14.
 */
public class Invoice {

	private Long id;
	private String date;
	private InvoiceNumberGenerator invoiceNumberGenerator;
	private String invoiceNumber;
	private String myCompany;
	private Customer customer;
	private List<Product> products;
	private int VAT;
	private BigDecimal totalNetPrice;
	private BigDecimal totalGrossPrice;


	public Invoice() {
		invoiceNumberGenerator = new InvoiceNumberGenerator();
		this.invoiceNumber = invoiceNumberGenerator.getInvoiceNumber();
		this.date = invoiceNumberGenerator.getDate();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getInvoiceNumber() {
		return this.invoiceNumber + "/" + this.date;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public String getMyCompany() {
		return myCompany;
	}

	public void setMyCompany(String myCompany) {
		this.myCompany = myCompany;
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

	public int getVAT() {
		return VAT;
	}

	public void setVAT(int VAT) {
		this.VAT = VAT;
	}

	public BigDecimal getTotalNetPrice() {
		return totalNetPrice;
	}

	public void setTotalNetPrice(BigDecimal totalNetPrice) {
		this.totalNetPrice = totalNetPrice;
	}

	public BigDecimal getTotalGrossPrice() {
		return totalGrossPrice;
	}

	public void setTotalGrossPrice(BigDecimal totalGrossPrice) {
		this.totalGrossPrice = totalGrossPrice;
	}
}