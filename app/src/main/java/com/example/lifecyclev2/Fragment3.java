package com.example.lifecyclev2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Fragment3 extends Fragment {

    View view;
    Button formBtn, aboutBtn, logoutBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_3, container, false);


        formBtn = view.findViewById(R.id.formBtn);
        aboutBtn = view.findViewById(R.id.aboutBtn);
        logoutBtn = view.findViewById(R.id.logOutBtn);

        formBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new Fragment2());
            }
        });

        aboutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new Fragment4());
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