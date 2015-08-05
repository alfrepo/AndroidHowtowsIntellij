package de.app.hellodragdrop;

import android.app.Activity;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import de.app.hellodragdrop.views.exp.ViewQuad;


public class OverlayActivity extends Activity {

    ArrayAdapter arrayAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overlay);
        openOverlay();
        fillListView();
    }

    private void fillListView() {
        listView = (ListView) findViewById(R.id.listView);

        String[] strings = new String[100];
        arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), -1, -1, strings) {

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if(convertView!= null){
                    return convertView;
                }

                ViewQuad view = new ViewQuad(getApplicationContext(), 0);
                view.setId(position);
                return view;

            }
        };
        listView.setAdapter(arrayAdapter);
        
        modifyViewInList(listView);
    }

    private void modifyViewInList(final ListView listView) {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                View viewItem = listView.getChildAt(position);
                viewItem.setBackgroundColor(getResources().getColor(android.R.color.white));
                Log.d("Tag", "" + viewItem);
            }
        });

    }

    private void openOverlay() {


        Button mOverlayView = new Button(getApplicationContext());
        mOverlayView.setText("This is the overlay");

        WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_SYSTEM_ALERT,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE |
                        WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN,
                PixelFormat.TRANSLUCENT);

        getWindowManager().addView(mOverlayView, params);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.list_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
