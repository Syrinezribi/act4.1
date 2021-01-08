package com.example.activit41;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences Preferences;
    private SharedPreferences.Editor editor;
    private EditText user,password;
    private CheckBox checkbox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user = findViewById(R.id.idName);
        password = findViewById(R.id.idPass);
        Button btnlog = findViewById(R.id.buttonLog);
        checkbox = findViewById(R.id.checkb);
        Preferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = Preferences.edit();
        CheckSharedPreferences();
        btnlog.setOnClickListener(v -> {
            if(checkbox.isChecked()){
                editor.putString(getString(R.string.ch),"true");
                editor.apply();
                String nom = user.getText().toString();
                editor.putString(getString(R.string.nom),nom);
                editor.commit();
                String pass = password.getText().toString();
                editor.putString(getString(R.string.pass),pass);
                editor.commit();
            }
            else{
                editor.putString(getString(R.string.ch),"false");
                editor.commit();

                editor.putString(getString(R.string.nom),"");
                editor.commit();

                editor.putString(getString(R.string.pass),"");
                editor.commit();
            }
        });
    }
    private void CheckSharedPreferences(){
        String nom = Preferences.getString(getString(R.string.nom),"");
        String pass = Preferences.getString(getString(R.string.pass),"");
        String ch = Preferences.getString(getString(R.string.ch),"False");
        user.setText(nom);
        password.setText(pass);
        checkbox.setChecked(ch.equals("true"));

    }
}