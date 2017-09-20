package sda.entity;

import sda.dto.Product;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by RENT on 2017-09-18.
 */
@Entity
public class InvoiceEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String date;
	private String invoiceNumber;
	private String myCompany;
	@OneToOne(cascade = CascadeType.ALL)
	private CustomerEntity customer;
	@OneToMany(cascade = CascadeType.ALL)
	private List<ProductEntity> products;
	private int VAT;
	private BigDecimal totalNetPrice;
	private BigDecimal totalGrossPrice;

	public InvoiceEntity() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
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

	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}

	public List<ProductEntity> getProducts() {
		return products;
	}

	public void setProducts(List<ProductEntity> products) {
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
