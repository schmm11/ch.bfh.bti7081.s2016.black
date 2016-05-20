package main.java.ch.bfh.bti7081.s2016.black.BlackSED.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import main.java.ch.bfh.bti7081.s2016.black.BlackSED.helper.NavigationHelper;

public class CalendarView extends VerticalLayout implements View {

	public CalendarView() {
		setSizeFull();
		
		Label titleLabel = new Label("Kalender");

        Button button = new Button("Go back to Main View");
        button.addClickListener( e -> {
        	getUI().getNavigator().navigateTo(NavigationHelper.MAINVIEW);
        });

        addComponents(titleLabel, button);
        setComponentAlignment(button, Alignment.MIDDLE_CENTER);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}
}
