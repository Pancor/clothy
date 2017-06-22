package pancor.pl.clothy.cloth_creator;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import pancor.pl.clothy.R;
import pancor.pl.clothy.base.App;
import pancor.pl.clothy.base.BaseActivity;
import pancor.pl.clothy.cloth_creator.steps.FirstStepFragment;
import pancor.pl.clothy.cloth_creator.steps.SecondStepFragment;
import pancor.pl.clothy.cloth_creator.steps.ThirdStepFragment;
import pancor.pl.clothy.models.Cloth;
import pancor.pl.clothy.utils.ui.recycler.SpaceItemDecoration;
import pancor.pl.clothy.utils.ui.stepper.Stepper;
import pancor.pl.clothy.utils.ui.stepper.StepperAdapter;

public class ClothCreatorActivity extends BaseActivity implements ClothCreator.View,
        Stepper {

    private static final int DISTANCE_BETWEEN_STEPPER_ITEMS_IN_DP = 8;
    private static final int STEPPER_ITEMS = 3;

    @Inject ClothCreatorPresenter presenter;

    private SteppersPagerAdapter pagerAdapter;

    @BindView(R.id.stepper) protected RecyclerView stepperRecyclerView;
    @BindView(R.id.viewPager) protected ViewPager containerViewPager;
    @BindView(R.id.clothImage) protected ImageView clothImage;
    @BindView(R.id.creatorLayout) protected LinearLayout creatorLayout;
    @BindView(R.id.progressBar) protected ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cloth_creator);

        setupInjection();
        setupStepperView();
        setupContainerViewPager();
        presenter.getClothData();
    }

    private void setupInjection(){
        ButterKnife.bind(this);
        DaggerClothCreatorComponent.builder()
                .clothDataComponent(((App)getApplication()).getClothDataComponent())
                .clothCreatorModule(new ClothCreatorModule(this))
                .build().inject(this);
    }

    private void setupContainerViewPager(){
        pagerAdapter = new SteppersPagerAdapter(getSupportFragmentManager());
        containerViewPager.setAdapter(pagerAdapter);
    }

    private void setupStepperView(){
        stepperRecyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager
                (this, LinearLayoutManager.HORIZONTAL, false);
        stepperRecyclerView.setLayoutManager(layoutManager);
        RecyclerView.ItemDecoration itemDecoration =
                new SpaceItemDecoration(DISTANCE_BETWEEN_STEPPER_ITEMS_IN_DP);
        stepperRecyclerView.addItemDecoration(itemDecoration);
        stepperRecyclerView.setAdapter(new StepperAdapter(this, getResources(), STEPPER_ITEMS));
    }

    @Override
    public void onStepperItemClick(int position) {
        presenter.goToGivenStepIfPossible(position);
    }

    @Override
    public void goToGivenStep(int givenStep) {
        containerViewPager.setCurrentItem(givenStep, true);
        stepperRecyclerView.smoothScrollToPosition(givenStep);
    }

    @Override
    public void onClothLoaded(@NonNull Cloth cloth) {

    }

    @Override
    public void onDataNotAvailable() {

    }

    @Override
    public void showLoadingIndicator() {
        creatorLayout.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoadingIndicator() {
        creatorLayout.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
    }

    private class SteppersPagerAdapter extends FragmentPagerAdapter {

        private SteppersPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return STEPPER_ITEMS;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return FirstStepFragment.newInstance();
                case 1:
                    return SecondStepFragment.newInstance();
                case 2:
                    return ThirdStepFragment.newInstance();
                default: throw new IllegalStateException("There should be only " +
                        STEPPER_ITEMS + " items.");
            }
        }
    }
}
