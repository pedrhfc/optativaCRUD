package com.trabalho.alunosapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;



public class HomeActivity extends AppCompatActivity implements View.OnClickListener{
    Intent intent;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("alunapp");
        setContentView(R.layout.activity_home);

        Toolbar toolbar = findViewById(R.id.nav_toolbar);
        TextView textView = findViewById(R.id.toolbar_title);
        setSupportActionBar(toolbar);
        textView.setText(toolbar.getTitle());
        textView.setTextColor(0xFFFFFFFF);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        CardView cardViewCadastrar = findViewById(R.id.cardviewCadastrar);
        CardView cardViewEditar = findViewById(R.id.cardviewEditar);
        CardView cardViewListar = findViewById(R.id.cardviewListar);
        CardView cardViewRemover = findViewById(R.id.cardviewRemover);
        cardViewCadastrar.setOnClickListener(this);
        cardViewEditar.setOnClickListener(this);
        cardViewListar.setOnClickListener(this);
        cardViewRemover.setOnClickListener(this);
    }
    public void onClick(View v){

        switch(v.getId()) {

            case R.id.cardviewCadastrar:
                intent = new Intent(getApplicationContext(), CadastrarActivity.class);
                startActivity(intent);
                break;

            case R.id.cardviewEditar:
                intent = new Intent(getApplicationContext(), EditarActivity.class);
                startActivity(intent);
                break;

            case R.id.cardviewListar:
                intent = new Intent(getApplicationContext(), ListarActivity.class);
                startActivity(intent);
                break;

            case R.id.cardviewRemover:
                intent = new Intent(getApplicationContext(), RemoverActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){
        int id = menuItem.getItemId();

        if(id == R.id.action_logout){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(R.string.app_name);
            builder.setIcon(R.mipmap.ic_launcher);
            builder.setMessage("Você tem a certeza que deseja sair?")
                    .setCancelable(false)
                    .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            finish();
                        }
                    })
                    .setNegativeButton("Não", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();

        }
        return super.onOptionsItemSelected(menuItem);
    }

}
