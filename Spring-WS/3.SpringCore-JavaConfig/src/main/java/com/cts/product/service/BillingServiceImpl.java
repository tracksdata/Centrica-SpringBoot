package com.cts.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.product.dao.PriceMatrix;

@Service
public class BillingServiceImpl implements BillingService {

	@Autowired
	private PriceMatrix price;

	@Override
	public double getCartTotal(String[] cart) {

		double total = 0.0;
		for (String itemCode : cart) {
			total = total + price.getItemPrice(itemCode);
		}

		return total;

	}

}
