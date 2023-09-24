package com.example.aiexpensestracker.expensesManagerModule;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.aiexpensestracker.R;
import com.example.aiexpensestracker.databinding.ActivityExpensesManagerBinding;
import com.example.aiexpensestracker.taxationModule.TaxationActivity;
import com.example.aiexpensestracker.userManagementModule.UserProfileActivity;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public class ExpensesManagerActivity extends AppCompatActivity implements OnItemClick {
    ActivityExpensesManagerBinding binding;
    BottomNavigationView bottomNavigationView;

    AddExpenseActivity addExpenseActivity;

    //ProgressBar
    ProgressBar progressBar;
    int progressValue = 0;

    private ExpensesAdapter expensesAdapter;

    private TextView totalAmountText;
    private ExpenseModel expenseModel;

    private double income = 0;
    private double expense = 0;
    private double totalAmount = 0;

    private TextView total_amount_textview;

    private double salaries = 0;
    private double wages = 0.0;
    private double commissions = 0.0;
    private double bonuses = 0.0;
    private double allowances = 0.0;
    private double pensions = 0.0;
    private double rent = 0.0;
    private double interest = 0.0;
    private double gainsProfits = 0.0;
    private double dividendsInterestDiscounts = 0.0;
    private double compensationLossEmployment = 0.0;
    private double gift = 0.0;
    private double inheritance = 0.0;


    private double foodDrinks = 0.0;
    private double shopping = 0.0;
    private double housing = 0.0;
    private double transportation = 0.0;
    private double vehicle = 0.0;
    private double lifeEntertainment = 0.0;
    private double communication = 0.0;
    private double investments = 0.0;
    private double alimonyPayment = 0.0;
    private double sspnChildEducationSaving = 0.0;
    private double breastfeedingEquipment = 0.0;
    private double childrenCentresKindergartenFees = 0.0;
    private double parentMedical = 0.0;
    private double annuityPRS = 0.0;
    private double educationMedicalInsurance = 0.0;
    private double educationFeesSelf = 0.0;
    private double supportingEquipment = 0.0;
    private double medicalExpenses = 0.0;
    private double epfKwsp = 0.0;
    private double lifeInsurance = 0.0;
    private double lifestyle = 0.0;
    private double lifestyleAdditional = 0.0;
    private double lifestyleSport = 0.0;
    private double socsoPerkeso = 0.0;
    private double domesticTravelExpenses = 0.0;
    private double electricalVehicleChargingExpenses = 0.0;
    private double monthlyTaxDeduction = 0.0;
    private double zakat = 0.0;

    //Limit
    private double foodDrinksLimit = 0.0;
    private double shoppingLimit = 0.0;
    private double housingLimit = 0.0;
    private double transportationLimit = 0.0;
    private double vehicleLimit = 0.0;
    private double lifeEntertainmentLimit = 0.0;
    private double communicationLimit = 0.0;
    private double investmentsLimit = 0.0;
    private double alimonyPaymentLimit = 0.0;
    private double sspnChildEducationSavingLimit = 0.0;
    private double breastfeedingEquipmentLimit = 0.0;
    private double childrenCentresKindergartenFeesLimit = 0.0;
    private double parentMedicalLimit = 0.0;
    private double annuityPRSLimit = 0.0;
    private double educationMedicalInsuranceLimit = 0.0;
    private double educationFeesSelfLimit = 0.0;
    private double supportingEquipmentLimit = 0.0;
    private double medicalExpensesLimit = 0.0;
    private double epfKwspLimit = 0.0;
    private double lifeInsuranceLimit = 0.0;
    private double lifestyleLimit = 0.0;
    private double lifestyleAdditionalLimit = 0.0;
    private double lifestyleSportLimit = 0.0;
    private double socsoPerkesoLimit = 0.0;
    private double domesticTravelExpensesLimit = 0.0;
    private double electricalVehicleChargingExpensesLimit = 0.0;
    private double monthlyTaxDeductionLimit = 0.0;
    private double zakatLimit = 0.0;
    //Limit


    //Total

    private double totalsalaries = 0;
    private double totalwages = 0.0;
    private double totalcommissions = 0.0;
    private double totalbonuses = 0.0;
    private double totalallowances = 0.0;
    private double totalpensions = 0.0;
    private double totalrent = 0.0;
    private double totalinterest = 0.0;
    private double totalgainsProfits = 0.0;
    private double totaldividendsInterestDiscounts = 0.0;
    private double totalcompensationLossEmployment = 0.0;
    private double totalgift = 0.0;
    private double totalinheritance = 0.0;
    private double totalfoodDrinks = 0.0;
    private double totalshopping = 0.0;
    private double totalhousing = 0.0;
    private double totaltransportation = 0.0;
    private double totalvehicle = 0.0;
    private double totallifeEntertainment = 0.0;
    private double totalcommunication = 0.0;
    private double totalinvestments = 0.0;
    private double totalalimonyPayment = 0.0;
    private double totalsspnChildEducationSaving = 0.0;
    private double totalbreastfeedingEquipment = 0.0;
    private double totalchildrenCentresKindergartenFees = 0.0;
    private double totalparentMedical = 0.0;
    private double totalannuityPRS = 0.0;
    private double totaleducationMedicalInsurance = 0.0;
    private double totaleducationFeesSelf = 0.0;
    private double totalsupportingEquipment = 0.0;
    private double totalmedicalExpenses = 0.0;
    private double totalepfKwsp = 0.0;
    private double totallifeInsurance = 0.0;
    private double totallifestyle = 0.0;
    private double totallifestyleAdditional = 0.0;
    private double totallifestyleSport = 0.0;
    private double totalsocsoPerkeso = 0.0;
    private double totaldomesticTravelExpenses = 0.0;
    private double totalelectricalVehicleChargingExpenses = 0.0;
    private double totalmonthlyTaxDeduction = 0.0;
    private double totalzakat = 0.0;
    //Total

    //alert
    private double alertfoodDrinks = 0.0;
    private double alertshopping = 0.0;
    private double alerthousing = 0.0;
    private double alerttransportation = 0.0;
    private double alertvehicle = 0.0;
    private double alertlifeEntertainment = 0.0;
    private double alertcommunication = 0.0;
    private double alertinvestments = 0.0;
    private double alertalimonyPayment = 0.0;
    private double alertsspnChildEducationSaving = 0.0;
    private double alertbreastfeedingEquipment = 0.0;
    private double alertchildrenCentresKindergartenFees = 0.0;
    private double alertparentMedical = 0.0;
    private double alertannuityPRS = 0.0;
    private double alerteducationMedicalInsurance = 0.0;
    private double alerteducationFeesSelf = 0.0;
    private double alertsupportingEquipment = 0.0;
    private double alertmedicalExpenses = 0.0;
    private double alertepfKwsp = 0.0;
    private double alertlifeInsurance = 0.0;
    private double alertlifestyle = 0.0;
    private double alertlifestyleAdditional = 0.0;
    private double alertlifestyleSport = 0.0;
    private double alertsocsoPerkeso = 0.0;
    private double alertdomesticTravelExpenses = 0.0;
    private double alertelectricalVehicleChargingExpenses = 0.0;
    private double alertmonthlyTaxDeduction = 0.0;
    private double alertzakat = 0.0;
    //alert

    private String category1;
    private String category2;
    private String category3;
    private String category4;
    private String category5;
    private double budgetLimit1;
    private double budgetLimit2;
    private double budgetLimit3;
    private double budgetLimit4;
    private double budgetLimit5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityExpensesManagerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.taxation:
                        Intent intent2 = new Intent(ExpensesManagerActivity.this, TaxationActivity.class);
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
                        intent2.putExtra("zakat", zakat);
                        startActivity(intent2);
                        overridePendingTransition(0, 0);

                        return true;

                    case R.id.home:
                        return true;

                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(), UserProfileActivity.class));
                        overridePendingTransition(0, 0);
                        return true;


                }
                return false;
            }
        });

        expensesAdapter = new ExpensesAdapter(this, this);
        binding.recycler.setAdapter(expensesAdapter);
        binding.recycler.setLayoutManager(new LinearLayoutManager(this));


        Intent intent = new Intent(ExpensesManagerActivity.this, AddExpenseActivity.class);

        binding.addIncome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("type", "Income");
                startActivity(intent);
            }
        });

        binding.addExpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("type", "Expense");


                startActivity(intent);
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        income = 0;
        expense = 0;
        totalAmount = 0;
        salaries = 0.0;
        wages = 0.0;
        commissions = 0.0;
        bonuses = 0.0;
        allowances = 0.0;
        pensions = 0.0;
        rent = 0.0;
        interest = 0.0;
        gainsProfits = 0.0;
        dividendsInterestDiscounts = 0.0;
        compensationLossEmployment = 0.0;
        gift = 0.0;
        inheritance = 0.0;

        foodDrinks = 0.0;
        shopping = 0.0;
        housing = 0.0;
        transportation = 0.0;
        vehicle = 0.0;
        lifeEntertainment = 0.0;
        communication = 0.0;
        investments = 0.0;
        alimonyPayment = 0.0;
        sspnChildEducationSaving = 0.0;
        breastfeedingEquipment = 0.0;
        childrenCentresKindergartenFees = 0.0;
        parentMedical = 0.0;
        annuityPRS = 0.0;
        educationMedicalInsurance = 0.0;
        educationFeesSelf = 0.0;
        supportingEquipment = 0.0;
        medicalExpenses = 0.0;
        epfKwsp = 0.0;
        lifeInsurance = 0.0;
        lifestyle = 0.0;
        lifestyleAdditional = 0.0;
        lifestyleSport = 0.0;
        socsoPerkeso = 0.0;
        domesticTravelExpenses = 0.0;
        electricalVehicleChargingExpenses = 0.0;
        monthlyTaxDeduction = 0.0;
        zakat = 0.0;

        getDate();
    }


    //Creating ActionBar Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate menu items
        getMenuInflater().inflate(R.menu.top_right_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //When any menu item is selected
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.add_Budget) {
            Intent intent = new Intent(ExpensesManagerActivity.this, BudgetPlanActivity.class);
            startActivity(intent);

            Intent intent3 = new Intent(ExpensesManagerActivity.this, BudgetPlanActivity.class);
            intent3.putExtra("income", income);
            intent3.putExtra("expense", expense);
            intent3.putExtra("totalAmount", totalAmount);
            startActivity(intent3);

        } else if (id == R.id.analytical_Chart) {
            Intent intent = new Intent(ExpensesManagerActivity.this, AnalyticalChartActivity.class);

            intent.putExtra("income", income);
            intent.putExtra("expense", expense);

            intent.putExtra("salaries", totalsalaries);

            intent.putExtra("wages", totalwages);
            intent.putExtra("commissions", totalcommissions);
            intent.putExtra("bonuses", totalbonuses);
            intent.putExtra("allowances", totalallowances);
            intent.putExtra("pensions", totalpensions);
            intent.putExtra("rent", totalrent);
            intent.putExtra("interest", totalinterest);
            intent.putExtra("gainsProfits", totalgainsProfits);
            intent.putExtra("dividendsInterestDiscounts", totaldividendsInterestDiscounts);
            intent.putExtra("compensationLossEmployment", totalcompensationLossEmployment);
            intent.putExtra("gift", totalgift);
            intent.putExtra("inheritance", totalinheritance);
            intent.putExtra("foodDrinks", totalfoodDrinks);
            intent.putExtra("shopping", totalshopping);
            intent.putExtra("housing", totalhousing);
            intent.putExtra("transportation", totaltransportation);
            intent.putExtra("vehicle", totalvehicle);
            intent.putExtra("lifeEntertainment", totallifeEntertainment);
            intent.putExtra("communication", totalcommunication);
            intent.putExtra("investments", totalinvestments);
            intent.putExtra("alimonyPayment", totalalimonyPayment);
            intent.putExtra("sspnChildEducationSaving", totalsspnChildEducationSaving);
            intent.putExtra("breastfeedingEquipment", totalbreastfeedingEquipment);
            intent.putExtra("childrenCentresKindergartenFees", totalchildrenCentresKindergartenFees);
            intent.putExtra("parentMedical", totalparentMedical);
            intent.putExtra("annuityPRS", totalannuityPRS);
            intent.putExtra("educationMedicalInsurance", totaleducationMedicalInsurance);
            intent.putExtra("educationFeesSelf", totaleducationFeesSelf);
            intent.putExtra("supportingEquipment", totalsupportingEquipment);
            intent.putExtra("medicalExpenses", totalmedicalExpenses);
            intent.putExtra("epfKwsp", totalepfKwsp);
            intent.putExtra("lifeInsurance", totallifeInsurance);
            intent.putExtra("lifestyle", totallifestyle);
            intent.putExtra("lifestyleAdditional", totallifestyleAdditional);
            intent.putExtra("lifestyleSport", totallifestyleSport);
            intent.putExtra("socsoPerkeso", totalsocsoPerkeso);
            intent.putExtra("domesticTravelExpenses", totaldomesticTravelExpenses);
            intent.putExtra("electricalVehicleChargingExpenses", totalelectricalVehicleChargingExpenses);
            intent.putExtra("monthlyTaxDeduction", totalmonthlyTaxDeduction);
            intent.putExtra("zakat", totalzakat);
            startActivity(intent);
        } else {
            Intent intent = new Intent(ExpensesManagerActivity.this, TaxLimitActivity.class);

            intent.putExtra("income", income);
            intent.putExtra("expense", expense);
            intent.putExtra("salaries", totalsalaries);
            intent.putExtra("wages", totalwages);
            intent.putExtra("commissions", totalcommissions);
            intent.putExtra("bonuses", totalbonuses);
            intent.putExtra("allowances", totalallowances);
            intent.putExtra("pensions", totalpensions);
            intent.putExtra("rent", totalrent);
            intent.putExtra("interest", totalinterest);
            intent.putExtra("gainsProfits", totalgainsProfits);
            intent.putExtra("dividendsInterestDiscounts", totaldividendsInterestDiscounts);
            intent.putExtra("compensationLossEmployment", totalcompensationLossEmployment);
            intent.putExtra("gift", totalgift);
            intent.putExtra("inheritance", totalinheritance);

            intent.putExtra("foodDrinks", totalfoodDrinks);
            intent.putExtra("shopping", totalshopping);
            intent.putExtra("housing", totalhousing);
            intent.putExtra("transportation", totaltransportation);
            intent.putExtra("vehicle", totalvehicle);
            intent.putExtra("lifeEntertainment", totallifeEntertainment);
            intent.putExtra("communication", totalcommunication);
            intent.putExtra("investments", totalinvestments);
            intent.putExtra("alimonyPayment", totalalimonyPayment);
            intent.putExtra("sspnChildEducationSaving", totalsspnChildEducationSaving);
            intent.putExtra("breastfeedingEquipment", totalbreastfeedingEquipment);
            intent.putExtra("childrenCentresKindergartenFees", totalchildrenCentresKindergartenFees);
            intent.putExtra("parentMedical", totalparentMedical);
            intent.putExtra("annuityPRS", totalannuityPRS);
            intent.putExtra("educationMedicalInsurance", totaleducationMedicalInsurance);
            intent.putExtra("educationFeesSelf", totaleducationFeesSelf);
            intent.putExtra("supportingEquipment", totalsupportingEquipment);
            intent.putExtra("medicalExpenses", totalmedicalExpenses);
            intent.putExtra("epfKwsp", totalepfKwsp);
            intent.putExtra("lifeInsurance", totallifeInsurance);
            intent.putExtra("lifestyle", totallifestyle);
            intent.putExtra("lifestyleAdditional", totallifestyleAdditional);
            intent.putExtra("lifestyleSport", totallifestyleSport);
            intent.putExtra("socsoPerkeso", totalsocsoPerkeso);
            intent.putExtra("domesticTravelExpenses", totaldomesticTravelExpenses);
            intent.putExtra("electricalVehicleChargingExpenses", totalelectricalVehicleChargingExpenses);
            intent.putExtra("monthlyTaxDeduction", totalmonthlyTaxDeduction);
            intent.putExtra("zakat", totalzakat);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    private void getDate() {

        DatabaseReference databaseReference = FirebaseDatabase.getInstance("https://aiexpensestracker-default-rtdb.asia-southeast1.firebasedatabase.app").getReference("budget_plans");
        databaseReference.child("Budget 1").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    category1 = dataSnapshot.child("category").getValue(String.class);
                    budgetLimit1 = dataSnapshot.child("budgetLimit").getValue(Double.class);

                    // Do something with the category and budgetLimit variables

                    if (category1 != null) {
                        if (category1.equals("Food & Drinks")) {
                            foodDrinksLimit = budgetLimit1;
                        } else if (category1.equals("Shopping")) {
                            shoppingLimit = budgetLimit1;
                        } else if (category1.equals("Housing")) {
                            housingLimit = budgetLimit1;
                        } else if (category1.equals("Transportation")) {
                            transportationLimit = budgetLimit1;
                        } else if (category1.equals("Vehicle")) {
                            vehicleLimit = budgetLimit1;
                        } else if (category1.equals("Life & Entertainment")) {
                            lifeEntertainmentLimit = budgetLimit1;
                        } else if (category1.equals("Communication")) {
                            communicationLimit = budgetLimit1;
                        } else if (category1.equals("Investments")) {
                            investmentsLimit = budgetLimit1;
                        } else if (category1.equals("Payment alimony to former wife")) {
                            alimonyPaymentLimit = budgetLimit1;
                        } else if (category1.equals("SSPN(Child Education Saving)")) {
                            sspnChildEducationSavingLimit = budgetLimit1;
                        } else if (category1.equals("Breastfeeding Equipment")) {
                            breastfeedingEquipmentLimit = budgetLimit1;
                        } else if (category1.equals("Children Centres and kindergartens fees")) {
                            childrenCentresKindergartenFeesLimit = budgetLimit1;
                        } else if (category1.equals("Parent Medical")) {
                            parentMedicalLimit = budgetLimit1;
                        } else if (category1.equals("Annuity/PRS")) {
                            annuityPRSLimit = budgetLimit1;
                        } else if (category1.equals("Education and Medical Insurance")) {
                            educationMedicalInsuranceLimit = budgetLimit1;
                        } else if (category1.equals("Education Fees(Self)")) {
                            educationFeesSelfLimit = budgetLimit1;
                        } else if (category1.equals("Supporting Equipment")) {
                            supportingEquipmentLimit = budgetLimit1;
                        } else if (category1.equals("Medical Expenses(Self/Spouse/Child)")) {
                            medicalExpensesLimit = budgetLimit1;
                        } else if (category1.equals("EPF/KWSP")) {
                            epfKwspLimit = budgetLimit1;
                        } else if (category1.equals("Life Insurance")) {
                            lifeInsuranceLimit = budgetLimit1;
                        } else if (category1.equals("LifeStyle")) {
                            lifestyleLimit = budgetLimit1;
                        } else if (category1.equals("LifeStyle(Additional)")) {
                            lifestyleAdditionalLimit = budgetLimit1;
                        } else if (category1.equals("LifeStyle(Sport)")) {
                            lifestyleSportLimit = budgetLimit1;
                        } else if (category1.equals("SOCSO/PERKESO")) {
                            socsoPerkesoLimit = budgetLimit1;
                        } else if (category1.equals("Domestic Travel Expenses")) {
                            domesticTravelExpensesLimit = budgetLimit1;
                        } else if (category1.equals("Electrical Vehicle Charging Expenses")) {
                            electricalVehicleChargingExpensesLimit = budgetLimit1;
                        } else if (category1.equals("Monthly Tax Deduction(MTD/PCB)")) {
                            monthlyTaxDeductionLimit = budgetLimit1;
                        } else if (category1.equals("Zakat")) {
                            zakatLimit = budgetLimit1;
                        }
                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("BudgetPlanActivity", "loadBudgetPlan:onCancelled", databaseError.toException());
            }
        });

        databaseReference.child("Budget 2").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    category2 = dataSnapshot.child("category").getValue(String.class);
                    budgetLimit2 = dataSnapshot.child("budgetLimit").getValue(Double.class);

                    // Do something with the category and budgetLimit variables
                    if (category2 != null) {
                        if (category2.equals("Food & Drinks")) {
                            foodDrinksLimit = budgetLimit2;
                        } else if (category2.equals("Shopping")) {
                            shoppingLimit = budgetLimit2;
                        } else if (category2.equals("Housing")) {
                            housingLimit = budgetLimit2;
                        } else if (category2.equals("Transportation")) {
                            transportationLimit = budgetLimit2;
                        } else if (category2.equals("Vehicle")) {
                            vehicleLimit = budgetLimit2;
                        } else if (category2.equals("Life & Entertainment")) {
                            lifeEntertainmentLimit = budgetLimit2;
                        } else if (category2.equals("Communication")) {
                            communicationLimit = budgetLimit2;
                        } else if (category2.equals("Investments")) {
                            investmentsLimit = budgetLimit2;
                        } else if (category2.equals("Payment alimony to former wife")) {
                            alimonyPaymentLimit = budgetLimit2;
                        } else if (category2.equals("SSPN(Child Education Saving)")) {
                            sspnChildEducationSavingLimit = budgetLimit2;
                        } else if (category2.equals("Breastfeeding Equipment")) {
                            breastfeedingEquipmentLimit = budgetLimit2;
                        } else if (category2.equals("Children Centres and kindergartens fees")) {
                            childrenCentresKindergartenFeesLimit = budgetLimit2;
                        } else if (category2.equals("Parent Medical")) {
                            parentMedicalLimit = budgetLimit2;
                        } else if (category2.equals("Annuity/PRS")) {
                            annuityPRSLimit = budgetLimit2;
                        } else if (category2.equals("Education and Medical Insurance")) {
                            educationMedicalInsuranceLimit = budgetLimit2;
                        } else if (category2.equals("Education Fees(Self)")) {
                            educationFeesSelfLimit = budgetLimit2;
                        } else if (category2.equals("Supporting Equipment")) {
                            supportingEquipmentLimit = budgetLimit2;
                        } else if (category2.equals("Medical Expenses(Self/Spouse/Child)")) {
                            medicalExpensesLimit = budgetLimit2;
                        } else if (category2.equals("EPF/KWSP")) {
                            epfKwspLimit = budgetLimit2;
                        } else if (category2.equals("Life Insurance")) {
                            lifeInsuranceLimit = budgetLimit2;
                        } else if (category2.equals("LifeStyle")) {
                            lifestyleLimit = budgetLimit2;
                        } else if (category2.equals("LifeStyle(Additional)")) {
                            lifestyleAdditionalLimit = budgetLimit2;
                        } else if (category2.equals("LifeStyle(Sport)")) {
                            lifestyleSportLimit = budgetLimit2;
                        } else if (category2.equals("SOCSO/PERKESO")) {
                            socsoPerkesoLimit = budgetLimit2;
                        } else if (category2.equals("Domestic Travel Expenses")) {
                            domesticTravelExpensesLimit = budgetLimit2;
                        } else if (category2.equals("Electrical Vehicle Charging Expenses")) {
                            electricalVehicleChargingExpensesLimit = budgetLimit2;
                        } else if (category2.equals("Monthly Tax Deduction(MTD/PCB)")) {
                            monthlyTaxDeductionLimit = budgetLimit2;
                        } else if (category2.equals("Zakat")) {
                            zakatLimit = budgetLimit2;
                        }
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("BudgetPlanActivity", "loadBudgetPlan:onCancelled", databaseError.toException());
            }
        });

        databaseReference.child("Budget 3").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    category3 = dataSnapshot.child("category").getValue(String.class);
                    budgetLimit3 = dataSnapshot.child("budgetLimit").getValue(Double.class);

                    // Do something with the category and budgetLimit variables
                    if (category3 != null) {
                        if (category3.equals("Food & Drinks")) {
                            foodDrinksLimit = budgetLimit3;
                        } else if (category3.equals("Shopping")) {
                            shoppingLimit = budgetLimit3;
                        } else if (category3.equals("Housing")) {
                            housingLimit = budgetLimit3;
                        } else if (category3.equals("Transportation")) {
                            transportationLimit = budgetLimit3;
                        } else if (category3.equals("Vehicle")) {
                            vehicleLimit = budgetLimit3;
                        } else if (category3.equals("Life & Entertainment")) {
                            lifeEntertainmentLimit = budgetLimit3;
                        } else if (category3.equals("Communication")) {
                            communicationLimit = budgetLimit3;
                        } else if (category3.equals("Investments")) {
                            investmentsLimit = budgetLimit3;
                        } else if (category3.equals("Payment alimony to former wife")) {
                            alimonyPaymentLimit = budgetLimit3;
                        } else if (category3.equals("SSPN(Child Education Saving)")) {
                            sspnChildEducationSavingLimit = budgetLimit3;
                        } else if (category3.equals("Breastfeeding Equipment")) {
                            breastfeedingEquipmentLimit = budgetLimit3;
                        } else if (category3.equals("Children Centres and kindergartens fees")) {
                            childrenCentresKindergartenFeesLimit = budgetLimit3;
                        } else if (category3.equals("Parent Medical")) {
                            parentMedicalLimit = budgetLimit3;
                        } else if (category3.equals("Annuity/PRS")) {
                            annuityPRSLimit = budgetLimit3;
                        } else if (category3.equals("Education and Medical Insurance")) {
                            educationMedicalInsuranceLimit = budgetLimit3;
                        } else if (category3.equals("Education Fees(Self)")) {
                            educationFeesSelfLimit = budgetLimit3;
                        } else if (category3.equals("Supporting Equipment")) {
                            supportingEquipmentLimit = budgetLimit3;
                        } else if (category3.equals("Medical Expenses(Self/Spouse/Child)")) {
                            medicalExpensesLimit = budgetLimit3;
                        } else if (category3.equals("EPF/KWSP")) {
                            epfKwspLimit = budgetLimit3;
                        } else if (category3.equals("Life Insurance")) {
                            lifeInsuranceLimit = budgetLimit3;
                        } else if (category3.equals("LifeStyle")) {
                            lifestyleLimit = budgetLimit3;
                        } else if (category3.equals("LifeStyle(Additional)")) {
                            lifestyleAdditionalLimit = budgetLimit3;
                        } else if (category3.equals("LifeStyle(Sport)")) {
                            lifestyleSportLimit = budgetLimit3;
                        } else if (category3.equals("SOCSO/PERKESO")) {
                            socsoPerkesoLimit = budgetLimit3;
                        } else if (category3.equals("Domestic Travel Expenses")) {
                            domesticTravelExpensesLimit = budgetLimit3;
                        } else if (category3.equals("Electrical Vehicle Charging Expenses")) {
                            electricalVehicleChargingExpensesLimit = budgetLimit3;
                        } else if (category3.equals("Monthly Tax Deduction(MTD/PCB)")) {
                            monthlyTaxDeductionLimit = budgetLimit3;
                        } else if (category3.equals("Zakat")) {
                            zakatLimit = budgetLimit3;
                        }
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("BudgetPlanActivity", "loadBudgetPlan:onCancelled", databaseError.toException());
            }
        });

        databaseReference.child("Budget 4").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    category4 = dataSnapshot.child("category").getValue(String.class);
                    budgetLimit4 = dataSnapshot.child("budgetLimit").getValue(Double.class);

                    // Do something with the category and budgetLimit variables
                    if (category4 != null) {
                        if (category4.equals("Food & Drinks")) {
                            foodDrinksLimit = budgetLimit4;
                        } else if (category4.equals("Shopping")) {
                            shoppingLimit = budgetLimit4;
                        } else if (category4.equals("Housing")) {
                            housingLimit = budgetLimit4;
                        } else if (category4.equals("Transportation")) {
                            transportationLimit = budgetLimit4;
                        } else if (category4.equals("Vehicle")) {
                            vehicleLimit = budgetLimit4;
                        } else if (category4.equals("Life & Entertainment")) {
                            lifeEntertainmentLimit = budgetLimit4;
                        } else if (category4.equals("Communication")) {
                            communicationLimit = budgetLimit4;
                        } else if (category4.equals("Investments")) {
                            investmentsLimit = budgetLimit4;
                        } else if (category4.equals("Payment alimony to former wife")) {
                            alimonyPaymentLimit = budgetLimit4;
                        } else if (category4.equals("SSPN(Child Education Saving)")) {
                            sspnChildEducationSavingLimit = budgetLimit4;
                        } else if (category4.equals("Breastfeeding Equipment")) {
                            breastfeedingEquipmentLimit = budgetLimit4;
                        } else if (category4.equals("Children Centres and kindergartens fees")) {
                            childrenCentresKindergartenFeesLimit = budgetLimit4;
                        } else if (category4.equals("Parent Medical")) {
                            parentMedicalLimit = budgetLimit4;
                        } else if (category4.equals("Annuity/PRS")) {
                            annuityPRSLimit = budgetLimit4;
                        } else if (category4.equals("Education and Medical Insurance")) {
                            educationMedicalInsuranceLimit = budgetLimit4;
                        } else if (category4.equals("Education Fees(Self)")) {
                            educationFeesSelfLimit = budgetLimit4;
                        } else if (category4.equals("Supporting Equipment")) {
                            supportingEquipmentLimit = budgetLimit4;
                        } else if (category4.equals("Medical Expenses(Self/Spouse/Child)")) {
                            medicalExpensesLimit = budgetLimit4;
                        } else if (category4.equals("EPF/KWSP")) {
                            epfKwspLimit = budgetLimit4;
                        } else if (category4.equals("Life Insurance")) {
                            lifeInsuranceLimit = budgetLimit4;
                        } else if (category4.equals("LifeStyle")) {
                            lifestyleLimit = budgetLimit4;
                        } else if (category4.equals("LifeStyle(Additional)")) {
                            lifestyleAdditionalLimit = budgetLimit4;
                        } else if (category4.equals("LifeStyle(Sport)")) {
                            lifestyleSportLimit = budgetLimit4;
                        } else if (category4.equals("SOCSO/PERKESO")) {
                            socsoPerkesoLimit = budgetLimit4;
                        } else if (category4.equals("Domestic Travel Expenses")) {
                            domesticTravelExpensesLimit = budgetLimit4;
                        } else if (category4.equals("Electrical Vehicle Charging Expenses")) {
                            electricalVehicleChargingExpensesLimit = budgetLimit4;
                        } else if (category4.equals("Monthly Tax Deduction(MTD/PCB)")) {
                            monthlyTaxDeductionLimit = budgetLimit4;
                        } else if (category4.equals("Zakat")) {
                            zakatLimit = budgetLimit4;
                        }
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("BudgetPlanActivity", "loadBudgetPlan:onCancelled", databaseError.toException());
            }
        });

        databaseReference.child("Budget 5").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    category5 = dataSnapshot.child("category").getValue(String.class);
                    budgetLimit5 = dataSnapshot.child("budgetLimit").getValue(Double.class);

                    // Do something with the category and budgetLimit variables
                    if (category5 != null) {
                        if (category5.equals("Food & Drinks")) {
                            foodDrinksLimit = budgetLimit5;
                        } else if (category5.equals("Shopping")) {
                            shoppingLimit = budgetLimit5;
                        } else if (category5.equals("Housing")) {
                            housingLimit = budgetLimit5;
                        } else if (category5.equals("Transportation")) {
                            transportationLimit = budgetLimit5;
                        } else if (category5.equals("Vehicle")) {
                            vehicleLimit = budgetLimit5;
                        } else if (category5.equals("Life & Entertainment")) {
                            lifeEntertainmentLimit = budgetLimit5;
                        } else if (category5.equals("Communication")) {
                            communicationLimit = budgetLimit5;
                        } else if (category5.equals("Investments")) {
                            investmentsLimit = budgetLimit5;
                        } else if (category5.equals("Payment alimony to former wife")) {
                            alimonyPaymentLimit = budgetLimit5;
                        } else if (category5.equals("SSPN(Child Education Saving)")) {
                            sspnChildEducationSavingLimit = budgetLimit5;
                        } else if (category5.equals("Breastfeeding Equipment")) {
                            breastfeedingEquipmentLimit = budgetLimit5;
                        } else if (category5.equals("Children Centres and kindergartens fees")) {
                            childrenCentresKindergartenFeesLimit = budgetLimit5;
                        } else if (category5.equals("Parent Medical")) {
                            parentMedicalLimit = budgetLimit5;
                        } else if (category5.equals("Annuity/PRS")) {
                            annuityPRSLimit = budgetLimit5;
                        } else if (category5.equals("Education and Medical Insurance")) {
                            educationMedicalInsuranceLimit = budgetLimit5;
                        } else if (category5.equals("Education Fees(Self)")) {
                            educationFeesSelfLimit = budgetLimit5;
                        } else if (category5.equals("Supporting Equipment")) {
                            supportingEquipmentLimit = budgetLimit5;
                        } else if (category5.equals("Medical Expenses(Self/Spouse/Child)")) {
                            medicalExpensesLimit = budgetLimit5;
                        } else if (category5.equals("EPF/KWSP")) {
                            epfKwspLimit = budgetLimit5;
                        } else if (category5.equals("Life Insurance")) {
                            lifeInsuranceLimit = budgetLimit5;
                        } else if (category5.equals("LifeStyle")) {
                            lifestyleLimit = budgetLimit5;
                        } else if (category5.equals("LifeStyle(Additional)")) {
                            lifestyleAdditionalLimit = budgetLimit5;
                        } else if (category5.equals("LifeStyle(Sport)")) {
                            lifestyleSportLimit = budgetLimit5;
                        } else if (category5.equals("SOCSO/PERKESO")) {
                            socsoPerkesoLimit = budgetLimit5;
                        } else if (category5.equals("Domestic Travel Expenses")) {
                            domesticTravelExpensesLimit = budgetLimit5;
                        } else if (category5.equals("Electrical Vehicle Charging Expenses")) {
                            electricalVehicleChargingExpensesLimit = budgetLimit5;
                        } else if (category5.equals("Monthly Tax Deduction(MTD/PCB)")) {
                            monthlyTaxDeductionLimit = budgetLimit5;
                        } else if (category5.equals("Zakat")) {
                            zakatLimit = budgetLimit5;
                        }
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("BudgetPlanActivity", "loadBudgetPlan:onCancelled", databaseError.toException());
            }
        });

        FirebaseFirestore
                .getInstance()
                .collection("Expenses")
                .whereEqualTo("uid", FirebaseAuth.getInstance().getUid())
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        expensesAdapter.clear();
                        List<DocumentSnapshot> dsList = queryDocumentSnapshots.getDocuments();

                        for (DocumentSnapshot ds : dsList) {
                            ExpenseModel expenseModel = ds.toObject(ExpenseModel.class);
                            if (expenseModel.getType().equals("Income")) {
                                income += expenseModel.getAmount();
                                String dateGet = expenseModel.getDate();

                                if (expenseModel.getCategory().equals("Salaries")) {
                                    // Assuming that `salaries` is declared as a double or float
                                    totalsalaries += expenseModel.getAmount();
                                } else if (expenseModel.getCategory().equals("Wages")) {
                                    totalwages += expenseModel.getAmount();
                                } else if (expenseModel.getCategory().equals("Commissions")) {
                                    totalcommissions += expenseModel.getAmount();
                                } else if (expenseModel.getCategory().equals("Bonuses")) {
                                    totalbonuses += expenseModel.getAmount();
                                } else if (expenseModel.getCategory().equals("Allowances")) {
                                    totalallowances += expenseModel.getAmount();
                                } else if (expenseModel.getCategory().equals("Pensions")) {
                                    totalpensions += expenseModel.getAmount();
                                } else if (expenseModel.getCategory().equals("Rent")) {
                                    totalrent += expenseModel.getAmount();
                                } else if (expenseModel.getCategory().equals("Interest")) {
                                    totalinterest += expenseModel.getAmount();
                                } else if (expenseModel.getCategory().equals("Gains or profits from any trade")) {
                                    totalgainsProfits += expenseModel.getAmount();
                                } else if (expenseModel.getCategory().equals("Dividends, interest or discounts")) {
                                    totaldividendsInterestDiscounts += expenseModel.getAmount();
                                } else if (expenseModel.getCategory().equals("Compensation for loss of employment")) {
                                    totalcompensationLossEmployment += expenseModel.getAmount();
                                } else if (expenseModel.getCategory().equals("Gift")) {
                                    totalgift += expenseModel.getAmount();
                                } else if (expenseModel.getCategory().equals("Inheritance")) {
                                    totalinheritance += expenseModel.getAmount();
                                }
                                if (expenseModel.getDate().contains("2022")) {
                                    if (expenseModel.getCategory() != null) {
                                        if (expenseModel.getCategory().equals("Salaries")) {
                                            // Assuming that `salaries` is declared as a double or float
                                            salaries += expenseModel.getAmount();
                                        } else if (expenseModel.getCategory().equals("Wages")) {
                                            wages += expenseModel.getAmount();
                                        } else if (expenseModel.getCategory().equals("Commissions")) {
                                            commissions += expenseModel.getAmount();
                                        } else if (expenseModel.getCategory().equals("Bonuses")) {
                                            bonuses += expenseModel.getAmount();
                                        } else if (expenseModel.getCategory().equals("Allowances")) {
                                            allowances += expenseModel.getAmount();
                                        } else if (expenseModel.getCategory().equals("Pensions")) {
                                            pensions += expenseModel.getAmount();
                                        } else if (expenseModel.getCategory().equals("Rent")) {
                                            rent += expenseModel.getAmount();
                                        } else if (expenseModel.getCategory().equals("Interest")) {
                                            interest += expenseModel.getAmount();
                                        } else if (expenseModel.getCategory().equals("Gains or profits from any trade")) {
                                            gainsProfits += expenseModel.getAmount();
                                        } else if (expenseModel.getCategory().equals("Dividends, interest or discounts")) {
                                            dividendsInterestDiscounts += expenseModel.getAmount();
                                        } else if (expenseModel.getCategory().equals("Compensation for loss of employment")) {
                                            compensationLossEmployment += expenseModel.getAmount();
                                        } else if (expenseModel.getCategory().equals("Gift")) {
                                            gift += expenseModel.getAmount();
                                        } else if (expenseModel.getCategory().equals("Inheritance")) {
                                            inheritance += expenseModel.getAmount();
                                        }
                                    }
                                }
                            }
                            if (expenseModel.getType().equals("Expense")) {
                                expense += expenseModel.getAmount();
                                if (expenseModel.getCategory() != null) {
                                    if (expenseModel.getCategory().equals("Food & Drinks")) {
                                        totalfoodDrinks += expenseModel.getAmount();
                                        if (foodDrinksLimit != 0) {
                                            if (totalfoodDrinks >= foodDrinksLimit) {
                                                if (alertfoodDrinks == 0) {
                                                    alertfoodDrinks = 1;
                                                    showAlertDialog("Your food budget exceeded!");
                                                }
                                            }
                                        }
                                    } else if (expenseModel.getCategory().equals("Shopping")) {
                                        totalshopping += expenseModel.getAmount();
                                        if (shoppingLimit != 0) {
                                            if (totalshopping >= shoppingLimit) {
                                                if (alertshopping == 0) {
                                                    alertshopping = 1;
                                                    showAlertDialog("Your shopping budget exceeded!");
                                                }
                                            }
                                        }
                                    } else if (expenseModel.getCategory().equals("Housing")) {
                                        totalhousing += expenseModel.getAmount();
                                        if (housingLimit != 0) {
                                            if (totalhousing >= housingLimit) {
                                                if (alerthousing == 0) {
                                                    alertshopping = 1;
                                                    showAlertDialog("Your housing budget exceeded!");
                                                }
                                            }
                                        }
                                    } else if (expenseModel.getCategory().equals("Transportation")) {
                                        totaltransportation += expenseModel.getAmount();
                                        if (transportationLimit != 0) {
                                            if (totaltransportation >= transportationLimit) {
                                                if (alerttransportation == 0) {
                                                    alerttransportation = 1;
                                                    showAlertDialog("Your transportation budget exceeded!");
                                                }
                                            }
                                        }
                                    } else if (expenseModel.getCategory().equals("Vehicle")) {
                                        totalvehicle += expenseModel.getAmount();
                                        if (vehicleLimit != 0) {
                                            if (totalvehicle >= vehicleLimit) {
                                                if (alertvehicle == 0) {
                                                    alertvehicle = 1;
                                                    showAlertDialog("Your vehicle budget exceeded!");
                                                }
                                            }
                                        }
                                    } else if (expenseModel.getCategory().equals("Life & Entertainment")) {
                                        totallifeEntertainment += expenseModel.getAmount();
                                        if (lifeEntertainmentLimit != 0) {
                                            if (totallifeEntertainment >= lifeEntertainmentLimit) {
                                                if (alertlifeEntertainment == 0) {
                                                    alertlifeEntertainment = 1;
                                                    showAlertDialog("Your life entertainment budget exceeded!");
                                                }
                                            }
                                        }
                                    } else if (expenseModel.getCategory().equals("Communication")) {
                                        totalcommunication += expenseModel.getAmount();
                                        if (communicationLimit != 0) {
                                            if (totalcommunication >= communicationLimit) {
                                                if (alertcommunication == 0) {
                                                    alertcommunication = 1;
                                                    showAlertDialog("Your communication budget exceeded!");
                                                }
                                            }
                                        }
                                    } else if (expenseModel.getCategory().equals("Investments")) {
                                        totalinvestments += expenseModel.getAmount();
                                        if (investmentsLimit != 0) {
                                            if (totalinvestments >= investmentsLimit) {
                                                if (alertinvestments == 0) {
                                                    alertinvestments = 1;
                                                    showAlertDialog("Your investment budget exceeded!");
                                                }
                                            }
                                        }
                                    } else if (expenseModel.getCategory().equals("Payment alimony to former wife")) {
                                        totalalimonyPayment += expenseModel.getAmount();
                                        if (alimonyPaymentLimit != 0) {
                                            if (totalalimonyPayment >= alimonyPaymentLimit) {
                                                if (alertalimonyPayment == 0) {
                                                    alertalimonyPayment = 1;
                                                    showAlertDialog("Your Payment alimony to former wife budget exceeded!");
                                                }
                                            }
                                        }
                                    } else if (expenseModel.getCategory().equals("SSPN(Child Education Saving)")) {
                                        totalsspnChildEducationSaving += expenseModel.getAmount();
                                        if (sspnChildEducationSavingLimit != 0) {
                                            if (totalsspnChildEducationSaving >= sspnChildEducationSavingLimit) {
                                                if (alertsspnChildEducationSaving == 0) {
                                                    alertsspnChildEducationSaving = 1;
                                                    showAlertDialog("Your SSPN(Child Education Saving) budget exceeded!");
                                                }
                                            }
                                        }
                                    } else if (expenseModel.getCategory().equals("Breastfeeding Equipment")) {
                                        totalbreastfeedingEquipment += expenseModel.getAmount();
                                        if (breastfeedingEquipmentLimit != 0) {
                                            if (totalbreastfeedingEquipment >= breastfeedingEquipmentLimit) {
                                                if (alertbreastfeedingEquipment == 0) {
                                                    alertbreastfeedingEquipment = 1;
                                                    showAlertDialog("Your Breastfeeding Equipment budget exceeded!");
                                                }
                                            }
                                        }
                                    } else if (expenseModel.getCategory().equals("Children Centres and kindergartens fees")) {
                                        totalchildrenCentresKindergartenFees += expenseModel.getAmount();
                                        if (childrenCentresKindergartenFeesLimit != 0) {
                                            if (totalchildrenCentresKindergartenFees >= childrenCentresKindergartenFeesLimit) {
                                                if (alertchildrenCentresKindergartenFees == 0) {
                                                    alertchildrenCentresKindergartenFees = 1;
                                                    showAlertDialog("Your Children Centres and kindergartens fees budget exceeded!");
                                                }
                                            }
                                        }
                                    } else if (expenseModel.getCategory().equals("Parent Medical")) {
                                        totalparentMedical += expenseModel.getAmount();
                                        if (parentMedicalLimit != 0) {
                                            if (totalparentMedical >= parentMedicalLimit) {
                                                if (alertparentMedical == 0) {
                                                    alertparentMedical = 1;
                                                    showAlertDialog("Your Parent Medical budget exceeded!");
                                                }
                                            }
                                        }
                                    } else if (expenseModel.getCategory().equals("Annuity/PRS")) {
                                        totalannuityPRS += expenseModel.getAmount();
                                        if (annuityPRSLimit != 0) {
                                            if (totalannuityPRS >= annuityPRSLimit) {
                                                if (alertannuityPRS == 0) {
                                                    alertannuityPRS = 1;
                                                    showAlertDialog("Your Annuity/PRS budget exceeded!");
                                                }
                                            }
                                        }
                                    } else if (expenseModel.getCategory().equals("Education and Medical Insurance")) {
                                        totaleducationMedicalInsurance += expenseModel.getAmount();
                                        if (educationMedicalInsuranceLimit != 0) {
                                            if (totaleducationMedicalInsurance >= educationMedicalInsuranceLimit) {
                                                if (alerteducationMedicalInsurance == 0) {
                                                    alerteducationMedicalInsurance = 1;
                                                    showAlertDialog("Your Education and Medical Insurance budget exceeded!");
                                                }
                                            }
                                        }
                                    } else if (expenseModel.getCategory().equals("Education Fees(Self)")) {
                                        totaleducationFeesSelf += expenseModel.getAmount();
                                        if (educationFeesSelfLimit != 0) {
                                            if (totaleducationFeesSelf >= educationFeesSelfLimit) {
                                                if (alerteducationFeesSelf == 0) {
                                                    alerteducationFeesSelf = 1;
                                                    showAlertDialog("Your Education Fees(Self) budget exceeded!");
                                                }
                                            }
                                        }
                                    } else if (expenseModel.getCategory().equals("Supporting Equipment")) {
                                        totalsupportingEquipment += expenseModel.getAmount();
                                        if (supportingEquipmentLimit != 0) {
                                            if (totalsupportingEquipment >= supportingEquipmentLimit) {
                                                if (alertsupportingEquipment == 0) {
                                                    alertsupportingEquipment = 1;
                                                    showAlertDialog("Your Supporting Equipment budget exceeded!");
                                                }
                                            }
                                        }
                                    } else if (expenseModel.getCategory().equals("Medical Expenses(Self/Spouse/Child)")) {
                                        totalmedicalExpenses += expenseModel.getAmount();
                                        if (medicalExpensesLimit != 0) {
                                            if (totalmedicalExpenses >= medicalExpensesLimit) {
                                                if (alertmedicalExpenses == 0) {
                                                    alertmedicalExpenses = 1;
                                                    showAlertDialog("Your Medical Expenses(Self/Spouse/Child) budget exceeded!");
                                                }
                                            }
                                        }
                                    } else if (expenseModel.getCategory().equals("EPF/KWSP")) {
                                        totalepfKwsp += expenseModel.getAmount();
                                        if (epfKwspLimit != 0) {
                                            if (totalepfKwsp >= epfKwspLimit) {
                                                if (alertepfKwsp == 0) {
                                                    alertepfKwsp = 1;
                                                    showAlertDialog("Your EPF/KWSP budget exceeded!");
                                                }
                                            }
                                        }
                                    } else if (expenseModel.getCategory().equals("Life Insurance")) {
                                        totallifeInsurance += expenseModel.getAmount();
                                        if (lifeInsuranceLimit != 0) {
                                            if (totallifeInsurance >= lifeInsuranceLimit) {
                                                if (alertlifeInsurance == 0) {
                                                    alertlifeInsurance = 1;
                                                    showAlertDialog("Your Life Insurance budget exceeded!");
                                                }
                                            }
                                        }
                                    } else if (expenseModel.getCategory().equals("LifeStyle")) {
                                        totallifestyle += expenseModel.getAmount();
                                        if (lifestyleLimit != 0) {
                                            if (totallifestyle >= lifestyleLimit) {
                                                if (alertlifestyle == 0) {
                                                    alertlifestyle = 1;
                                                    showAlertDialog("Your LifeStyle budget exceeded!");
                                                }
                                            }
                                        }
                                    } else if (expenseModel.getCategory().equals("LifeStyle(Additional)")) {
                                        totallifestyleAdditional += expenseModel.getAmount();
                                        if (lifestyleAdditionalLimit != 0) {
                                            if (totallifestyleAdditional >= lifestyleAdditionalLimit) {
                                                if (alertlifestyleAdditional == 0) {
                                                    alertlifestyleAdditional = 1;
                                                    showAlertDialog("Your LifeStyle(Additional) budget exceeded!");
                                                }
                                            }
                                        }
                                    } else if (expenseModel.getCategory().equals("LifeStyle(Sport)")) {
                                        totallifestyleSport += expenseModel.getAmount();
                                        if (lifestyleSportLimit != 0) {
                                            if (totallifestyleSport >= lifestyleSportLimit) {
                                                if (alertlifestyleSport == 0) {
                                                    alertlifestyleSport = 1;
                                                    showAlertDialog("Your LifeStyle(Sport) budget exceeded!");
                                                }
                                            }
                                        }
                                    } else if (expenseModel.getCategory().equals("SOCSO/PERKESO")) {
                                        totalsocsoPerkeso += expenseModel.getAmount();
                                        if (socsoPerkesoLimit != 0) {
                                            if (totalsocsoPerkeso >= socsoPerkesoLimit) {
                                                if (alertsocsoPerkeso == 0) {
                                                    alertsocsoPerkeso = 1;
                                                    showAlertDialog("Your SOCSO/PERKESO budget exceeded!");
                                                }
                                            }
                                        }
                                    } else if (expenseModel.getCategory().equals("Domestic Travel Expenses")) {
                                        totaldomesticTravelExpenses += expenseModel.getAmount();
                                        if (domesticTravelExpensesLimit != 0) {
                                            if (totaldomesticTravelExpenses >= domesticTravelExpensesLimit) {
                                                if (alertdomesticTravelExpenses == 0) {
                                                    alertdomesticTravelExpenses = 1;
                                                    showAlertDialog("Your Domestic Travel Expenses budget exceeded!");
                                                }
                                            }
                                        }
                                    } else if (expenseModel.getCategory().equals("Electrical Vehicle Charging Expenses")) {
                                        totalelectricalVehicleChargingExpenses += expenseModel.getAmount();
                                        if (electricalVehicleChargingExpensesLimit != 0) {
                                            if (totalelectricalVehicleChargingExpenses >= electricalVehicleChargingExpensesLimit) {
                                                if (alertelectricalVehicleChargingExpenses == 0) {
                                                    alertelectricalVehicleChargingExpenses = 1;
                                                    showAlertDialog("Your Electrical Vehicle Charging Expenses budget exceeded!");
                                                }
                                            }
                                        }
                                    } else if (expenseModel.getCategory().equals("Monthly Tax Deduction(MTD/PCB)")) {
                                        totalmonthlyTaxDeduction += expenseModel.getAmount();
                                        if (monthlyTaxDeductionLimit != 0) {
                                            if (totalmonthlyTaxDeduction >= monthlyTaxDeductionLimit) {
                                                if (alertmonthlyTaxDeduction == 0) {
                                                    alertmonthlyTaxDeduction = 1;
                                                    showAlertDialog("Your Monthly Tax Deduction(MTD/PCB) budget exceeded!");
                                                }
                                            }
                                        }
                                    } else if (expenseModel.getCategory().equals("Zakat")) {
                                        totalzakat += expenseModel.getAmount();
                                        if (zakatLimit != 0) {
                                            if (totalzakat >= zakatLimit) {
                                                if (alertzakat == 0) {
                                                    alertzakat = 1;
                                                    showAlertDialog("Your Zakat budget exceeded!");
                                                }
                                            }
                                        }
                                    }
                                }

                                if (expenseModel.getDate().contains("2022")) {
                                    if (expenseModel.getCategory() != null) {
                                        if (expenseModel.getCategory().equals("Food & Drinks")) {
                                            foodDrinks += expenseModel.getAmount();
                                        } else if (expenseModel.getCategory().equals("Shopping")) {
                                            shopping += expenseModel.getAmount();
                                        } else if (expenseModel.getCategory().equals("Housing")) {
                                            housing += expenseModel.getAmount();
                                        } else if (expenseModel.getCategory().equals("Transportation")) {
                                            transportation += expenseModel.getAmount();
                                        } else if (expenseModel.getCategory().equals("Vehicle")) {
                                            vehicle += expenseModel.getAmount();
                                        } else if (expenseModel.getCategory().equals("Life & Entertainment")) {
                                            lifeEntertainment += expenseModel.getAmount();
                                        } else if (expenseModel.getCategory().equals("Communication")) {
                                            communication += expenseModel.getAmount();
                                        } else if (expenseModel.getCategory().equals("Investments")) {
                                            investments += expenseModel.getAmount();
                                        } else if (expenseModel.getCategory().equals("Payment alimony to former wife")) {
                                            alimonyPayment += expenseModel.getAmount();
                                        } else if (expenseModel.getCategory().equals("SSPN(Child Education Saving)")) {
                                            sspnChildEducationSaving += expenseModel.getAmount();
                                        } else if (expenseModel.getCategory().equals("Breastfeeding Equipment")) {
                                            breastfeedingEquipment += expenseModel.getAmount();
                                        } else if (expenseModel.getCategory().equals("Children Centres and kindergartens fees")) {
                                            childrenCentresKindergartenFees += expenseModel.getAmount();
                                        } else if (expenseModel.getCategory().equals("Parent Medical")) {
                                            parentMedical += expenseModel.getAmount();
                                        } else if (expenseModel.getCategory().equals("Annuity/PRS")) {
                                            annuityPRS += expenseModel.getAmount();
                                        } else if (expenseModel.getCategory().equals("Education and Medical Insurance")) {
                                            educationMedicalInsurance += expenseModel.getAmount();
                                        } else if (expenseModel.getCategory().equals("Education Fees(Self)")) {
                                            educationFeesSelf += expenseModel.getAmount();
                                        } else if (expenseModel.getCategory().equals("Supporting Equipment")) {
                                            supportingEquipment += expenseModel.getAmount();
                                        } else if (expenseModel.getCategory().equals("Medical Expenses(Self/Spouse/Child)")) {
                                            medicalExpenses += expenseModel.getAmount();
                                        } else if (expenseModel.getCategory().equals("EPF/KWSP")) {
                                            epfKwsp += expenseModel.getAmount();
                                        } else if (expenseModel.getCategory().equals("Life Insurance")) {
                                            lifeInsurance += expenseModel.getAmount();
                                        } else if (expenseModel.getCategory().equals("LifeStyle")) {
                                            lifestyle += expenseModel.getAmount();
                                        } else if (expenseModel.getCategory().equals("LifeStyle(Additional)")) {
                                            lifestyleAdditional += expenseModel.getAmount();
                                        } else if (expenseModel.getCategory().equals("LifeStyle(Sport)")) {
                                            lifestyleSport += expenseModel.getAmount();
                                        } else if (expenseModel.getCategory().equals("SOCSO/PERKESO")) {
                                            socsoPerkeso += expenseModel.getAmount();
                                        } else if (expenseModel.getCategory().equals("Domestic Travel Expenses")) {
                                            domesticTravelExpenses += expenseModel.getAmount();
                                        } else if (expenseModel.getCategory().equals("Electrical Vehicle Charging Expenses")) {
                                            electricalVehicleChargingExpenses += expenseModel.getAmount();
                                        } else if (expenseModel.getCategory().equals("Monthly Tax Deduction(MTD/PCB)")) {
                                            monthlyTaxDeduction += expenseModel.getAmount();
                                        } else if (expenseModel.getCategory().equals("Zakat")) {
                                            zakat += expenseModel.getAmount();
                                        }
                                    }
                                }
                            }
                            expensesAdapter.add(expenseModel);
                        }


                        totalAmount = income - expense;

                        String formattedTotal = String.format("%.2f", totalAmount);

                        total_amount_textview = findViewById(R.id.total_amount);
                        total_amount_textview.setText("RM " + formattedTotal);


                        progressBar = findViewById(R.id.progressBar);

                        String formattedIncome = String.format("%.2f", income);
                        String formattedExpense = String.format("%.2f", expense);

                        double IncomeDouble = Double.parseDouble(formattedIncome);
                        double ExpenseDouble = Double.parseDouble(formattedExpense);

                        progressValue = (int) ((IncomeDouble - ExpenseDouble) / IncomeDouble * 100);
                        progressBar.setProgress(progressValue);


                        Intent intent2 = new Intent(ExpensesManagerActivity.this, TaxationActivity.class);
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
                        intent2.putExtra("zakat", zakat);
                    }
                });
    }

    private void showAlertDialog(String message) {
        // Setup alert user

        AlertDialog.Builder builder = new AlertDialog.Builder(ExpensesManagerActivity.this);
        builder.setTitle(message);
        builder.setMessage("Please control your expenses");

        //Open Email Apps if User clicks/taps continue button
        builder.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                alertfoodDrinks = 1.0;
                alertshopping = 1.0;
                alerthousing = 1.0;
                alerttransportation = 1.0;
                alertvehicle = 1.0;
                alertlifeEntertainment = 1.0;
                alertcommunication = 1.0;
                alertinvestments = 1.0;
                alertalimonyPayment = 1.0;
                alertsspnChildEducationSaving = 1.0;
                alertbreastfeedingEquipment = 1.0;
                alertchildrenCentresKindergartenFees = 1.0;
                alertparentMedical = 1.0;
                alertannuityPRS = 1.0;
                alerteducationMedicalInsurance = 1.0;
                alerteducationFeesSelf = 1.0;
                alertsupportingEquipment = 1.0;
                alertmedicalExpenses = 1.0;
                alertepfKwsp = 1.0;
                alertlifeInsurance = 1.0;
                alertlifestyle = 1.0;
                alertlifestyleAdditional = 1.0;
                alertlifestyleSport = 1.0;
                alertsocsoPerkeso = 1.0;
                alertdomesticTravelExpenses = 1.0;
                alertelectricalVehicleChargingExpenses = 1.0;
                alertmonthlyTaxDeduction = 1.0;
                alertzakat = 1.0;
            }
        });

        // Create Alert Dialog Box
        AlertDialog alertDialog = builder.create();

        //Change the button color to continue
        alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {
                alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(getResources().getColor(R.color.red));
            }
        });

        //Show the Alert Dialog Box
        alertDialog.show();
    }


    @Override
    public void onClick(ExpenseModel expenseModel) {

        Intent intent = new Intent(ExpensesManagerActivity.this, AddExpenseActivity.class);

        intent.putExtra("model", expenseModel);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
    }


}