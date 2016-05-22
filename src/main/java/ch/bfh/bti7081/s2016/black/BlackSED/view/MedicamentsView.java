package main.java.ch.bfh.bti7081.s2016.black.BlackSED.view;

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
	}
}