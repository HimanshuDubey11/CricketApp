package project.himanshu.com.cricketapp;

import android.app.ProgressDialog;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.StaticLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Home extends AppCompatActivity {

    RelativeLayout relativeLayout;
    RequestQueue requestQueue;
    ArrayList<TypeODI> odiMatches = new ArrayList<TypeODI>();
    ArrayList<TypeT20> t20Matches = new ArrayList<TypeT20>();
    ArrayList<TypeTest> testMatches =new ArrayList<TypeTest>();
    ArrayList<TypeAll> allMatches = new ArrayList<TypeAll>();
    String url = "http://cricapi.com/api/matches/ob242roZWFSsuZkkdNjjCUFefms1";
    ProgressDialog dialog;
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        relativeLayout = findViewById(R.id.homerelative);
        relativeLayout.setEnabled(false);
        dialog = new ProgressDialog(Home.this);
        dialog.setMessage("Loading...");

        requestQueue = Volley.newRequestQueue(Home.this);
        dialog.show();

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                odiMatches = new ArrayList<TypeODI>();
                t20Matches = new ArrayList<TypeT20>();
                testMatches = new ArrayList<TypeTest>();
                allMatches = new ArrayList<TypeAll>();

                try {
                    JSONArray array = response.getJSONArray("matches");

                    for (int i = 0; i < array.length() ; i++) {

                        JSONObject obj = array.getJSONObject(i);

                        String unique_id =obj.getString("unique_id");
                        String team_2 =obj.getString("team-2");
                        String team_1 =obj.getString("team-1");
                        String matchType =obj.getString("type");
                        String matchDate =obj.getString("date");
                        String dateTimeGMT =/*obj.getString("dateTimeGMT")*/" ";
                        String squad =/*obj.getString("squad")*/ " ";
                        String toss_winner_team =/*obj.getString("toss_winner")*/ " ";
                        String winner_team =/*obj.getString("winner_team")*/ " ";
                        String matchStarted =obj.getString("matchStarted");

//                        if(team_1.equals("India")||team_2.equals("India")
//                                ||team_1.equals("Australia")||team_2.equals("Australia")
//                                ||team_1.equals("Pakistan")||team_2.equals("Pakistan")
//                                ||team_1.equals("Bangladesh")||team_2.equals("Bangladesh")
//                                ||team_1.equals("England")||team_2.equals("England")
//                                ||team_1.equals("South Africa")||team_2.equals("South Africa")
//                                ||team_1.equals("Sri Lanka")||team_2.equals("Sri Lanka")
//                                ||team_1.equals("West Indies")||team_2.equals("West Indies")
//                                ||team_1.equals("New Zealand")||team_2.equals("New Zealand")) {
//
//                            if(matchType.equals("Twenty20")||matchType.equals("WomensT20I")||matchType.equals("T20I")) {
//
//                                TypeT20 t20 = new TypeT20(unique_id,team_2,team_1,matchType,matchDate,dateTimeGMT,squad,toss_winner_team,winner_team,matchStarted);
//                                t20Matches.add(t20);
//
//                            }
//
//                            if(matchType.equals("Test")) {
//
//                                TypeTest test = new TypeTest(unique_id,team_2,team_1,matchType,matchDate,dateTimeGMT,squad,toss_winner_team,winner_team,matchStarted);
//                                testMatches.add(test);
//
//                            }
//
//                            if(matchType.equals("ODI")||matchType.equals("WomensODI")) {
//
//                                TypeODI odi = new TypeODI(unique_id,team_2,team_1,matchType,matchDate,dateTimeGMT,squad,toss_winner_team,winner_team,matchStarted);
//                                odiMatches.add(odi);
//
//                            }
//
//                            TypeAll all = new TypeAll(unique_id, team_2, team_1, matchType, matchDate, dateTimeGMT, squad, toss_winner_team, winner_team, matchStarted);
//                            allMatches.add(all);
//
//                        }


                        TypeAll all = new TypeAll(unique_id, team_2, team_1, matchType, matchDate, dateTimeGMT, squad, toss_winner_team, winner_team, matchStarted);
                            allMatches.add(all);
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue.add(request);


        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {


                dialog.dismiss();
                relativeLayout.setEnabled(true);

                tabLayout = findViewById(R.id.hometablayout);
                tabLayout.setupWithViewPager(viewPager);

                viewPager = findViewById(R.id.homeviewpager);
                viewPager.setAdapter(new MyViewPagerAdapter(getSupportFragmentManager(),Home.this,allMatches));

                tabLayout.addTab(tabLayout.newTab().setText("Live Matches"));
                tabLayout.addTab(tabLayout.newTab().setText("Schedule"));

                tabLayout.setupWithViewPager(viewPager);

            }
        },3000);




    }
}
