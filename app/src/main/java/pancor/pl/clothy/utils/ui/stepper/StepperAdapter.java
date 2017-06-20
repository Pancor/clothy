package pancor.pl.clothy.utils.ui.stepper;

import android.content.res.Resources;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import pancor.pl.clothy.R;

public class StepperAdapter extends RecyclerView.Adapter {

    private static final int COUNT_FROM_ONE = 1;

    private Stepper stepper;
    private int itemsCount;
    private String[] stepsTitlesArray;

    public StepperAdapter(@NonNull Stepper stepperInterface, @NonNull Resources res,
                          int itemsCount){
        this.itemsCount = itemsCount;
        this.stepper = stepperInterface;
        stepsTitlesArray = res.getStringArray(R.array.cloth_creator_steps);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.holder_stepper, parent, false);
        return new StepperHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        StepperHolder h = (StepperHolder) holder;
        if (position == 0){
            h.arrowView.setFirstItem();
            h.arrowView.setBackgroundColorOfShape(Color.BLACK);
        }
        h.stepsTitle.setText(stepsTitlesArray[position]);
        String step = String.valueOf(position + COUNT_FROM_ONE);
        h.stepsCount.setText(step);
    }

    @Override
    public int getItemCount() {
        return itemsCount;
    }

    class StepperHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.arrowView)     StepperView arrowView;
        @BindView(R.id.stepper)       RelativeLayout stepperLayout;
        @BindView(R.id.stepTextView)  TextView stepsTitle;
        @BindView(R.id.stepCountView) TextView stepsCount;

        StepperHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            stepperLayout.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.stepper){
                int position = getAdapterPosition();
                stepper.onStepperItemClick(position);
                arrowView.setBackgroundColorOfShape(Color.BLACK);
            }
        }
    }
}
