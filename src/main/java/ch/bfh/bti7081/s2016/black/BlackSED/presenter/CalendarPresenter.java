package main.java.ch.bfh.bti7081.s2016.black.BlackSED.presenter;

import main.java.ch.bfh.bti7081.s2016.black.BlackSED.model.CalendarModel;
import main.java.ch.bfh.bti7081.s2016.black.BlackSED.view.CalendarView;

public class CalendarPresenter extends BasePresenter implements CalendarView.CalendarViewListener {
    
	public CalendarPresenter(CalendarModel model, CalendarView view, String presentingViewIdentifier) {
		super(model, view, presentingViewIdentifier);
	}
}