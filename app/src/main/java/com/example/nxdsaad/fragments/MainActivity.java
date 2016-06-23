package com.example.nxdsaad.fragments;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements ListSelectionListener {

    public static String[] Items;
    public static String[] details;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    private static DetailsFragments1 mDetailsFragment1 = new DetailsFragments1();
    private static DetailsFragments2 mDetailsFragment2 = new DetailsFragments2();
    private static DetailsFragments3 mDetailsFragment3 = new DetailsFragments3();

    @Override
    public void onBackPressed() {
        int fragments = fragmentManager.getBackStackEntryCount();
        if (fragments == 1) {
            finish();
            return;
        } else {
            fragmentManager.popBackStack();
        }
    }

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Items = getResources().getStringArray(R.array.Items);
        details = getResources().getStringArray(R.array.Details);

        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.titles, new ItemFragment());
        fragmentManager
                .beginTransaction().replace(R.id.details, mDetailsFragment1)
                .addToBackStack("F1")
                .commit();
        fragmentTransaction.commit();
    }

    // Called when the user selects an item in the TitlesFragment
    @Override
    public void onListSelection(int index) {
        switch (index) {
            case 0:
                /*if (mDetailsFragment1.getShownIndex() != index) {
                    // Tell the QuoteFragment to show the quote string at position index
                    mDetailsFragment1.showQuoteAtIndex(index);
                }*/
                fragmentManager
                        .beginTransaction().replace(R.id.details, mDetailsFragment1)
                        .addToBackStack("F1")
                        .commit();
                break;
            case 1:
                fragmentManager
                        .beginTransaction().replace(R.id.details, mDetailsFragment2)
                        .addToBackStack("F2")
                        .commit();
                break;
            case 2:
                fragmentManager
                        .beginTransaction().replace(R.id.details, mDetailsFragment3)
                        .addToBackStack("F3")
                        .commit();
                break;
        }
    }
}
