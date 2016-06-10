package main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.entities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.MysqlAdapter;
import main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.model.MedicineModel;

import com.sun.javafx.collections.MappingChange.Map;

public class Prescription extends AbstractEntity {

	protected int prescription_id;
	protected String medicine;
	protected int dose;
	protected String taking;
	
	public int getPrescription_id() {
		return prescription_id;
	}
	
	public void setPrescription_id(int prescription_id) {
		this.prescription_id = prescription_id;
	}
	
	public Medicine getMedicine() {
		int[] medicine = Arrays.stream(this.medicine.substring(1, this.medicine.length()-1).split(",")).map(String::trim).mapToInt(Integer::parseInt).toArray();
		try {
			MedicineModel tm = new MedicineModel(new MysqlAdapter());
			for(int i = 0; i <= medicine.length; i++) {
				return tm.get(medicine[i]);
			}
		}
		catch (Exception e) {}
		return new Medicine();
	}
	
	public void setMedicine(String[] medicine) {
		this.medicine = Arrays.toString(medicine);
	}
	
	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}
	
	public int getDose() {
		return dose;
	}
	
	public void setDose(int dose) {
		this.dose = dose;
	}
	
	public Date[] getTaking() {
		String[] takings = this.taking.split(",");
		Date[] dates = new Date[takings.length];
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		try {
			for(int i = 0; i <= takings.length; i++) {
				dates[i] = format.parse(takings[i]);
			}
		}
		catch (Exception e) {}
		
		return dates;
		//return Arrays.stream(this.taking.substring(1, this.taking.length()-1).split(",")).map(String::trim).mapToInt(Integer::parseInt).toArray();
	}
	
	public void setTaking(String[] taking) {
		this.taking = Arrays.toString(taking);
	}
	
	public void setTaking(String taking) {
		this.taking = taking;
	}
	
}
