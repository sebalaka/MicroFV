package sda.dao;

import org.springframework.data.repository.CrudRepository;
import sda.entity.InvoiceEntity;

/**
 * Created by RENT on 2017-09-18.
 */
public interface InvoiceRepository extends CrudRepository<InvoiceEntity, Long> {
}
