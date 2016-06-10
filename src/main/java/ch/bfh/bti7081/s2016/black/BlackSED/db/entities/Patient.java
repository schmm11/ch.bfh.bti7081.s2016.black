package main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.entities;

import java.util.ArrayList;
import java.util.Arrays;

import main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.MysqlAdapter;
import main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.model.TreatmentModel;

public class Patient extends AbstractEntity {

	protected int patient_id;
	protected String threatment;

	public int getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}

	public ArrayList<Treatment> getThreatment() {
		int[] threatment = Arrays.stream(this.threatment.substring(1, this.threatment.length()-1).split(",")).map(String::trim).mapToInt(Integer::parseInt).toArray();
		ArrayList<Treatment> al = new ArrayList<Treatment>();
		try {
			TreatmentModel tm = new TreatmentModel(new MysqlAdapter());
			for(int i = 0; i <= threatment.length; i++) {
				al.add(tm.get(threatment[i]));
			}
		}
		catch (Exception e) {}
		return al;
	}

	public void setThreatment(int[] threatment) {
		this.threatment = Arrays.toString(threatment);
	}
	
	public void setThreatment(String threatment) {
		this.threatment = threatment;
	}

}
