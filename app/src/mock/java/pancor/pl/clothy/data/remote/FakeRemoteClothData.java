package pancor.pl.clothy.data.remote;


import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import pancor.pl.clothy.R;
import pancor.pl.clothy.data.ClothData;
import pancor.pl.clothy.models.Cloth;

@Singleton
public class FakeRemoteClothData implements ClothData {

    public FakeRemoteClothData(){}

    @Override
    public void getCloth(@NonNull LoadClothDataCallback callback) {
        //creates dummy cloth
        List<Integer> sizes = new ArrayList<>();
        sizes.add(R.drawable.cloth_1);
        sizes.add(R.drawable.cloth_2);
        sizes.add(R.drawable.cloth_3);
        sizes.add(R.drawable.cloth_4);
        Cloth cloth = new Cloth(sizes);
        callback.onClothLoaded(cloth);
    }
}
