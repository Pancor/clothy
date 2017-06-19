package pancor.pl.clothy.cloth_creator.steps;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import pancor.pl.clothy.R;

public class ThirdStepFragment extends Fragment {

    public ThirdStepFragment(){}

    public static ThirdStepFragment newInstance(){
        return new ThirdStepFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_third_step_creator, container, false);
        ButterKnife.bind(this, v);
        return v;
    }
}
