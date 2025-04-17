package com.m_malam.sportapp;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import androidx.appcompat.app.AppCompatActivity;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lvSessions = findViewById(R.id.lvSessions);

        String jsonString = "{\n" +
                "  \"Sessions\": [\n" +
                "    {\n" +
                "      \"session_id\": 123456,\n" +
                "      \"sport\": \"basketball\",\n" +
                "      \"gym\": \"Gym 1\",\n" +
                "      \"start_time\": 1742943570,\n" +
                "      \"participants\": [\n" +
                "        {\"first_name\":\"Mike\",\"last_name\":\"Smith\",\"phone_number\":\"226 678 5493\",\"member_number\":98765,\"session_id\":123456},\n" +
                "        {\"first_name\":\"Kira\",\"last_name\":\"Mallony\",\"phone_number\":\"519 468 7495\",\"member_number\":16578,\"session_id\":123456},\n" +
                "        {\"first_name\":\"Holly\",\"last_name\":\"Plainer\",\"phone_number\":\"519 785 6542\",\"member_number\":65932,\"session_id\":123456}\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"session_id\": 65432,\n" +
                "      \"sport\": \"dodgeball\",\n" +
                "      \"gym\": \"Gym 3\",\n" +
                "      \"start_time\": 1742943570,\n" +
                "      \"participants\": [\n" +
                "        {\"first_name\":\"Blake\",\"last_name\":\"Danver\",\"phone_number\":\"226 678 5493\",\"member_number\":45269,\"session_id\":65432},\n" +
                "        {\"first_name\":\"Harold\",\"last_name\":\"Romy\",\"phone_number\":\"519 468 7495\",\"member_number\":32657,\"session_id\":65432},\n" +
                "        {\"first_name\":\"James\",\"last_name\":\"Flats\",\"phone_number\":\"519 785 6542\",\"member_number\":05697,\"session_id\":65432}\n" +
                "      ]\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        // Parse JSON string
        List<Session> sessions = parseSessions(jsonString);

        // Set up adapter for ListView
        ArrayAdapter<Session> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sessions);
        lvSessions.setAdapter(adapter);
    }

    private List<Session> parseSessions(String jsonString) {
        List<Session> sessions = new ArrayList<>();
        Gson gson = new Gson();

        // Convert JSON string to JsonObject
        JsonObject jsonObject = gson.fromJson(jsonString, JsonObject.class);

        // Get the "Sessions" array from the JSON object
        JsonArray jsonArray = jsonObject.getAsJsonArray("Sessions");

        // Iterate through the array and parse each session
        for (JsonElement element : jsonArray) {
            Session session = gson.fromJson(element, Session.class);
            sessions.add(session);
        }

        return sessions;
    }
}
