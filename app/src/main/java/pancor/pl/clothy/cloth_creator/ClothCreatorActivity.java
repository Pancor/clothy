package pancor.pl.clothy.cloth_creator;

import android.os.Bundle;
import android.support.annotation.Nullable;

import javax.inject.Inject;

import pancor.pl.clothy.R;
import pancor.pl.clothy.base.BaseActivity;

public class ClothCreatorActivity extends BaseActivity implements ClothCreator.View {

    @Inject ClothCreatorPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cloth_creator);

        DaggerClothCreatorComponent.builder()
                .clothCreatorModule(new ClothCreatorModule(this))
                .build().inject(this);
    }
}
