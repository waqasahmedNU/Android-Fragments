package com.example.nxdsaad.fragments;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity{ //implements ListSelectionListener {


    ListView listView;
    private DrawerLayout mDrawerLayout;

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    public static String[] Items;
    public static String[] details;
//    private static DetailsFragments1 mDetailsFragment1 = new DetailsFragments1();
//    private static DetailsFragments2 mDetailsFragment2 = new DetailsFragments2();
//    private static DetailsFragments3 mDetailsFragment3 = new DetailsFragments3();

    private static UserInfo userInfo = new UserInfo();
//    private static ShowData showData = new ShowData();

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

        listView = (ListView) findViewById(R.id.listview);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        String[] temp = {"User Info","Show Data"};

        ListAdapter listAdapter = new ListAdapter(this, temp);
        listView.setAdapter(listAdapter);

        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        fragmentManager
                            .beginTransaction().replace(R.id.display, userInfo)
                            .addToBackStack("F1")
                            .commit();
                        mDrawerLayout.closeDrawers();
                        break;
//                    case 1:
//                        fragmentManager
//                                .beginTransaction().replace(R.id.display, showData)
//                                .addToBackStack("F1")
//                                .commit();
//                        break;
                }
            }
        });


//        Items = getResources().getStringArray(R.array.Items);
//        details = getResources().getStringArray(R.array.Details);

//        fragmentManager = getFragmentManager();
//        fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.add(R.id.titles, new ItemFragment());
//        fragmentManager
//                .beginTransaction().replace(R.id.details, mDetailsFragment1)
//                .addToBackStack("F1")
//                .commit();
//        fragmentTransaction.commit();
    }

    // Called when the user selects an item in the TitlesFragment
//    @Override
//    public void onListSelection(int index) {
//        switch (index) {
//            case 0:
//                /*if (mDetailsFragment1.getShownIndex() != index) {
//                    // Tell the QuoteFragment to show the quote string at position index
//                    mDetailsFragment1.showQuoteAtIndex(index);
//                }*/
//                fragmentManager
//                        .beginTransaction().replace(R.id.details, mDetailsFragment1)
//                        .addToBackStack("F1")
//                        .commit();
//                break;
//            case 1:
//                fragmentManager
//                        .beginTransaction().replace(R.id.details, mDetailsFragment2)
//                        .addToBackStack("F2")
//                        .commit();
//                break;
//            case 2:
//                fragmentManager
//                        .beginTransaction().replace(R.id.details, mDetailsFragment3)
//                        .addToBackStack("F3")
//                        .commit();
//                break;
//        }
//    }

    class ListAdapter extends BaseAdapter{

        Context context;
        String[] list;

        ListAdapter(Context content,String[] item){
            this.context = content;
            this.list = item;
        }

        @Override
        public int getCount() {
            return list.length;
        }

        @Override
        public Object getItem(int position) {
            return list[position];
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View drawer;
            if (convertView == null) {
                LayoutInflater layoutInflater = getLayoutInflater();
                drawer = layoutInflater.inflate(R.layout.listitem, null);
            }else {
                drawer = convertView;
            }
            TextView item = (TextView)drawer.findViewById(R.id.item);
            item.setText(list[position]);

            return drawer;
        }
    }
}
