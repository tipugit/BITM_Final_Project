package com.example.tourmate;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class TripsFragment extends Fragment {

    private RecyclerView recyclerView;
    private TripAdapter adapter;
    private ArrayList<Trip> trips = new ArrayList<>();
    private TextView profileName;
    private DatabaseReference databaseReference;
    private String id = "Bangladesh";



    public TripsFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_trips, container, false);




        init(view);
        setAdapter();
        addTrips();

        getData();




        return view;
    }



    private void getData() {


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {




                String name = dataSnapshot.getValue().toString();



                profileName.setText(id);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }


    private void addTrips() {

        trips.add(new Trip("Sajek Tour","18-09-2019","This Trip Was very Enjoyfull.",R.drawable.sajek));
        trips.add(new Trip("Cox-Bazar","03-05-2018","This Trip Was very Enjoyfull.",R.drawable.cox_bazar));
        trips.add(new Trip("Nilgiri-BandarBan","11-05-2017","This Trip Was very Enjoyfull.",R.drawable.nilgiri));
        trips.add(new Trip("Jaflong_Sylhet","20-02-2016","This Trip Was very Enjoyfull.",R.drawable.jaflong));


    }

    private void setAdapter() {



        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);


    }



    private void init(View view) {

        recyclerView = view.findViewById(R.id.RvId);
        adapter = new TripAdapter(trips,getActivity());
        profileName = view.findViewById(R.id.profileNameTvId);




        databaseReference= FirebaseDatabase.getInstance().getReference().child("name");



    }





}
