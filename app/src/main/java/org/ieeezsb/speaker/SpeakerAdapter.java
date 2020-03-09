package org.ieeezsb.speaker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.ieeezsb.R;

import java.util.ArrayList;

public class SpeakerAdapter extends RecyclerView.Adapter<SpeakerAdapter.ViewHolder> {


    private Speaker currentSpeaker;
    private Context context;
    private ArrayList<Speaker> speakersList;


    public SpeakerAdapter(Context context, ArrayList<Speaker> speakersList) {
        this.context = context;
        this.speakersList = speakersList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(
                R.layout.speakers_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        currentSpeaker = speakersList.get(position);
        holder.speakerImage.setImageResource(currentSpeaker.getImageResource());
        holder.speakerName.setText(currentSpeaker.getName());
        holder.speakerDescription.setText(currentSpeaker.getDescription());

        initSocialMedia(holder);

    }

    private void initSocialMedia(ViewHolder holder) {
        ArrayList<ImageButton> emptySocialMedia = new ArrayList<>();
        emptySocialMedia.add(holder.social1);
        emptySocialMedia.add(holder.social2);
        emptySocialMedia.add(holder.social3);
        emptySocialMedia.add(holder.social4);

        emptySocialMedia.get(0).setVisibility(View.GONE);
        emptySocialMedia.get(1).setVisibility(View.GONE);
        emptySocialMedia.get(2).setVisibility(View.GONE);
        emptySocialMedia.get(3).setVisibility(View.GONE);


        if (currentSpeaker.getFacebookLink() != null) {
            emptySocialMedia.get(0).setVisibility(View.VISIBLE);
            emptySocialMedia.get(0).setImageResource(R.drawable.ic_facebook);
            emptySocialMedia.get(0).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // TODO : Facebook intent
                    Toast.makeText(context, "Facebook", Toast.LENGTH_SHORT).show();
                }
            });
            emptySocialMedia.remove(0);
        }
        if (currentSpeaker.getTwitterLink() != null) {
            emptySocialMedia.get(0).setVisibility(View.VISIBLE);
            emptySocialMedia.get(0).setImageResource(R.drawable.ic_twitter);
            emptySocialMedia.get(0).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // TODO : Twitter intent
                    Toast.makeText(context, "Twitter", Toast.LENGTH_SHORT).show();
                }
            });
            emptySocialMedia.remove(0);
        }
        if (currentSpeaker.getLinkedinLink() != null) {
            emptySocialMedia.get(0).setVisibility(View.VISIBLE);
            emptySocialMedia.get(0).setImageResource(R.drawable.ic_linkedin);
            emptySocialMedia.get(0).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // TODO : Linked in intent
                    Toast.makeText(context, "Linked in", Toast.LENGTH_SHORT).show();
                }
            });
            emptySocialMedia.remove(0);
        }
        if (currentSpeaker.getGithubLink() != null) {
            emptySocialMedia.get(0).setVisibility(View.VISIBLE);
            emptySocialMedia.get(0).setImageResource(R.drawable.ic_github);
            emptySocialMedia.get(0).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // TODO : Github intent
                    Toast.makeText(context, "Github", Toast.LENGTH_SHORT).show();
                }
            });
            emptySocialMedia.remove(0);
        }

        if (!emptySocialMedia.isEmpty()) {
            emptySocialMedia.clear();
        }

    }

    @Override
    public int getItemCount() {
        return speakersList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView speakerName, speakerDescription;
        ImageView speakerImage;
        ImageButton social1, social2, social3, social4;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            speakerImage = itemView.findViewById(R.id.user_image);
            speakerName = itemView.findViewById(R.id.user_name);
            speakerDescription = itemView.findViewById(R.id.user_description);
            social1 = itemView.findViewById(R.id.social_media_1);
            social2 = itemView.findViewById(R.id.social_media_2);
            social3 = itemView.findViewById(R.id.social_media_3);
            social4 = itemView.findViewById(R.id.social_media_4);


        }
    }

}
