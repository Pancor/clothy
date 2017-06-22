package pancor.pl.clothy.cloth_creator;

import javax.inject.Inject;

import pancor.pl.clothy.base.ActivityScope;
import pancor.pl.clothy.data.ClothDataManager;

@ActivityScope
public class ClothCreatorPresenter implements ClothCreator.Presenter {

    private ClothCreator.View view;
    private ClothDataManager clothDataManager;

    @Inject
    public ClothCreatorPresenter(ClothCreator.View view, ClothDataManager clothDataManager){
        this.view = view;
        this.clothDataManager = clothDataManager;
    }

    @Override
    public void getClothData() {

    }

    @Override
    public void goToGivenStepIfPossible(int givenStep) {
        view.goToGivenStep(givenStep);
    }
}
