package project.himanshu.com.cricketapp;

import java.io.Serializable;

public class PlayerScore implements Serializable {


    String batsman;
    String dismissal_info;
    String r;
    String b;

    public PlayerScore(String batsman, String dismissal_info, String r, String b) {
        this.batsman = batsman;
        this.dismissal_info = dismissal_info;
        this.r = r;
        this.b = b;
    }

    public String getBatsman() {
        return batsman;
    }

    public void setBatsman(String batsman) {
        this.batsman = batsman;
    }

    public String getDismissal_info() {
        return dismissal_info;
    }

    public void setDismissal_info(String dismissal_info) {
        this.dismissal_info = dismissal_info;
    }

    public String getR() {
        return r;
    }

    public void setR(String r) {
        this.r = r;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }
}
