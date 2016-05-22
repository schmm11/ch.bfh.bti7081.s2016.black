package main.java.ch.bfh.bti7081.s2016.black.BlackSED.presenter;

import main.java.ch.bfh.bti7081.s2016.black.BlackSED.model.MedicamentsModel;
import main.java.ch.bfh.bti7081.s2016.black.BlackSED.view.MedicamentsView;

public class MedicamentsPresenter extends BasePresenter implements MedicamentsView.MedicamentsViewListener {
    
	public MedicamentsPresenter(MedicamentsModel model, MedicamentsView view, String presentingViewIdentifier) {
		super(model, view, presentingViewIdentifier);
	}
}
