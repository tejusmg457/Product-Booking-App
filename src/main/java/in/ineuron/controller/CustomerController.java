package in.ineuron.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.model.Customer;
import in.ineuron.service.ICustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
	
	@Autowired(required=true)
	private ICustomerService service;
	
	@PostMapping("/save-Customer")
	public String saveCustomer(@RequestBody Customer customer) {
		String body = service.saveCustomer(customer);
		return body;
	}
	
	@GetMapping("/find-Customer/{id}")
	public Optional<Customer> findCustomerById(@PathVariable Integer id) {
		@SuppressWarnings("unchecked")
		Optional<Customer> customer = (Optional<Customer>) service.findCustomerById(id);
		return customer;
	}
	
	@DeleteMapping("/delete-Customer/{id}")
	public String deleteCustomer(@PathVariable Integer id) {
		String body = service.deleteCustomer(id);
		return body;
	}
	
	@PatchMapping("/update-Customer")
	public String updateCustomer(@RequestBody Customer customer) {
		String body = service.updateCustomer(customer);
		return body;
	}
	
	@GetMapping("/findAllCustomer")
	public List<Customer> findAllCustomer(){
		List<Customer> customerList = service.findAllCustomer();
		return customerList;
	}
	
	
	
	

}
