package main.java.ch.bfh.bti7081.s2016.black.BlackSED.view;

interface CalendarDetailViewInterface extends BaseViewInterface {
    public interface CalendarDetailViewListener extends BaseViewListener {
    	//TODO add here calendar related interface methods
    	//TODO in code cast needed to call method of subclass ((CalendarDetailViewListener)listener)
    }
}

@SuppressWarnings("serial")
public class CalendarDetailView extends BaseView implements CalendarDetailViewInterface {

	public CalendarDetailView(String navigationTitle) {
		super(navigationTitle);
	}
}