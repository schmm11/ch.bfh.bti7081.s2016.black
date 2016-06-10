package main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.entities;

import java.util.Arrays;

import main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.MysqlAdapter;
import main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.model.LocationModel;

public class Doctor extends AbstractEntity {

	protected int doctor_id;
	protected String defaultLocation;

	
	public int getDoctor_id() {
		return doctor_id;
	}

	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}

	public Location getDefaultLocation() {
		try {
			int[] location = Arrays.stream(this.defaultLocation.substring(1, this.defaultLocation.length()-1).split(",")).map(String::trim).mapToInt(Integer::parseInt).toArray();
			LocationModel lm = new LocationModel(new MysqlAdapter());
			for(int i = 0; i <= location.length; i++) {
				return lm.get(location[i]);
			}
		}
		catch (Exception e) {}
		return new Location();
	}

	public void setDefaultLocation(String defaultLocation) {
		this.defaultLocation = defaultLocation;
	}
	
}
