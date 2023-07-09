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

import in.ineuron.model.Product;
import in.ineuron.service.IProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {
	
	@Autowired(required=true)
	private IProductService productService;
	
	@PostMapping("/save-Product")
	public String saveProduct(@RequestBody Product product) {
		String body = productService.saveProduct(product);
		return body;
	}
	
	@GetMapping("/find-Product/{id}")
	public Optional<Product> findProductById(@PathVariable Integer id) {
		Optional<Product> product = productService.findProductById(id);
		return product;
	}
	
	@DeleteMapping("/delete-Product/{id}")
	public String deleteProduct(@PathVariable Integer id) {
		String body = productService.deleteProduct(id);
		return body;
	}
	
	@PatchMapping("/update-Product")
	public String updateProduct(@RequestBody Product product) {
		String body = productService.updateProduct(product);
		return body;
	}
	
	@GetMapping("/findAllProduct")
	public List<Product> findAllProduct(){
		List<Product> productList = productService.findAllProduct();
		return productList;
	}
}
