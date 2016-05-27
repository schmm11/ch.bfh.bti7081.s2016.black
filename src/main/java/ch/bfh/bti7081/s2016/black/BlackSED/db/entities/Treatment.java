package main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.entities;

import java.util.Arrays;

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
	
	public int[] getPrescription() {
		return Arrays.stream(this.prescription.substring(1, this.prescription.length()-1).split(",")).map(String::trim).mapToInt(Integer::parseInt).toArray();
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
	
	public int[] getAppointments() {
		return Arrays.stream(this.appointments.substring(1, this.appointments.length()-1).split(",")).map(String::trim).mapToInt(Integer::parseInt).toArray();
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
