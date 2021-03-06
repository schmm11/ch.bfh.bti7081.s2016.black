package main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.entities;

import java.util.ArrayList;
import java.util.Arrays;

import main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.MysqlAdapter;
import main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.model.SiteEffectModel;

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
	
	public SideEffect[] getSideEffect() {
		int[] sideEffects = Arrays.stream(this.sideEffect.substring(1, this.sideEffect.length()-1).split(",")).map(String::trim).mapToInt(Integer::parseInt).toArray();
		SideEffect[] se = new SideEffect[sideEffects.length];
		try {
			SiteEffectModel sem = new SiteEffectModel(new MysqlAdapter());
			for(int i = 0; i <= sideEffects.length; i++) {
				se[i] = sem.get(sideEffects[i]);
			}
		}
		catch (Exception e) {}
		return se;
	}
	
	public void setSideEffect(int[] sideEffect) {
		this.sideEffect = Arrays.toString(sideEffect);
	}
	
	public void setSiteEffect(String sideEffect) {
		this.sideEffect = sideEffect;
	}
	
}
