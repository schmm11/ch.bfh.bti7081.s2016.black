package main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.entities;

public class Location extends AbstractEntity {

	protected int location_id;
	protected String name;
	protected String address;
	
	public int getLocation_id() {
		return location_id;
	}
	
	public void setLocation_id(int location_id) {
		this.location_id = location_id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
}
