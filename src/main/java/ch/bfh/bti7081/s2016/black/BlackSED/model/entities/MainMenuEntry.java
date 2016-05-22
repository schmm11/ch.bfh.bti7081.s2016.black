package main.java.ch.bfh.bti7081.s2016.black.BlackSED.model.entities;

public class MainMenuEntry {
	public enum MainMenuType {
		CALENDAR,
		MEDICAMENTS,
		EMERGENCY,
		SETTINGS
	}
	
	public MainMenuType mainMenuType;
	public String buttonTitle;
	
	public MainMenuEntry(MainMenuType mainMenuType, String buttonTitle) {
		this.mainMenuType = mainMenuType;
		this.buttonTitle = buttonTitle;
	}
}