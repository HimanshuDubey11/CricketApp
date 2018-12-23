package project.himanshu.com.cricketapp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class LiveAdapter extends RecyclerView.Adapter<LiveAdapter.Live> {

    ArrayList<LiveMatches> liveMatches;
    Context context;

    public LiveAdapter(Context liveMatchesFrag, ArrayList<LiveMatches> liveMatches) {

        this.context = liveMatchesFrag;
        this.liveMatches = liveMatches;
        
    }

    @NonNull
    @Override
    public LiveAdapter.Live onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_live_adapter,null);
        
        return new Live(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final LiveAdapter.Live live, final int i) {

        String team1 = liveMatches.get(i).team_1;
        String team1clear[] = team1.split(" ");
        String team1main="";
        for (int j = 0; j <team1clear.length ; j++) {
            team1main += ("\n"  +  team1clear[j]);
        }
        live.team1.setText(team1main);

        String team2 = liveMatches.get(i).team_2;
        String team2clear[] = team2.split(" ");
        String team2main = "";
        for (int j = 0; j <team2clear.length ; j++) {
            team2main += ("\n" + team2clear[j]);
        }
        live.team2.setText(team2main);

        live.type.setText(liveMatches.get(i).matchType);
        String date[] = liveMatches.get(i).matchDate.split("T");
        live.date.setText(date[0]);

        live.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context,Score.class);
                intent.putExtra("unique_id",liveMatches.get(i).unique_id);
                context.startActivity(intent);

            }
        });

        
    }

    @Override
    public int getItemCount() {
        return liveMatches.size();
    }
    
    public class Live extends RecyclerView.ViewHolder {

        TextView team1, team2 ,type, date;
        RelativeLayout relativeLayout;
        public Live(@NonNull View itemView) {
            super(itemView);

            relativeLayout = itemView.findViewById(R.id.myrelativelayout);
            team1 = itemView.findViewById(R.id.team1);
            team2 = itemView.findViewById(R.id.team2);
            type = itemView.findViewById(R.id.type);
            date = itemView.findViewById(R.id.date);
            
        }
    }
}
