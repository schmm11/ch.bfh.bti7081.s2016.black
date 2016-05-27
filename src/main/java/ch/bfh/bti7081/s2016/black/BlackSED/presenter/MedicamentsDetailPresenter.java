package main.java.ch.bfh.bti7081.s2016.black.BlackSED.presenter;

import main.java.ch.bfh.bti7081.s2016.black.BlackSED.model.BaseModel;
import main.java.ch.bfh.bti7081.s2016.black.BlackSED.view.BaseView;
import main.java.ch.bfh.bti7081.s2016.black.BlackSED.view.MedicamentsDetailView;

public class MedicamentsDetailPresenter extends BasePresenter implements MedicamentsDetailView.MedicamentsDetailViewListener {

	MedicamentsDetailPresenter(BaseModel model, BaseView view, String presentingViewIdentifier) {
		super(model, view, presentingViewIdentifier);
	}
}