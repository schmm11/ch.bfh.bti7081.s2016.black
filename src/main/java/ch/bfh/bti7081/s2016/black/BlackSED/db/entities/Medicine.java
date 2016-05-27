package main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.entities;

import java.util.Arrays;

public class Medicine extends AbstractEntity {

	protected int medicine_id;
	protected String name;
	protected String manufacturer;
	protected String doseUnit;
	protected String sideEffect;
	
	public int getMedicine_id() {
		return medicine_id;
	}
	
	public void setMedicine_id(int medicine_id) {
		this.medicine_id = medicine_id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getManufacturer() {
		return manufacturer;
	}
	
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	public String getDoseUnit() {
		return doseUnit;
	}
	
	public void setDoseUnit(String doseUnit) {
		this.doseUnit = doseUnit;
	}
	
	public int[] getSideEffect() {
		return Arrays.stream(this.sideEffect.substring(1, this.sideEffect.length()-1).split(",")).map(String::trim).mapToInt(Integer::parseInt).toArray();
	}
	
	public void setSideEffect(int[] sideEffect) {
		this.sideEffect = Arrays.toString(sideEffect);
	}
	
	public void setSiteEffect(String sideEffect) {
		this.sideEffect = sideEffect;
	}
	
}
