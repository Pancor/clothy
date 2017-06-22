package pancor.pl.clothy.data;


import android.support.annotation.NonNull;

import pancor.pl.clothy.models.Cloth;

public interface ClothData {

    void getCloth(@NonNull LoadClothDataCallback callback);

    interface LoadClothDataCallback{

        void onClothLoaded(@NonNull Cloth cloth);

        void clothNotAvailable();
    }
}
