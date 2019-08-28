package com.example.tourmate;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;


public class WalletFragment extends Fragment {

    private Button signOutBtn;
    private FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();


    public WalletFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wallet, container, false);


        signOutBtn = view.findViewById(R.id.signOutBtn);
        signOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                firebaseAuth.signOut();
                startActivity(new Intent(getActivity(),LoginActivity.class));
                Toast.makeText(getActivity(), "Signed Out", Toast.LENGTH_SHORT).show();

            }
        });


        return view;
    }

}
