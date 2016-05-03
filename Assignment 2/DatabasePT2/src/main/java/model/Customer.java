package model;

public class Customer {
	String name;
	String email;
	
	public Customer(String name, String email)
	{
		this.name=name;
		this.email=email;
		
	}
	
	public Customer()
	{
		this("","");
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}
