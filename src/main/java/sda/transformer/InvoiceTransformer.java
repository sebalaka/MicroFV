
package sda.transformer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sda.dto.Invoice;
import sda.dto.Product;
import sda.entity.InvoiceEntity;
import sda.entity.ProductEntity;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by RENT on 2017-09-18.
 */
@Component
public class InvoiceTransformer {

	@Autowired
	private ProductTransformer productTransformer;

	public InvoiceEntity transform (Invoice invoice){
		InvoiceEntity invoiceEntity = new InvoiceEntity();
		invoiceEntity.setId(invoice.getId());
		invoiceEntity.setDate(invoice.getDate());
		invoiceEntity.setInvoiceNumber(invoice.getInvoiceNumber());
		invoiceEntity.setMyCompany(invoice.getMyCompanyName());
		invoiceEntity.setCustomer(invoice.getCustomer());
		invoiceEntity.setProducts(transform(invoice.getProducts()));
		invoiceEntity.setVAT(invoice.getVAT());
		invoiceEntity.setTotalNetPrice(invoice.getTotalNetPrice());
		invoiceEntity.setTotalGrossPrice(invoice.getTotalGrossPrice());
		return invoiceEntity;
	}

	private List<ProductEntity> transform(List<Product> products){
		return products.stream().map(productTransformer::transform).collect(Collectors.toList());
	}


	private List<Product> transformToProducts(List<ProductEntity> products){
		return products.stream().map(productTransformer::transformToProduct).collect(Collectors.toList());
	}

	public Invoice transformToInvoice (InvoiceEntity invoiceEntity){
		Invoice invoice = new Invoice();
		invoice.setId(invoiceEntity.getId());
		invoice.setDate(invoiceEntity.getDate());
		invoice.setInvoiceNumber(invoiceEntity.getInvoiceNumber());
		invoice.setMyCompanyName(invoiceEntity.getMyCompany());
		invoice.setCustomer(invoiceEntity.getCustomer());
		invoice.setProducts(transformToProducts(invoiceEntity.getProducts()));
		invoice.setVAT(invoiceEntity.getVAT());
		invoice.setTotalNetPrice(invoiceEntity.getTotalNetPrice());
		invoice.setTotalGrossPrice(invoiceEntity.getTotalGrossPrice());
		return invoice;
	}
}
