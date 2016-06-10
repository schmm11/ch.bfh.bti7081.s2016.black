package main.java.ch.bfh.bti7081.s2016.black.BlackSED.view;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Calendar;

interface MedicamentsDetailViewInterface extends BaseViewInterface {
    public interface MedicamentsDetailViewListener extends BaseViewListener {
    	//TODO add here calendar related interface methods
    	//TODO in code cast needed to call method of subclass ((MedicamentsDetailViewListener)listener)
    }
}

@SuppressWarnings("serial")
public class MedicamentsDetailView extends BaseView implements MedicamentsDetailViewInterface {

	public MedicamentsDetailView(String navigationTitle) {
		super(navigationTitle);
		
		Calendar cal = new Calendar("My Calendar");
		cal.setWidth("700px");
		cal.setHeight("300px");
		addComponent(cal);
		setComponentAlignment(cal, Alignment. TOP_RIGHT);
	}
}
