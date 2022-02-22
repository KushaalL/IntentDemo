package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivityTwo extends AppCompatActivity {

    Button closeButton;
    static final String intentSendBackCode = "ABAB";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_two);
        Toast.makeText(this,getIntent().getStringExtra(MainActivity.intentKey),Toast.LENGTH_SHORT).show();
        closeButton = findViewById(R.id.main2_button);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendInfoBack = new Intent();
                sendInfoBack.putExtra(intentSendBackCode,"This is from Activity 2");
                setResult(RESULT_OK,sendInfoBack);
                finish();
            }
        });
    }
}