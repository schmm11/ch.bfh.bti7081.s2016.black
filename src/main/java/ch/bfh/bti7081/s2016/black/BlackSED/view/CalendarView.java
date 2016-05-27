package main.java.ch.bfh.bti7081.s2016.black.BlackSED.view;

import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.navigator.Navigator;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Calendar;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;

interface CalendarViewInterface extends BaseViewInterface {
    public interface CalendarViewListener extends BaseViewListener {

		void detailButtonClicked(int id);
    	//TODO add here calendar related interface methods
    	//TODO in code cast needed to call method of subclass ((CalendarViewListener)listener)
    }
}

@SuppressWarnings("serial")
public class CalendarView extends BaseView implements CalendarViewInterface {

	public CalendarView(String navigationTitle) {
		super(navigationTitle);
		
		
		// **************** TABLE ***********************
		Table table = new Table("Termin-Tabelle");
		
		table.addContainerProperty("ID", Integer.class, null);
		table.addContainerProperty("Datum", String.class, null);
		table.addContainerProperty("Arzt", String.class, null);
		table.addContainerProperty("Beschreibung", String.class, null);
		table.addContainerProperty("Mehr", Button.class, null);
		
		//TODO create buttons dynamically later on
        Button button1 = new Button("-->");
        button1.addClickListener( e -> {
        	for (BaseViewListener listener: this.listeners) {
        		((CalendarViewListener)listener).detailButtonClicked(1);
        	}
        });
		
		//TODO create buttons dynamically later on
        Button button2 = new Button("-->");
        button2.addClickListener( e -> {
        	for (BaseViewListener listener: this.listeners) {
        		((CalendarViewListener)listener).detailButtonClicked(2);
        	}
        });
		   
		//TODO create buttons dynamically later on
        Button button3 = new Button("-->");
        button3.addClickListener( e -> {
        	for (BaseViewListener listener: this.listeners) {
        		((CalendarViewListener)listener).detailButtonClicked(3);
        	}
        });
		    
		// Beispiele
		table.addItem(new Object[]{1, "01.01.2016", "Doktor Müller", "Erste Besprechung", button1}, 1);
		table.addItem(new Object[]{2, "13.02.2016", "Doktor Müller", "Zweite Besprechung", button2}, 2);
		table.addItem(new Object[]{3, "05.04.2016", "Doktor Moser", "Dritte Besprechung", button3}, 3);
		
		table.setSelectable(true);
		table.setImmediate(true);
		
		final Label current = new Label("Selected: -");
		
		table.addValueChangeListener(new Property.ValueChangeListener() {
			
			@Override
			public void valueChange(ValueChangeEvent event) {
				// TODO Auto-generated method stub
				current.setValue("Selected: " + table.getValue());
			}
		});

		table.setPageLength(table.size());
		
		
		// ************************ CALENDAR *******************************//
		Calendar cal = new Calendar("My Calendar");
		cal.setWidth("600px");
		cal.setHeight("300px");
		
		
		
		// ************************ END CALENDAR *******************************//
		
		addComponent(table);
		//addComponent(current);
		addComponent(cal);
		setComponentAlignment(cal, Alignment. TOP_RIGHT);
		//setComponentAlignment(current, Alignment.MIDDLE_CENTER);
		setComponentAlignment(table, Alignment.TOP_LEFT);
		//setComponentAlignment(table, Alignment. MIDDLE_RIGHT);
		// **************** END OF TABLE ***************
	}

	public void presentView(CalendarDetailView view, String identifier) {
		Navigator navigator = getUI().getNavigator();
		navigator.addView(identifier, view);
		navigator.navigateTo(identifier);		
	}
	
}