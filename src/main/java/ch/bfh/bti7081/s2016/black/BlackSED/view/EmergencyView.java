package main.java.ch.bfh.bti7081.s2016.black.BlackSED.view;

import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

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
		
Label notfall = new Label(
	"<h1> Im Falle eines Falles</h1>"+
    "<b>First: Stay calm</B>" +
    "<ul>"+
    "  <li>Atmen Sie ruhig</li>"+
    "  <li>itemized lists</li>"+
    "  <li>etc.</li>"+
    "</ul> "+
    "Bla Bla Bla.<br><br>"+
    "<audio controls><source src=\"https://www.angst-panik-hilfe.de/angst-notruf.mp3\" type=\"audio/ogg\"> <source src=\"horse.mp3\" type=\"audio/mpeg\">  Your browser does not support the audio element.  </audio>"
    
    
    ,
    ContentMode.HTML);
	content.addComponents(notfall);
	
	
// MusikPlayer
	
	
		content.setSizeUndefined();
		this.addComponentAsFirst(content);
		this.setComponentAlignment(content, Alignment.MIDDLE_CENTER);
		
	}
}