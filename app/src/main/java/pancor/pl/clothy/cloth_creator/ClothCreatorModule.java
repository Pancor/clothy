package pancor.pl.clothy.cloth_creator;

import android.support.annotation.NonNull;

import dagger.Module;
import dagger.Provides;

@Module
public class ClothCreatorModule {

    private ClothCreator.View view;

    public ClothCreatorModule(@NonNull ClothCreator.View view){
        this.view = view;
    }

    @Provides
    ClothCreator.View provideView(){
        return view;
    }
}
