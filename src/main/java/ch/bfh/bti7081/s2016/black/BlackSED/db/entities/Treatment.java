package main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.entities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

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
	
	public Prescription[] getPrescription() {
		int[] prescription = Arrays.stream(this.prescription.substring(1, this.prescription.length()-1).split(",")).map(String::trim).mapToInt(Integer::parseInt).toArray();
		Prescription[] p = new Prescription[prescription.length];
		try {
			PrescriptionModel tm = new PrescriptionModel(new MysqlAdapter());
			for(int i = 0; i <= prescription.length; i++) {
				p[i] = tm.get(prescription[i]);
			}
		}
		catch (Exception e) {}
		return p;
	}
	
	public void setPrescription(int[] prescription) {
		this.prescription = Arrays.toString(prescription);
	}
	
	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}
	
	public Date getStartDate() {
		try {
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return format.parse(this.startDate);
		}
		catch (Exception e) {}
		return new Date();
	}
	
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	public Date getEndDate() {
		try {
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return format.parse(this.endDate);
		}
		catch (Exception e) {}
		return new Date();
	}
	
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	public Appointment[] getAppointments() {
		int[] appointment = Arrays.stream(this.appointments.substring(1, this.appointments.length()-1).split(",")).map(String::trim).mapToInt(Integer::parseInt).toArray();
		Appointment[] a = new Appointment[appointment.length];
		try {
			AppointmentModel tm = new AppointmentModel(new MysqlAdapter());
			for(int i = 0; i <= appointment.length; i++) {
				a[i] = tm.get(appointment[i]);
			}
		}
		catch (Exception e) {}
		return a;
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
