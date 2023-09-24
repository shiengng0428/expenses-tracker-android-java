package com.example.aiexpensestracker.expensesManagerModule;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.aiexpensestracker.R;
import com.example.aiexpensestracker.databinding.ActivityAddExpenseBinding;
import com.example.aiexpensestracker.userManagementModule.RegisterActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Instant;
import java.time.temporal.TemporalAdjuster;
import java.util.Calendar;
import java.util.UUID;

public class AddExpenseActivity extends AppCompatActivity {
    ActivityAddExpenseBinding binding;

    //DropDown List

    String[] items1 = {
            "Salaries",
            "Wages",
            "Commissions",
            "Bonuses",
            "Allowances",
            "Pensions",
            "Rent",
            "Interest",
            "Royalties",
            "Gains or profits from any trade",
            "Dividends",
            "Compensation for loss of employment",
            "Gift",
            "Inheritance"
    };

    String[] items2 = {"Food & Drinks", "Shopping", "Housing", "Transportation", "Vehicle", "Life & Entertainment", "Communication", "Investments","Payment alimony to former wife", "SSPN(Child Education Saving)", "Breastfeeding Equipment", "Children Centres and kindergartens fees", "Parent Medical",
    "Annuity/PRS", "Education and Medical Insurance", "Education Fees(Self)", "Supporting Equipment", "Medical Expenses(Self/Spouse/Child)", "EPF/KWSP", "Life Insurance", "LifeStyle",
    "LifeStyle(Additional)", "LifeStyle(Sport)", "SOCSO/PERKESO", "Domestic Travel Expenses", "Electrical Vehicle Charging Expenses", "Monthly Tax Deduction(MTD/PCB)", "Zakat"};




    AutoCompleteTextView autoCompleteTxt2;
    ArrayAdapter<String> adapterItems1;
    ArrayAdapter<String> adapterItems2;
    private String account, category;
    //DropDown List

    private DatePickerDialog picker;
    private EditText datePicker, timeString ;
    private TimePickerDialog timePicker;
    private String time, type;
    private ExpenseModel expenseModel;

    private double runningTotal = 0.0;

    //Add Receipt
    private ImageView imageViewUploadPic;
    private FirebaseAuth authProfile;
    private StorageReference storageReference;
    private FirebaseUser firebaseUser;
    private static final int PICK_IMAGE_REQUEST = 1;
    private Uri uriImage;
    private static final String TAG = "AddExpenseActivity";

    //Add Receipt




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddExpenseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        type = getIntent().getStringExtra("type");
        expenseModel = (ExpenseModel) getIntent().getSerializableExtra("model");

        if (type == null){
            type = expenseModel.getType();
            binding.amount.setText(String.valueOf(expenseModel.getAmount()));
            binding.autoCompleteTxt2.setText(expenseModel.getCategory());
            binding.note.setText(expenseModel.getNote());
            binding.itemName.setText(expenseModel.getItemName());
            binding.date.setText(expenseModel.getDate());
            binding.time.setText(expenseModel.getTime());
            binding.shopName.setText(expenseModel.getShopName());
            binding.phoneNumber.setText(expenseModel.getPhoneNumber());
            binding.address.setText(expenseModel.getAddress());

        }

//        if(expenseModel != null){
//            type = "";
//            binding.amount.setText("");
//            binding.autoCompleteTxt2.setText("");
//            binding.note.setText("");
//            binding.itemName.setText("");
//            binding.date.setText("");
//            binding.time.setText("");
//            binding.shopName.setText("");
//            binding.phoneNumber.setText("");
//            binding.address.setText("");
//        }

        if (type.equals("Income")) {
            getSupportActionBar().setTitle("Add Income");
            binding.incomeRadio.setChecked(true);

            autoCompleteTxt2 = findViewById(R.id.auto_complete_txt2);

            adapterItems2 = new ArrayAdapter<String>(this,R.layout.list_item,items1);

            autoCompleteTxt2.setAdapter(adapterItems2);

            autoCompleteTxt2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                    category = parent.getItemAtPosition(position).toString();
                    Toast.makeText(getApplicationContext(), "Item: " + category, Toast.LENGTH_SHORT).show();
                }
            });

        } else {
            getSupportActionBar().setTitle("Add Expense");
            autoCompleteTxt2 = findViewById(R.id.auto_complete_txt2);

            adapterItems2 = new ArrayAdapter<String>(this,R.layout.list_item,items2);

            autoCompleteTxt2.setAdapter(adapterItems2);

            autoCompleteTxt2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                    category = parent.getItemAtPosition(position).toString();
                    Toast.makeText(getApplicationContext(), "Item: " + category, Toast.LENGTH_SHORT).show();
                }
            });
            binding.expenseRadio.setChecked(true);
        }

        binding.incomeRadio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                type = "Income";
            }
        });

        binding.expenseRadio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                type = "Expense";
            }
        });

        //DropDown List - 2.category

        datePicker = findViewById(R.id.date);
        //Setting up DataPicker on EditText
        datePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calender = Calendar.getInstance();
                int day = calender.get(Calendar.DAY_OF_MONTH);
                int month = calender.get(Calendar.MONTH);
                int year = calender.get(Calendar.YEAR);

                //Date Picker Dialog
                picker = new DatePickerDialog(AddExpenseActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        datePicker.setText(dayOfMonth + "/" + (month + 1) + "/" + year);

                    }
                }, year, month, day);
                picker.show();
            }
        });

        timeString = findViewById(R.id.time);

// Setting up DataPicker on EditText
        timeString.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the current time
                final Calendar calendar = Calendar.getInstance();
                int hour = calendar.get(Calendar.HOUR_OF_DAY);
                int minute = calendar.get(Calendar.MINUTE);

                // Create a TimePickerDialog and set the initial values
                TimePickerDialog timePickerDialog = new TimePickerDialog(AddExpenseActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        // Set the selected time to the EditText
                        String time = String.format("%02d:%02d", hourOfDay, minute);
                        timeString.setText(time);
                    }
                }, hour, minute, false);

                // Show the TimePickerDialog
                timePickerDialog.show();

                // Set the current time in the TimePickerDialog
                timePickerDialog.updateTime(hour, minute);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();

        if (expenseModel == null){
            menuInflater.inflate(R.menu.add_menu, menu);
        } else {
            menuInflater.inflate(R.menu.update_menu, menu);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.saveExpense) {
            if (expenseModel == null) {
                createExpense();
            } else {

               updateExpense();
            }
            return true;
        }

        if (id == R.id.deleteExpense) {
            deleteExpense();
        }
        return false;
    }

    private void deleteExpense() {
        FirebaseFirestore.getInstance().collection("Expenses").document(expenseModel.getExpenseID()).delete();
        finish();

        Intent intent = new Intent(AddExpenseActivity.this, ExpensesManagerActivity.class);
        finish();
        startActivity(intent);

    }


//    private void createExpense() {
//
//
//        String expenseId = UUID.randomUUID().toString();
//
//        String amount = binding.amount.getText().toString();
//        double amountDouble = Double.parseDouble(amount);
//
//        boolean incomeChecked = binding.incomeRadio.isChecked();
//        String itemName = binding.itemName.getText().toString();
//        String note = binding.note.getText().toString();
//        String shopName = binding.shopName.getText().toString();
//        String phoneNumber = binding.phoneNumber.getText().toString();
//        String address = binding.address.getText().toString();
//        String selectedDate = datePicker.getText().toString();
//        time  = timeString.getText().toString();
//
//        if (incomeChecked) {
//            type = "Income";
//
//        } else {
//            type = "Expense";
//
//        }
//
//        if (amount.trim().length() == 0) {
//            binding.amount.setError("Empty");
//            return;
//        }
//
//        ExpenseModel expenseModel = new ExpenseModel(expenseId, amountDouble, type, category, itemName, note, selectedDate, time, shopName, phoneNumber, address, FirebaseAuth.getInstance().getUid());
//
//        FirebaseFirestore.getInstance().collection("Expenses").document(expenseId).set(expenseModel);
//        finish();
//
//
//    }

    private void createExpense() {

        // get the current count of expenses
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("Expenses")
                .get()
                .addOnSuccessListener(querySnapshot -> {
                    int expenseCount = querySnapshot.size();

                    // increment the count and generate the expense ID
                    expenseCount++;
                    String expenseId = "EP" + String.format("%03d", expenseCount);

                    String amount = binding.amount.getText().toString();
                    double amountDouble = Double.parseDouble(amount);

                    boolean incomeChecked = binding.incomeRadio.isChecked();
                    String itemName = binding.itemName.getText().toString();
                    String note = binding.note.getText().toString();
                    String shopName = binding.shopName.getText().toString();
                    String phoneNumber = binding.phoneNumber.getText().toString();
                    String address = binding.address.getText().toString();
                    String selectedDate = datePicker.getText().toString();
                    time = timeString.getText().toString();

                    if (incomeChecked) {
                        type = "Income";
                    } else {
                        type = "Expense";
                    }

                    if (amount.trim().length() == 0) {
                        binding.amount.setError("Empty");
                        return;
                    }

                    ExpenseModel expenseModel = new ExpenseModel(expenseId, amountDouble, type, category, itemName, note, selectedDate, time, shopName, phoneNumber, address, FirebaseAuth.getInstance().getUid());

                    FirebaseFirestore.getInstance().collection("Expenses").document(expenseId).set(expenseModel);
                    finish();
                })
                .addOnFailureListener(e -> Log.e(TAG, "Error getting expense count", e));
    }


    private void updateExpense() {
        ExpenseModel model = new ExpenseModel();

        String expenseId = expenseModel.getExpenseID();
        String amount = binding.amount.getText().toString();
        double amountDouble = Double.parseDouble(amount);
        boolean incomeChecked = binding.incomeRadio.isChecked();
        String itemName = binding.itemName.getText().toString();
        String note = binding.note.getText().toString();
        String shopName = binding.shopName.getText().toString();
        String phoneNumber = binding.phoneNumber.getText().toString();
        String address = binding.address.getText().toString();
        String selectedDate = datePicker.getText().toString();



            autoCompleteTxt2 = findViewById(R.id.auto_complete_txt2);
            String autoCompleteTxt2_value = autoCompleteTxt2.getText().toString();

        Toast.makeText(this, autoCompleteTxt2_value, Toast.LENGTH_SHORT).show();

        time = timeString.getText().toString();
        if (incomeChecked) {
            type = "Income";
        } else {
            type = "Expense";
        }

        if (amount.trim().length() == 0) {
            binding.amount.setError("Empty");
            return;
        }

        ExpenseModel expenseModel = new ExpenseModel(expenseId, amountDouble, type, autoCompleteTxt2_value, itemName, note, selectedDate, time, shopName, phoneNumber, address, FirebaseAuth.getInstance().getUid());
        FirebaseFirestore.getInstance().collection("Expenses").document(expenseId).set(expenseModel);
        finish();
    }







    @Override
    public void onBackPressed() {
        super.onBackPressed();
        // Reload the activity
        Intent intent = new Intent(AddExpenseActivity.this, ExpensesManagerActivity.class);
        finish();
        startActivity(intent);
    }
}