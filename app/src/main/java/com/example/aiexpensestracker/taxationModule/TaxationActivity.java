package com.example.aiexpensestracker.taxationModule;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aiexpensestracker.R;
import com.example.aiexpensestracker.expensesManagerModule.ExpensesManagerActivity;
import com.example.aiexpensestracker.userManagementModule.UserProfileActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Objects;

public class TaxationActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    private double income = 0;
    private double expense = 0;
    private double totalAmount = 0;

    private TextView total_amount_textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taxation);
        double income = getIntent().getDoubleExtra("income", 0.0);
        double expense = getIntent().getDoubleExtra("expense", 0.0);
        double totalAmount = getIntent().getDoubleExtra("totalAmount", 0.0);
        double salaries = getIntent().getDoubleExtra("salaries", 0.0); //taxable

        double wages = getIntent().getDoubleExtra("wages", 0.0); //taxable
        double commissions = getIntent().getDoubleExtra("commissions", 0.0); //taxable
        double bonuses = getIntent().getDoubleExtra("bonuses", 0.0); //taxable
        double allowances = getIntent().getDoubleExtra("allowances", 0.0); //taxable
        double pensions = getIntent().getDoubleExtra("pensions", 0.0); //taxable
        double rent = getIntent().getDoubleExtra("rent", 0.0); //taxable
        double interest = getIntent().getDoubleExtra("interest", 0.0); //taxable
        double gainsProfits = getIntent().getDoubleExtra("gainsProfits", 0.0);
        double dividendsInterestDiscounts = getIntent().getDoubleExtra("dividendsInterestDiscounts", 0.0);
        double compensationLossEmployment = getIntent().getDoubleExtra("compensationLossEmployment", 0.0);
        double gift = getIntent().getDoubleExtra("gift", 0.0);
        double inheritance = getIntent().getDoubleExtra("inheritance", 0.0);


        double foodDrinks = getIntent().getDoubleExtra("foodDrinks", 0.0);
        double shopping = getIntent().getDoubleExtra("shopping", 0.0);
        double housing = getIntent().getDoubleExtra("housing", 0.0);
        double transportation = getIntent().getDoubleExtra("transportation", 0.0);
        double vehicle = getIntent().getDoubleExtra("vehicle", 0.0);
        double lifeEntertainment = getIntent().getDoubleExtra("lifeEntertainment", 0.0);
        double communication = getIntent().getDoubleExtra("communication", 0.0);
        double investments = getIntent().getDoubleExtra("investments", 0.0);
        double alimonyPayment = getIntent().getDoubleExtra("alimonyPayment", 0.0);
        double sspnChildEducationSaving = getIntent().getDoubleExtra("sspnChildEducationSaving", 0.0);
        double breastfeedingEquipment = getIntent().getDoubleExtra("breastfeedingEquipment", 0.0);
        double childrenCentresKindergartenFees = getIntent().getDoubleExtra("childrenCentresKindergartenFees", 0.0);
        double parentMedical = getIntent().getDoubleExtra("parentMedical", 0.0);
        double annuityPRS = getIntent().getDoubleExtra("annuityPRS", 0.0);
        double educationMedicalInsurance = getIntent().getDoubleExtra("educationMedicalInsurance", 0.0);
        double educationFeesSelf = getIntent().getDoubleExtra("educationFeesSelf", 0.0);
        double supportingEquipment = getIntent().getDoubleExtra("supportingEquipment", 0.0);
        double medicalExpenses = getIntent().getDoubleExtra("medicalExpenses", 0.0);
        double epfKwsp = getIntent().getDoubleExtra("epfKwsp", 0.0);
        double lifeInsurance = getIntent().getDoubleExtra("lifeInsurance", 0.0);
        double lifestyle = getIntent().getDoubleExtra("lifestyle", 0.0);
        double lifestyleAdditional = getIntent().getDoubleExtra("lifestyleAdditional", 0.0);
        double lifestyleSport = getIntent().getDoubleExtra("lifestyleSport", 0.0);
        double socsoPerkeso = getIntent().getDoubleExtra("socsoPerkeso", 0.0);
        double domesticTravelExpenses = getIntent().getDoubleExtra("domesticTravelExpenses", 0.0);
        double electricalVehicleChargingExpenses = getIntent().getDoubleExtra("electricalVehicleChargingExpenses", 0.0);
        double monthlyTaxDeduction = getIntent().getDoubleExtra("monthlyTaxDeduction", 0.0);
        double zakatTotal = getIntent().getDoubleExtra("zakat", 0.0);

        Button taxLearning = findViewById(R.id.button_taxation_learning);
        taxLearning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TaxationActivity.this, TaxationLearningActivity.class);
                startActivity(intent);
            }
        });

        Button taxCalculate = findViewById(R.id.button_taxation_calculate);
        taxCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(TaxationActivity.this, TaxationCalculationActivity.class);
                intent2.putExtra("income", income);
                intent2.putExtra("expense", expense);

                intent2.putExtra("salaries", salaries);
                intent2.putExtra("wages", wages);
                intent2.putExtra("commissions", commissions);
                intent2.putExtra("bonuses", bonuses);
                intent2.putExtra("allowances", allowances);
                intent2.putExtra("pensions", pensions);
                intent2.putExtra("rent", rent);
                intent2.putExtra("interest", interest);
                intent2.putExtra("gainsProfits", gainsProfits);
                intent2.putExtra("dividendsInterestDiscounts", dividendsInterestDiscounts);
                intent2.putExtra("compensationLossEmployment", compensationLossEmployment);
                intent2.putExtra("gift", gift);
                intent2.putExtra("inheritance", inheritance);



                intent2.putExtra("foodDrinks", foodDrinks);
                intent2.putExtra("shopping", shopping);
                intent2.putExtra("housing", housing);
                intent2.putExtra("transportation", transportation);
                intent2.putExtra("vehicle", vehicle);
                intent2.putExtra("lifeEntertainment", lifeEntertainment);
                intent2.putExtra("communication", communication);
                intent2.putExtra("investments", investments);
                intent2.putExtra("alimonyPayment", alimonyPayment);
                intent2.putExtra("sspnChildEducationSaving", sspnChildEducationSaving);
                intent2.putExtra("breastfeedingEquipment", breastfeedingEquipment);
                intent2.putExtra("childrenCentresKindergartenFees", childrenCentresKindergartenFees);
                intent2.putExtra("parentMedical", parentMedical);
                intent2.putExtra("annuityPRS", annuityPRS);
                intent2.putExtra("educationMedicalInsurance", educationMedicalInsurance);
                intent2.putExtra("educationFeesSelf", educationFeesSelf);
                intent2.putExtra("supportingEquipment", supportingEquipment);
                intent2.putExtra("medicalExpenses", medicalExpenses);
                intent2.putExtra("epfKwsp", epfKwsp);
                intent2.putExtra("lifeInsurance", lifeInsurance);
                intent2.putExtra("lifestyle", lifestyle);
                intent2.putExtra("lifestyleAdditional", lifestyleAdditional);
                intent2.putExtra("lifestyleSport", lifestyleSport);
                intent2.putExtra("socsoPerkeso", socsoPerkeso);
                intent2.putExtra("domesticTravelExpenses", domesticTravelExpenses);
                intent2.putExtra("electricalVehicleChargingExpenses", electricalVehicleChargingExpenses);
                intent2.putExtra("monthlyTaxDeduction", monthlyTaxDeduction);
                intent2.putExtra("zakatTotal", zakatTotal);
                startActivity(intent2);
            }
        });


        Button taxQuiz = findViewById(R.id.button_taxation_quiz);
        taxQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TaxationActivity.this, TaxationQuizActivity.class);
                startActivity(intent);
            }
        });



        Objects.requireNonNull(getSupportActionBar()).setTitle("Taxation Paradise");

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.taxation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.taxation:
                        return true;

                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), ExpensesManagerActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(), UserProfileActivity.class));
                        overridePendingTransition(0,0);
                        return true;


                }
                return false;
            }
        });
    }
}