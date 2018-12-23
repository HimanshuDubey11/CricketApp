package project.himanshu.com.cricketapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.Data> {

    String type;
    ArrayList<TypeODI> odiMatches ;
    ArrayList<TypeT20> t20Matches ;
    ArrayList<TypeTest> testMatches ;
    ArrayList<TypeAll> allMatches;

    public DataAdapter(String type, ArrayList<TypeODI> odiMatches, ArrayList<TypeT20> t20Matches, ArrayList<TypeTest> testMatches, ArrayList<TypeAll> allMatches) {
        this.type = type;
        this.odiMatches = odiMatches;
        this.t20Matches = t20Matches;
        this.testMatches = testMatches;
        this.allMatches = allMatches;
    }

    @NonNull
    @Override
    public DataAdapter.Data onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_data_adapter,null);

        return new Data(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataAdapter.Data data, int i) {

        if(type.equals("ALL")) {
            data.team1.setText(allMatches.get(i).team_1);
            data.team2.setText(allMatches.get(i).team_2);
            String date[] = allMatches.get(i).matchDate.split("T");
            data.date.setText(date[0]);
        }

        if(type.equals("T20")) {
            data.team1.setText(t20Matches.get(i).team_1);
            data.team2.setText(t20Matches.get(i).team_2);
            String date[] = t20Matches.get(i).matchDate.split("T");
            data.date.setText(date[0]);
        }

        if(type.equals("ODI")) {
            data.team1.setText(odiMatches.get(i).team_1);
            data.team2.setText(odiMatches.get(i).team_2);
            String date[] = odiMatches.get(i).matchDate.split("T");
            data.date.setText(date[0]);

        }

        if(type.equals("TEST")) {
            data.team1.setText(testMatches.get(i).team_1);
            data.team2.setText(testMatches.get(i).team_2);
            String date[] = odiMatches.get(i).matchDate.split("T");
            data.date.setText(date[0]);
        }


    }

    @Override
    public int getItemCount() {

        int count = 0;

        if(type.equals("ALL")) {
            count = allMatches.size();
        }

        if(type.equals("T20")) {
            count = t20Matches.size();
        }

        if(type.equals("ODI")) {
            count = odiMatches.size();
        }

        if(type.equals("TEST")) {
            count = testMatches.size();
        }

        return count;
    }

    public class Data extends RecyclerView.ViewHolder {
        TextView team1, team2 , date;
        RelativeLayout relativeLayout;
        public Data(@NonNull View itemView) {
            super(itemView);
            relativeLayout = itemView.findViewById(R.id.myrelativelayout);
            team1 = itemView.findViewById(R.id.team1);
            team2 = itemView.findViewById(R.id.team2);
            date = itemView.findViewById(R.id.date);
        }
    }
}
