package org.ieeezsb.agenda;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import org.ieeezsb.R;

import java.util.ArrayList;

public class AgendaAdapter extends ArrayAdapter<TalkData> {

    public AgendaAdapter(Activity context, ArrayList<TalkData> words) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, words);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.agenda_object, parent, false);
        }


        TalkData currentAndroidFlavor = getItem(position);


        TextView talkTextView = listItemView.findViewById(R.id.talk);
        assert currentAndroidFlavor != null;
        talkTextView.setText(currentAndroidFlavor.getTalk());

        TextView speakerTextView =  listItemView.findViewById(R.id.speaker);

        if (currentAndroidFlavor.getSpeaker().equals("None"))
            speakerTextView.setVisibility(View.GONE);
        else {
            speakerTextView.setVisibility(View.VISIBLE);
            speakerTextView.setText(currentAndroidFlavor.getSpeaker());
        }


        TextView timeTextView =  listItemView.findViewById(R.id.time);
        timeTextView.setText(currentAndroidFlavor.getTime());

        ImageView image= listItemView.findViewById(R.id.speaker_img);
        image.setImageResource(currentAndroidFlavor.getImage());


        return listItemView;
    }
}

