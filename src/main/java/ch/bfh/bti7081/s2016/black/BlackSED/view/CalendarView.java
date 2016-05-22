package main.java.ch.bfh.bti7081.s2016.black.BlackSED.view;

interface CalendarViewInterface extends BaseViewInterface {
    public interface CalendarViewListener extends BaseViewListener {
    	//TODO add here calendar related interface methods
    	//TODO in code cast needed to call method of subclass ((CalendarViewListener)listener)
    }
}

@SuppressWarnings("serial")
public class CalendarView extends BaseView implements CalendarViewInterface {

	public CalendarView(String navigationTitle) {
		super(navigationTitle);
	}
}