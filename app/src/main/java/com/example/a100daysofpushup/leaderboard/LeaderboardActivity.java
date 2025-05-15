package com.example.a100daysofpushup.leaderboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.a100daysofpushup.R;
import com.example.a100daysofpushup.leaderboard.LeaderboardAdapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;
public class LeaderboardActivity extends AppCompatActivity {

    private RecyclerView leaderboardRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);

        leaderboardRecyclerView = findViewById(R.id.leaderboard_recycler_view);
        leaderboardRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize adapter with an empty list
 leaderboardRecyclerView.setAdapter(new LeaderboardAdapter(new ArrayList<LeaderboardUser>()));

        // Fetch leaderboard data from the Google Sheet
 new FetchLeaderboardTask(this).execute(webAppUrl);
    }

    private void fetchLeaderboardData() {
        // Use the provided Google Apps Script web app URL
    }

    private static class FetchLeaderboardTask extends AsyncTask<String, Void, List<LeaderboardUser>> {
        // Make this a WeakReference to the Activity to avoid memory leaks
        private WeakReference<LeaderboardActivity> activityReference;
        @Override
        protected List<LeaderboardUser> doInBackground(String... urls) {
            String webAppUrl = urls[0];
            try {
                URL url = new URL(webAppUrl);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");

                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                List<LeaderboardUser> topUsers = new ArrayList<>();
                if (response.length() > 0) {
                    try {
                        JSONArray jsonArray = new JSONArray(response.toString());
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            String username = jsonObject.getString("username");
                            int pushupCount = jsonObject.getInt("pushupCount");
                            topUsers.add(new LeaderboardUser(username, pushupCount));
                        }

                        // Sort the users by pushup count in descending order
                        Collections.sort(topUsers, (user1, user2) -> Integer.compare(user2.pushupCount, user1.pushupCount));

                        // Take the top 10 users
                        if (topUsers.size() > 10) {
                            topUsers = topUsers.subList(0, 10);
                        }

                    } catch (JSONException e) {
                        Log.e("LeaderboardActivity", "Error parsing JSON: " + e.getMessage());
                        return null; // Indicate an error
                    }
                }
            } catch (IOException | JSONException e) {
                Log.e("LeaderboardActivity", "Error fetching leaderboard data: " + e.getMessage());
                return null; // Indicate an error
            }
            return topUsers;
        }

 @Override
 protected void onPostExecute(List<LeaderboardUser> topUsers) {
 LeaderboardActivity activity = activityReference.get();
 if (activity == null || activity.isFinishing()) {
 return; // Activity is no longer valid
 }

 if (topUsers != null) {
 // Assuming you have an updateData method in your LeaderboardAdapter
 // (You'll need to add this method if you haven't already)
 activity.leaderboardRecyclerView.setAdapter(new LeaderboardAdapter(topUsers));
 } else {
 // Handle the case where fetching or parsing data failed
                }
            }
        }.execute();
    }
}