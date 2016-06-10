package main.java.ch.bfh.bti7081.s2016.black.BlackSED.view;

import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;

interface CalendarDetailViewInterface extends BaseViewInterface {
    public interface CalendarDetailViewListener extends BaseViewListener {
    	//TODO add here calendar related interface methods
    	//TODO in code cast needed to call method of subclass ((CalendarDetailViewListener)listener)
    }
}

@SuppressWarnings("serial")
public class CalendarDetailView extends BaseView implements CalendarDetailViewInterface {

	public CalendarDetailView(String navigationTitle) {
		super(navigationTitle);
		
		// ************ PANEL  TERMIN ***********
		Panel panelTermin = new Panel("Termin");
		panelTermin.setSizeUndefined();
		panelTermin.setWidth("400px");
		addComponent(panelTermin);
		
		// Panel Termin content
		FormLayout contentTermin = new FormLayout();
		contentTermin.addComponent(new Label("Arzt: Dr. Klaus Müller"));
		contentTermin.addComponent(new Label("Datum: 01. Januar 2016"));
		contentTermin.addComponent(new Label("Uhrzeit: 16:15 Uhr"));
		contentTermin.setMargin(true);
		panelTermin.setContent(contentTermin);

		// ******* PANEL ORT ********
		Panel panelOrt = new Panel("Ort");
		panelOrt.setSizeUndefined();
		panelOrt.setWidth("400px");
		addComponent(panelOrt);
		
		// Panel Ort content
		FormLayout contentOrt = new FormLayout();
		contentOrt.addComponent(new Label("Inselspital, 3. Stock, Zimmer 305A"));
		contentOrt.addComponent(new Label("Freiburgstrasse 8"));
		contentOrt.addComponent(new Label("3010 Bern"));
		
		contentOrt.setMargin(true);
		panelOrt.setContent(contentOrt);
		
		// ******* PANEL Notizen ********
		Panel panelNotizen = new Panel("Notizen");
		panelNotizen.setSizeUndefined();
		panelNotizen.setWidth("400px");
		addComponent(panelNotizen);
		
		// ********* PANEL Notizen Content **********
		FormLayout contentNotizen = new FormLayout();
		contentNotizen.addComponent(new Label("Notiz von Dr. Müller:"));
		contentNotizen.addComponent(new Label("Dosierung der Medikamente prüfen, blablablablababla"));
		
		contentNotizen.setMargin(true);
		panelNotizen.setContent(contentNotizen);
		
	}
}