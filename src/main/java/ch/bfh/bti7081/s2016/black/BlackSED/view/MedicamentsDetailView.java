package main.java.ch.bfh.bti7081.s2016.black.BlackSED.view;

import java.util.GregorianCalendar;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Calendar;
import com.vaadin.ui.components.calendar.event.BasicEvent;

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
		
		Calendar calendar = new Calendar();
		calendar.setWidth("700px");
		calendar.setHeight("700px");
		
		for (int i = 0; i < 30; i++) {
			GregorianCalendar start = new GregorianCalendar(2016,5,5,10,00);
			GregorianCalendar end   = new GregorianCalendar(2016,5,5,10,00);
			start.add(java.util.Calendar.HOUR, 24*i);
			end.add(java.util.Calendar.HOUR, 24*i + 2);
			calendar.addEvent(new BasicEvent("Rote Pille", "", start.getTime(), end.getTime()));
			
			if (i % 2 == 0) {
				start.add(java.util.Calendar.HOUR, 6);
				end.add(java.util.Calendar.HOUR, 6);	
				calendar.addEvent(new BasicEvent("Blaue Pille", "", start.getTime(), end.getTime()));	
			}
		}

		addComponent(calendar);
		setComponentAlignment(calendar, Alignment. TOP_RIGHT);
	}
}