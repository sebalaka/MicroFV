package sda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sda.dao.InvoiceRepository;
import sda.dto.Invoice;
import sda.entity.InvoiceEntity;
import sda.transformer.InvoiceTransformer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RENT on 2017-09-18.
 */
@Service
public class InvoiceService {

	private InvoiceRepository invoiceRepository;
	private InvoiceTransformer invoiceTransformer;
	private InvoiceNumberGenerator invoiceNumberGenerator;

	@Autowired
	public InvoiceService(InvoiceRepository invoiceRepository,
						  InvoiceTransformer invoiceTransformer,
						  InvoiceNumberGenerator invoiceNumberGenerator
						  ) {

		this.invoiceRepository = invoiceRepository;
		this.invoiceTransformer = invoiceTransformer;
	}

	public Long add(Invoice invoice){
		if(invoice.getInvoiceNumber().isEmpty()){
			return null;
		} else {
			InvoiceEntity invoiceEntity = invoiceRepository.save(invoiceTransformer.transform(invoice));
			return invoiceEntity.getId();
		}
	}

	public List<Invoice> getAll() {
		Iterable<InvoiceEntity> all = invoiceRepository.findAll();
		List<Invoice> result = new ArrayList<>();
		for(InvoiceEntity invoiceEntity : all){
			result.add(invoiceTransformer.transformToInvoice(invoiceEntity));
		}
		return result;
	}

}
