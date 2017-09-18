
package sda.transformer;

import org.springframework.stereotype.Component;
import sda.dto.Invoice;
import sda.entity.InvoiceEntity;

/**
 * Created by RENT on 2017-09-18.
 */
@Component
public class InvoiceTransformer {

	public InvoiceEntity transform (Invoice invoice){
		InvoiceEntity invoiceEntity = new InvoiceEntity();
		invoiceEntity.setId(invoice.getId());
		invoiceEntity.setDate(invoice.getDate());
		invoiceEntity.setInvoiceNumber(invoice.getInvoiceNumber());
		invoiceEntity.setMyCompany(invoice.getMyCompany());
		invoiceEntity.setCustomer(invoice.getCustomer());
		invoiceEntity.setProducts(invoice.getProducts());
		invoiceEntity.setVAT(invoice.getVAT());
		invoiceEntity.setTotalNetPrice(invoice.getTotalNetPrice());
		invoiceEntity.setTotalGrossPrice(invoice.getTotalGrossPrice());
		return invoiceEntity;
	}

	public Invoice transformToInvoice (InvoiceEntity invoiceEntity){
		Invoice invoice = new Invoice();
		invoice.setId(invoiceEntity.getId());
		invoice.setDate(invoiceEntity.getDate());
		invoice.setInvoiceNumber(invoiceEntity.getInvoiceNumber());
		invoice.setMyCompany(invoiceEntity.getMyCompany());
		invoice.setCustomer(invoiceEntity.getCustomer());
		invoice.setProducts(invoiceEntity.getProducts());
		invoice.setVAT(invoiceEntity.getVAT());
		invoice.setTotalNetPrice(invoiceEntity.getTotalNetPrice());
		invoice.setTotalGrossPrice(invoiceEntity.getTotalGrossPrice());
		return invoice;
	}
}
