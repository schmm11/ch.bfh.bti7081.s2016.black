package main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.model;

import java.sql.ResultSet;
import java.util.ArrayList;

import main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.MysqlAdapter;
import main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.entities.Address;

public class AddressModel extends AbstractModel {

	MysqlAdapter adapter;
	
	public AddressModel(MysqlAdapter adapter) {
		this.adapter = adapter;
	}
	
	public ArrayList<Address> fetchAll() {
		String sql = "SELECT * from address;";
		
		ArrayList<Address> al = new ArrayList<Address>();
		try {
			ResultSet rs = this.adapter.query(sql);
			while(rs.next()) {
				Address obj = new Address();
				obj.setAddress_id(rs.getInt("address_id"));
				obj.setCity(rs.getString("city"));
				obj.setPostalCode(rs.getInt("postalCode"));
				obj.setStreet(rs.getString("street"));
				
				al.add(obj);
			}
		}
		catch (Exception e) {}
		
		return al;
	}
	
}
