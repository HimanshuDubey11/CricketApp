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

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class T20MatchesFrag extends Fragment {


    ArrayList<TypeODI> odiMatches ;
    ArrayList<TypeT20> t20Matches ;
    ArrayList<TypeTest> testMatches ;
    ArrayList<TypeAll> allMatches;

    public T20MatchesFrag(ArrayList<TypeODI> odiMatches, ArrayList<TypeT20> t20Matches, ArrayList<TypeTest> testMatches, ArrayList<TypeAll> allMatches) {
        this.odiMatches = odiMatches;
        this.t20Matches = t20Matches;
        this.testMatches = testMatches;
        this.allMatches = allMatches;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_t20_matches, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.t20recyclerview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager
                (getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new DataAdapter("T20",odiMatches,t20Matches,testMatches,allMatches));

    }
}
