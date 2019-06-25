package com.trabalho.alunosapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.trabalho.alunosapp.tools.DatabaseHelper;

public class EditarActivity extends AppCompatActivity {
    DatabaseHelper db;
    MaterialButton button;
    TextView textView,textViewId,textViewNome,textViewEmail;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("alunapp");
        setContentView(R.layout.activity_editar);
        toolbar = findViewById(R.id.nav_toolbar);
        textView = findViewById(R.id.toolbar_title);
        button = findViewById(R.id.buttonEditar);
        textViewId = findViewById(R.id.id);
        textViewNome = findViewById(R.id.nome);
        textViewEmail = findViewById(R.id.email);
        db = new DatabaseHelper(this);
        setSupportActionBar(toolbar);
        textView.setText(toolbar.getTitle());
        textView.setTextColor(0xFFFFFFFF);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        showAluno();
    }

    public void onButtonClick(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = textViewId.getText().toString();
                String nome = textViewNome.getText().toString();
                String email = textViewEmail.getText().toString();

                boolean update = db.update(id, nome, email);

                if (update)
                    alert("Aluno atualizado com sucesso!");
                else
                    alert("Não foi possível atualizar aluno.");
                finish();
            }
        });
    }

    public void alert(String alert) {
        Toast.makeText(EditarActivity.this, alert, Toast.LENGTH_SHORT).show();
    }

    public void showAluno() {
        Cursor data = db.findAll();
        if (data.getCount() == 0) {
            alert("Nenhum usuário encontrado.");
            finish();
        } else
            onButtonClick();
    }
}
