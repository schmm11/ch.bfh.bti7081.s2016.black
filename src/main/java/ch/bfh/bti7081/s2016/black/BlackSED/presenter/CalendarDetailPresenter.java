package main.java.ch.bfh.bti7081.s2016.black.BlackSED.presenter;

import main.java.ch.bfh.bti7081.s2016.black.BlackSED.model.BaseModel;
import main.java.ch.bfh.bti7081.s2016.black.BlackSED.view.BaseView;
import main.java.ch.bfh.bti7081.s2016.black.BlackSED.view.CalendarDetailView;

public class CalendarDetailPresenter extends BasePresenter implements CalendarDetailView.CalendarDetailViewListener {

	CalendarDetailPresenter(BaseModel model, BaseView view, String presentingViewIdentifier) {
		super(model, view, presentingViewIdentifier);
	}
}