package com.example.a11_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class ThirdActivity extends AppCompatActivity {
    private EditText edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        edit = (EditText) findViewById(R.id.edit_third);
        Intent intent = getIntent();
        edit.setText(intent.getStringExtra("third"));

    }

    @Override
    public void onBackPressed() {
        Intent returnIntent = new Intent();
        returnIntent.putExtra("third_return", edit.getText().toString());
        setResult(1, returnIntent);
        finish();
    }
}
