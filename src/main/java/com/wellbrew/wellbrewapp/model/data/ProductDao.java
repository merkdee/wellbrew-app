package com.wellbrew.wellbrewapp.model.data;

import com.wellbrew.wellbrewapp.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface ProductDao extends CrudRepository<Product, Integer> {

    @Override
    <S extends Product> S save(S entity);

    @Override
    void deleteById(Integer integer);

    @Override
    Iterable<Product> findAll();

    @Override
    Optional<Product> findById(Integer integer);
}
