package main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.entities;

public class SideEffect extends AbstractEntity {
	
	protected int sideEffect_id;
	protected String name;
	protected String description;
	
	public int getSideEffect_id() {
		return sideEffect_id;
	}
	
	public void setSideEffect_id(int sideEffect_id) {
		this.sideEffect_id = sideEffect_id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
}
