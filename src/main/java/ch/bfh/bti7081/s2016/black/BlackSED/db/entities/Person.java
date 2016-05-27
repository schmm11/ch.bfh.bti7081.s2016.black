package main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.entities;

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
	
	public String getAddress() {
		return address;
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
