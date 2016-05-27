package main.java.ch.bfh.bti7081.s2016.black.BlackSED.view;

import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Label;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.Table;

interface MedicamentsViewInterface extends BaseViewInterface {
    public interface MedicamentsViewListener extends BaseViewListener {
    	//TODO add here medicaments related interface methods
    	//TODO in code cast needed to call method of subclass ((MedicamentsViewListener)listener)
    }
}

@SuppressWarnings("serial")
public class MedicamentsView extends BaseView implements MedicamentsViewInterface {

	public MedicamentsView(String navigationTitle) {
		super(navigationTitle);
		
		
		// **************** TABLE ***********************
		
				Table table = new Table("Medikamenten-Tabelle");
				
				table.addContainerProperty("Name", String.class, null);
				table.addContainerProperty("Datum", String.class, null);
				table.addContainerProperty("Beschreibung", String.class, null);
				
				// Beispiele
				table.addItem(new Object[]{"Prescrption 1", "01.01.2016", "Schnupfen"}, 1);
				table.addItem(new Object[]{"Prescrption 2", "13.02.2016", "Grippe"}, 2);
				table.addItem(new Object[]{"Prescrption 3", "05.04.2016", "Aids Krebs"}, 3);
				
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
		
		/*
		// List
				// Create the selection component
				ListSelect mediList = new ListSelect("Behandlungen");
				mediList.addItems("The Schnupfen", "The Grippe", "The Aidskrebs");
				mediList.setNullSelectionAllowed(false);
				mediList.setRows(5);
				addComponent(mediList);
				
				
				setComponentAlignment(mediList, Alignment.TOP_CENTER);
				
				mediList.containerPropertySetChange(event);
		*/
	}
}