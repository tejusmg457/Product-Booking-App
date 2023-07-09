package in.ineuron.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.Exception.CustomerNotFoundException;
import in.ineuron.dao.ICustomerDao;
import in.ineuron.model.Customer;

@Service("service")
public class CustomerServiceImpl implements ICustomerService {
	
	@Autowired(required=true)
	private ICustomerDao repo;

	@Override
	public String saveCustomer(Customer customer) {
		int id = repo.save(customer).getCid();
		String body = "Customer successfully registered & their id is :: "+ id;
		return body;
	}
	
	@Override
	public String deleteCustomer(int id) {
		Optional<Customer> customer = repo.findById(id);
		if(customer.isPresent()) {
			repo.deleteById(id);
			return "Customer deleted successfully for the id :: "+ id;
		}
		else {
			CustomerNotFoundException errormsg = new CustomerNotFoundException(" Customer with id "+id+" not found");
			String error = errormsg.getMessage();
			return error;
		}
	}

	@Override
	public String updateCustomer(Customer customer) {
		Optional<Customer> customer1 = repo.findById(customer.getCid());
		if(customer1.isPresent()) {
			repo.save(customer);
			return "Updated customer information";
		}else {
			CustomerNotFoundException errormsg = new CustomerNotFoundException(" Customer with id "+customer.getCid()+" not found");
			String error = errormsg.getMessage();
			return error;
		}
	}

	@Override
	public Optional<Customer> findCustomerById(int id) {
		
		Optional<Customer> customer = repo.findById(id);
		if(customer.isPresent())
			return customer;
		else {
			throw new CustomerNotFoundException(" Customer with id "+id+" not found");
		}
	}

	@Override
	public List<Customer> findAllCustomer() {
		List<Customer> allCoustomer = (List<Customer>) repo.findAll();
		return allCoustomer;
	}

	@Override
	public String verifyCustomer(int id) {
		Optional<Customer> customer = repo.findById(id);
		if(customer.isPresent()) {
			return "success";
		}else {
			CustomerNotFoundException errormsg = new CustomerNotFoundException("Invalid Customer with the id "+id+" not found");
			String error = errormsg.getMessage();
			return error;
		}
	}
}
