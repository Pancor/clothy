package pancor.pl.clothy.data;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pancor.pl.clothy.data.remote.FakeRemoteClothData;

@Module
public class ClothDataModule {

    @Provides
    @Singleton
    ClothData providesRemoteStationData(){

        return new FakeRemoteClothData();
    }
}
