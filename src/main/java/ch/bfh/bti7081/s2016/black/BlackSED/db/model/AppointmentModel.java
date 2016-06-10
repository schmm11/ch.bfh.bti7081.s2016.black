package main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.model;

import java.sql.ResultSet;
import java.util.ArrayList;

import main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.MysqlAdapter;
import main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.entities.Address;
import main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.entities.Appointment;

public class AppointmentModel extends AbstractModel {

	MysqlAdapter adapter;
	
	public AppointmentModel(MysqlAdapter adapter) {
		this.adapter = adapter;
	}
	
	public ArrayList<Appointment> fetchAll() {
		String sql = "SELECT * from appointment;";
		
		ArrayList<Appointment> al = new ArrayList<Appointment>();
		try {
			ResultSet rs = this.adapter.query(sql);
			while(rs.next()) {
				Appointment obj = new Appointment();
				obj.setAppointment_id(rs.getInt("appointment_id"));
				obj.setStartDate(rs.getString("startDate"));
				obj.setEndDate(rs.getString("endDate"));
				obj.setLocation(rs.getString("location"));
				
				al.add(obj);
			}
		}
		catch (Exception e) {}
		
		return al;
	}
	
	public Appointment get(int id) {
		String sql = "SELECT * from appointment where appointment_id = " + id +";";
		Appointment obj = new Appointment();
		
		try {
			ResultSet rs = this.adapter.query(sql);
			while(rs.next()) {
				obj.setAppointment_id(rs.getInt("appointment_id"));
				obj.setStartDate(rs.getString("startDate"));
				obj.setEndDate(rs.getString("endDate"));
				obj.setLocation(rs.getString("location"));
			}
		}
		catch (Exception e) {}
		
		return obj;
	}
	
}
