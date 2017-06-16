package com.example.a9770382.event;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        TextView userWelcome = (TextView) findViewById(R.id.userTextView);

        // Display user details
        String message = name + " welcome to your user area";

        userWelcome.setText(message);
    }
}
