package main.java.ch.bfh.bti7081.s2016.black.BlackSED.view;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Page;
import com.vaadin.server.Page.Styles;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import main.java.ch.bfh.bti7081.s2016.black.BlackSED.model.entities.MainMenuEntry;

interface MainMenuViewInterface {
    public void addListener(MainMenuViewListener listener);
	public void presentView(View view, String identifier);
	public void initializeMenu(List<MainMenuEntry> mainMenuEntries);

    public interface MainMenuViewListener {
		void menuButtonClicked(MainMenuEntry mainMenuEntry);
    }
}

@SuppressWarnings("serial")
public class MainMenuView extends VerticalLayout implements View, MainMenuViewInterface {
	
	private List<MainMenuViewListener> listeners = new ArrayList<MainMenuViewListener>();
	
	public MainMenuView() {
		setSizeUndefined();	
		Label titleLabel = new Label("Health App");
		titleLabel.setWidth(150, Unit.POINTS);
		addComponent(titleLabel);
        setMargin(true);
        setSpacing(true);
    }

	@Override
	public void enter(ViewChangeEvent event) {
	}

	@Override
	public void addListener(MainMenuViewListener listener) {
		listeners.add(listener);
	}
	
	@Override
	public void presentView(View view, String identifier) {
		Navigator navigator = getUI().getNavigator();
		navigator.addView(identifier, view);
		navigator.navigateTo(identifier);
	}

	@Override
	public void initializeMenu(List<MainMenuEntry> mainMenuEntries) {
		for (MainMenuEntry mainMenuEntry : mainMenuEntries) {
	        Button button = new Button(mainMenuEntry.buttonTitle);
	        button.setData(mainMenuEntry.mainMenuType);
	        button.setWidth(150, Unit.POINTS);
	        button.setStyleName("foo");
	        //Page.getCurrent().getStyles().add("{ border-radius: 25px }");
	        
	        //Styles styles = Page.getCurrent().getStyles();
	        //styles.add(".v-button { background-color: red; }");
	        
	        button.addClickListener( e -> {
	        	for (MainMenuViewListener listener: this.listeners) {
	                listener.menuButtonClicked(mainMenuEntry);
	        	}
	        });

	        addComponent(button);
	        setComponentAlignment(button, Alignment.MIDDLE_CENTER);
		}
	}
}
