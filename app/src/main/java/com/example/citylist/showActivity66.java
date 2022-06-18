package com.example.citylist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class showActivity66 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show66);
        Intent intent=getIntent();
        String s=intent.getStringExtra("cityname");

        TextView textView=findViewById(R.id.textView2);
        textView.setText(s);

        Button button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent1=new Intent(showActivity66.this,MainActivity.class);
                startActivity(intent1);
                finish();
            }
        });
    }
}