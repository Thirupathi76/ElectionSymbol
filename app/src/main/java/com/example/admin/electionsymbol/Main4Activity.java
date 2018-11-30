package com.example.admin.electionsymbol;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main4Activity extends AppCompatActivity {
   TextView name1,email1,number1,gender1,state1,constitution1, age;
   Button submit1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        name1=findViewById(R.id.names1);
        email1=findViewById(R.id.email1);
        number1=findViewById(R.id.number1);
        gender1=findViewById(R.id.gender1);
        age=findViewById(R.id.age);
        state1=findViewById(R.id.state1);
        submit1=findViewById(R.id.submit1);
        constitution1=findViewById(R.id.constitution1);
//        SharedPreferences sharedPreferences=getSharedPreferences("studentdata", Context.MODE_PRIVATE);
        name1.setText(Utilities.getPreference(this, Constants.USER_NAME));
        email1.setText(Utilities.getPreference(this, Constants.EMAIL));
        number1.setText(Utilities.getPreference(this, Constants.PHONE));
        state1.setText(Utilities.getPreference(this, Constants.STATE));
        gender1.setText(Utilities.getPreference(this, Constants.GENDER));
        constitution1.setText(Utilities.getPreference(this, Constants.CONSTITUTION));
        age.setText(Utilities.getPreference(this, Constants.AGE));
        submit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Main4Activity.this,ViewDataActivity.class);
                startActivity(i);
            }
        });
    }
}
