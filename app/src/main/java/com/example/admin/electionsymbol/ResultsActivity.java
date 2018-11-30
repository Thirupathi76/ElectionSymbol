package com.example.admin.electionsymbol;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {
    RecyclerView listView2;
    TextView txt1;
    int[] image1 = {R.drawable.bjp1, R.drawable.congrass, R.drawable.jenasena, R.drawable.tdp, R.drawable.trs, R.drawable.ycp, R.drawable.loksatha};
    String[] names1 = {"Bharat Janatha Party", "Congress Party", "Janasena Party", "Telugu Desam Party", "Telangana Rastra Samithi Party",
            "Yuvajana Sramika Rythu Congress Party", "Loksatta Party"};
    int[] seekbarvalues = {10, 20, 30, 10, 10, 15, 5};
    String[] percentages = {"10%", "20%", "30%", "10%", "10%", "15%", "5%"};
    int[] colors = {R.color.safforn, R.color.green, R.color.red, R.color.yellow,
            R.color.pink,
            R.color.colorPrimary, R.color.purple};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        listView2 = findViewById(R.id.listview2);
        listView2.setLayoutManager(new LinearLayoutManager(this));
        txt1 = findViewById(R.id.heading);
        ResultsAdapter adapter1 = new ResultsAdapter(ResultsActivity.this, image1, names1, seekbarvalues, percentages, colors);
        listView2.setAdapter(adapter1);
        adapter1.notifyDataSetChanged();
        SharedPreferences sharedPreferences = getSharedPreferences("studentdata", Context.MODE_PRIVATE);
        String statename = sharedPreferences.getString("STATENAMES", "");
        String constitutionname = sharedPreferences.getString("CONSTITUTION", "");
        txt1.setText(statename + "\\" + constitutionname);

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
