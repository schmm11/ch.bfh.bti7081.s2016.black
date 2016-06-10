package main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.entities;

import java.util.ArrayList;
import java.util.Arrays;

import main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.MysqlAdapter;
import main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.model.AppointmentModel;
import main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.model.PrescriptionModel;
import jdk.nashorn.internal.ir.debug.JSONWriter;

import com.google.gwt.json.client.JSONParser;

public class Treatment extends AbstractEntity {

	protected int treatment_id;
	protected String name;
	protected String prescription;
	protected String startDate;
	protected String endDate;
	protected String appointments;
	protected String description;
	
	public int getTreatment_id() {
		return treatment_id;
	}
	
	public void setTreatment_id(int treatment_id) {
		this.treatment_id = treatment_id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public ArrayList<Prescription> getPrescription() {
		int[] prescription = Arrays.stream(this.prescription.substring(1, this.prescription.length()-1).split(",")).map(String::trim).mapToInt(Integer::parseInt).toArray();
		ArrayList<Prescription> al = new ArrayList<Prescription>();
		try {
			PrescriptionModel tm = new PrescriptionModel(new MysqlAdapter());
			for(int i = 0; i <= prescription.length; i++) {
				al.add(tm.get(prescription[i]));
			}
		}
		catch (Exception e) {}
		return al;
	}
	
	public void setPrescription(int[] prescription) {
		this.prescription = Arrays.toString(prescription);
	}
	
	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}
	
	public String getStartDate() {
		return startDate;
	}
	
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	public String getEndDate() {
		return endDate;
	}
	
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	public ArrayList<Appointment> getAppointments() {
		int[] appointment = Arrays.stream(this.appointments.substring(1, this.appointments.length()-1).split(",")).map(String::trim).mapToInt(Integer::parseInt).toArray();
		ArrayList<Appointment> al = new ArrayList<Appointment>();
		try {
			AppointmentModel tm = new AppointmentModel(new MysqlAdapter());
			for(int i = 0; i <= appointment.length; i++) {
				al.add(tm.get(appointment[i]));
			}
		}
		catch (Exception e) {}
		return al;
	}
	
	public void setAppointments(int[] appointments) {
		this.appointments = Arrays.toString(appointments);
	}
	
	public void setAppointments(String appointments) {
		this.appointments = appointments;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
}
