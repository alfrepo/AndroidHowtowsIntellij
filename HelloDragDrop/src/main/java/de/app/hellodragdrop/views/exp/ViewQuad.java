package de.app.hellodragdrop.views.exp;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by skip on 06.09.2014.
 */
public class ViewQuad extends LinearLayout {

    int minWidth = 300;
    int minHeight = 100;
    boolean useMinHeight = false;

    public ViewQuad(Context context, int i) {
        super(context);
        init(context, i);
    }

    public ViewQuad(Context context) {
        super(context);
        init(context, 0);
    }
    public ViewQuad(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, 0);
    }

    public ViewQuad(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, 0);
    }

    private void init(Context context, int i) {
        int r = (int)( Math.random() * 255);
        int g = (int)( Math.random() * 255);
        int b = (int)( Math.random() * 255);
        this.setBackgroundColor(Color.argb(100, r, g, b));

//        LayoutInflater inflater = (LayoutInflater)   getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        inflater.inflate(R.layout.view_menu, this, true);

        this.setOrientation(LinearLayout.VERTICAL);

        if(i>0){
            addView(new ViewQuad(context, i-1));
            addView(new ViewQuad(context, i-1));
            addView(new ViewQuad(context, i-1));
            addView(new ViewQuad(context, i-1));
        }else{
            useMinHeight = true;
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, minHeight);
        int w = getMeasuredWidth();
        int h = getMeasuredHeight();
        if(w<minWidth){
            w = minWidth;
        }
        if(h<minHeight){
            h = minHeight;
        }
        //MUST CALL THIS
        setMeasuredDimension(w, h);
    }
}
