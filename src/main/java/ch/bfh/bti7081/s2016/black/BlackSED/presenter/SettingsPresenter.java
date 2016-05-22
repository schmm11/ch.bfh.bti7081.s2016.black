package main.java.ch.bfh.bti7081.s2016.black.BlackSED.presenter;

import main.java.ch.bfh.bti7081.s2016.black.BlackSED.model.SettingsModel;
import main.java.ch.bfh.bti7081.s2016.black.BlackSED.view.SettingsView;

public class SettingsPresenter extends BasePresenter implements SettingsView.SettingsViewListener {
    
	public SettingsPresenter(SettingsModel model, SettingsView view, String presentingViewIdentifier) {
		super(model, view, presentingViewIdentifier);
	}
}
