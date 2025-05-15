package com.example.a100daysofpushup.leaderboard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.a100daysofpushup.R;
import java.util.List;

public class LeaderboardAdapter extends RecyclerView.Adapter<LeaderboardAdapter.LeaderboardViewHolder> {

    private List<LeaderboardUser> leaderboardUserList;

    public LeaderboardAdapter(List<LeaderboardUser> leaderboardUserList) {
        this.leaderboardUserList = leaderboardUserList;
    }

    @Override
    public LeaderboardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.leaderboard_item, parent, false);
        return new LeaderboardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(LeaderboardViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return leaderboardUserList.size();
    }

    public static class LeaderboardViewHolder extends RecyclerView.ViewHolder {
        public TextView usernameTextView;
        public TextView pushupCountTextView;


    }
}