package com.example.aiexpensestracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.aiexpensestracker.expensesManagerModule.AddExpenseActivity;
import com.example.aiexpensestracker.expensesManagerModule.ExpensesManagerActivity;
import com.example.aiexpensestracker.userManagementModule.LoginActivity;
import com.example.aiexpensestracker.userManagementModule.RegisterActivity;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth authProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        authProfile = FirebaseAuth.getInstance();


        //Open Login Activity
        Button buttonLogin = findViewById(R.id.button_login);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        //Open Register Activity
        Button buttonRegister = findViewById(R.id.button_register);
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences pref = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        boolean isFirstTime = pref.getBoolean("isFirstTime", true);



        if (authProfile.getCurrentUser() != null) {
            Toast.makeText(MainActivity.this, "Already Logged In!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, ExpensesManagerActivity.class);
            startActivity(intent);


            //Start the UserProfileActivity
            finish();
        } else {
            Toast.makeText(MainActivity.this, "You can login now!", Toast.LENGTH_SHORT).show();
        }
    }


}