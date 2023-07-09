package in.ineuron.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.ineuron.model.Product;

@Repository("productRepo")
public interface IProductDao extends CrudRepository<Product, Integer> {

}
