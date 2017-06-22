package pancor.pl.clothy.cloth_creator;


interface ClothCreator {

    interface View {

        void goToGivenStep(int givenStep);
    }

    interface Presenter {

        void getClothData();

        void goToGivenStepIfPossible(int givenStep);
    }
}
