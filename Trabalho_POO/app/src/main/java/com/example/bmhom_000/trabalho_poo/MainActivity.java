package com.example.bmhom_000.trabalho_poo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //Vai pra login
    public void loginButton(View view){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
