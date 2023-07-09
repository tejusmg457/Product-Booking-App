package in.ineuron.service;

import java.util.List;
import java.util.Optional;

import in.ineuron.model.Product;

public interface IProductService {

	public String saveProduct(Product product);
	public String deleteProduct(int id);
	public String updateProduct(Product product);
	public Optional<Product> findProductById(int id);
	public List<Product> findAllProduct();
	public String verifyProduct(int id);
	
}

