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

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.Schedule> {


    ArrayList<TypeAll> allMatches;

    public ScheduleAdapter(ArrayList<TypeAll> allMatches) {

        this.allMatches = allMatches;

    }

    @NonNull
    @Override
    public ScheduleAdapter.Schedule onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_schedule_adapter,null);

        return new Schedule(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ScheduleAdapter.Schedule schedule, int i) {

        String team1 = allMatches.get(i).team_1;
        String team1clear[] = team1.split(" ");
        String team1main="";
        for (int j = 0; j <team1clear.length ; j++) {
            team1main += ("\n"  +  team1clear[j]);
        }
        schedule.team1.setText(team1main);

        String team2 = allMatches.get(i).team_2;
        String team2clear[] = team2.split(" ");
        String team2main = "";
        for (int j = 0; j <team2clear.length ; j++) {
            team2main += ("\n" + team2clear[j]);
        }
        schedule.team2.setText(team2main);
        schedule.type.setText(allMatches.get(i).matchType);
        String date[] = allMatches.get(i).matchDate.split("T");
        schedule.date.setText(date[0]);

    }

    @Override
    public int getItemCount() {
        return allMatches.size();
    }


    public class Schedule extends RecyclerView.ViewHolder {

        TextView team1, team2 , date, type;
        RelativeLayout relativeLayout;
        public Schedule(@NonNull View itemView) {
            super(itemView);
            relativeLayout = itemView.findViewById(R.id.myrelativelayout);
            team1 = itemView.findViewById(R.id.team1);
            type = itemView.findViewById(R.id.type);
            team2 = itemView.findViewById(R.id.team2);
            date = itemView.findViewById(R.id.date);
        }
    }
}
