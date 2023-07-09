package in.ineuron.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.ineuron.model.Customer;

@Repository("repo")
public interface ICustomerDao extends CrudRepository<Customer, Integer> {

}
