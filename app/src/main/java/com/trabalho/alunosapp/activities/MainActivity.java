package com.trabalho.alunosapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
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
        final CheckBox checkBox = findViewById(R.id.checkBox);
        buttonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextInputEditText textInputUsuario = findViewById(R.id.user);
                TextInputEditText textInputSenha = findViewById(R.id.password);
                String nome = textInputUsuario.getText().toString();
                String senha = textInputSenha.getText().toString();
                checkBox.setChecked(false);
                if(nome.isEmpty() || senha.isEmpty()){
                    alert("Campo vazio. Preencha todos os campos.");
                }else if(nome.equals("1") && senha.equals("1")) {
                    Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                    startActivity(intent);
                    textInputUsuario.setText("");
                    textInputSenha.setText("");
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
