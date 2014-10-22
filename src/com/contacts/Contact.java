package com.contacts;

class Contact {
	String name;
	String phone;
	
	@Override
	public String toString() {
		return this.name + " " + this.phone;		
	}
	
}
