package com.m_malam.sportapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AddParticipantActivity extends AppCompatActivity {

    private EditText firstNameEditText, lastNameEditText, phoneNumberEditText, memberNumberEditText, sessionIdEditText;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_participant);

        firstNameEditText = findViewById(R.id.firstNameEditText);
        lastNameEditText = findViewById(R.id.lastNameEditText);
        phoneNumberEditText = findViewById(R.id.phoneNumberEditText);
        memberNumberEditText = findViewById(R.id.memberNumberEditText);
        sessionIdEditText = findViewById(R.id.sessionIdEditText);
        saveButton = findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName = firstNameEditText.getText().toString();
                String lastName = lastNameEditText.getText().toString();
                String phoneNumber = phoneNumberEditText.getText().toString();
                int memberNumber = Integer.parseInt(memberNumberEditText.getText().toString());
                int sessionId = Integer.parseInt(sessionIdEditText.getText().toString());

                if (firstName.isEmpty() || lastName.isEmpty() || phoneNumber.isEmpty()) {
                    Toast.makeText(AddParticipantActivity.this, "All fields must be filled.", Toast.LENGTH_SHORT).show();
                } else {
                    Participant participant = new Participant(firstName, lastName, phoneNumber, memberNumber, sessionId);
                    Realm realm = Realm.getDefaultInstance();
                    realm.beginTransaction();
                    realm.insertOrUpdate(participant);
                    realm.commitTransaction();

                    Toast.makeText(AddParticipantActivity.this, "Participant Saved", Toast.LENGTH_SHORT).show();
                    finish(); // Close the activity
                }
            }
        });
    }
}
