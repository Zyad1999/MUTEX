package org.ieeezsb.recommended;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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

    public Adapter(List<UserModel> modelList) {
        this.modelList = modelList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recommended, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        UserModel model = modelList.get(position);
        holder.txtName.setText(model.getfName() + " " + model.getlName());
        holder.txtFaculty.setText(model.getBio());
        Picasso.get().load(model.getProfilePicLink()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView txtName, txtFaculty;
        public CircularImageView img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txt_name);
            txtFaculty = itemView.findViewById(R.id.txt_faculty);
            img = itemView.findViewById(R.id.cir_img);
        }
    }
}
