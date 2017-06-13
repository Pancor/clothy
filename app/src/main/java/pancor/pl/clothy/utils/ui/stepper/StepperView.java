package pancor.pl.clothy.utils.ui.stepper;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class StepperView extends View {

    private Paint paint;
    private boolean isFirstItem;

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
        paint.setColor(color);
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

    private void drawFirstItem(Canvas canvas){
        canvas.drawRect(0, 0, (float) (getWidth() * 0.9), getHeight(), paint);
        drawTriangle(canvas, (int) (getWidth() * 0.9), 0, getWidth(), getHeight(), Color.BLACK);
    }

    private void drawNextItem(Canvas canvas){
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.GRAY);

        canvas.drawRect(0, 0, (float) (getWidth() * 0.9), getHeight(), paint);
        drawTriangle(canvas, (int) (getWidth() * 0.9), 0, getWidth(), getHeight(), Color.GRAY);
        drawTriangle(canvas, 0, 0, (int) (getWidth() * 0.1), getHeight(), Color.WHITE);
    }

    private void drawTriangle(Canvas canvas, int x, int y, int width, int height, int color) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(color);
        Path path = new Path();
        path.moveTo(x, y);
        path.lineTo(x, height);
        path.lineTo(width, height/2);
        path.lineTo(x,y);
        path.close();
        canvas.drawPath(path, paint);
    }


}
