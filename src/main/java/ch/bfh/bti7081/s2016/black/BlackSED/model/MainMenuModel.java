package main.java.ch.bfh.bti7081.s2016.black.BlackSED.model;

import java.util.ArrayList;
import java.util.List;

import main.java.ch.bfh.bti7081.s2016.black.BlackSED.model.entities.MainMenuEntry;
import main.java.ch.bfh.bti7081.s2016.black.BlackSED.model.entities.MainMenuEntry.MainMenuType;

public class MainMenuModel extends BaseModel {

	public List<MainMenuEntry> getMainMenuEntries() {
		List<MainMenuEntry> list = new ArrayList<MainMenuEntry>();
		list.add(new MainMenuEntry(MainMenuType.CALENDAR, "Kalender"));
		list.add(new MainMenuEntry(MainMenuType.MEDICAMENTS, "Medikamente"));
		list.add(new MainMenuEntry(MainMenuType.EMERGENCY, "Notfallkarte"));
		list.add(new MainMenuEntry(MainMenuType.SETTINGS, "Einstellungen"));
		list.add(new MainMenuEntry(MainMenuType.LOGOUT, "Abmelden"));
		return list;
	}
}