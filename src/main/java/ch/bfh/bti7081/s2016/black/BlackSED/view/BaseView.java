package main.java.ch.bfh.bti7081.s2016.black.BlackSED.view;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

interface BaseViewInterface  {
    public void addListener(BaseViewListener listener);
	public void navigateBackWithIdentifier(String presentingViewIdentifier);
	
    public interface BaseViewListener {
        void backButtonClicked();
    } 
}

@SuppressWarnings("serial")
public class BaseView extends VerticalLayout implements View, BaseViewInterface {

	protected List<BaseViewListener> listeners = new ArrayList<BaseViewListener>();

	public BaseView(String title) {
		setSizeUndefined();
		
		
		
		Label titleLabel = new Label(title);	
		
        Button button = new Button("Zurück");
        button.addClickListener( e -> {
        	for (BaseViewListener listener: this.listeners) {
        		listener.backButtonClicked();
        	}
        });
        
        HorizontalLayout header = new HorizontalLayout();
        header.setSizeFull();
        header.addComponent(button);
        header.addComponent(titleLabel);
        header.setComponentAlignment(titleLabel, Alignment.MIDDLE_RIGHT);
        
        addComponent(header);
        //addComponent(titleLabel);
        //setComponentAlignment(titleLabel, Alignment.TOP_RIGHT);
        //setComponentAlignment(button, Alignment.TOP_LEFT);	
        	
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void addListener(BaseViewListener listener) {
		listeners.add(listener);
	}

	@Override
	public void navigateBackWithIdentifier(String presentingViewIdentifier) {
		getUI().getNavigator().navigateTo(presentingViewIdentifier);
	}
}
