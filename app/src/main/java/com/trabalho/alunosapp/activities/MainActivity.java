package com.trabalho.alunosapp.activities;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MaterialButton buttonEnviar = findViewById(R.id.buttonEntrar);
        buttonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextInputEditText textInputUsuario = findViewById(R.id.user);
                TextInputEditText textInputSenha = findViewById(R.id.password);
                String nome = textInputUsuario.getText().toString();
                String senha = textInputSenha.getText().toString();
                if(nome.isEmpty() || senha.isEmpty()){
                    alert("Insira um usuário ou uma senha válida.");
                }else if(nome.equals("1") && senha.equals("1")) {
                    Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                    startActivity(intent);
                }else{
                    alert("Usuário ou senha inválido(s).");
                }
            }
        });
    }
    public void alert(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
