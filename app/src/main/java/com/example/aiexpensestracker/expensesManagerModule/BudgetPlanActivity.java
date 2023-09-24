package com.example.aiexpensestracker.expensesManagerModule;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aiexpensestracker.R;
import com.example.aiexpensestracker.taxationModule.TaxationCalculationActivity;
import com.example.aiexpensestracker.userManagementModule.DeleteProfileActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class BudgetPlanActivity extends AppCompatActivity {

    private TextView totalIncomeTextview, totalExpenseTextView, totalAmountTextView, textView_row_1, textView_row_2, textView_row_3, textView_row_4,textView_row_5;

    private EditText editText_budget_limit;

    private Button buttonBudgetPlan;

    String[] items = {"Budget 1", "Budget 2", "Budget 3", "Budget 4", "Budget 5"};
    private static final String TAG = "BudgetPlanActivity";


    String[] items1 = {"Food & Drinks", "Shopping", "Housing", "Transportation", "Vehicle", "Life & Entertainment", "Communication", "Investments","Payment alimony to former wife", "SSPN(Child Education Saving)", "Breastfeeding Equipment", "Children Centres and kindergartens fees", "Parent Medical",
            "Annuity/PRS", "Education and Medical Insurance", "Education Fees(Self)", "Supporting Equipment", "Medical Expenses(Self/Spouse/Child)", "EPF/KWSP", "Life Insurance", "LifeStyle",
            "LifeStyle(Additional)", "LifeStyle(Sport)", "SOCSO/PERKESO", "Domestic Travel Expenses", "Electrical Vehicle Charging Expenses", "Monthly Tax Deduction(MTD/PCB)", "Zakat"};
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
    private String category, budgetPlanNumber;
    private Button delete1, delete2, delete3, delete4, delete5;

    AutoCompleteTextView autoCompleteTxt;
    ArrayAdapter<String> adapterItems;

    AutoCompleteTextView autoCompleteTxt1;
    ArrayAdapter<String> adapterItems1;

    FirebaseDatabase database = FirebaseDatabase.getInstance("https://aiexpensestracker-default-rtdb.asia-southeast1.firebasedatabase.app");
    DatabaseReference ref = database.getReference("budget_plans");

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget_plan);

        getSupportActionBar().setTitle("Budget Plan");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        double income = getIntent().getDoubleExtra("income", 0.0);
        double expense = getIntent().getDoubleExtra("expense", 0.0);
        double totalAmount = getIntent().getDoubleExtra("totalAmount", 0.0);

        textView_row_1 = findViewById(R.id.textView_row_1);
        textView_row_2 = findViewById(R.id.textView_row_2);
        textView_row_3 = findViewById(R.id.textView_row_3);
        textView_row_4 = findViewById(R.id.textView_row_4);
        textView_row_5 = findViewById(R.id.textView_row_5);

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot childSnapshot : dataSnapshot.getChildren()) {
                    BudgetPlan budgetPlan = childSnapshot.getValue(BudgetPlan.class);
                    if (budgetPlan.budgetPlanNumber.equals("Budget 1")) {
                        String text = "Budget 1:\nCategories: " + budgetPlan.category + "\nAmount: RM" + budgetPlan.budgetLimit;
                        textView_row_1.setText(text);
                        break; // exit the loop after finding the matching budget plan
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e(TAG, "onCancelled", databaseError.toException());
            }
        });

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot childSnapshot : dataSnapshot.getChildren()) {
                    BudgetPlan budgetPlan = childSnapshot.getValue(BudgetPlan.class);
                    if (budgetPlan.budgetPlanNumber.equals("Budget 2")) {
                        String text = "Budget 2:\nCategories: " + budgetPlan.category + "\nAmount: RM" + budgetPlan.budgetLimit;
                        textView_row_2.setText(text);
                        break; // exit the loop after finding the matching budget plan
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e(TAG, "onCancelled", databaseError.toException());
            }
        });

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot childSnapshot : dataSnapshot.getChildren()) {
                    BudgetPlan budgetPlan = childSnapshot.getValue(BudgetPlan.class);
                    if (budgetPlan.budgetPlanNumber.equals("Budget 3")) {
                        String text = "Budget 3:\nCategories: " + budgetPlan.category + "\nAmount: RM" + budgetPlan.budgetLimit;
                        textView_row_3.setText(text);
                        break; // exit the loop after finding the matching budget plan
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e(TAG, "onCancelled", databaseError.toException());
            }
        });

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot childSnapshot : dataSnapshot.getChildren()) {
                    BudgetPlan budgetPlan = childSnapshot.getValue(BudgetPlan.class);
                    if (budgetPlan.budgetPlanNumber.equals("Budget 4")) {
                        String text = "Budget 4:\nCategories: " + budgetPlan.category + "\nAmount: RM" + budgetPlan.budgetLimit;
                        textView_row_4.setText(text);
                        break; // exit the loop after finding the matching budget plan
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e(TAG, "onCancelled", databaseError.toException());
            }
        });

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot childSnapshot : dataSnapshot.getChildren()) {
                    BudgetPlan budgetPlan = childSnapshot.getValue(BudgetPlan.class);
                    if (budgetPlan.budgetPlanNumber.equals("Budget 5")) {
                        String text = "Budget 5:\nCategories: " + budgetPlan.category + "\nAmount: RM" + budgetPlan.budgetLimit;
                        textView_row_5.setText(text);
                        break; // exit the loop after finding the matching budget plan
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e(TAG, "onCancelled", databaseError.toException());
            }
        });

        delete1 = findViewById(R.id.delete1);
        delete1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView_row_1 = findViewById(R.id.textView_row_1);

                budgetPlanNumber = "Budget 1";

                if (budgetPlanNumber.equals("Budget 1")) {

                    category = "No Categories";
                    double editText_budget_limit_value = 0;
                    textView_row_1.setText("Budget 1: \nCategories: " + category + " ,  \nAmount: RM" + editText_budget_limit_value);
                    BudgetPlan budgetPlan = new BudgetPlan(budgetPlanNumber, category, editText_budget_limit_value);
                    ref.child(budgetPlanNumber).setValue(budgetPlan);


                }
            }
        });

        delete2 = findViewById(R.id.delete2);
        delete2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView_row_2 = findViewById(R.id.textView_row_2);

                budgetPlanNumber = "Budget 2";

                if (budgetPlanNumber.equals("Budget 2")) {

                    category = "No Categories";
                    double editText_budget_limit_value = 0;

                    textView_row_2.setText("Budget 2: \nCategories: " + category + " ,  \nAmount: RM" + editText_budget_limit_value);
                    BudgetPlan budgetPlan = new BudgetPlan(budgetPlanNumber, category, editText_budget_limit_value);
                    ref.child(budgetPlanNumber).setValue(budgetPlan);


                }
            }
        });

        delete3 = findViewById(R.id.delete3);
        delete3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView_row_3 = findViewById(R.id.textView_row_3);

                budgetPlanNumber = "Budget 3";

                if (budgetPlanNumber.equals("Budget 3")) {

                    category = "No Categories";
                    double editText_budget_limit_value = 0;

                    textView_row_3.setText("Budget 3: \nCategories: " + category + " ,  \nAmount: RM" + editText_budget_limit_value);
                    BudgetPlan budgetPlan = new BudgetPlan(budgetPlanNumber, category, editText_budget_limit_value);
                    ref.child(budgetPlanNumber).setValue(budgetPlan);


                }
            }
        });

        delete4 = findViewById(R.id.delete4);
        delete4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView_row_4 = findViewById(R.id.textView_row_4);

                budgetPlanNumber = "Budget 4";

                if (budgetPlanNumber.equals("Budget 4")) {

                    category = "No Categories";
                    double editText_budget_limit_value = 0;

                    textView_row_4.setText("Budget 4: \nCategories: " + category + " ,  \nAmount: RM" + editText_budget_limit_value);
                    BudgetPlan budgetPlan = new BudgetPlan(budgetPlanNumber, category, editText_budget_limit_value);
                    ref.child(budgetPlanNumber).setValue(budgetPlan);


                }
            }
        });

        delete5 = findViewById(R.id.delete5);
        delete5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView_row_5 = findViewById(R.id.textView_row_5);

                budgetPlanNumber = "Budget 5";

                if (budgetPlanNumber.equals("Budget 5")) {

                    category = "No Categories";
                    double editText_budget_limit_value = 0;

                    textView_row_5.setText("Budget 5: \nCategories: " + category + " ,  \nAmount: RM" + editText_budget_limit_value);
                    BudgetPlan budgetPlan = new BudgetPlan(budgetPlanNumber, category, editText_budget_limit_value);
                    ref.child(budgetPlanNumber).setValue(budgetPlan);


                }
            }
        });

        totalIncomeTextview = findViewById(R.id.total_income);
        totalExpenseTextView = findViewById(R.id.total_expense);
        totalAmountTextView = findViewById(R.id.total_amount);


        totalIncomeTextview.setText(String.valueOf(income));
        totalExpenseTextView.setText(String.valueOf(expense));
        totalAmountTextView.setText(String.valueOf(totalAmount));


        autoCompleteTxt = findViewById(R.id.auto_complete_txt2);
        autoCompleteTxt.setText("Budget 1");
        budgetPlanNumber = "Budget 1";
        adapterItems = new ArrayAdapter<String>(this,R.layout.list_item,items);

        autoCompleteTxt.setAdapter(adapterItems);

        autoCompleteTxt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                budgetPlanNumber = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), "Budget Plan: " + budgetPlanNumber, Toast.LENGTH_SHORT).show();
            }
        });


        autoCompleteTxt1 = findViewById(R.id.auto_complete_txt_category);
        autoCompleteTxt1.setText("Food & Drinks");
        category = "Food & Drinks";
        adapterItems1 = new ArrayAdapter<String>(this,R.layout.list_item,items1);

        autoCompleteTxt1.setAdapter(adapterItems1);

        autoCompleteTxt1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                category = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), "Category: " + category, Toast.LENGTH_SHORT).show();
            }
        });

        buttonBudgetPlan = findViewById(R.id.button_budget_plan_set);





        buttonBudgetPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                editText_budget_limit = findViewById(R.id.editText_budget_limit);
                String editText_budget_limit_text = editText_budget_limit.getText().toString();

                if (TextUtils.isEmpty(editText_budget_limit_text)) {
                    Toast.makeText(BudgetPlanActivity.this, "Please set your budget limit", Toast.LENGTH_LONG).show();
                    editText_budget_limit.setError("Please set the budget limit");
                    editText_budget_limit.requestFocus();
                } else {
                    double editText_budget_limit_value = Double.parseDouble(editText_budget_limit_text);
                    Toast.makeText(BudgetPlanActivity.this, "Ans: " + editText_budget_limit_value, Toast.LENGTH_SHORT).show();

                    if (budgetPlanNumber.equals("Budget 1")) {

                        textView_row_1.setText("Budget 1: ( Categories: " + category + " ,  Amount: RM" + editText_budget_limit_text + ")");
                        BudgetPlan budgetPlan = new BudgetPlan(budgetPlanNumber, category, editText_budget_limit_value);
                        ref.child(budgetPlanNumber).setValue(budgetPlan);


                    } else if (budgetPlanNumber.equals("Budget 2")) {

                        textView_row_2.setText("Budget 2: ( Categories: " + category + " ,  Amount: RM" + editText_budget_limit_text + ")");
                        BudgetPlan budgetPlan = new BudgetPlan(budgetPlanNumber, category, editText_budget_limit_value);
                        ref.child(budgetPlanNumber).setValue(budgetPlan);

                    } else if (budgetPlanNumber.equals("Budget 3")) {

                        textView_row_3.setText("Budget 2: ( Categories: " + category + " ,  Amount: RM" + editText_budget_limit_text + ")");
                        BudgetPlan budgetPlan = new BudgetPlan(budgetPlanNumber, category, editText_budget_limit_value);
                        ref.child(budgetPlanNumber).setValue(budgetPlan);

                    } else if (budgetPlanNumber.equals("Budget 4")) {

                        textView_row_4.setText("Budget 2: ( Categories: " + category + " ,  Amount: RM" + editText_budget_limit_text + ")");
                        BudgetPlan budgetPlan = new BudgetPlan(budgetPlanNumber, category, editText_budget_limit_value);
                        ref.child(budgetPlanNumber).setValue(budgetPlan);

                    } else if (budgetPlanNumber.equals("Budget 5")) {

                        textView_row_5.setText("Budget 2: ( Categories: " + category + " ,  Amount: RM" + editText_budget_limit_text + ")");
                        BudgetPlan budgetPlan = new BudgetPlan(budgetPlanNumber, category, editText_budget_limit_value);
                        ref.child(budgetPlanNumber).setValue(budgetPlan);

                    }
                }


                textView_row_2 = findViewById(R.id.textView_row_2);
                textView_row_3 = findViewById(R.id.textView_row_3);
                textView_row_4 = findViewById(R.id.textView_row_4);
                textView_row_5 = findViewById(R.id.textView_row_5);
                editText_budget_limit = findViewById(R.id.editText_budget_limit);


                String textView_row_1_value = textView_row_1.getText().toString();
                String textView_row_2_value = textView_row_2.getText().toString();
                String textView_row_3_value = textView_row_3.getText().toString();
                String textView_row_4_value = textView_row_4.getText().toString();
                String textView_row_5_value = textView_row_5.getText().toString();






            }
        });








    }
}