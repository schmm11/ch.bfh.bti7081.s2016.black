package main.java.ch.bfh.bti7081.s2016.black.BlackSED.presenter;


import main.java.ch.bfh.bti7081.s2016.black.BlackSED.model.LoginModel;
import main.java.ch.bfh.bti7081.s2016.black.BlackSED.view.LoginView;


/** */
public final class LoginPresenter implements LoginView.LoginListener
{
	private final LoginView k_xView;
	private final LoginModel k_xModel;

	/** */
	public LoginPresenter(final LoginView xView, final LoginModel xModel)
	{
		k_xView = xView;
		xView.addLoginListener(this);
		k_xModel = xModel;
	}

	@Override
	public void loginAttempt(final String strUsername, final String strPassword)
	{
		if(k_xModel.loginAttempt(strUsername, strPassword))
		{
			// login successful
			k_xView.loginSuccess(strUsername);
		}
		else
		{
			// login failed
			k_xView.loginFailed();
		}
	}
}
