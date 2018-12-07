package com.example.suberic.waterscorer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.suberic.waterscorer.helpers.MatchResult;

public class ShowScoreActivity extends AppCompatActivity {

    private static final String TAG = "ShowScoreActivity";
    private MatchResult mMatchResult = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_score);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        mMatchResult = (MatchResult) bundle.getSerializable("MATCH_RESULT");
        displayValues();
    }

    public void startNewMatch(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void displayValues() {
        TextView scoreTeamA = findViewById(R.id.team_a_score);
        TextView scoreTeamB = findViewById(R.id.team_b_score);
        TextView foulsTeamA = findViewById(R.id.team_a_fouls);
        TextView foulsTeamB = findViewById(R.id.team_b_fouls);

        scoreTeamA.setText(mMatchResult.getScoreTeamA()+"");
        scoreTeamB.setText(mMatchResult.getScoreTeamB()+"");
        foulsTeamA.setText(mMatchResult.getFoulsTeamA()+"");
        foulsTeamB.setText(mMatchResult.getFoulsTeamB()+"");
    }
}
