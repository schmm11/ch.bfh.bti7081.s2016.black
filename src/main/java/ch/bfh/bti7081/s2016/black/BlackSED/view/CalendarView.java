package main.java.ch.bfh.bti7081.s2016.black.BlackSED.view;

import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;

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
		
		
		// **************** TABLE ***********************
		Table table = new Table("Termin-Tabelle");
		
		table.addContainerProperty("ID", Integer.class, null);
		table.addContainerProperty("Datum", String.class, null);
		table.addContainerProperty("Arzt", String.class, null);
		table.addContainerProperty("Beschreibung", String.class, null);
		
		// Beispiele
		table.addItem(new Object[]{1, "01.01.2016", "Doktor Müller", "Erste Besprechung"}, 1);
		table.addItem(new Object[]{2, "13.02.2016", "Doktor Müller", "Zweite Besprechung"}, 2);
		table.addItem(new Object[]{3, "05.04.2016", "Doktor Moser", "Dritte Besprechung"}, 3);
		
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

		addComponent(table);
		addComponent(current);
		setComponentAlignment(current, Alignment.MIDDLE_CENTER);
		setComponentAlignment(table, Alignment.TOP_CENTER);
		// **************** END OF TABLE ***************
	}
	
}