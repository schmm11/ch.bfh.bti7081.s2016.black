package main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.entities;

public class Address extends AbstractEntity {
	
	protected int address_id;
	protected String street;
	protected int postalCode;
	protected String city;
	
	
	public int getAddress_id() {
		return address_id;
	}
	
	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}
	
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public int getPostalCode() {
		return postalCode;
	}
	
	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
}
