package pancor.pl.clothy.base;

import android.app.Application;

import pancor.pl.clothy.data.ClothDataComponent;
import pancor.pl.clothy.data.ClothDataModule;
import pancor.pl.clothy.data.DaggerClothDataComponent;

public class App extends Application  {

    private ClothDataComponent clothDataComponent;

    @Override
    public void onCreate(){
        super.onCreate();

        buildClothDataComponent();
    }

    public ClothDataComponent getClothDataComponent(){

        return clothDataComponent;
    }

    private void buildClothDataComponent(){

        clothDataComponent = DaggerClothDataComponent.builder()
                .clothDataModule(new ClothDataModule())
                .build();
    }
}
