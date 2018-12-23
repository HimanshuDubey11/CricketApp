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

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.Player1> {

    ArrayList<PlayerScore> playerScores = new ArrayList<PlayerScore>();

    public PlayerAdapter(ArrayList<PlayerScore> playerScores) {

        this.playerScores = playerScores;

    }

    @NonNull
    @Override
    public PlayerAdapter.Player1 onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_player_adapter,null);

        return new Player1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayerAdapter.Player1 player1, int i) {

        player1.batsman.setText(playerScores.get(i).batsman.toString());
        player1.dismissal.setText(playerScores.get(i).dismissal_info.toString());
        player1.runs.setText(playerScores.get(i).r.toString());
        player1.balls.setText("(" + playerScores.get(i).b.toString() + ")");

    }

    @Override
    public int getItemCount() {
        return playerScores.size();
    }

    public class Player1 extends RecyclerView.ViewHolder {
        TextView batsman, dismissal, runs, balls;
        public Player1(@NonNull View itemView) {
            super(itemView);

            batsman = itemView.findViewById(R.id.batsman);
            dismissal = itemView.findViewById(R.id.dismissal);
            runs = itemView.findViewById(R.id.runs);
            balls = itemView.findViewById(R.id.balls);

        }
    }
}
