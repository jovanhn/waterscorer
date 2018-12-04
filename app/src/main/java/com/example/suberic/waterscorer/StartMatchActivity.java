package com.example.suberic.waterscorer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class StartMatchActivity extends AppCompatActivity {

    private static String team_a_name = "";
    private static String team_b_name = "";
    private static final String TAG = "StartMatchActivity";


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
}
