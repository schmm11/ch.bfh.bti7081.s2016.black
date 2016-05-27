package main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.entities;

import java.util.Arrays;

public class Patient extends AbstractEntity {

	protected int patient_id;
	protected String threatment;

	public int getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}

	public int[] getThreatment() {
		return Arrays.stream(this.threatment.substring(1, this.threatment.length()-1).split(",")).map(String::trim).mapToInt(Integer::parseInt).toArray();
	}

	public void setThreatment(int[] threatment) {
		this.threatment = Arrays.toString(threatment);
	}
	
	public void setThreatment(String threatment) {
		this.threatment = threatment;
	}

}
