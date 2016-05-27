package main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.entities;

public class Doctor extends AbstractEntity {

	protected int doctor_id;
	protected String defaultLocation;

	
	public int getDoctor_id() {
		return doctor_id;
	}

	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}

	public String getDefaultLocation() {
		return defaultLocation;
	}

	public void setDefaultLocation(String defaultLocation) {
		this.defaultLocation = defaultLocation;
	}
	
}
