package sda.dao;

import sda.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by RENT on 2017-09-08.
 */
public interface ProductRepository extends CrudRepository<ProductEntity, Long> {
}
