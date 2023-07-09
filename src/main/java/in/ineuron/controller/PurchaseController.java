package in.ineuron.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import in.ineuron.model.Purchase;
import in.ineuron.service.ICustomerService;
import in.ineuron.service.IProductService;
import in.ineuron.service.IPurchaseService;

@RestController
@RequestMapping("/api")
public class PurchaseController {
	
	@Autowired
	private ICustomerService service;
	@Autowired
	private IProductService productService;
	
	@Autowired
	private IPurchaseService purchaseService;
	
	@PostMapping("/purchase-Product")
	public String purchaseProduct(@RequestBody Purchase purchase) {
		String cverify = service.verifyCustomer(purchase.getCid());
		if(cverify.equalsIgnoreCase("success")) {
			String pverify = productService.verifyProduct(purchase.getPid());
			if(pverify.equalsIgnoreCase("success")) {
				String msg = purchaseService.purcaseProduct(purchase);
				return msg;
			}else 
				return pverify;
			}else 
				return cverify;	
	}
}
