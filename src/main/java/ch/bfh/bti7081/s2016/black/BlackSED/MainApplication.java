package main.java.ch.bfh.bti7081.s2016.black.BlackSED;

import java.util.List;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

import main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.MysqlAdapter;
import main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.entities.Person;
import main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.model.PersonModel;
import main.java.ch.bfh.bti7081.s2016.black.BlackSED.helper.NavigationHelper;
import main.java.ch.bfh.bti7081.s2016.black.BlackSED.model.LoginModel;
import main.java.ch.bfh.bti7081.s2016.black.BlackSED.model.MainMenuModel;
import main.java.ch.bfh.bti7081.s2016.black.BlackSED.presenter.LoginPresenter;
import main.java.ch.bfh.bti7081.s2016.black.BlackSED.presenter.MainMenuPresenter;
import main.java.ch.bfh.bti7081.s2016.black.BlackSED.view.LoginView;
import main.java.ch.bfh.bti7081.s2016.black.BlackSED.view.MainMenuView;

/**
 * This UI is the application entry point. A UI may either represent a browser window
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
@Widgetset("ch.bfh.bti7081.s2016.black.BlackSED.MyAppWidgetset")
@SuppressWarnings("serial")
public class MainApplication extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
    	MysqlAdapter mysql = null;
    	try {
    		mysql = new MysqlAdapter();
    		mysql.query("show tables;");
    	}
    	catch (Exception e) {
    		System.out.println(e.getMessage());
    	}

    	// set title of page
        getPage().setTitle("Health App Team Black");

        //create a navigator to control the views (will be used for all navigation within the app)
        Navigator navigator = new Navigator(this, this);
        navigator.addViewChangeListener(new ViewChangeListener()
		{
			@Override
			public boolean beforeViewChange(final ViewChangeEvent xEvent)
			{
				final boolean bLoggedIn = (getSession().getAttribute("username") != null);
				if(!xEvent.getViewName().equals(NavigationHelper.LOGINVIEW) && !bLoggedIn)
				{
					xEvent.getNavigator().navigateTo(NavigationHelper.LOGINVIEW);
					return false;
				}
				else
				{
					return true;
				}
			}

			@Override
			public void afterViewChange(ViewChangeEvent event)
			{
			}
		});

        //create model and Vaadin view implementation
        MainMenuModel model = new MainMenuModel();
        MainMenuView view  = new MainMenuView();

        //the presenter binds the model and view together
        MainMenuPresenter presenter = new MainMenuPresenter(model, view);

        //add presenter as listener of view
        view.addListener(presenter);

        //add view to Vaadin navigation stack
        navigator.addView(NavigationHelper.MAINVIEW, view);

        final PersonModel xPersonModel = new PersonModel(mysql);
        final List<Person> lstPeople = xPersonModel.fetchAll();

        final LoginView xLoginView = new LoginView();
        final LoginModel xLoginModel = new LoginModel(lstPeople);
        new LoginPresenter(xLoginView, xLoginModel);
        navigator.addView(NavigationHelper.LOGINVIEW, xLoginView);

        //present main menu
        navigator.navigateTo(NavigationHelper.MAINVIEW);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MainApplication.class, productionMode = false)
    public static class MainApplicationUIServlet extends VaadinServlet {
    }
}
