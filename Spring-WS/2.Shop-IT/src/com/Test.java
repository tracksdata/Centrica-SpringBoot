package com;

public class Test {

	public static void main(String[] args) {

		String[] cart1 = { "Item01", "Item02", "Item03" };
		String[] cart2 = { "Item04", "Item05" };

		
		//-------------------------------------------------
		  PriceMatrix price=new PriceMatrixImpl(); // Dependency object
		//-------------------------------------------------
	
		BillerImpl biller = new BillerImpl(); // Dependent object
		
		biller.setPrice(price); // DI
		
		double total = biller.getTotalCartItems(cart1);
		System.out.println("Total Payable Amount for Cart1: " + total);

		total = biller.getTotalCartItems(cart2);
		System.out.println("Total Payable Amount for Cart2: " + total);

	}

}
