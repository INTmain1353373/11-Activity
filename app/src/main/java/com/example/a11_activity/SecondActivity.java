package com.example.a11_activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {
    private EditText edit;
    private Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        edit = (EditText) findViewById(R.id.edit_second);
        Intent intent = getIntent();
        edit.setText(intent.getStringExtra("second"));
        bt = (Button) findViewById(R.id.start);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra("second_return", edit.getText().toString());
                setResult(1,returnIntent);
                finish();
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent returnIntent = new Intent();
        returnIntent.putExtra("second_return", edit.getText().toString());
        Log.e("second",returnIntent.getStringExtra("second_return"));
        setResult(1,returnIntent);
        finish();
    }


}
