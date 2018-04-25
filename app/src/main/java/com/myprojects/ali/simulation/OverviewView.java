package com.myprojects.ali.simulation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.myprojects.ali.simulation.Adapters.ResultsListAdapter;
import com.myprojects.ali.simulation.Fragments.*;
import com.myprojects.ali.simulation.models.Match;

import java.util.ArrayList;

/**
 * TODO: document your custom view class.
 */
public class OverviewView extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Intent i = getIntent();
        //ArrayList<Match> matches = (ArrayList<Match>) i.getParcelableExtra("matches");

        //ListView mListView = (ListView) findViewById(R.id.resultslistview);

        //Create list adapter to fill the list and will it with the teams.
        //ResultsListAdapter adapter = new ResultsListAdapter(this, R.layout.sample_overview_view, null);
        //mListView.setAdapter(adapter);

    }

}
