package main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.model;

import java.sql.ResultSet;
import java.util.ArrayList;

import main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.MysqlAdapter;
import main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.entities.SideEffect;
import main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.entities.Treatment;

public class TreatmentModel extends AbstractModel {

	MysqlAdapter adapter;
	
	public TreatmentModel(MysqlAdapter adapter) {
		this.adapter = adapter;
	}
	
	public ArrayList<Treatment> fetchAll() {
		String sql = "SELECT * from threatment;";
		
		ArrayList<Treatment> al = new ArrayList<Treatment>();
		try {
			ResultSet rs = this.adapter.query(sql);
			while(rs.next()) {
				Treatment obj = new Treatment();
				obj.setTreatment_id(rs.getInt("threatment_id"));
				obj.setAppointments(rs.getString("appointments"));
				obj.setDescription(rs.getString("description"));
				obj.setEndDate(rs.getString("endDate"));
				obj.setName(rs.getString("name"));
				obj.setPrescription(rs.getString("prescription"));
				obj.setStartDate(rs.getString("startDate"));

				al.add(obj);
			}
		}
		catch (Exception e) {}
		
		return al;
	}
	
	public Treatment get(int id) {
		String sql = "SELECT * from treatment where treatment_id = " + id +";";
		Treatment obj = new Treatment();
		
		try {
			ResultSet rs = this.adapter.query(sql);
			while(rs.next()) {
				obj.setTreatment_id(rs.getInt("threatment_id"));
				obj.setAppointments(rs.getString("appointments"));
				obj.setDescription(rs.getString("description"));
				obj.setEndDate(rs.getString("endDate"));
				obj.setName(rs.getString("name"));
				obj.setPrescription(rs.getString("prescription"));
				obj.setStartDate(rs.getString("startDate"));
			}
		}
		catch (Exception e) {}
		
		return obj;
	}
}
