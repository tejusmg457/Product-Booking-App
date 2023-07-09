package in.ineuron.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.dao.IPurchaseDao;
import in.ineuron.model.Purchase;

@Service("purchaseService")
public class PurchaseServiceImpl implements IPurchaseService{
	
	@Autowired
	private IPurchaseDao purchaseRepo;
	
	@Override
	public String purcaseProduct(Purchase purchase) {
		int id = purchaseRepo.save(purchase).getPurchaseId();
		return "Customer purchased product successfully & order id is :: "+id;
	}

	
}
