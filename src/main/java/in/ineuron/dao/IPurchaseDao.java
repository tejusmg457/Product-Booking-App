package in.ineuron.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.ineuron.model.Purchase;

@Repository("purchaseDao")
public interface IPurchaseDao extends JpaRepository<Purchase, Integer> {

}
