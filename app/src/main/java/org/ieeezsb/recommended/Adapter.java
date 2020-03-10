package org.ieeezsb.recommended;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Picasso;

import org.ieeezsb.R;
import org.ieeezsb.Registration.UserModel;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    @NonNull
    private List<UserModel> modelList;
    private Context context;
    public Adapter(List<UserModel> modelList , Context context) {
        this.modelList = modelList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recommended, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final UserModel model = modelList.get(position);
        holder.txtName.setText(model.getfName() + " " + model.getlName());
        holder.txtFaculty.setText(model.getBio());
        Picasso.get().load(model.getProfilePicLink()).into(holder.img);
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context , AtendeesDetailsActivity.class);
                i.putExtra("name",model.getfName() + " " + model.getlName());
                i.putExtra("picture",model.getProfilePicLink());
                i.putExtra("bio",model.getBio());
                i.putExtra("facebookLink",model.getFacebookLink());
                i.putExtra("mobileNum",model.getWhatsapp());
                i.putExtra("skills",model.getSkills());
                i.putExtra("interests",model.getInterests());
                context.startActivity(i);

            }
        });
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView txtName, txtFaculty;
        public CircularImageView img;
        RelativeLayout relativeLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txt_name);
            txtFaculty = itemView.findViewById(R.id.txt_faculty);
            img = itemView.findViewById(R.id.cir_img);
            relativeLayout = itemView.findViewById(R.id.relativeL);
        }
    }
}
