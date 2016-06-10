package main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.entities;

import java.util.ArrayList;
import java.util.Arrays;

import main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.MysqlAdapter;
import main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.model.AddressModel;
import main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.model.MedicineModel;

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
	
	public Address getAddress() {
		int[] address = Arrays.stream(this.address.substring(1, this.address.length()-1).split(",")).map(String::trim).mapToInt(Integer::parseInt).toArray();
		try {
			AddressModel am = new AddressModel(new MysqlAdapter());
			for(int i = 0; i <= address.length; i++) {
				return am.get(address[i]);
			}
		}
		catch (Exception e) {}
		return new Address();
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
}
