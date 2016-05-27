package main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.model;

import java.sql.ResultSet;
import java.util.ArrayList;

import main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.MysqlAdapter;
import main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.entities.Prescription;

public class PrescriptionModel extends AbstractModel {

	MysqlAdapter adapter;
	
	public PrescriptionModel(MysqlAdapter adapter) {
		this.adapter = adapter;
	}
	
	public ArrayList<Prescription> fetchAll() {
		String sql = "SELECT * from prescription;";
		
		ArrayList<Prescription> al = new ArrayList<Prescription>();
		try {
			ResultSet rs = this.adapter.query(sql);
			while(rs.next()) {
				Prescription obj = new Prescription();
				obj.setPrescription_id(rs.getInt("prescription_id"));
				obj.setDose(rs.getInt("dose"));
				obj.setMedicine(rs.getString("medicine"));
				obj.setTaking(rs.getString("taking"));

				al.add(obj);
			}
		}
		catch (Exception e) {}
		
		return al;
	}
	
}
