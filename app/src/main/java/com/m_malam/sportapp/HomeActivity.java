package com.m_malam.sportapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    private Button viewSessionsButton, addParticipantButton, logoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        viewSessionsButton = findViewById(R.id.viewSessionsButton);
        addParticipantButton = findViewById(R.id.addParticipantButton);
        logoutButton = findViewById(R.id.logoutButton);

        viewSessionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, SessionsActivity.class);
                startActivity(intent);
            }
        });

        addParticipantButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, AddParticipantActivity.class);
                startActivity(intent);
            }
        });

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(intent);
                finish(); // Close the current activity
            }
        });
    }
}
