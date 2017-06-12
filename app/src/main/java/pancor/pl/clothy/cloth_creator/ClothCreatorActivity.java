package pancor.pl.clothy.cloth_creator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

import pancor.pl.clothy.R;

public class ClothCreatorActivity extends AppCompatActivity implements ClothCreator.View {

    @Inject ClothCreatorPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cloth_creator);

        DaggerClothCreatorComponent.builder()
                .clothCreatorModule(new ClothCreatorModule(this))
                .build().inject(this);
    }
}
