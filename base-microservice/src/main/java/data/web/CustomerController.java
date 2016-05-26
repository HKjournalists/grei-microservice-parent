package data.web;

import data.entity.Customer;
import data.query.QCustomer;
import data.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author 刘佳兴
 */
@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    Customer create(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.GET)
    Customer findOne(@PathVariable Long id) {
        return customerRepository.findOne(id);
    }

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    Page<Customer> page(QCustomer qCustomer, Pageable pageable) {
        return customerRepository.findAll(qCustomer, pageable);
    }

}
