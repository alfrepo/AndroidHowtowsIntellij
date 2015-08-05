package de.app.fragments.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import de.app.R;

/**
 * Created by skip on 02.09.2014.
 */
public class ViewMenuCalendar extends LinearLayout {

    public ViewMenuCalendar(Context context) {
        super(context);init(context);
    }
    public ViewMenuCalendar(Context context, AttributeSet attrs) {
        super(context, attrs);init(context);
    }
    public ViewMenuCalendar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    void init(Context context){
        LayoutInflater inflater = (LayoutInflater)   getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.view_menu_calendar, this, true);
    }
}
