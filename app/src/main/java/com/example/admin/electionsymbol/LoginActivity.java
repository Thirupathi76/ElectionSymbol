package com.example.admin.electionsymbol;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class LoginActivity extends AppCompatActivity {
    TextInputEditText fullname, emailid, number, state, constitution, age;
    RadioButton male, female, transdenger;
    Button submit;
    private String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        fullname = findViewById(R.id.fullname);
        emailid = findViewById(R.id.emailid);
        number = findViewById(R.id.number);
        state = findViewById(R.id.state);
        constitution = findViewById(R.id.constitution);
        age = findViewById(R.id.age);

        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        transdenger = findViewById(R.id.transgender);
        submit = findViewById(R.id.submit);

        String name = Utilities.getPreference(this, Constants.USER_NAME);
        if (!name.isEmpty()){
            startActivity(new Intent(LoginActivity.this, CastVoteActivity.class));
        }
        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                boolean isValid = true;
                String name = fullname.getText().toString();
                String email = emailid.getText().toString();
                String phone = number.getText().toString();
                String statename = state.getText().toString();
                String age_str = age.getText().toString();
                String constitutionname = constitution.getText().toString();

                Utilities.setPreference(LoginActivity.this, Constants.USER_NAME, name);
                Utilities.setPreference(LoginActivity.this, Constants.EMAIL, email);
                Utilities.setPreference(LoginActivity.this, Constants.PHONE, phone);
                Utilities.setPreference(LoginActivity.this, Constants.STATE, statename);
                Utilities.setPreference(LoginActivity.this, Constants.CONSTITUTION, constitutionname);
                Utilities.setPreference(LoginActivity.this, Constants.GENDER, gender);
                Utilities.setPreference(LoginActivity.this, Constants.AGE, age_str);

                Intent intent = new Intent(LoginActivity.this, CastVoteActivity.class);
                startActivity(intent);

                if (name.isEmpty()) {
                    isValid = false;
                    fullname.setError("Invalid Username");
                    if (email.isEmpty()) {
                        isValid = false;
                        emailid.setError("Invalid Email");
                    }
                    if (phone.isEmpty()) {
                        isValid = false;
                        number.setError("Invlid Number");
                    }
                    if (statename.isEmpty()) {
                        isValid = false;
                        state.setError("Invalid State");
                    }
                    if (constitutionname.isEmpty()) {
                        constitution.setError("Invalid Constitution");
                    }


                    if (male.isChecked()) {
                        gender = male.getText().toString();
                    } else if (female.isChecked()) {
                        gender = female.getText().toString();
                    } else if (transdenger.isChecked()) {
                        gender = transdenger.getText().toString();
                    }
                } else {

                    /*SharedPreferences sharedPreferences = getSharedPreferences("studentdata", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();*/

                }
            }

        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        String name = Utilities.getPreference(this, Constants.USER_NAME);
        if (!name.isEmpty()){
            startActivity(new Intent(LoginActivity.this, CastVoteActivity.class));
        }
    }
}
