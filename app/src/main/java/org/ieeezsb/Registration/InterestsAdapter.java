package org.ieeezsb.Registration;

import android.content.Context;
import android.graphics.Color;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.ieeezsb.Common;
import org.ieeezsb.R;
import org.ieeezsb.speaker.SpeakerAdapter;

import java.util.ArrayList;


public class InterestsAdapter extends RecyclerView.Adapter<InterestsAdapter.ViewHolder> {

    public interface ChangeStatusListener{
        void onItemChangeListener(int position, InterestsModel model);
    }

    private Context context;
    private ArrayList<InterestsModel> interestsList;
    private ChangeStatusListener changeStatusListener;

    public InterestsAdapter(Context context, ArrayList<InterestsModel> interestsList, ChangeStatusListener changeStatusListener) {
        this.context = context;
        this.interestsList = interestsList;
        this.changeStatusListener = changeStatusListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.interests_item, parent, false);
        return new InterestsAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder,final int position) {

        InterestsModel interestsModel = interestsList.get(position);
        if (interestsModel != null){
            holder.text.setText(interestsModel.getText());
            holder.position = position;

            if(interestsModel.isSelect()){
                holder.view.setBackgroundColor(context.getResources().getColor(R.color.colorAccent));
            }
            else{
                holder.view.setBackgroundColor(context.getResources().getColor(R.color.colorPrimary));
            }

        }

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InterestsModel model1=interestsList.get(position);
                if(model1.isSelect()){
                    model1.setSelect(false);
                }else{
                    model1.setSelect(true);
                }
                interestsList.set(holder.position,model1);
                if(changeStatusListener!=null){
                    changeStatusListener.onItemChangeListener(holder.position,model1);
                }
                notifyItemChanged(holder.position);
            }
        });



    }

    public void setModel(ArrayList<InterestsModel> models){
        this.interestsList=models;
    }


    @Override
    public int getItemCount() {
        return interestsList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{



        public TextView text;
        public View view;
        public int position;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        text = itemView.findViewById(R.id.tvInterest);
        view=itemView;

    }

    }



}
