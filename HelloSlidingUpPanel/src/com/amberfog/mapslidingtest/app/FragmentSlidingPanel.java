package com.amberfog.mapslidingtest.app;

import java.util.ArrayList;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class FragmentSlidingPanel extends Fragment {
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_slidingpanel_layout, container,false);
		setUpView(view);
		return view;
	}

	private void setUpView(View view) {
        
        ListView listView = (ListView) view.findViewById(R.id.list);
        final ArrayList<String> list = new ArrayList<String>();
        
        for(int i=0; i<100; i++){
        	list.add(""+i);
        	TextView text = new TextView(getActivity());
        	text.setText(""+i);
        }
        
        
        // This is the array adapter, it takes the context of the activity as a 
        // first parameter, the type of list view as a second parameter and your 
        // array as a third parameter.
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                getActivity(), 
                android.R.layout.simple_list_item_1,
                list );
        
        listView.setAdapter(arrayAdapter);
	}
}
