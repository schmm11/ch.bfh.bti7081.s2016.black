package main.java.ch.bfh.bti7081.s2016.black.BlackSED.view;


import java.util.ArrayList;
import java.util.List;

import com.vaadin.data.validator.RegexpValidator;
import com.vaadin.event.ShortcutAction;
import com.vaadin.event.ShortcutListener;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import main.java.ch.bfh.bti7081.s2016.black.BlackSED.helper.NavigationHelper;


/** */
interface LoginViewInterface
{
	/** */
	public interface LoginListener
	{
		public void loginAttempt(final String strUserName, final String strPassword);
	}

	/** */
	public void addLoginListener(final LoginListener xListener);
}


/** */
@SuppressWarnings("serial")
public final class LoginView extends VerticalLayout implements View, LoginViewInterface
{
    /** */
    private final TextField k_xTextField;

    /** */
    private final PasswordField k_xPasswordField;

    /** */
    private final Button k_xLoginButton;

    /** */
    private final List<LoginListener> k_lstListeners = new ArrayList<LoginListener>();

    /** */
    public LoginView()
    {
    	// temporary hack for login without authentication
    	// Use 'ALT + ENTER' to bypass authentication
    	addShortcutListener(new ShortcutListener("backdoor", ShortcutAction.KeyCode.ENTER, new int[] { ShortcutAction.ModifierKey.ALT })
		{
			@Override
			public void handleAction(Object sender, Object target)
			{
				getSession().setAttribute("username", "user");
				getUI().getNavigator().navigateTo(NavigationHelper.MAINVIEW);
			}
		});

    	k_xTextField = new TextField();
    		k_xTextField.setCaption("Username");
    		k_xTextField.addValidator(new RegexpValidator("[A-Za-z]+[\\w-]*", "Name must start with a letter and contain letters, digits, - or _"));
    		k_xTextField.setImmediate(true);
    		k_xTextField.setRequired(true);
    		k_xTextField.addShortcutListener(loginOnEnter(this::loginAttempt));

    	k_xPasswordField = new PasswordField();
    		k_xPasswordField.setCaption("Password");
    		// remove validations our current password does not respect
//    		k_xPasswordField.addValidator(new StringLengthValidator("Password is too short", 8, null, false));
    		k_xPasswordField.addValidator(new RegexpValidator(".*[A-Za-z].*", "Password must contain a letter"));
//    		k_xPasswordField.addValidator(new RegexpValidator(".*[0-9].*", "Password must contain a digit"));
    		k_xPasswordField.addValidator(new RegexpValidator("[A-Za-z0-9]+", "Password must only contain digits and letters"));
    		k_xPasswordField.setImmediate(true);
    		k_xPasswordField.setRequired(true);
    		k_xPasswordField.addShortcutListener(loginOnEnter(this::loginAttempt));

    	k_xLoginButton = new Button();
    		k_xLoginButton.setCaption("Login");
    		k_xLoginButton.addClickListener(xButton -> loginAttempt());

    	final FormLayout xLayout = new FormLayout();
    		xLayout.setSizeUndefined();
    		xLayout.setMargin(true);
    		xLayout.setSpacing(true);
    		xLayout.addComponents(
    				k_xTextField,
    				k_xPasswordField,
    				k_xLoginButton);

		setSizeFull();
    	addComponent(xLayout);
    	setComponentAlignment(xLayout, Alignment.MIDDLE_CENTER);
    }

    /** */
    private void loginAttempt()
    {
    	final String strUsername = k_xTextField.getValue();
    	final String strPassword = k_xPasswordField.getValue();

    	k_lstListeners.forEach(xListener -> xListener.loginAttempt(strUsername, strPassword));
    }

    /** */
    public void loginSuccess(final String strUsername)
    {
    	getSession().setAttribute("username", strUsername);
    	getUI().getNavigator().navigateTo(NavigationHelper.MAINVIEW);
    }

    /** */
    public void loginFailed()
    {
    	Notification.show("Invalid username or password", Type.HUMANIZED_MESSAGE);
    }

	@Override
	public void enter(final ViewChangeEvent xEvent)
	{
		k_xTextField.focus();
		k_xTextField.setValue("");
		k_xPasswordField.setValue("");
	}

	@Override
	public void addLoginListener(final LoginListener xListener)
	{
		if(xListener == null) throw new IllegalArgumentException("xListener must not be null");
		k_lstListeners.add(xListener);
	}

	/** */
	private static ShortcutListener loginOnEnter(final Runnable xAction)
	{
		return new ShortcutListener("enter", ShortcutAction.KeyCode.ENTER, null)
		{
			@Override
			public void handleAction(final Object xSender, final Object xTarget)
			{
				xAction.run();
			}
		};
	}
}
