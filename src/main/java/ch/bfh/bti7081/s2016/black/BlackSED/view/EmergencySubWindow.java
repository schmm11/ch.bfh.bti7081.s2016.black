package main.java.ch.bfh.bti7081.s2016.black.BlackSED.view;

import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;


@SuppressWarnings("serial")


public class EmergencySubWindow extends BaseView  {
	private Window window;
	public EmergencySubWindow(String title) {
		super(title);

        // Create a sub-window and set the content
        Window subWindow = new Window("");
        VerticalLayout subContent = new VerticalLayout();
        Label label = new Label(" .... Rufe Notfall an....");
        
        subContent.addComponent(label);
        subContent.setComponentAlignment(label, Alignment.MIDDLE_CENTER);
        
        subWindow.setContent(subContent);
    
        subWindow.setHeight("250px");
        subWindow.setWidth("400px");
        subWindow.center();
        this.window = subWindow;
	}

	protected void init(VaadinRequest request) {

        // Open it in the UI
        //addWindow(subWindow);
    }
	public Window getWindow(){
		return this.window;
	}
}