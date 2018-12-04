package com.example.suberic.waterscorer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String TEAM_A = "com.example.waterscorer.TEAM_A";
    public static final String TEAM_B = "com.example.waterscorer.TEAM_B";

    public static String team_a = "TeamA";
    public static String team_b = "TeamB";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onStartMatch(View view) {
        Intent intent =  new Intent(this, StartMatchActivity.class);
        EditText editTextTeamA = (EditText) findViewById(R.id.team_a);
        String team_a = editTextTeamA.getText().toString();
        EditText editTextTeamB = (EditText) findViewById(R.id.team_b);
        String team_b = editTextTeamB.getText().toString();

        intent.putExtra(TEAM_A, team_a);
        intent.putExtra(TEAM_B, team_b);

        startActivity(intent);
    }
}
