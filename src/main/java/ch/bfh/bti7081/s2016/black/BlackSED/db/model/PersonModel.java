package main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.model;

import java.sql.ResultSet;
import java.util.ArrayList;

import main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.MysqlAdapter;
import main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.entities.Person;

public class PersonModel extends AbstractModel {

	MysqlAdapter adapter;
	
	public PersonModel(MysqlAdapter adapter) {
		this.adapter = adapter;
	}
	
	public ArrayList<Person> fetchAll() {
		String sql = "SELECT * from person;";
		
		ArrayList<Person> al = new ArrayList<Person>();
		try {
			ResultSet rs = this.adapter.query(sql);
			while(rs.next()) {
				Person obj = new Person();
				obj.setPerson_id(rs.getInt("person_id"));
				obj.setAddress(rs.getString("address"));
				obj.setFirstName(rs.getString("firstName"));
				obj.setLastName(rs.getString("lastName"));
				obj.setPassword(rs.getString("password"));
				obj.setUsername(rs.getString("username"));
				
				al.add(obj);
			}
		}
		catch (Exception e) {}
		
		return al;
	}
	
}
