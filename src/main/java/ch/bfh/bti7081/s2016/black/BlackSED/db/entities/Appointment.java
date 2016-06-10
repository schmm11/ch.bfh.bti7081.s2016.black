package main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.entities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.MysqlAdapter;
import main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.model.LocationModel;
import main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.model.MedicineModel;

public class Appointment extends AbstractEntity {

	protected int appointment_id;
	protected String startDate;
	protected String endDate;
	protected String location;
	
	
	public int getAppointment_id() {
		return appointment_id;
	}
	
	public void setAppointment_id(int appointment_id) {
		this.appointment_id = appointment_id;
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
	
	public Location getLocation() {
		try {
			int[] location = Arrays.stream(this.location.substring(1, this.location.length()-1).split(",")).map(String::trim).mapToInt(Integer::parseInt).toArray();
			LocationModel lm = new LocationModel(new MysqlAdapter());
			for(int i = 0; i <= location.length; i++) {
				return lm.get(location[i]);
			}
		}
		catch (Exception e) {}
		return new Location();
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
}
