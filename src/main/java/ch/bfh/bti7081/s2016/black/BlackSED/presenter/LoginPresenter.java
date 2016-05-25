package main.java.ch.bfh.bti7081.s2016.black.BlackSED.presenter;


import main.java.ch.bfh.bti7081.s2016.black.BlackSED.view.LoginView;


/** */
public final class LoginPresenter implements LoginView.LoginViewListener
{
	/** */
	public LoginPresenter()
	{
	}
	
	@Override
	public boolean loginAttempt(final String strUsername, final String strPassword)
	{
		return (strUsername.equalsIgnoreCase("user") && strPassword.equals("black"));
	}
}
