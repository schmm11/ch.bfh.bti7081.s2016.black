package main.java.ch.bfh.bti7081.s2016.black.BlackSED.view;


import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

import com.vaadin.data.Validator.InvalidValueException;
import com.vaadin.event.FieldEvents.TextChangeListener;
import com.vaadin.event.ShortcutAction;
import com.vaadin.event.ShortcutListener;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.AbstractTextField;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import main.java.ch.bfh.bti7081.s2016.black.BlackSED.helper.NavigationHelper;
import main.java.ch.bfh.bti7081.s2016.black.BlackSED.helper.StringValidator;


/** */
interface LoginViewInterface
{
	/** */
	public interface LoginViewListener
	{
		public boolean loginAttempt(final String strUserName, final String strPassword);
	}

	/** */
	public void addListener(final LoginViewListener xListener);
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
    private final Set<LoginViewListener> k_setListeners = new HashSet<LoginViewListener>();

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
				getUI().getNavigator().navigateTo(NavigationHelper.MAINVIEW);
			}
		});

    	final Predicate<String> xPasswordPredicate = (strPassword) ->
    	{
    		return strPassword.length() >= 8 &&
    				strPassword.matches(".*\\d.*") &&
    				strPassword.matches(".*\\w.*") &&
    				strPassword.matches(".*[^\\w\\d\\s].*");
    	};

    	k_xTextField = new TextField();
    		k_xTextField.setCaption("Username");
    		k_xTextField.setRequired(true);
    		k_xTextField.setValidationVisible(true);
    		k_xTextField.addValidator(new StringValidator(str -> str.matches("[A-Za-z]+[A-Za-z0-9-_]*")));
    		k_xTextField.addTextChangeListener(validateOnChange(k_xTextField));
    		k_xTextField.addShortcutListener(doOnEnter(this::loginAttempt));

    	k_xPasswordField = new PasswordField();
    		k_xPasswordField.setCaption("Password");
    		k_xPasswordField.setRequired(true);
    		k_xPasswordField.addValidator(new StringValidator(xPasswordPredicate));
    		k_xPasswordField.setValidationVisible(true);
    		k_xPasswordField.addTextChangeListener(validateOnChange(k_xPasswordField));
    		k_xPasswordField.addShortcutListener(doOnEnter(this::loginAttempt));

    	k_xLoginButton = new Button();
    		k_xLoginButton.setCaption("Login");
    		k_xLoginButton.addClickListener(l -> loginAttempt());

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

    private void loginAttempt()
    {
    	final boolean bSuccess = k_setListeners.stream()
    		.map(l -> l.loginAttempt(k_xTextField.getValue(), k_xPasswordField.getValue()))
    		.allMatch(l -> l);
    	if(bSuccess)
    	{
    		getUI().getNavigator().navigateTo(NavigationHelper.MAINVIEW);
    	}
    }

	@Override
	public void enter(final ViewChangeEvent xEvent)
	{
		k_xTextField.focus();
	}

	@Override
	public void addListener(final LoginViewListener xListener)
	{
		if(xListener != null)
		{
			k_setListeners.add(xListener);
		}
		else
		{
			throw new IllegalArgumentException("xListener musn't be null");
		}
	}

	private static ShortcutListener doOnEnter(final Runnable xAction)
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

	private static TextChangeListener validateOnChange(final AbstractTextField xField)
	{
		return (xEvent) ->
		{
			try
			{
				xField.validate();
			}
			catch(final InvalidValueException xException)
			{
			}
		};
	}
}
