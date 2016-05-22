package main.java.ch.bfh.bti7081.s2016.black.BlackSED.presenter;

import main.java.ch.bfh.bti7081.s2016.black.BlackSED.helper.NavigationHelper;
import main.java.ch.bfh.bti7081.s2016.black.BlackSED.model.CalendarModel;
import main.java.ch.bfh.bti7081.s2016.black.BlackSED.model.EmergencyModel;
import main.java.ch.bfh.bti7081.s2016.black.BlackSED.model.MainMenuModel;
import main.java.ch.bfh.bti7081.s2016.black.BlackSED.model.MedicamentsModel;
import main.java.ch.bfh.bti7081.s2016.black.BlackSED.model.SettingsModel;
import main.java.ch.bfh.bti7081.s2016.black.BlackSED.model.entities.MainMenuEntry;
import main.java.ch.bfh.bti7081.s2016.black.BlackSED.view.CalendarView;
import main.java.ch.bfh.bti7081.s2016.black.BlackSED.view.EmergencyView;
import main.java.ch.bfh.bti7081.s2016.black.BlackSED.view.MainMenuView;
import main.java.ch.bfh.bti7081.s2016.black.BlackSED.view.MedicamentsView;
import main.java.ch.bfh.bti7081.s2016.black.BlackSED.view.SettingsView;

public class MainMenuPresenter implements MainMenuView.MainMenuViewListener {
	private MainMenuView view;
    private MainMenuModel model;
    
    public MainMenuPresenter(MainMenuModel model, MainMenuView view) {
		this.view = view;
		this.model = model;
		this.view.initializeMenu(this.model.getMainMenuEntries());
	}
    
	@Override
	public void menuButtonClicked(MainMenuEntry mainMenuEntry) {
		switch (mainMenuEntry.mainMenuType) {
		case CALENDAR: this.presentCalendarView(mainMenuEntry); break;
		case MEDICAMENTS: this.presentMedicamentsView(mainMenuEntry); break;
		case EMERGENCY: this.presentEmergencyView(mainMenuEntry); break;
		case SETTINGS: this.presentSettingsView(mainMenuEntry); break;
		default:
			//TODO: show page not found error page
			break;	
		}
	}

	public void presentCalendarView(MainMenuEntry mainMenuEntry) {
        //create model and Vaadin view implementation
        CalendarModel calendarModel = new CalendarModel();
        CalendarView calendarView  = new CalendarView(mainMenuEntry.buttonTitle);
      
        //the presenter binds the model and view together
        CalendarPresenter calendarPresenter = new CalendarPresenter(calendarModel, calendarView, NavigationHelper.MAINVIEW);
        
        //add presenter as listener of view
        calendarView.addListener(calendarPresenter);
        
        //present calendar view
		this.view.presentView(calendarView, NavigationHelper.CALENDARVIEW);
	}

	public void presentMedicamentsView(MainMenuEntry mainMenuEntry) {
        //create model and Vaadin view implementation
        MedicamentsModel medicamentsModel = new MedicamentsModel();
        MedicamentsView medicamentsView  = new MedicamentsView(mainMenuEntry.buttonTitle);
      
        //the presenter binds the model and view together
        MedicamentsPresenter medicamentsPresenter = new MedicamentsPresenter(medicamentsModel, medicamentsView, NavigationHelper.MAINVIEW);
        
        //add presenter as listener of view
        medicamentsView.addListener(medicamentsPresenter);
        
        //present calendar view
		this.view.presentView(medicamentsView, NavigationHelper.MEDICAMENTSVIEW);
	}

	public void presentEmergencyView(MainMenuEntry mainMenuEntry) {
        //create model and Vaadin view implementation
        EmergencyModel ermergencyModel = new EmergencyModel();
        EmergencyView emergencyView  = new EmergencyView(mainMenuEntry.buttonTitle);
      
        //the presenter binds the model and view together
        EmergencyPresenter emergencyPresenter = new EmergencyPresenter(ermergencyModel, emergencyView, NavigationHelper.MAINVIEW);
        
        //add presenter as listener of view
        emergencyView.addListener(emergencyPresenter);
        
        //present calendar view
		this.view.presentView(emergencyView, NavigationHelper.EMERGENCYVIEW);
	}

	public void presentSettingsView(MainMenuEntry mainMenuEntry) {
        //create model and Vaadin view implementation
        SettingsModel settingsModel = new SettingsModel();
        SettingsView settingsView  = new SettingsView(mainMenuEntry.buttonTitle);
      
        //the presenter binds the model and view together
        SettingsPresenter settingsPresenter = new SettingsPresenter(settingsModel, settingsView, NavigationHelper.MAINVIEW);
        
        //add presenter as listener of view
        settingsView.addListener(settingsPresenter);
        
        //present calendar view
		this.view.presentView(settingsView, NavigationHelper.SETTINGSVIEW);
	}
}