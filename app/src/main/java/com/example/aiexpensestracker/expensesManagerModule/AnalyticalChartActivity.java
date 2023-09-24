package com.example.aiexpensestracker.expensesManagerModule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.example.aiexpensestracker.R;
import com.example.aiexpensestracker.databinding.ActivityAnalyticalChartBinding;
import com.example.aiexpensestracker.databinding.ActivityExpensesManagerBinding;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class AnalyticalChartActivity extends AppCompatActivity {
    ActivityAnalyticalChartBinding binding;

    double income = 0.0;
    double expense = 0.0;
    double totalAmount = 0.0;
    double salaries = 0.0; //taxable
    double wages = 0.0; //taxable
    double commissions = 0.0; //taxable
    double bonuses = 0.0; //taxable
    double allowances = 0.0; //taxable
    double pensions = 0.0; //taxable
    double rent = 0.0; //taxable
    double interest = 0.0; //taxable
    double gainsProfits = 0.0;
    double dividendsInterestDiscounts = 0.0;
    double compensationLossEmployment = 0.0;
    double gift = 0.0;
    double inheritance = 0.0;
    double foodDrinks = 0.0;
    double shopping = 0.0;
    double housing = 0.0;
    double transportation = 0.0;
    double vehicle = 0.0;
    double lifeEntertainment = 0.0;
    double communication = 0.0;
    double investments = 0.0;
    double alimonyPayment = 0.0;
    double sspnChildEducationSaving = 0.0;
    double breastfeedingEquipment = 0.0;
    double childrenCentresKindergartenFees = 0.0;
    double parentMedical = 0.0;
    double annuityPRS = 0.0;
    double educationMedicalInsurance = 0.0;
    double educationFeesSelf = 0.0;
    double supportingEquipment = 0.0;
    double medicalExpenses = 0.0;
    double epfKwsp = 0.0;
    double lifeInsurance = 0.0;
    double lifestyle = 0.0;
    double lifestyleAdditional = 0.0;
    double lifestyleSport = 0.0;
    double socsoPerkeso = 0.0;
    double domesticTravelExpenses = 0.0;
    double electricalVehicleChargingExpenses = 0.0;
    private double monthlyTaxDeduction;
    private double zakatTotal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding= ActivityAnalyticalChartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().setTitle("Analytical Chart");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        income = getIntent().getDoubleExtra("income", 0.0);
        expense = getIntent().getDoubleExtra("expense", 0.0);
        totalAmount = getIntent().getDoubleExtra("totalAmount", 0.0);
        salaries = getIntent().getDoubleExtra("salaries", 0.0); //taxable
        wages = getIntent().getDoubleExtra("wages", 0.0); //taxable
        commissions = getIntent().getDoubleExtra("commissions", 0.0); //taxable
        bonuses = getIntent().getDoubleExtra("bonuses", 0.0); //taxable
        allowances = getIntent().getDoubleExtra("allowances", 0.0); //taxable
        pensions = getIntent().getDoubleExtra("pensions", 0.0); //taxable
        rent = getIntent().getDoubleExtra("rent", 0.0); //taxable
        interest = getIntent().getDoubleExtra("interest", 0.0); //taxable
        gainsProfits = getIntent().getDoubleExtra("gainsProfits", 0.0);
        dividendsInterestDiscounts = getIntent().getDoubleExtra("dividendsInterestDiscounts", 0.0);
        compensationLossEmployment = getIntent().getDoubleExtra("compensationLossEmployment", 0.0);
        gift = getIntent().getDoubleExtra("gift", 0.0);
        inheritance = getIntent().getDoubleExtra("inheritance", 0.0);
        foodDrinks = getIntent().getDoubleExtra("foodDrinks", 0.0);
        shopping = getIntent().getDoubleExtra("shopping", 0.0);
        housing = getIntent().getDoubleExtra("housing", 0.0);
        transportation = getIntent().getDoubleExtra("transportation", 0.0);
        vehicle = getIntent().getDoubleExtra("vehicle", 0.0);
        lifeEntertainment = getIntent().getDoubleExtra("lifeEntertainment", 0.0);
        communication = getIntent().getDoubleExtra("communication", 0.0);
        investments = getIntent().getDoubleExtra("investments", 0.0);
        alimonyPayment = getIntent().getDoubleExtra("alimonyPayment", 0.0);
        sspnChildEducationSaving = getIntent().getDoubleExtra("sspnChildEducationSaving", 0.0);
        breastfeedingEquipment = getIntent().getDoubleExtra("breastfeedingEquipment", 0.0);
        childrenCentresKindergartenFees = getIntent().getDoubleExtra("childrenCentresKindergartenFees", 0.0);
        parentMedical = getIntent().getDoubleExtra("parentMedical", 0.0);
        annuityPRS = getIntent().getDoubleExtra("annuityPRS", 0.0);
        educationMedicalInsurance = getIntent().getDoubleExtra("educationMedicalInsurance", 0.0);
        educationFeesSelf = getIntent().getDoubleExtra("educationFeesSelf", 0.0);
        supportingEquipment = getIntent().getDoubleExtra("supportingEquipment", 0.0);
        medicalExpenses = getIntent().getDoubleExtra("medicalExpenses", 0.0);
        epfKwsp = getIntent().getDoubleExtra("epfKwsp", 0.0);
        lifeInsurance = getIntent().getDoubleExtra("lifeInsurance", 0.0);
        lifestyle = getIntent().getDoubleExtra("lifestyle", 0.0);
        lifestyleAdditional = getIntent().getDoubleExtra("lifestyleAdditional", 0.0);
        lifestyleSport = getIntent().getDoubleExtra("lifestyleSport", 0.0);
        socsoPerkeso = getIntent().getDoubleExtra("socsoPerkeso", 0.0);
        domesticTravelExpenses = getIntent().getDoubleExtra("domesticTravelExpenses", 0.0);
        electricalVehicleChargingExpenses = getIntent().getDoubleExtra("electricalVehicleChargingExpenses", 0.0);
        monthlyTaxDeduction = getIntent().getDoubleExtra("monthlyTaxDeduction", 0.0);
        zakatTotal = getIntent().getDoubleExtra("zakat", 0.0);

        setUpPieChart(income, expense, totalAmount);
        float[] incomeValues = new float[]{(float) income};
        float[] expenseValues = new float[]{(float) expense};
        setUpBarChart(incomeValues, expenseValues);

        setUpVerticalBarChart();
        setUpHorizontalExpenseBarChart();
    }

    private void setUpPieChart(double income, double expense, double totalAmount) {
        List<PieEntry> pieEntryList = new ArrayList<>();
        List<Integer> colorsList = new ArrayList<>();
        if (income != 0) {
            pieEntryList.add(new PieEntry((float) income, "Income"));
            colorsList.add(getResources().getColor(R.color.lavender));
        }

        if (expense != 0) {  // corrected comparison to 'expense' instead of 'income'
            pieEntryList.add(new PieEntry((float) expense, "Expense"));
            colorsList.add(getResources().getColor(R.color.red));
        }

        PieDataSet pieDataSet = new PieDataSet(pieEntryList, String.valueOf(income=expense));
        pieDataSet.setColors(colorsList);
        pieDataSet.setValueTextColor(getResources().getColor(R.color.white));
        PieData pieData = new PieData(pieDataSet);

        binding.pieChart.setData(pieData);
        binding.pieChart.invalidate();
    }

    private void setUpBarChart(float[] incomeValues, float[] expenseValues) {
        List<BarEntry> incomeEntries = new ArrayList<>();
        for (int i = 0; i < incomeValues.length; i++) {
            incomeEntries.add(new BarEntry(i, incomeValues[i]));
        }
        BarDataSet incomeDataSet = new BarDataSet(incomeEntries, "Income");
        incomeDataSet.setColor(Color.BLUE);

        List<BarEntry> expenseEntries = new ArrayList<>();
        for (int i = 0; i < expenseValues.length; i++) {
            expenseEntries.add(new BarEntry(i, expenseValues[i]));
        }
        BarDataSet expenseDataSet = new BarDataSet(expenseEntries, "Expense");
        expenseDataSet.setColor(Color.RED);

        BarData barData = new BarData(incomeDataSet, expenseDataSet);

        binding.barChart.setData(barData);
        binding.barChart.invalidate();
    }

    private void setUpVerticalBarChart() {
        BarChart barChart = findViewById(R.id.vertical_bar_chart);

        // Get the new data from the intent extras
        double salaries = getIntent().getDoubleExtra("salaries", 0.0);
        double wages = getIntent().getDoubleExtra("wages", 0.0);
        double commissions = getIntent().getDoubleExtra("commissions", 0.0);
        double bonuses = getIntent().getDoubleExtra("bonuses", 0.0);
        double allowances = getIntent().getDoubleExtra("allowances", 0.0);
        double pensions = getIntent().getDoubleExtra("pensions", 0.0);
        double rent = getIntent().getDoubleExtra("rent", 0.0);
        double interest = getIntent().getDoubleExtra("interest", 0.0);
        double gainsProfits = getIntent().getDoubleExtra("gainsProfits", 0.0);
        double dividendsInterestDiscounts = getIntent().getDoubleExtra("dividendsInterestDiscounts", 0.0);
        double compensationLossEmployment = getIntent().getDoubleExtra("compensationLossEmployment", 0.0);
        double gift = getIntent().getDoubleExtra("gift", 0.0);
        double inheritance = getIntent().getDoubleExtra("inheritance", 0.0);

        // Create a new entries list with the new data
        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(0, (float) salaries));
        entries.add(new BarEntry(1, (float) wages));
        entries.add(new BarEntry(2, (float) commissions));
        entries.add(new BarEntry(3, (float) bonuses));
        entries.add(new BarEntry(4, (float) allowances));
        entries.add(new BarEntry(5, (float) pensions));
        entries.add(new BarEntry(6, (float) rent));
        entries.add(new BarEntry(7, (float) interest));
        entries.add(new BarEntry(8, (float) gainsProfits));
        entries.add(new BarEntry(9, (float) dividendsInterestDiscounts));
        entries.add(new BarEntry(10, (float) compensationLossEmployment));
        entries.add(new BarEntry(11, (float) gift));
        entries.add(new BarEntry(12, (float) inheritance));


        // Create a new BarDataSet with the updated entries list
        BarDataSet dataSet = new BarDataSet(entries, "Income");

        // Set the color of the bars
        dataSet.setColor(Color.BLUE);

        // Set the names for the x-axis
        String[] labels = {"Salaries", "Wages", "Commissions", "Bonuses", "Allowances", "Pensions", "Rent", "Interest", "GainProfits", "Dividends", "CompensationLoss", "Gift", "Inheritances"};
        XAxis xAxis = barChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(labels));

        // Set the x-axis labels to be vertical
        xAxis.setLabelRotationAngle(-90f);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

        // Create a new BarData object with the updated BarDataSet
        BarData barData = new BarData(dataSet);

        // Set the updated BarData to the BarChart and redraw the chart
        barChart.setData(barData);
        barChart.invalidate();
    }

    private void setUpHorizontalExpenseBarChart() {
        BarChart barChart1 = findViewById(R.id.vertical_bar_chart_expenses);

        // Get the new data from the intent extras
        income = getIntent().getDoubleExtra("income", 0.0);
        expense = getIntent().getDoubleExtra("expense", 0.0);
        totalAmount = getIntent().getDoubleExtra("totalAmount", 0.0);
        salaries = getIntent().getDoubleExtra("salaries", 0.0); //taxable
        wages = getIntent().getDoubleExtra("wages", 0.0); //taxable
        commissions = getIntent().getDoubleExtra("commissions", 0.0); //taxable
        bonuses = getIntent().getDoubleExtra("bonuses", 0.0); //taxable
        allowances = getIntent().getDoubleExtra("allowances", 0.0); //taxable
        pensions = getIntent().getDoubleExtra("pensions", 0.0); //taxable
        rent = getIntent().getDoubleExtra("rent", 0.0); //taxable
        interest = getIntent().getDoubleExtra("interest", 0.0); //taxable
        gainsProfits = getIntent().getDoubleExtra("gainsProfits", 0.0);
        dividendsInterestDiscounts = getIntent().getDoubleExtra("dividendsInterestDiscounts", 0.0);
        compensationLossEmployment = getIntent().getDoubleExtra("compensationLossEmployment", 0.0);
        gift = getIntent().getDoubleExtra("gift", 0.0);
        inheritance = getIntent().getDoubleExtra("inheritance", 0.0);
        foodDrinks = getIntent().getDoubleExtra("foodDrinks", 0.0);
        shopping = getIntent().getDoubleExtra("shopping", 0.0);
        housing = getIntent().getDoubleExtra("housing", 0.0);
        transportation = getIntent().getDoubleExtra("transportation", 0.0);
        vehicle = getIntent().getDoubleExtra("vehicle", 0.0);
        lifeEntertainment = getIntent().getDoubleExtra("lifeEntertainment", 0.0);
        communication = getIntent().getDoubleExtra("communication", 0.0);
        investments = getIntent().getDoubleExtra("investments", 0.0);
        alimonyPayment = getIntent().getDoubleExtra("alimonyPayment", 0.0);
        sspnChildEducationSaving = getIntent().getDoubleExtra("sspnChildEducationSaving", 0.0);
        breastfeedingEquipment = getIntent().getDoubleExtra("breastfeedingEquipment", 0.0);
        childrenCentresKindergartenFees = getIntent().getDoubleExtra("childrenCentresKindergartenFees", 0.0);
        parentMedical = getIntent().getDoubleExtra("parentMedical", 0.0);
        annuityPRS = getIntent().getDoubleExtra("annuityPRS", 0.0);
        educationMedicalInsurance = getIntent().getDoubleExtra("educationMedicalInsurance", 0.0);
        educationFeesSelf = getIntent().getDoubleExtra("educationFeesSelf", 0.0);
        supportingEquipment = getIntent().getDoubleExtra("supportingEquipment", 0.0);
        medicalExpenses = getIntent().getDoubleExtra("medicalExpenses", 0.0);
        epfKwsp = getIntent().getDoubleExtra("epfKwsp", 0.0);
        lifeInsurance = getIntent().getDoubleExtra("lifeInsurance", 0.0);
        lifestyle = getIntent().getDoubleExtra("lifestyle", 0.0);
        lifestyleAdditional = getIntent().getDoubleExtra("lifestyleAdditional", 0.0);
        lifestyleSport = getIntent().getDoubleExtra("lifestyleSport", 0.0);
        socsoPerkeso = getIntent().getDoubleExtra("socsoPerkeso", 0.0);
        domesticTravelExpenses = getIntent().getDoubleExtra("domesticTravelExpenses", 0.0);
        electricalVehicleChargingExpenses = getIntent().getDoubleExtra("electricalVehicleChargingExpenses", 0.0);
        monthlyTaxDeduction = getIntent().getDoubleExtra("monthlyTaxDeduction", 0.0);
        zakatTotal = getIntent().getDoubleExtra("zakat", 0.0);


        // Create a new entries list with the new data
        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(0, (float) foodDrinks));
        entries.add(new BarEntry(1, (float) shopping));
        entries.add(new BarEntry(2, (float) housing));
        entries.add(new BarEntry(3, (float) transportation));
        entries.add(new BarEntry(4, (float) vehicle));
        entries.add(new BarEntry(5, (float) lifeEntertainment));
        entries.add(new BarEntry(6, (float) communication));
        entries.add(new BarEntry(7, (float) investments));
        entries.add(new BarEntry(8, (float) alimonyPayment));
        entries.add(new BarEntry(9, (float) sspnChildEducationSaving));
        entries.add(new BarEntry(10, (float) breastfeedingEquipment));
        entries.add(new BarEntry(11, (float) childrenCentresKindergartenFees));
        entries.add(new BarEntry(12, (float) parentMedical));
        entries.add(new BarEntry(13, (float) annuityPRS));
        entries.add(new BarEntry(14, (float) educationMedicalInsurance));
        entries.add(new BarEntry(15, (float) educationFeesSelf));
        entries.add(new BarEntry(16, (float) supportingEquipment));
        entries.add(new BarEntry(17, (float) medicalExpenses));
        entries.add(new BarEntry(18, (float) epfKwsp));
        entries.add(new BarEntry(19, (float) lifeInsurance));
        entries.add(new BarEntry(20, (float) lifestyle));
        entries.add(new BarEntry(21, (float) lifestyleAdditional));
        entries.add(new BarEntry(22, (float) lifestyleSport));
        entries.add(new BarEntry(23, (float) socsoPerkeso));
        entries.add(new BarEntry(24, (float) domesticTravelExpenses));
        entries.add(new BarEntry(25, (float) electricalVehicleChargingExpenses));
        entries.add(new BarEntry(26, (float) monthlyTaxDeduction));
        entries.add(new BarEntry(27, (float) zakatTotal));

        // Create a new BarDataSet with the updated entries list
        BarDataSet dataSet1 = new BarDataSet(entries, "Expenses");

        // Set the color of the bars
        dataSet1.setColor(Color.BLUE);

        // Set the names for the x-axis
        String[] labels1 = {"foodDrinks",
                "shopping",
                "housing",
                "transportation",
                "vehicle",
                "lifeEntertainment",
                "communication",
                "investments",
                "alimonyPayment",
                "spnChildEducationSaving",
                "breastfeedingEquipment",
                "childrenCentresKindergartenFees",
                "parentMedical",
                "annuityPRS",
                "educationMedicalInsurance",
                "educationFeesSelf",
                "supportingEquipment",
                "medicalExpenses",
                "epfKwsp",
                "lifeInsurance",
                "lifestyle",
                "lifestyleAdditional",
                "lifestyleSport",
                "socsoPerkeso",
                "domesticTravelExpenses",
                "electricalVehicleChargingExpenses",
                "monthlyTaxDeduction",
                "zakatTotal"};

        XAxis xAxis1 = barChart1.getXAxis();
        xAxis1.setValueFormatter(new IndexAxisValueFormatter(labels1));

        // Set the x-axis labels to be vertical
        xAxis1.setLabelRotationAngle(-90f);
        xAxis1.setPosition(XAxis.XAxisPosition.BOTTOM);

        // Create a new BarData object with the updated BarDataSet
        BarData barData1 = new BarData(dataSet1);

        // Set the updated BarData to the BarChart and redraw the chart
        barChart1.setData(barData1);
        barChart1.invalidate();


    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(AnalyticalChartActivity.this, ExpensesManagerActivity.class);
        income = 0.0;
        expense = 0.0;
        totalAmount = 0.0;
        salaries = 0.0; //taxable
        wages = 0.0; //taxable
        commissions = 0.0; //taxable
        bonuses = 0.0; //taxable
        allowances = 0.0; //taxable
        pensions = 0.0; //taxable
        rent = 0.0; //taxable
        interest = 0.0; //taxable
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
        zakatTotal = 0.0;
        startActivity(intent);
    }









}