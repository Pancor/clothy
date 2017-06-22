package pancor.pl.clothy.cloth_creator;

import javax.inject.Inject;

import pancor.pl.clothy.base.ActivityScope;

@ActivityScope
public class ClothCreatorPresenter implements ClothCreator.Presenter {

    private ClothCreator.View view;

    @Inject
    public ClothCreatorPresenter(ClothCreator.View view){
        this.view = view;
    }

    @Override
    public void getClothData() {

    }

    @Override
    public void goToGivenStepIfPossible(int givenStep) {
        view.goToGivenStep(givenStep);
    }
}
