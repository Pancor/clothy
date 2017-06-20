package pancor.pl.clothy.utils.ui.stepper;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class StepperView extends View {

    private static final String STATE_SUPER = "state_super";
    private static final String STATE_IS_BLACK = "state_is_black";

    private Paint paint;
    private boolean isFirstItem;
    private boolean isBlack = false;

    public StepperView(Context context) {
        super(context);
        init();
    }

    public StepperView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public StepperView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void setBackgroundColorOfShape(int color){
        isBlack = true;
        paint.setColor(color);
        invalidate();
    }

    public void setFirstItem(){
        isFirstItem = true;
        invalidate();
    }

    private void init(){
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.GRAY);
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

        if (isFirstItem){
            drawFirstItem(canvas);
        } else {
            drawNextItem(canvas);
        }
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(STATE_SUPER, super.onSaveInstanceState());
        bundle.putBoolean(STATE_IS_BLACK, isBlack);
        return bundle;
    }

    @Override
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle){
            Bundle bundle = (Bundle) parcelable;
            isBlack = bundle.getBoolean(STATE_IS_BLACK);
            invalidate();
            parcelable = bundle.getParcelable(STATE_SUPER);
        }
        super.onRestoreInstanceState(parcelable);
    }


    private void drawFirstItem(Canvas canvas){
        paint.setColor(Color.BLACK);
        canvas.drawRect(0, 0, (float) (getWidth() * 0.9), getHeight(), paint);
        drawTriangle(canvas, (int) (getWidth() * 0.9), 0, getWidth(), getHeight());
    }

    private void drawNextItem(Canvas canvas){
        drawTriangle(canvas, (int) (getWidth() * 0.9), 0, getWidth(), getHeight());
        Path path = new Path();
        path.moveTo(0,0);
        path.lineTo((int) (getWidth() * 0.9), 0);
        path.lineTo((int) (getWidth() * 0.9), getHeight());
        path.lineTo(0, getHeight());
        path.lineTo((int) (getWidth() * 0.1), getHeight() / 2);
        path.lineTo(0,0);
        path.close();
        canvas.drawPath(path, paint);
    }

    private void drawTriangle(Canvas canvas, int x, int y, int width, int height) {
        Path path = new Path();
        path.moveTo(x, y);
        path.lineTo(x, height);
        path.lineTo(width, height/2);
        path.lineTo(x,y);
        path.close();
        canvas.drawPath(path, paint);
    }
}