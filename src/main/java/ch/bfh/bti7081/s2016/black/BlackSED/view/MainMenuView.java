package main.java.ch.bfh.bti7081.s2016.black.BlackSED.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class MainMenuView extends VerticalLayout implements View {
	
	public MainMenuView() {
		setSizeFull();
		
		Label titleLabel = new Label("Health App");
                
        Button menuButton1 = new Button("Kalender");
        menuButton1.addClickListener( e -> {
        	getUI().getNavigator().navigateTo("calendar");
        });
        
        Button menuButton2 = new Button("Medikamente");
        menuButton2.addClickListener( e -> {
        	getUI().getNavigator().navigateTo("medicaments");
        });
        
        Button menuButton3 = new Button("Notfallkarte");
        menuButton3.addClickListener( e -> {
        	getUI().getNavigator().navigateTo("emergency");
        });
        
        Button menuButton4 = new Button("Einstellungen");
        menuButton4.addClickListener( e -> {
        	getUI().getNavigator().navigateTo("settings");
        });

        addComponents(titleLabel, menuButton1, menuButton2, menuButton3, menuButton4);
        setComponentAlignment(menuButton1, Alignment.MIDDLE_CENTER);
        setComponentAlignment(menuButton2, Alignment.MIDDLE_CENTER);
        setComponentAlignment(menuButton3, Alignment.MIDDLE_CENTER);
        setComponentAlignment(menuButton4, Alignment.MIDDLE_CENTER);
        setMargin(true);
        setSpacing(true);
    }

	@Override
	public void enter(ViewChangeEvent event) {

	}
}
