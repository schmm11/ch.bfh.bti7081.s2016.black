package main.java.ch.bfh.bti7081.s2016.black.BlackSED.view;

import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

import main.java.ch.bfh.bti7081.s2016.black.BlackSED.view.BaseViewInterface.BaseViewListener;

interface EmergencyViewInterface extends BaseViewInterface {
    public interface EmergencyViewListener extends BaseViewListener {
    	//TODO add here emergency related interface methods
    	//TODO in code cast needed to call method of subclass ((EmergencyViewListener)listener)
    }
}

@SuppressWarnings("serial")
public class EmergencyView extends BaseView implements EmergencyViewInterface {

	public EmergencyView(String navigationTitle) {
		super(navigationTitle);

		VerticalLayout content = new VerticalLayout();
		
		//Notfall Button
        Button notButton = new Button("NOTFALL ANRUF");
        
        notButton.addClickListener( e -> {
        this.showNotButton();
        	
        	
        	
        });
		
		
		
		// NOTFall Text
		
Label notfall = new Label(
	"<h1> Im Falle eines Falles</h1>"+
    "<b>First: Stay calm</B>" +
    "<ul>"+
    "  <li>Atmen Sie ruhig</li>"+
    "  <li>Hocken Sie sich hin</li>"+
    "  <li>Es wird Ihnen nichts passieren</li>"+
    "</ul> "+
    " Befolgen Sie die Audioanweisungen </br></br>"+
    "<audio controls><source src=\"https://www.angst-panik-hilfe.de/angst-notruf.mp3\" type=\"audio/ogg\"> <source src=\"horse.mp3\" type=\"audio/mpeg\">  Your browser does not support the audio element.  </audio>"+
    "<br> <font size=\"2\"> &copy; Dr. Rolf Merkle, Thanks alot"
    ,
    ContentMode.HTML);
	content.addComponents(notfall);
	content.addComponent(notButton);
	content.setSizeUndefined();
	this.addComponentAsFirst(content);
	this.setComponentAlignment(content, Alignment.MIDDLE_CENTER);
		
	}
	private void showNotButton(){

		EmergencySubWindow window = new EmergencySubWindow("Emer");
		this.getUI().addWindow(window.getWindow());
		
	}
	
	
}