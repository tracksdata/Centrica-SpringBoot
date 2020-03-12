package com;

public class Test {

	public static void main(String[] args) {
		
		// Store sub class object in the super class ref
		//Customer c1=new Customer();
		//c1.openAccount();
		//c1.custInfo();
		Bank b=new Customer(); // => Abstraction
		/*
		 * Note:
		 * -> super class ref can store all its sub class objects
		 * -> super class ref can access all the methods in 
		 *    super class and overridden methods of sub class
		 * -> super class ref can not access individual methods
		 *    of sub class (a method which is available only in 
		 *    sub class, and not available in super class)
		 *    
		 *    
		 *    
		 */
		b.openAccount();
		//b.info();
		//b.custInfo();
		
		
		

	}

}
