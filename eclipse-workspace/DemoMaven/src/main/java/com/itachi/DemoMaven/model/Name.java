package com.itachi.DemoMaven.model;

public class Name {
	
	private String firstName;
	private String LastName;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	
	public Name() {
		super();
		System.out.println("name bean created.");
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}	public Name(String firstName) {
		super();
		this.firstName = firstName;
	}
	@Override
	public String toString() {
		return "Name [firstName=" + firstName + ", LastName=" + LastName + "]";
	}
}
