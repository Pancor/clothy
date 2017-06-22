package pancor.pl.clothy.data;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ClothDataModule.class)
public interface ClothDataComponent {

    ClothDataManager getClothDataManager();
}
