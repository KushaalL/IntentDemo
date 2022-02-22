package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button launch;
    TextView text;
    static final String intentKey = "ABCD";
    static final int loadCode = 1234;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        launch = findViewById(R.id.main_button);
        text = findViewById(R.id.main_text_middle);

        launch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentToLoadActvity = new Intent(MainActivity.this,MainActivityTwo.class);
                intentToLoadActvity.putExtra(intentKey,"This is my message");
//                startActivity(intentToLoadActvity);
                startActivityForResult(intentToLoadActvity,loadCode);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==loadCode&&resultCode==RESULT_OK)
        {
            text.setText(data.getStringExtra(MainActivityTwo.intentSendBackCode));
        }
    }
}