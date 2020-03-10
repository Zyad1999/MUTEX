package org.ieeezsb.recommended;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.ieeezsb.R;
import org.ieeezsb.Registration.UserModel;
import org.ieeezsb.speaker.Speaker;

import java.util.ArrayList;

public class RecommendationAdapter extends RecyclerView.Adapter<RecommendationAdapter.ViewHolder> {

    private UserModel currentUser;
    private Context context;
    private ArrayList<UserModel> recommendedUser;


    public RecommendationAdapter(Context context, ArrayList<UserModel> recommendedUser) {
        this.context = context;
        this.recommendedUser = recommendedUser;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(
                R.layout.recommendation_item, parent, false);
        return new ViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        currentUser = recommendedUser.get(position);
        holder.userName.setText(currentUser.getfName() + " " + currentUser.getlName());
        holder.userDescription.setText(currentUser.getBio());
        Picasso.get().load(currentUser.getProfilePicLink()).into(holder.userImage);
    }



    @Override
    public int getItemCount() {
        return recommendedUser.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView userName, userDescription;
        ImageView userImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userImage = itemView.findViewById(R.id.user_image);
            userName = itemView.findViewById(R.id.user_name);
            userDescription = itemView.findViewById(R.id.user_description);
        }
    }

}
