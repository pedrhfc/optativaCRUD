package com.trabalho.alunosapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.database.Cursor;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.trabalho.alunosapp.tools.DatabaseHelper;
import com.trabalho.alunosapp.tools.HttpURLConnectionWS;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;


public class ListarActivity extends AppCompatActivity {
    DatabaseHelper db;
    Toolbar toolbar;
    TabLayout tabLayout;
    TextView textView;

    ArrayList<String> listArray;
    ListView alunoList;
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
        alunoList = findViewById(R.id.list);
        int[] drawableId = {R.drawable.circle};
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
                            listArray = new ArrayList<>();
                            selectAll();
                            break;
                        case 1:
                            listArray = new ArrayList<>();
                            getAluno();
                            break;
                    }
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {
                    switch (tab.getPosition()) {
                        case 0:
                            break;
                        case 1:
                            break;
                    }
                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {
                }
            });
            tabLayout.selectTab(tabLayout.getTabAt(1));
        }
    public void selectAll() {
        Cursor data = db.findAll();
        if (data.getCount() == 0) {
            alert("Nenhum usuário encontrado.");
            finish();
        } else {
            while (data.moveToNext()) {
                StringBuilder buffer = new StringBuilder();
                String id = "\n" + data.getString(0);
                String nome = "\n" + data.getString(1);
                String email = "\n" + data.getString(2);
                buffer.append(id).append(nome).append(email);
                listArray.add(buffer.toString());
            }
            adapter = new ArrayAdapter<>(this, R.layout.listview_row, listArray);
            alunoList.setAdapter(adapter);
        }
    }

    public void getAluno(){
        try {
            String json = new HttpURLConnectionWS().execute().get();
            JSONObject jObject = new JSONObject(json);
            JSONObject jAlunos = jObject.getJSONObject("alunos");
            JSONArray jArrayAluno = jAlunos.getJSONArray("aluno");
            for(int i = 0 ; i < jArrayAluno.length() ; i++) {
                StringBuilder buffer = new StringBuilder();
                String nome = "\n" + jArrayAluno.getJSONObject(i).getString("alunos_nome");
                String email = "\n" + jArrayAluno.getJSONObject(i).getString("alunos_email");
                buffer.append(nome).append(email);
                listArray.add(buffer.toString());
            }
            adapter = new ArrayAdapter<>(this, R.layout.listview_row, listArray);
            alunoList.setAdapter(adapter);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } catch (ExecutionException ex) {
            ex.printStackTrace();
        } catch (JSONException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
    }


    }
    public void alert(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
