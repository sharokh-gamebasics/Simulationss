package com.myprojects.ali.simulation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.myprojects.ali.simulation.Adapters.ResultsListAdapter;
import com.myprojects.ali.simulation.models.Match;

import java.util.ArrayList;

public class Overview extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.overview_view);

        Intent i = getIntent();
        ArrayList<Match> matches = (ArrayList<Match>) i.getSerializableExtra("matches");
        String aa = i.getStringExtra("matches");


        ListView mListView = (ListView) findViewById(R.id.resultslistview);

        //Create list adapter to fill the list and will it with the teams.
        ResultsListAdapter adapter = new ResultsListAdapter(this, R.layout.list_item_result, null);
        mListView.setAdapter(adapter);
    }
}
