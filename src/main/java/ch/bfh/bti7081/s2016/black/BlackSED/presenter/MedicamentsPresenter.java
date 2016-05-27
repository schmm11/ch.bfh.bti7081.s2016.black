package main.java.ch.bfh.bti7081.s2016.black.BlackSED.presenter;

import main.java.ch.bfh.bti7081.s2016.black.BlackSED.helper.NavigationHelper;
import main.java.ch.bfh.bti7081.s2016.black.BlackSED.model.MedicamentsDetailModel;
import main.java.ch.bfh.bti7081.s2016.black.BlackSED.model.MedicamentsModel;
import main.java.ch.bfh.bti7081.s2016.black.BlackSED.view.MedicamentsDetailView;
import main.java.ch.bfh.bti7081.s2016.black.BlackSED.view.MedicamentsView;

public class MedicamentsPresenter extends BasePresenter implements MedicamentsView.MedicamentsViewListener {
    
	public MedicamentsPresenter(MedicamentsModel model, MedicamentsView view, String presentingViewIdentifier) {
		super(model, view, presentingViewIdentifier);
	}

	@Override
	public void detailButtonClicked(int id) {
        //create model and Vaadin view implementation
        MedicamentsDetailModel medicamentsDetailModel = new MedicamentsDetailModel();
        MedicamentsDetailView medicamentsDetailView  = new MedicamentsDetailView("Medicaments Detail View");
      
        //the presenter binds the model and view together
        MedicamentsDetailPresenter medicamentsDetailPresenter = new MedicamentsDetailPresenter(medicamentsDetailModel, medicamentsDetailView, NavigationHelper.MEDICAMENTSVIEW);
        
        //add presenter as listener of view
        medicamentsDetailView.addListener(medicamentsDetailPresenter);
        
        //present calendar view
        ((MedicamentsView)this.view).presentView(medicamentsDetailView, NavigationHelper.MEDICAMENTSDETAILVIEW);
	}
}
