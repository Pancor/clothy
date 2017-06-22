package pancor.pl.clothy.data;


import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ClothDataManager {

    private ClothData remoteClothData;

    @Inject ClothDataManager(ClothData remoteClothData){
        this.remoteClothData = remoteClothData;
    }
}
