package com.example.lifecyclev2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Fragment4 extends Fragment {

    View view;
    Button formBtn, contactBtn, logoutBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_4, container, false);

        formBtn = view.findViewById(R.id.formBtn);
        contactBtn = view.findViewById(R.id.contactBtn);
        logoutBtn = view.findViewById(R.id.logOutBtn);

        formBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new Fragment2());
            }
        });

        contactBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new Fragment3());
            }
        });

        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new Fragment1());
            }
        });

        return view;
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }
}