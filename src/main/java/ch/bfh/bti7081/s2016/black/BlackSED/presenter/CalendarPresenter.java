package main.java.ch.bfh.bti7081.s2016.black.BlackSED.presenter;

import main.java.ch.bfh.bti7081.s2016.black.BlackSED.helper.NavigationHelper;
import main.java.ch.bfh.bti7081.s2016.black.BlackSED.model.CalendarDetailModel;
import main.java.ch.bfh.bti7081.s2016.black.BlackSED.model.CalendarModel;
import main.java.ch.bfh.bti7081.s2016.black.BlackSED.view.CalendarDetailView;
import main.java.ch.bfh.bti7081.s2016.black.BlackSED.view.CalendarView;

public class CalendarPresenter extends BasePresenter implements CalendarView.CalendarViewListener {
    
	public CalendarPresenter(CalendarModel model, CalendarView view, String presentingViewIdentifier) {
		super(model, view, presentingViewIdentifier);
	}

	@Override
	public void detailButtonClicked(int id) {
        //create model and Vaadin view implementation
        CalendarDetailModel calendarDetailModel = new CalendarDetailModel();
        CalendarDetailView calendarDetailView  = new CalendarDetailView("Calendar Detail View");
      
        //the presenter binds the model and view together
        CalendarDetailPresenter calendarDetailPresenter = new CalendarDetailPresenter(calendarDetailModel, calendarDetailView, NavigationHelper.CALENDARVIEW);
        
        //add presenter as listener of view
        calendarDetailView.addListener(calendarDetailPresenter);
        
        //present calendar view
        ((CalendarView)this.view).presentView(calendarDetailView, NavigationHelper.CALENDARDETAILVIEW);
	}
}