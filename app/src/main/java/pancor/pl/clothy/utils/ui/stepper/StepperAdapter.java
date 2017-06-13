package pancor.pl.clothy.utils.ui.stepper;


import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import pancor.pl.clothy.R;

public class StepperAdapter extends RecyclerView.Adapter{

    private int itemsCount;

    public StepperAdapter(int itemsCount){
        this.itemsCount = itemsCount;
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
    }

    @Override
    public int getItemCount() {
        return itemsCount;
    }

    class StepperHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.arrowView)
        StepperView arrowView;

        StepperHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
