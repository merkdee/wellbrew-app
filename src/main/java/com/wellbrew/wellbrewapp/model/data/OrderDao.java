package com.wellbrew.wellbrewapp.model.data;

import com.wellbrew.wellbrewapp.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderDao extends CrudRepository<Order, Integer> {

}
