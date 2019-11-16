package com.example.a11_activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edit2 ;
    EditText edit3 ;
    Button bt2 ;
    Button bt3 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit2 = (EditText) findViewById(R.id.edit_second);
        edit3 = (EditText) findViewById(R.id.edit_third);
        bt2 = (Button) findViewById(R.id.button_second);
        bt3 = (Button) findViewById(R.id.button_third);

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("second" , edit2.getText().toString());

                startActivityForResult(intent, 1);
            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
                intent.putExtra("third" , edit3.getText().toString());
                startActivityForResult(intent, 2);
            }
        });
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Log.e("onActivityResult","执行");
        super.onActivityResult(requestCode,resultCode,data);
        switch (requestCode) {
            case 1:

                if (resultCode == 1) {
                    edit2.setText(data.getStringExtra("second_return"));
                }
                break;
            case 2:
                if (resultCode == 1) {
                    edit3.setText(data.getStringExtra("third_return"));
                }
                break;
            default:
                Log.e("default","lihang");
        }
    }
}
