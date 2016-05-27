package main.java.ch.bfh.bti7081.s2016.black.BlackSED.view;

import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.navigator.Navigator;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;

interface MedicamentsViewInterface extends BaseViewInterface {
    public interface MedicamentsViewListener extends BaseViewListener {

		void detailButtonClicked(int is);
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
				table.addContainerProperty("Mehr", Button.class, null);
				
				//TODO create buttons dynamically later on
		        Button button1 = new Button("-->");
		        button1.addClickListener( e -> {
		        	for (BaseViewListener listener: this.listeners) {
		        		((MedicamentsViewListener)listener).detailButtonClicked(1);
		        	}
		        });
				
				//TODO create buttons dynamically later on
		        Button button2 = new Button("-->");
		        button2.addClickListener( e -> {
		        	for (BaseViewListener listener: this.listeners) {
		        		((MedicamentsViewListener)listener).detailButtonClicked(2);
		        	}
		        });
				   
				//TODO create buttons dynamically later on
		        Button button3 = new Button("-->");
		        button3.addClickListener( e -> {
		        	for (BaseViewListener listener: this.listeners) {
		        		((MedicamentsViewListener)listener).detailButtonClicked(3);
		        	}
		        });
		        
				// Beispiele
				table.addItem(new Object[]{"Prescrption 1", "01.01.2016", "Schnupfen", button1}, 1);
				table.addItem(new Object[]{"Prescrption 2", "13.02.2016", "Grippe", button2}, 2);
				table.addItem(new Object[]{"Prescrption 3", "05.04.2016", "Aids Krebs", button3}, 3);
				
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

	public void presentView(MedicamentsDetailView view, String identifier) {
		Navigator navigator = getUI().getNavigator();
		navigator.addView(identifier, view);
		navigator.navigateTo(identifier);
	}
}