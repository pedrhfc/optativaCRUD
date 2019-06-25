package com.trabalho.alunosapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.trabalho.alunosapp.tools.DatabaseHelper;

public class RemoverActivity extends AppCompatActivity {
    MaterialButton buttonRemover;
    DatabaseHelper db;
    TextInputEditText editTextId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("alunapp");
        setContentView(R.layout.activity_remover);
        buttonRemover = findViewById(R.id.buttonRemover);
        editTextId = findViewById(R.id.id);
        Toolbar toolbar = findViewById(R.id.nav_toolbar);
        TextView textView = findViewById(R.id.toolbar_title);
        db = new DatabaseHelper(this);
        setSupportActionBar(toolbar);
        textView.setText(toolbar.getTitle());
        textView.setTextColor(0xFFFFFFFF);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        onButtonClick();
    }

    public void onButtonClick(){
    buttonRemover.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int id = editTextId.getText().toString().length();
            if(id > 0){
                Integer deleteRow = db.delete(editTextId.getText().toString());
                if(deleteRow > 0) {
                    alert("Aluno removido com sucesso!");
                    finish();
                }
                else
                    alert("Não foi possível remover aluno.");
            }else
                alert("");
        }
    });
    }
    public void alert(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
