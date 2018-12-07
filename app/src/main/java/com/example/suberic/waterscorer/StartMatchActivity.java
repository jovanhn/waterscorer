package com.example.suberic.waterscorer;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.suberic.waterscorer.helpers.MatchResult;

public class StartMatchActivity extends AppCompatActivity {

    private static String team_a_name = "";
    private static String team_b_name = "";
    private static final String TAG = "StartMatchActivity";

    private static int scoreTeamA = 0;
    private static int scoreTeamB = 0;
    private static int foulsTeamA = 0;
    private static int foulsTeamB = 0;
    private static MatchResult mMatchResult = new MatchResult();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_match);

        TextView textViewTeamAName = findViewById(R.id.team_a_name);
        TextView textViewTeamBName = findViewById(R.id.team_b_name);

        Intent intent =  getIntent();

        textViewTeamAName.setText(intent.getStringExtra(MainActivity.TEAM_A));
        textViewTeamBName.setText(intent.getStringExtra(MainActivity.TEAM_B));

    }

    public void plusScoreTeamA(View view) {
        scoreTeamA++;
        mMatchResult.teamScored(1);
        TextView textView = findViewById(R.id.team_a_score);
        textView.setText(scoreTeamA+"");

    }
    public void plusScoreTeamB(View view) {
        scoreTeamB++;
        mMatchResult.teamScored(2);
        TextView textView = findViewById(R.id.team_b_score);
        textView.setText(scoreTeamB+"");

    }
    public void plusFoulsTeamA(View view) {
        foulsTeamA++;
        mMatchResult.teamFoul(1);
        TextView textView = findViewById(R.id.team_a_fouls);
        textView.setText(foulsTeamA+"");

    }
    public void plusFoulsTeamB(View view) {
        foulsTeamB++;
        mMatchResult.teamFoul(2);
        TextView textView = findViewById(R.id.team_b_fouls);
        textView.setText(foulsTeamB+"");

    }

    public void minusScoreTeamA(View view) {
        if(scoreTeamA > 0) {
            scoreTeamA--;
            mMatchResult.removeGoalTeam(1);
        }
        TextView textView = findViewById(R.id.team_a_score);
        textView.setText(scoreTeamA+"");

    }
    public void minusScoreTeamB(View view) {
        if(scoreTeamB > 0) {
            scoreTeamB--;
            mMatchResult.removeGoalTeam(2);
        }
        TextView textView = findViewById(R.id.team_b_score);
        textView.setText(scoreTeamB+"");

    }
    public void minusFoulsTeamA(View view) {
        if(foulsTeamA > 0) {
            foulsTeamA--;
            mMatchResult.removeFoulTeam(1);
        }
        TextView textView = findViewById(R.id.team_a_fouls);
        textView.setText(foulsTeamA+"");

    }
    public void minusFoulsTeamB(View view) {
        if(foulsTeamB > 0) {
            foulsTeamB--;
            mMatchResult.removeFoulTeam(2);
        }
        TextView textView = findViewById(R.id.team_b_fouls);
        textView.setText(foulsTeamB+"");
    }

    public void endMatch(View view) {
        Context context = getApplicationContext();
        CharSequence text = "Match ended!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        Intent intent = new Intent(this, ShowScoreActivity.class);
        Bundle extras = new Bundle();

        extras.putSerializable("MATCH_RESULT", mMatchResult);

        intent.putExtras(extras);
        startActivity(intent);
    }
}
