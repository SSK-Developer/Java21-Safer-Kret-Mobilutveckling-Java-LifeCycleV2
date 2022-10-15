package com.example.lifecyclev2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Fragment1 extends Fragment {

    View view;
    Button logInBtn;
    EditText usernameInput;
    EditText passwordInput;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_1, container, false);

        logInBtn = (Button) view.findViewById(R.id.LogInBtn);
        usernameInput = (EditText) view.findViewById(R.id.userName);
        passwordInput = (EditText) view.findViewById(R.id.password);


        logInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = String.valueOf(usernameInput.getText());
                String pass = String.valueOf(passwordInput.getText());
                if(name.equals("admin") && pass.equals("admin")){
                    replaceFragment(new Fragment2());
                }
                else{
                    Toast.makeText(getActivity(), "Invalid username or password", Toast.LENGTH_SHORT).show();
                }
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