package com.wellbrew.wellbrewapp.model.data;

import com.wellbrew.wellbrewapp.model.Orders;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface OrderDao extends CrudRepository<Orders, Integer> {

    @Override
    <S extends Orders> S save(S entity);

    @Override
    void deleteById(Integer integer);


    @Override
    Iterable<Orders> findAll();


}
