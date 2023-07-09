package in.ineuron.service;

import java.util.List;
import java.util.Optional;

import in.ineuron.model.Customer;

public interface ICustomerService {

	public String saveCustomer(Customer customer);
	public String deleteCustomer(int id);
	public String updateCustomer(Customer customer);
	public Optional<?> findCustomerById(int id);
	public List<Customer> findAllCustomer();
	public String verifyCustomer(int id);
	
}
