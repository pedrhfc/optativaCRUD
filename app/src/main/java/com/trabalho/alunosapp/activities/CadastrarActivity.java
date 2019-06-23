package com.trabalho.alunosapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.TextView;

public class CadastrarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("alunapp");
        setContentView(R.layout.activity_cadastrar);

        Toolbar toolbar = findViewById(R.id.nav_toolbar);
        TextView textView = findViewById(R.id.toolbar_title);
        setSupportActionBar(toolbar);
        textView.setText(toolbar.getTitle());
        textView.setTextColor(0xFFFFFFFF);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }
}
