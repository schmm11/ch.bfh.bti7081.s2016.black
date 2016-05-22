package main.java.ch.bfh.bti7081.s2016.black.BlackSED.presenter;

import main.java.ch.bfh.bti7081.s2016.black.BlackSED.model.EmergencyModel;
import main.java.ch.bfh.bti7081.s2016.black.BlackSED.view.EmergencyView;

public class EmergencyPresenter extends BasePresenter implements EmergencyView.EmergencyViewListener {
    
	public EmergencyPresenter(EmergencyModel model, EmergencyView view, String presentingViewIdentifier) {
		super(model, view, presentingViewIdentifier);
	}
}