package com.wellbrew.wellbrewapp.model.data;

import com.wellbrew.wellbrewapp.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface ProductDao extends CrudRepository<Product, Integer> {

    Product findByName(String name);

    Product findByVendor(String vendor);
}
