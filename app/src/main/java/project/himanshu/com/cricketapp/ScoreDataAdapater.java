package project.himanshu.com.cricketapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ScoreDataAdapater extends RecyclerView.Adapter<ScoreDataAdapater.ScoreData1> {

    ArrayList<ScoreData> scoreData = new ArrayList<ScoreData>();

    public ScoreDataAdapater(ArrayList<ScoreData> scoreData) {

        this.scoreData = scoreData;

    }

    @NonNull
    @Override
    public ScoreDataAdapater.ScoreData1 onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_score_data_adapater,null);

        return new ScoreData1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ScoreDataAdapater.ScoreData1 scoreData1, int i) {

        scoreData1.textView.setText(scoreData.get(i).getTitle().toString().toUpperCase());
        scoreData1.recyclerView.setAdapter(new PlayerAdapter(scoreData.get(i).playerScores));

    }

    @Override
    public int getItemCount() {
        return scoreData.size();
    }

    public class ScoreData1 extends RecyclerView.ViewHolder {
        TextView textView;
        RecyclerView recyclerView;
        public ScoreData1(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.teamname);
            recyclerView = itemView.findViewById(R.id.playerrecylerview);
        }
    }
}
