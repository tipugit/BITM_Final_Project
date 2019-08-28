package com.example.tourmate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TripAdapter extends RecyclerView.Adapter<TripAdapter.ViewHolder> {

    private ArrayList<Trip> trips = new ArrayList<>();
    Context context;

    public TripAdapter(ArrayList<Trip> trips, Context context) {
        this.trips = trips;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.trip_design,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Trip trip = trips.get(position);


        holder.tripTittleTv.setText(trip.getTripName());
        holder.tripDateTv.setText(trip.getTripDate());
        holder.tripImageIv.setImageResource(trip.getTripImage());

    }

    @Override
    public int getItemCount() {
        return trips.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tripTittleTv,tripDateTv;
        private ImageView tripImageIv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tripTittleTv = itemView.findViewById(R.id.tripTittleTvId);
            tripDateTv   = itemView.findViewById(R.id.tripDateTvId);
            tripImageIv  = itemView.findViewById(R.id.tripImageIv);


        }
    }
}
