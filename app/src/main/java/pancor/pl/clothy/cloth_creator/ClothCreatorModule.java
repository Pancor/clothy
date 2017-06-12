package pancor.pl.clothy.cloth_creator;

import dagger.Module;
import dagger.Provides;

@Module
public class ClothCreatorModule {

    private ClothCreator.View view;

    public ClothCreatorModule(ClothCreator.View view){
        this.view = view;
    }

    @Provides
    ClothCreator.View provideView(){
        return view;
    }
}
