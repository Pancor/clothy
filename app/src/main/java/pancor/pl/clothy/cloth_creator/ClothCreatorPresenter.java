package pancor.pl.clothy.cloth_creator;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import pancor.pl.clothy.base.ActivityScope;
import pancor.pl.clothy.data.ClothData;
import pancor.pl.clothy.data.ClothDataManager;
import pancor.pl.clothy.models.Cloth;

@ActivityScope
class ClothCreatorPresenter implements ClothCreator.Presenter {

    private ClothCreator.View view;
    private ClothDataManager clothDataManager;

    @Inject
    ClothCreatorPresenter(ClothCreator.View view, ClothDataManager clothDataManager){
        this.view = view;
        this.clothDataManager = clothDataManager;
    }

    @Override
    public void getClothData() {
        view.showLoadingIndicator();
        clothDataManager.getCloth(new ClothData.LoadClothDataCallback() {
            @Override
            public void onClothLoaded(@NonNull Cloth cloth) {
                view.onClothLoaded(cloth);
                view.hideLoadingIndicator();
            }

            @Override
            public void clothNotAvailable() {
                view.onDataNotAvailable();
                view.hideLoadingIndicator();
            }
        });
    }

    @Override
    public void goToGivenStepIfPossible(int givenStep) {
        view.goToGivenStep(givenStep);
    }
}
