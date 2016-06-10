package main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.model;

import java.sql.ResultSet;
import java.util.ArrayList;

import main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.MysqlAdapter;
import main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.entities.Doctor;
import main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.entities.Location;

public class LocationModel extends AbstractModel {
	
	MysqlAdapter adapter;
	
	public LocationModel(MysqlAdapter adapter) {
		this.adapter = adapter;
	}
	
	public ArrayList<Location> fetchAll() {
		String sql = "SELECT * from location;";
		
		ArrayList<Location> al = new ArrayList<Location>();
		try {
			ResultSet rs = this.adapter.query(sql);
			while(rs.next()) {
				Location obj = new Location();
				obj.setLocation_id(rs.getInt("location_id"));
				obj.setAddress(rs.getString("address"));
				obj.setName(rs.getString("name"));
				
				al.add(obj);
			}
		}
		catch (Exception e) {}
		
		return al;
	}
	
	public Location get(int id) {
		String sql = "SELECT * from location where location_id = " + id +";";
		Location obj = new Location();
		
		try {
			ResultSet rs = this.adapter.query(sql);
			while(rs.next()) {
				obj.setLocation_id(rs.getInt("location_id"));
				obj.setAddress(rs.getString("address"));
				obj.setName(rs.getString("name"));
			}
		}
		catch (Exception e) {}
		
		return obj;
	}
}
