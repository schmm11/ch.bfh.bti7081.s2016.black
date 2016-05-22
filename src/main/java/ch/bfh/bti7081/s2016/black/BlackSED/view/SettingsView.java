package main.java.ch.bfh.bti7081.s2016.black.BlackSED.view;

interface SettingsViewInterface extends BaseViewInterface {
    public interface SettingsViewListener extends BaseViewListener {
    	//TODO add here settings related interface methods
    	//TODO in code cast needed to call method of subclass ((SettingsViewListener)listener)
    }
}

@SuppressWarnings("serial")
public class SettingsView extends BaseView implements SettingsViewInterface {

	public SettingsView(String navigationTitle) {
		super(navigationTitle);
	}
}