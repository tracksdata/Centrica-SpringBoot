package com;

// Dependent
public class BillerImpl {
	
	/*
	 *  Design Issues
	 *  -------------------
	 *  
	 *  
	 *  
	 *  1. Too many dependency object creations 
	 *  	-> Performance of application goes down, memory leaks
	 *  
	 *  Why this issue happened?
	 *  ---------------------------
	 *  
	 *  -> Dependent class itself creating dependency class object.
	 *  
	 *  What is the solution?
	 *  ----------------------
	 *  -> Do not ever create dependency object in the dependent directly
	 *  
	 *  -> Instead, create Reference of Dependency class.
	 *  
	 *  How to assign Dependency object to the reference created?
	 *  
	 *  -> use JNDI (Java Naming Directory Interface) location to get object (EJB)
	 *  	-> JNDI location is tightly coupled
	 *  
	 *  What is the best solution?
	 *  -> Do not create, or Do not find using Look up factory techniques,
	 *     instead ask some one to inject/pass dependency object => IoC (Inversion of Control)
	 *  
	 *  
	 *  How Can I perform IoC operations?
	 *  -> using Dependency Injection (DI)
	 *  
	 *  Dependency Injection (DI)
	 *  1. using constructor based DI
	 *  2. using setter based DI
	 *  
	 *  What is Dependency Injection?
	 *  -> Injecting / passing dependency object to the dependent object
	 *  
	 *  	
	 * 
	 * 
	 * 
	 */
	
	private PriceMatrix price; // has 'A' relationship
	
	

	public void setPrice(PriceMatrix price) {
		this.price = price;
	}



	public double getTotalCartItems(String[] cart) {

		//PriceMatrixImpl price = new PriceMatrixImpl();

		double total = 0.0;

		for (String itemCode : cart) {
			total = total + price.getItemPrice(itemCode);
		}

		return total;

	}

}
