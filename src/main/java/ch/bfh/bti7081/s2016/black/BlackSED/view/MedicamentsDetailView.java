package main.java.ch.bfh.bti7081.s2016.black.BlackSED.view;

interface MedicamentsDetailViewInterface extends BaseViewInterface {
    public interface MedicamentsDetailViewListener extends BaseViewListener {
    	//TODO add here calendar related interface methods
    	//TODO in code cast needed to call method of subclass ((MedicamentsDetailViewListener)listener)
    }
}

@SuppressWarnings("serial")
public class MedicamentsDetailView extends BaseView implements MedicamentsDetailViewInterface {

	public MedicamentsDetailView(String navigationTitle) {
		super(navigationTitle);
	}
}
