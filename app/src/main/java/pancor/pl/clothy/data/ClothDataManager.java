package pancor.pl.clothy.data;


import android.support.annotation.NonNull;

import javax.inject.Inject;
import javax.inject.Singleton;

import pancor.pl.clothy.models.Cloth;

@Singleton
public class ClothDataManager implements ClothData{

    private ClothData remoteClothData;

    @Inject ClothDataManager(ClothData remoteClothData){
        this.remoteClothData = remoteClothData;
    }

    @Override
    public void getCloth(@NonNull LoadClothDataCallback callback) {

        remoteClothData.getCloth(new LoadClothDataCallback() {
            @Override
            public void onClothLoaded(@NonNull Cloth cloth) {
                callback.onClothLoaded(cloth);
            }

            @Override
            public void clothNotAvailable() {
                callback.clothNotAvailable();
            }
        });
    }
}
