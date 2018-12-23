package project.himanshu.com.cricketapp;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
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

public class Score extends AppCompatActivity {

    String unique_id;
    RequestQueue requestQueue;
    ProgressDialog dialog;
    TextView scoreboard;
    RecyclerView recyclerView;
    ArrayList<ScoreData> scoreData = new ArrayList<ScoreData>();
    ArrayList<PlayerScore> playerScores = new ArrayList<PlayerScore>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        recyclerView = findViewById(R.id.scorerecyclerview);
        dialog = new ProgressDialog(Score.this);
        dialog.setMessage("Loading...");
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                unique_id = null;
            } else {
                unique_id = extras.getString("unique_id");
            }
        } else {
            unique_id = (String) savedInstanceState.getSerializable("unique_id");
        }

        scoreboard = findViewById(R.id.scoreboard);
        requestQueue = Volley.newRequestQueue(Score.this);
        dialog.show();
        String url = "http://cricapi.com/api/cricketScore/ob242roZWFSsuZkkdNjjCUFefms1";

        JSONObject object = new JSONObject();
        try {
            object.put("unique_id",unique_id);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url,object, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {

                    String score = response.getString("score");
                    String scoreArray[] = score.split("v");
                    scoreboard.setText(scoreArray[0].trim() + "\n" + scoreArray[1].trim());


                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(Score.this, "" + error, Toast.LENGTH_SHORT).show();

            }
        });

        String urlScores = "http://cricapi.com/api/fantasySummary/ob242roZWFSsuZkkdNjjCUFefms1";
        JsonObjectRequest request1 = new JsonObjectRequest(Request.Method.POST, urlScores, object, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    dialog.dismiss();
                    JSONObject dataRequest = response.getJSONObject("data");

                    JSONArray battingArray = dataRequest.getJSONArray("batting");



                    for (int i = 0; i < battingArray.length(); i++) {

                        JSONObject battingObj = battingArray.getJSONObject(i);

                        String title = battingObj.getString("title");

                        JSONArray scores = battingObj.getJSONArray("scores");

                        for (int j = 0; j <scores.length() ; j++) {

                            JSONObject scoresObj = scores.getJSONObject(j);

                            String batsman = scoresObj.getString("batsman");
                            String dismissal_info = scoresObj.getString("dismissal-info");
                            String r = scoresObj.getString("R");
                            String b = scoresObj.getString("B");

                            if(!batsman.equals("Extras")) {
                                PlayerScore playerScore = new PlayerScore(batsman, dismissal_info, r, b);
                                playerScores.add(playerScore);
                            }

                        }

                        ScoreData scoreData1 = new ScoreData(title,playerScores);
                        scoreData.add(scoreData1);

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }


                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager
                        (Score.this,LinearLayoutManager.VERTICAL,false);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(new PlayerAdapter(playerScores));

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


        requestQueue.add(request);
        requestQueue.add(request1);


    }

}
