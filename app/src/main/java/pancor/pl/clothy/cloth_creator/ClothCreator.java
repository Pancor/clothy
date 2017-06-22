package pancor.pl.clothy.cloth_creator;


import android.support.annotation.NonNull;

import pancor.pl.clothy.models.Cloth;

interface ClothCreator {

    interface View {

        void goToGivenStep(int givenStep);

        void onClothLoaded(@NonNull Cloth cloth);

        void onDataNotAvailable();

        void showLoadingIndicator();

        void hideLoadingIndicator();
    }

    interface Presenter {

        void getClothData();

        void goToGivenStepIfPossible(int givenStep);
    }
}
