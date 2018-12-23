package project.himanshu.com.cricketapp;

import java.io.Serializable;

public class LiveMatches implements Serializable {

    String unique_id;
    String team_2;
    String team_1;
    String matchType;
    String matchDate;
    String dateTimeGMT;
    String squad;
    String toss_winner_team;
    String winner_team;
    String matchStarted;


    public LiveMatches(String unique_id, String team_2, String team_1, String matchType, String matchDate, String dateTimeGMT, String squad, String toss_winner_team, String winner_team, String matchStarted) {
        this.unique_id = unique_id;
        this.team_2 = team_2;
        this.team_1 = team_1;
        this.matchType = matchType;
        this.matchDate = matchDate;
        this.dateTimeGMT = dateTimeGMT;
        this.squad = squad;
        this.toss_winner_team = toss_winner_team;
        this.winner_team = winner_team;
        this.matchStarted = matchStarted;
    }


    public String getUnique_id() {
        return unique_id;
    }

    public void setUnique_id(String unique_id) {
        this.unique_id = unique_id;
    }

    public String getTeam_2() {
        return team_2;
    }

    public void setTeam_2(String team_2) {
        this.team_2 = team_2;
    }

    public String getTeam_1() {
        return team_1;
    }

    public void setTeam_1(String team_1) {
        this.team_1 = team_1;
    }

    public String getMatchType() {
        return matchType;
    }

    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }

    public String getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(String matchDate) {
        this.matchDate = matchDate;
    }

    public String getDateTimeGMT() {
        return dateTimeGMT;
    }

    public void setDateTimeGMT(String dateTimeGMT) {
        this.dateTimeGMT = dateTimeGMT;
    }

    public String getSquad() {
        return squad;
    }

    public void setSquad(String squad) {
        this.squad = squad;
    }

    public String getToss_winner_team() {
        return toss_winner_team;
    }

    public void setToss_winner_team(String toss_winner_team) {
        this.toss_winner_team = toss_winner_team;
    }

    public String getWinner_team() {
        return winner_team;
    }

    public void setWinner_team(String winner_team) {
        this.winner_team = winner_team;
    }

    public String getMatchStarted() {
        return matchStarted;
    }

    public void setMatchStarted(String matchStarted) {
        this.matchStarted = matchStarted;
    }
}
