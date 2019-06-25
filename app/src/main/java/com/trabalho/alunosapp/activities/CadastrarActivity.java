package com.trabalho.alunosapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.trabalho.alunosapp.tools.DatabaseHelper;

public class CadastrarActivity extends AppCompatActivity {
    MaterialButton buttonEntrarCadastro;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("alunapp");
        setContentView(R.layout.activity_cadastrar);

        Toolbar toolbar = findViewById(R.id.nav_toolbar);
        TextView textView = findViewById(R.id.toolbar_title);
        buttonEntrarCadastro = findViewById(R.id.buttonEntrarCadastro);
        db = new DatabaseHelper(this);
        setSupportActionBar(toolbar);
        textView.setText(toolbar.getTitle());
        textView.setTextColor(0xFFFFFFFF);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        onButtonClick();
    }

    public void onButtonClick(){
        buttonEntrarCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextInputEditText editTextNome = findViewById(R.id.nome);
                TextInputEditText editTextEmail = findViewById(R.id.email);
                String nome,email;
                nome = editTextNome.getText().toString();
                email = editTextEmail.getText().toString();

                boolean inserirAluno = db.insert(nome,email);
                if(nome.isEmpty() || email.isEmpty()){
                    alert("Campo vazio. Preencha todos os campos.");
                }else{
                    if (inserirAluno) {
                        alert("Aluno cadastrado com sucesso!");
                        finish();
                    }
                    else
                        alert("Não foi possível cadastrar o aluno "+ nome +".");

                }
            }
        });
    }

    public void alert(String msg){
        Toast.makeText(CadastrarActivity.this, msg, Toast.LENGTH_SHORT).show();
    }
}
