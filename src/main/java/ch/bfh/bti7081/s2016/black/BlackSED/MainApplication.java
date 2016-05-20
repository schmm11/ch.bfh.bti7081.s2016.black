package main.java.ch.bfh.bti7081.s2016.black.BlackSED;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import main.java.ch.bfh.bti7081.s2016.black.BlackSED.helper.NavigationHelper;
import main.java.ch.bfh.bti7081.s2016.black.BlackSED.view.CalendarView;
import main.java.ch.bfh.bti7081.s2016.black.BlackSED.view.EmergencyCardView;
import main.java.ch.bfh.bti7081.s2016.black.BlackSED.view.MainMenuView;
import main.java.ch.bfh.bti7081.s2016.black.BlackSED.view.MedicamentView;
import main.java.ch.bfh.bti7081.s2016.black.BlackSED.view.SettingsView;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
@Widgetset("ch.bfh.bti7081.s2016.black.BlackSED.MyAppWidgetset")
public class MainApplication extends UI {

	Navigator navigator;
    
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        getPage().setTitle("Health App Team Black");
        
        // Create a navigator to control the views
        navigator = new Navigator(this, this);
        
        // Create and register the views
        navigator.addView(NavigationHelper.MAINVIEW, new MainMenuView());
        navigator.addView(NavigationHelper.CALENDARVIEW, new CalendarView());
        navigator.addView(NavigationHelper.MEDICAMENTSVIEW, new MedicamentView());
        navigator.addView(NavigationHelper.EMERGENCYCARDVIEW, new EmergencyCardView());
        navigator.addView(NavigationHelper.SETTINGSVIEW, new SettingsView());
        
        navigator.navigateTo("main");
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MainApplication.class, productionMode = false)
    public static class MainApplicationUIServlet extends VaadinServlet {
    }
}
