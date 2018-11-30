package com.example.admin.electionsymbol;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public class CastVoteActivity extends AppCompatActivity {
ListView listView;
TextView txt2;
int[] image={R.drawable.bjp1,R.drawable.congrass,R.drawable.jenasena,R.drawable.tdp,R.drawable.trs,R.drawable.ycp,R.drawable.loksatha};
String[] names={"Bharat Janatha Party","Congress Party","Janasena Party","Telugu Desam Party","Telangana Rastra Samithi Party",
        "Yuvajana Sramika Rythu Congress Party","Loksatta Party"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listview);
        VoteAdapter adapter=new VoteAdapter(CastVoteActivity.this,names,image);
        listView.setAdapter(adapter);
        txt2=findViewById(R.id.txt2);

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        String pa = Utilities.getPreference(this, Constants.USER_NAME);
        if(!Utilities.isFirstRun(CastVoteActivity.this, "FIRST_RUN")){

        } else {
            if (!pa.isEmpty()) {
                startActivity(new Intent(this, ViewDataActivity.class));
                finish();
            }
        }
        txt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(CastVoteActivity.this,ViewDataActivity.class);
                startActivity(i);
            }
        });


    }

    /*@Override
    public boolean onNavigateUp() {
        onBackPressed();
        return super.onNavigateUp();

    }*/

    @Override
    protected void onResume() {
        super.onResume();
        String pa = Utilities.getPreference(this, Constants.USER_NAME);
        if(!Utilities.isFirstRun(CastVoteActivity.this, "FIRST_RUN")){

        } else {

            if (!pa.isEmpty()) {
                startActivity(new Intent(this, ResultsActivity.class));
                finish();
            }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
    }
}
