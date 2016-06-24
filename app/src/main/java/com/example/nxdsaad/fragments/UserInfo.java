package com.example.nxdsaad.fragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class UserInfo extends Fragment {

    private EditText name, email;
    private Button switchFragment;
    private String userName, userEmail;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.userinfo, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        name = (EditText) getActivity().findViewById(R.id.name);
        email = (EditText) getActivity().findViewById(R.id.email);
        switchFragment = (Button) getActivity().findViewById(R.id.nextFrag);


        switchFragment.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                userName = name.getText().toString();
                userEmail = email.getText().toString();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager
                        .beginTransaction().replace(R.id.display, new ShowData(userName, userEmail))
                        .addToBackStack("F2")
                        .commit();
            }
        });
    }

}
