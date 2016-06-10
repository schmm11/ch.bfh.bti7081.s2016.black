package main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.model;

import java.sql.ResultSet;
import java.util.ArrayList;

import main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.MysqlAdapter;
import main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.entities.Appointment;
import main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.entities.Doctor;

public class DoctorModel extends AbstractModel {
	
	MysqlAdapter adapter;
	
	public DoctorModel(MysqlAdapter adapter) {
		this.adapter = adapter;
	}
	
	public ArrayList<Doctor> fetchAll() {
		String sql = "SELECT * from doctor;";
		
		ArrayList<Doctor> al = new ArrayList<Doctor>();
		try {
			ResultSet rs = this.adapter.query(sql);
			while(rs.next()) {
				Doctor obj = new Doctor();
				obj.setDoctor_id(rs.getInt("doctor_id"));
				obj.setDefaultLocation(rs.getString("defaultLocation"));
				
				al.add(obj);
			}
		}
		catch (Exception e) {}
		
		return al;
	}
	
	public Doctor get(int id) {
		String sql = "SELECT * from doctor where doctor_id = " + id +";";
		Doctor obj = new Doctor();
		
		try {
			ResultSet rs = this.adapter.query(sql);
			while(rs.next()) {
				obj.setDoctor_id(rs.getInt("doctor_id"));
				obj.setDefaultLocation(rs.getString("defaultLocation"));
			}
		}
		catch (Exception e) {}
		
		return obj;
	}
}
