/**
 * Copyright 2014-present Amberfog
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.amberfog.mapslidingtest.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.sothree.slidinguppanel.SlidingUpPanelLayout;


public class MainActivity extends Activity implements SlidingUpPanelLayout.PanelSlideListener {

    private ListView mListView;
    private SlidingUpPanelLayout mSlidingUpPanelLayout;

    private View mTransparentHeaderView;
    private View mTransparentView;
    private View mSpaceView;

    private List<Map<String, Object>> data;
    private ListView listView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onPanelSlide(View view, float v) {
    	System.out.println("onPanelSlide");
    }


    @Override
    public void onPanelAnchored(View view) {
    	System.out.println("onPanelAnchored");
    }


	@Override
	public void onPanelCollapsed(View panel) {
		System.out.println("onPanelCollapsed");
	}


	@Override
	public void onPanelExpanded(View panel) {
		System.out.println("onPanelExpanded");
	}
}
