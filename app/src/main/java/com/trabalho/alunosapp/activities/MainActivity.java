package com.trabalho.alunosapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.trabalho.alunosapp.tools.KeepLoggedIn;

public class MainActivity extends AppCompatActivity {
    CheckBox checkBox;
    TextInputEditText textInputUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MaterialButton buttonEnviar = findViewById(R.id.buttonEntrar);
        checkBox = findViewById(R.id.checkBox);
        textInputUsuario = findViewById(R.id.user);
        textInputUsuario.setText(KeepLoggedIn.getValuesString(getApplicationContext(),"usuario"));

        if(!KeepLoggedIn.getValuesBoolean(this.getApplicationContext(),"keeploggedin")) {
            buttonEnviar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TextInputEditText textInputSenha = findViewById(R.id.password);
                    String usuario = textInputUsuario.getText().toString();
                    String senha = textInputSenha.getText().toString();
                    checkBox.setChecked(false);
                    if (usuario.isEmpty() || senha.isEmpty()) {
                        alert("Campo vazio. Preencha todos os campos.");
                    } else if (usuario.equals("admin") && senha.equals("admin")) {
                        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("usuario", usuario);
                        intent.putExtras(bundle);

                        textInputUsuario.setText("");
                        textInputSenha.setText("");

                        KeepLoggedIn.setValuesString(getApplicationContext(), "usuario", usuario);

                        if (checkBox.isChecked()) {
                            KeepLoggedIn.setValuesBoolean(getApplicationContext(), "keeploggedin", true);
                        } else {
                            KeepLoggedIn.setValuesBoolean(getApplicationContext(), "keeploggedin", false);
                        }
                        startActivity(intent);
                    } else {
                        alert("Usuário ou senha inválido(s).");
                    }
                }
            });
        }else{
            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
            startActivity(intent);
        }
    }
    public void alert(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
