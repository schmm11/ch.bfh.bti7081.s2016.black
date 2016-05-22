package main.java.ch.bfh.bti7081.s2016.black.BlackSED.presenter;

import main.java.ch.bfh.bti7081.s2016.black.BlackSED.model.BaseModel;
import main.java.ch.bfh.bti7081.s2016.black.BlackSED.view.BaseView;

public class BasePresenter implements BaseView.BaseViewListener {
    protected BaseModel model;
    protected BaseView view;
    protected String presentingViewIdentifier; //holds the identifier which presents the current view. being used for back navigation.

    BasePresenter(BaseModel model, BaseView view, String presentingViewIdentifier) {
    	this.model = model;
    	this.view = view;
    	this.presentingViewIdentifier = presentingViewIdentifier;
    }

	@Override
	public void backButtonClicked() {
		this.view.navigateBackWithIdentifier(this.presentingViewIdentifier);
	}
}