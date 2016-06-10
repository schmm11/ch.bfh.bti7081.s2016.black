package main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.entities;

import java.util.Arrays;

import main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.MysqlAdapter;
import main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.model.AddressModel;

public class Person extends AbstractEntity {

	protected int person_id;
	protected String firstName;
	protected String lastName;
	protected String address;
	protected String username;
	protected String password;
	
	public int getPerson_id() {
		return person_id;
	}
	
	public void setPerson_id(int person_id) {
		this.person_id = person_id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
