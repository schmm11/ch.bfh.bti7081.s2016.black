package main.java.ch.bfh.bti7081.s2016.black.BlackSED.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class EmergencyCardView extends VerticalLayout implements View {

	public EmergencyCardView() {
		setSizeFull();
		
		Label titleLabel = new Label("Notfallkarte");


        Button button = new Button("Go back to Main View");
        button.addClickListener( e -> {
        	getUI().getNavigator().navigateTo("main");
        });

        addComponents(titleLabel, button);
        setComponentAlignment(button, Alignment.MIDDLE_CENTER);
	}
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}
}
