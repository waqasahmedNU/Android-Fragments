package com.example.nxdsaad.fragments;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


@SuppressLint("ValidFragment")
public class ShowData extends Fragment {

    String name,email;
    private EditText sName, sEmail;

    @SuppressLint("ValidFragment")
    public ShowData(String name,String email) {
        this.name = name;
        this.email = email;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.showdata, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        sName= (EditText) getActivity().findViewById(R.id.sName);
        sEmail = (EditText) getActivity().findViewById(R.id.sEmail);

        sName.setText(name);
        sEmail.setText(email);
        super.onActivityCreated(savedInstanceState);
    }
}
