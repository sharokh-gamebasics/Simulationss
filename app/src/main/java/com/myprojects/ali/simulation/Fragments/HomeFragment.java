package com.myprojects.ali.simulation.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.myprojects.ali.simulation.Adapters.OverviewListAdapter;
import com.myprojects.ali.simulation.MainActivity;
import com.myprojects.ali.simulation.Overview;
import com.myprojects.ali.simulation.OverviewView;
import com.myprojects.ali.simulation.R;
import com.myprojects.ali.simulation.models.*;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HomeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private Poule poule;
    public static transient ArrayList< Match > matches;
    private OnFragmentInteractionListener mListener;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        Team netherlands = new Team("Netherlands", 85, 85);
        Team germany = new Team("Zweden", 79, 78);
        Team france = new Team("France", 90, 84);
        Team portugal = new Team("Belarus", 77, 75);

        ArrayList<Team> teams = new ArrayList<Team>();
        teams.add(netherlands);
        teams.add(germany);
        teams.add(france);
        teams.add(portugal);

        poule = new Poule(teams);

        final ListView listView = (ListView) view.findViewById(R.id.teamlist);

        OverviewListAdapter adapter = new OverviewListAdapter(this.getContext(), R.layout.list_item_overview, teams);

        listView.setAdapter(adapter);

        Button simulateButton = (Button) view.findViewById(R.id.simulatePoule);
        Button resetButton = (Button) view.findViewById(R.id.resetButton);

         matches = poule.getPouleMatches();

        simulateButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                poule.resetPoule();
                poule.simulatePoule();
                ArrayList<Team> sortedTeams = poule.sortPoule(poule.getPouleTeams());
                OverviewListAdapter playedGames = new OverviewListAdapter(v.getContext(), R.layout.list_item_overview, sortedTeams);
                listView.setAdapter(playedGames);
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), Overview.class);
                intent.putExtra("name", matches);
               // intent.putExtra("matches", matches);
                startActivity(intent);

            }
        });

        // Inflate the layout for this fragment
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {

        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
