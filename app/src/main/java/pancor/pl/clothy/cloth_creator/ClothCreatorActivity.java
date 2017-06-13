package pancor.pl.clothy.cloth_creator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import pancor.pl.clothy.R;
import pancor.pl.clothy.base.BaseActivity;
import pancor.pl.clothy.utils.ui.recycler.SpaceItemDecoration;
import pancor.pl.clothy.utils.ui.stepper.StepperAdapter;

public class ClothCreatorActivity extends BaseActivity implements ClothCreator.View {

    @Inject ClothCreatorPresenter presenter;

    @BindView(R.id.stepper) protected RecyclerView stepperView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cloth_creator);
        ButterKnife.bind(this);

        DaggerClothCreatorComponent.builder()
                .clothCreatorModule(new ClothCreatorModule(this))
                .build().inject(this);

        stepperView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager
                (this, LinearLayoutManager.HORIZONTAL, false);
        stepperView.setLayoutManager(layoutManager);
        stepperView.addItemDecoration(new SpaceItemDecoration(8));
        stepperView.setAdapter(new StepperAdapter(3));

    }
}
