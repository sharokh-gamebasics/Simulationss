package com.myprojects.ali.simulation.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.myprojects.ali.simulation.R;
import com.myprojects.ali.simulation.models.Team;

import java.util.ArrayList;

public class OverviewListAdapter extends ArrayAdapter<Team> {

    private Context mContext;
    int mResource;

    public OverviewListAdapter(Context context, int resource, ArrayList< Team > teams) {
        super(context, resource, teams);
        this.mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Get al variables for the team object in the list.
        String Rank = position + 1 + "";
        String name = getItem(position).getTeamName();
        String points = String.valueOf(getItem(position).getPoints());
        String GoalsScored = String.valueOf(getItem(position).getGoalsScored());
        String GoalsConceded = String.valueOf(getItem(position).getGoalsConceded());
        //Get the view
        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);
        //Set all textField for the  List object.
        TextView rank = convertView.findViewById(R.id.rank);
        TextView teamName = convertView.findViewById(R.id.team);
        TextView Points = convertView.findViewById(R.id.points);
        TextView Goals = convertView.findViewById(R.id.Scored);
        TextView Conceded = convertView.findViewById(R.id.Conceded);

        //Fill all textFields for the List object,
        rank.setText(Rank);
        teamName.setText(name);
        Points.setText(points);
        Goals.setText(GoalsScored);
        Conceded.setText(GoalsConceded);
        //Return the View
        return convertView;
    }
}
