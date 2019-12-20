package com.wellbrew.wellbrewapp.model.data;

import com.wellbrew.wellbrewapp.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface CustomerDao extends CrudRepository<Customer, Integer> {

    Customer findByUsername(String username);
}
