package pancor.pl.clothy.cloth_creator;

import dagger.Component;
import pancor.pl.clothy.base.ActivityScope;

@ActivityScope
@Component(modules = ClothCreatorModule.class)
public interface ClothCreatorComponent{

    void inject(ClothCreatorActivity activity);
}
