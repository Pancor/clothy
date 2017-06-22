package pancor.pl.clothy.cloth_creator;

import dagger.Component;
import pancor.pl.clothy.base.ActivityScope;
import pancor.pl.clothy.data.ClothDataComponent;

@ActivityScope
@Component(dependencies = ClothDataComponent.class, modules = ClothCreatorModule.class)
public interface ClothCreatorComponent{

    void inject(ClothCreatorActivity activity);
}
