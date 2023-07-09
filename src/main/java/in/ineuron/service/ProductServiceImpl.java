package in.ineuron.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.dao.IProductDao;
import in.ineuron.model.Product;
import in.ineuron.Exception.ProductNotFoundException;

@Service("productService")
public class ProductServiceImpl implements IProductService {
	
	@Autowired(required=true)
	private IProductDao productRepo;

	@Override
	public String saveProduct(Product product) {
		int id = productRepo.save(product).getPid();
		String body = "Product successfully registered & their id is :: "+ id;
		return body;
	}

	@Override
	public String deleteProduct(int id) {
		Optional<Product> product = productRepo.findById(id);
		if(product.isPresent()) {
			productRepo.deleteById(id);
			return "Product deleted successfully for the id :: "+ id;
		}else {
			ProductNotFoundException errormsg = new ProductNotFoundException("Product with id "+id+" not found");
			String error = errormsg.getMessage();
			return error;
		}
	}

	@Override
	public String updateProduct(Product product) {
		Optional<Product> product1 = productRepo.findById(product.getPid());
		if(product1.isPresent()) {
			productRepo.save(product);
			return "Product updated successfully for the id :: "+ product.getPid();
		}else {
			ProductNotFoundException errormsg = new ProductNotFoundException("Product with id "+product.getPid()+" not found");
			String error = errormsg.getMessage();
			return error;
		}
	}

	@Override
	public Optional<Product> findProductById(int id) {
		Optional<Product> product = productRepo.findById(id);
		if(product.isPresent())
			return product;
		else {
			throw new ProductNotFoundException("product with id :: "+id+" not found");
		}
	}

	@Override
	public List<Product> findAllProduct() {
		List<Product> allProduct = (List<Product>) productRepo.findAll();
		return allProduct;
	}

	@Override
	public String verifyProduct(int id) {
		Optional<Product> product = productRepo.findById(id);
		if(product.isPresent()) {
			return "success";
		}else {
			ProductNotFoundException errormsg = new ProductNotFoundException("Invalid Product with the id "+id+" not found");
			String error = errormsg.getMessage();
			return error;
		}
	}
}
