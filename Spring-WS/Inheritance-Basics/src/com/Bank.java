package com;

public abstract class Bank {
	
	public String custName;

	public abstract void openAccount();

	public void info() {
		System.out.println("-- bank class info method");
	}

}
