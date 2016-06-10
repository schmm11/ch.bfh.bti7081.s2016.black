package main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.model;

import java.sql.ResultSet;
import java.util.ArrayList;

import main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.MysqlAdapter;
import main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.entities.Medicine;
import main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.entities.Patient;

public class PatientModel extends AbstractModel {
	
	MysqlAdapter adapter;
	
	public PatientModel(MysqlAdapter adapter) {
		this.adapter = adapter;
	}
	
	public ArrayList<Patient> fetchAll() {
		String sql = "SELECT * from patient;";
		
		ArrayList<Patient> al = new ArrayList<Patient>();
		try {
			ResultSet rs = this.adapter.query(sql);
			while(rs.next()) {
				Patient obj = new Patient();
				obj.setPatient_id(rs.getInt("patient_id"));
				obj.setThreatment(rs.getString("threatment"));
				
				al.add(obj);
			}
		}
		catch (Exception e) {}
		
		return al;
	}
	
	public Patient get(int id) {
		String sql = "SELECT * from patient where patient_id = " + id +";";
		Patient obj = new Patient();
		
		try {
			ResultSet rs = this.adapter.query(sql);
			while(rs.next()) {
				obj.setPatient_id(rs.getInt("patient_id"));
				obj.setThreatment(rs.getString("threatment"));
			}
		}
		catch (Exception e) {}
		
		return obj;
	}
}
