package com.myprojects.ali.simulation.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.myprojects.ali.simulation.R;
import com.myprojects.ali.simulation.models.Match;

import java.util.ArrayList;

public class ResultsListAdapter extends ArrayAdapter<Match> {

    private Context mContext;
    int mResource;

    public ResultsListAdapter(Context context, int resource, ArrayList< Match > matches) {
        super(context, resource, matches);
        this.mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Get al variables for the team object in the list.
        String homeTeamName = getItem(position).getHomeTeam().getTeamName();
        String homeTeamGoals = String.valueOf(getItem(position).getHomeGoals());
        String outTeamGoals = String.valueOf(getItem(position).getAwayGoals());
        String OutTeamName = getItem(position).getAwayTeam().getTeamName();
        //Get the view
        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);
        //Set all textField for the  List object.
        TextView homeTeam = convertView.findViewById(R.id.homeTeam);
        TextView homeGoals = convertView.findViewById(R.id.homeGoals);
        TextView outGoals = convertView.findViewById(R.id.outGoals);
        TextView OutTeam = convertView.findViewById(R.id.outTeam);

        //Fill all textFields for the List object,
        homeTeam.setText(homeTeamName);
        homeGoals.setText(homeTeamGoals);
        outGoals.setText(outTeamGoals);
        OutTeam.setText(OutTeamName);
        //Return the View
        return convertView;
    }
}
