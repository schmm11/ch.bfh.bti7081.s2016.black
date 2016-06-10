package main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.entities;

import java.util.ArrayList;
import java.util.Arrays;

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
	
	public ArrayList<Medicine> getMedicine() {
		int[] medicine = Arrays.stream(this.medicine.substring(1, this.medicine.length()-1).split(",")).map(String::trim).mapToInt(Integer::parseInt).toArray();
		ArrayList<Medicine> al = new ArrayList<Medicine>();
		try {
			MedicineModel tm = new MedicineModel(new MysqlAdapter());
			for(int i = 0; i <= medicine.length; i++) {
				al.add(tm.get(medicine[i]));
			}
		}
		catch (Exception e) {}
		return al;
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
	
	public String[] getTaking() {
		return this.taking.split(",");
		//return Arrays.stream(this.taking.substring(1, this.taking.length()-1).split(",")).map(String::trim).mapToInt(Integer::parseInt).toArray();
	}
	
	public void setTaking(String[] taking) {
		this.taking = Arrays.toString(taking);
	}
	
	public void setTaking(String taking) {
		this.taking = taking;
	}
	
}
