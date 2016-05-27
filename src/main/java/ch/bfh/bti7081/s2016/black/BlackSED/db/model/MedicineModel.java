package main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.model;

import java.sql.ResultSet;
import java.util.ArrayList;

import main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.MysqlAdapter;
import main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.entities.Medicine;

public class MedicineModel extends AbstractModel {
	
	MysqlAdapter adapter;
	
	public MedicineModel(MysqlAdapter adapter) {
		this.adapter = adapter;
	}
	
	public ArrayList<Medicine> fetchAll() {
		String sql = "SELECT * from medicine;";
		
		ArrayList<Medicine> al = new ArrayList<Medicine>();
		try {
			ResultSet rs = this.adapter.query(sql);
			while(rs.next()) {
				Medicine obj = new Medicine();
				obj.setMedicine_id(rs.getInt("medicine_id"));
				obj.setDoseUnit(rs.getString("doseUnit"));
				obj.setManufacturer(rs.getString("manufacturer"));
				obj.setName(rs.getString("name"));
				obj.setSiteEffect(rs.getString("siteEffect"));
				
				al.add(obj);
			}
		}
		catch (Exception e) {}
		
		return al;
	}
}
