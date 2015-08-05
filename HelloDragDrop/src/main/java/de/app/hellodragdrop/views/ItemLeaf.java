package de.app.hellodragdrop.views;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;

public class ItemLeaf extends Item {

    public ItemLeaf(Context context) {
        super(context);
    }

    public ItemLeaf(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ItemLeaf(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
