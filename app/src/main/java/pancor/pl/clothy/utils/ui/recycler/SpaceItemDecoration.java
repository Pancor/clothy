package pancor.pl.clothy.utils.ui.recycler;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;

public class SpaceItemDecoration extends RecyclerView.ItemDecoration {

    private int spaceWidth;

    public SpaceItemDecoration(int spaceInDp) {
        this.spaceWidth = spaceInDp;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                               RecyclerView.State state) {

        Context context = parent.getContext();
        Resources r = context.getResources();
        int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                spaceWidth, r.getDisplayMetrics());

        int itemPosition = parent.getChildAdapterPosition(view);
        if (itemPosition == 0) {
            outRect.left = px;
        } else if (itemPosition == parent.getAdapter().getItemCount() - 1){
            outRect.right = px;
        }
    }
}
