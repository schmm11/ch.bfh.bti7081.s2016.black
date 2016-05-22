package main.java.ch.bfh.bti7081.s2016.black.BlackSED.view;

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
	}
}