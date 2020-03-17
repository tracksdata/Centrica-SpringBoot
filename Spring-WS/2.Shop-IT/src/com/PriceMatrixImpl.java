package com;


// Dependency
public class PriceMatrixImpl implements PriceMatrix {

	public PriceMatrixImpl() {
		System.out.println("-- PriceMatrix Object is created with "+System.identityHashCode(this));
	}

	@Override
	public double getItemPrice(String itemCode) {
		// code to connect to DB and fetch price of given itemCode
		return 100.00;

	}

}
