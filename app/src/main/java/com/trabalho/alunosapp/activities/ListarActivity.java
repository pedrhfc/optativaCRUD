package com.trabalho.alunosapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.ListViewCompat;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.trabalho.alunosapp.tools.DatabaseHelper;

public class ListarActivity extends AppCompatActivity {
    DatabaseHelper db;
    Toolbar toolbar;
    TabLayout tabLayout;
    TextView textView;

    String[] listArray = {"Android ListView Example","ListVIew Android","Simple Android ListView","ListView in Android","Android ListView Example","ListVIew Android","Simple Android ListView","ListView in Android","Android ListView Example","ListVIew Android","Simple Android ListView","ListView in Android"};
    ListView mlistView;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("alunapp");
        setContentView(R.layout.activity_listar);
        toolbar = findViewById(R.id.nav_toolbar);
        textView = findViewById(R.id.toolbar_title);
        db = new DatabaseHelper(this);
        setSupportActionBar(toolbar);
        textView.setText(toolbar.getTitle());
        textView.setTextColor(0xFFFFFFFF);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        tabInstance();


    }

        public void tabInstance() {
            tabLayout = findViewById(R.id.tab_layout);
            tabLayout.addTab(tabLayout.newTab().setText("SQLITE"));
            tabLayout.addTab(tabLayout.newTab().setText("JSON"));

            tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    switch (tab.getPosition()) {
                        case 0:
                            adapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.listview_row, listArray);
                            mlistView = findViewById(R.id.list);
                            mlistView.setAdapter(adapter);
                            Log.i("teste", "SQLITE");
                            break;
                        case 1:
                            Log.i("teste", "JSON");
                            break;
                    }
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {
                    switch (tab.getPosition()) {
                        case 0:
                            Log.i("teste", "SQLITE");
                            break;
                        case 1:
                            Log.i("teste", "JSON");
                            break;
                    }
                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {
                }
            });
        }
}
