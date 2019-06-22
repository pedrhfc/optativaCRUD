package com.trabalho.alunosapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.transition.Explode;
import android.util.Log;
import android.view.Window;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        final TabLayout tabs = findViewById(R.id.tabs);
        final AppBarLayout appBar = findViewById(R.id.appbar);
        tabs.addTab(tabs.newTab().setText("Cad."));
        tabs.addTab(tabs.newTab().setText("List."));
        tabs.addTab(tabs.newTab().setText("Atual."));
        tabs.addTab(tabs.newTab().setText("Rem."));
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch(tabs.getSelectedTabPosition()){
                    case 0:
                        Log.i("teste",tabs.getTabAt(0).getText().toString());
                        break;
                    case 1:
                        Log.i("teste",tabs.getTabAt(1).getText().toString());
                        break;
                    case 2:
                        Log.i("teste",tabs.getTabAt(2).getText().toString());
                        break;
                    case 3:
                        Log.i("teste",tabs.getTabAt(3).getText().toString());
                        break;
                    default:

                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}
