package de.app.hellodragdrop.views.exp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Picture;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class ViewTouchShape extends View implements View.OnTouchListener {


    String TAG = "TAG";

    Path p;
    Region r;
    Picture cache;

    public ViewTouchShape(Context context) {
        super(context);
        init(context);
    }

    public ViewTouchShape(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ViewTouchShape(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    void init(Context context){
        this.setOnTouchListener(this);
    }


    @Override
    public void onDraw(Canvas canvas) {

        p = new Path();

        p.moveTo(50, 50);
        p.lineTo(100, 50);
        p.lineTo(100, 100);
        p.lineTo(80, 100);
        p.close();

        Paint paint = new Paint();
        paint.setARGB(100,255, 255, 255);

        canvas.drawPath(p, paint);

        RectF rectF = new RectF();
        p.computeBounds(rectF, true);
        r = new Region();
        r.setPath(p, new Region((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom));

        render(this);
    }

    void render(Object o){
        Log.d(TAG, "renderObject");
    }
    void render(View o){
        Log.d(TAG, "renderView");
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Point point = new Point();
        point.x = (int)event.getX();
        point.y = (int)event.getY();
//        points.add(point);
        invalidate();
        Log.d(TAG, "point: " + point);

        if(r.contains((int)point.x,(int) point.y))
            Log.d(TAG, "Touch IN");
        else
            Log.d(TAG, "Touch OUT");

        return true;
    }

}
