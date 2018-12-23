package project.himanshu.com.cricketapp;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class LiveMatchesFrag extends Fragment {


    ArrayList<TypeAll> allMatches;
    ArrayList<LiveMatches> liveMatches;

    public LiveMatchesFrag(ArrayList<TypeAll> allMatches) {
        // Required empty public constructor
        this.allMatches = allMatches;

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_live_matches, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        liveMatches = new ArrayList<LiveMatches>();

        for (int i = 0; i < allMatches.size(); i++) {

            LiveMatches liveMatches1 = new LiveMatches(allMatches.get(i).unique_id,allMatches.get(i).team_2,allMatches.get(i).team_1,allMatches.get(i).matchType,allMatches.get(i).matchDate,allMatches.get(i).dateTimeGMT,allMatches.get(i).squad,allMatches.get(i).toss_winner_team,allMatches.get(i).winner_team,allMatches.get(i).matchStarted);

            if(liveMatches1.matchStarted.equals("true")) {
                liveMatches.add(liveMatches1);
            }

        }


        RecyclerView recyclerView = view.findViewById(R.id.liverecyclerview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager
                (getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new LiveAdapter(getContext(),liveMatches));

    }
}
