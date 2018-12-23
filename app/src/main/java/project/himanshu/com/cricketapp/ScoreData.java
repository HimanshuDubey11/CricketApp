package project.himanshu.com.cricketapp;

import java.io.Serializable;
import java.util.ArrayList;

public class ScoreData implements Serializable {

    String title;
    ArrayList<PlayerScore> playerScores;

    public ScoreData(String title, ArrayList<PlayerScore> playerScores) {
        this.title = title;
        this.playerScores = playerScores;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<PlayerScore> getPlayerScores() {
        return playerScores;
    }

    public void setPlayerScores(ArrayList<PlayerScore> playerScores) {
        this.playerScores = playerScores;
    }
}
