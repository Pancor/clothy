package pancor.pl.clothy.cloth_creator.steps;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatSeekBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import pancor.pl.clothy.R;

public class FirstStepFragment extends Fragment implements SeekBar.OnSeekBarChangeListener {

    private FirstStep firstStepInterface;

    @BindView(R.id.clothSizeBar) protected AppCompatSeekBar clothSizeBar;

    public FirstStepFragment(){}

    public static FirstStepFragment newInstance() {
        return new FirstStepFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        firstStepInterface = (FirstStep) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_first_step_creator, container, false);
        ButterKnife.bind(this, v);
        return v;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){

        clothSizeBar.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        firstStepInterface.setClothSize(i);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    public interface FirstStep {

        void setClothSize(int size);
    }
}
