package com.example.aiexpensestracker.taxationModule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aiexpensestracker.MainActivity;
import com.example.aiexpensestracker.R;
import com.example.aiexpensestracker.expensesManagerModule.ExpensesManagerActivity;

public class TaxationCalculationActivity extends AppCompatActivity {

    private EditText editText_taxation_YA2022_total_annual_income, editText_taxation_YA2022_year_service_completed,
            editText_taxation_YA2022_compensation_amount_received, editText_taxation_YA2022_payment_alimony_to_former_wife,
            editText_taxation_YA2022_number_of_child_under_18, editText_taxation_YA2022_number_of_child_above_18_A_level,
            editText_taxation_YA2022_number_of_child_above_18_diploma, editText_taxation_YA2022_number_of_disabled_child,
            editText_taxation_YA2022_number_of_disabled_child_diploma_above_18, editText_taxation_YA2022_sspn_child_education_saving,
            editText_taxation_YA2022_breastfeeding_equipment, editText_taxation_YA2022_childcare_centres_kindergartens_fees,
            editText_taxation_YA2022_parent_medical, editText_taxation_YA2022_annuity_prs, editText_taxation_YA2022_education_medical_insurance,
            editText_taxation_YA2022_education_fees_self, editText_taxation_YA2022_supporting_equipment, editText_taxation_YA2022_medical_expenses,
            editText_taxation_YA2022_epf_kwsp, editText_taxation_YA2022_life_insurance, editText_taxation_YA2022_lifestyle, editText_taxation_YA2022_lifestyle_additional,
            editText_taxation_YA2022_lifestyle_sport, editText_taxation_YA2022_socso_perkeso, editText_taxation_YA2022_domestic_travel_expenses,
            editText_taxation_YA2022_electrical_vehicle_charging_expenses, editText_taxation_YA2022_pcb, editText_taxation_YA2022_zakat;

    private RadioGroup radio_group_taxation_YA2022_compensation_true_false, radio_group_taxation_YA2022_disabled_yes_no,
            radio_group_taxation_YA2022_marital_status, radio_group_taxation_YA2022_husband_wife_disabled_yes_no,
            radio_group_taxation_YA2022_husband_wife_working_yes_no, radio_group_taxation_YA2022_do_you_have_child;

    private RadioButton radioButtonCompensationSelected, radioButtonDisabledSelected, radioButtonMaritalStatusSelected, radioButtonHusbandWifeDisabledSelected,
            radioButtonHusbandWifeWorkingSelected, radioButtonDoYouHaveChildSelected;

    int yearServiceCompleted = 0, numberOfChildUnder18 = 0, numberOfChildAbove18ALevel = 0, numberOfChildAbove18Diploma = 0, numberOfDisabledChild = 0,
            numberOfDisabledChildDiplomaAbove18 = 0;

    double totalAnnualIncome = 0, amountCompensationReceived = 0, paymentAlimonyToFormerWife = 0, sspnChildEducationSaving = 0, breastfeedingEquipment = 0,
            childcareCentresKindergartensFees = 0, parentMedical = 0, annuityPrs = 0, educationMedicalInsurance = 0, educationFeeSelf = 0, supportingEquipment = 0,
            medicalExpenses = 0, epfKwsp = 0, lifeInsurance = 0, lifeStyle = 0, lifeStyleAdditional = 0, lifeStyleSport = 0, socsoPerkeso = 0, domesticTravelExpenses = 0,
            electricalVehicleChargingExpenses = 0;

    private double grossIncomeBeforeDeduction = 0;
    private double individualRelief = 0;
    private double childRelief = 0;
    private double parentRelief = 0;
    private double otherRelief = 0;
    private double zakat = 0;
    private double pcb = 0;

    private TextView textViewSetTotalIncomeDetail, textViewSetTotalTaxReliefDetail, textViewSetTotalChildDetail, textViewSetTotalParentDetail, textViewSetTotalOtherDetail,
    textViewGrossIncome, textViewIndividualDeduction, textViewChildDeduction, textViewParentDeduction, textViewOtherDeduction, textViewTaxableIncome, textViewTaxAmount, textViewPCBLast,
    textViewZakatLast, textViewTaxNeededToPay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taxation_calculation);

        getSupportActionBar().setTitle("Taxation Calculator");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        editText_taxation_YA2022_total_annual_income = findViewById(R.id.editText_taxation_YA2022_total_annual_income);
        editText_taxation_YA2022_year_service_completed = findViewById(R.id.editText_taxation_YA2022_year_service_completed);
        editText_taxation_YA2022_compensation_amount_received = findViewById(R.id.editText_taxation_YA2022_compensation_amount_received);
        editText_taxation_YA2022_payment_alimony_to_former_wife = findViewById(R.id.editText_taxation_YA2022_payment_alimony_to_former_wife);
        editText_taxation_YA2022_number_of_child_under_18 = findViewById(R.id.editText_taxation_YA2022_number_of_child_under_18);
        editText_taxation_YA2022_number_of_child_above_18_A_level = findViewById(R.id.editText_taxation_YA2022_number_of_child_above_18_A_level);
        editText_taxation_YA2022_number_of_child_above_18_diploma = findViewById(R.id.editText_taxation_YA2022_number_of_child_above_18_diploma);
        editText_taxation_YA2022_number_of_disabled_child = findViewById(R.id.editText_taxation_YA2022_number_of_disabled_child);
        editText_taxation_YA2022_number_of_disabled_child_diploma_above_18 = findViewById(R.id.editText_taxation_YA2022_number_of_disabled_child_diploma_above_18);
        editText_taxation_YA2022_sspn_child_education_saving = findViewById(R.id.editText_taxation_YA2022_sspn_child_education_saving);
        editText_taxation_YA2022_breastfeeding_equipment = findViewById(R.id.editText_taxation_YA2022_breastfeeding_equipment);
        editText_taxation_YA2022_childcare_centres_kindergartens_fees = findViewById(R.id.editText_taxation_YA2022_childcare_centres_kindergartens_fees);
        editText_taxation_YA2022_parent_medical = findViewById(R.id.editText_taxation_YA2022_parent_medical);
        editText_taxation_YA2022_annuity_prs = findViewById(R.id.editText_taxation_YA2022_annuity_prs);
        editText_taxation_YA2022_education_medical_insurance = findViewById(R.id.editText_taxation_YA2022_education_medical_insurance);
        editText_taxation_YA2022_education_fees_self = findViewById(R.id.editText_taxation_YA2022_education_fees_self);
        editText_taxation_YA2022_supporting_equipment = findViewById(R.id.editText_taxation_YA2022_supporting_equipment);
        editText_taxation_YA2022_medical_expenses = findViewById(R.id.editText_taxation_YA2022_medical_expenses);
        editText_taxation_YA2022_epf_kwsp = findViewById(R.id.editText_taxation_YA2022_epf_kwsp);
        editText_taxation_YA2022_life_insurance = findViewById(R.id.editText_taxation_YA2022_life_insurance);
        editText_taxation_YA2022_lifestyle = findViewById(R.id.editText_taxation_YA2022_lifestyle);
        editText_taxation_YA2022_lifestyle_additional = findViewById(R.id.editText_taxation_YA2022_lifestyle_additional);
        editText_taxation_YA2022_lifestyle_sport = findViewById(R.id.editText_taxation_YA2022_lifestyle_sport);
        editText_taxation_YA2022_socso_perkeso = findViewById(R.id.editText_taxation_YA2022_socso_perkeso);
        editText_taxation_YA2022_domestic_travel_expenses = findViewById(R.id.editText_taxation_YA2022_domestic_travel_expenses);
        editText_taxation_YA2022_electrical_vehicle_charging_expenses = findViewById(R.id.editText_taxation_YA2022_electrical_vehicle_charging_expenses);
        editText_taxation_YA2022_pcb = findViewById(R.id.editText_taxation_YA2022_pcb);
        editText_taxation_YA2022_zakat = findViewById(R.id.editText_taxation_YA2022_zakat);

        radio_group_taxation_YA2022_compensation_true_false = findViewById(R.id.radio_group_taxation_YA2022_compensation_true_false);
        radio_group_taxation_YA2022_disabled_yes_no = findViewById(R.id.radio_group_taxation_YA2022_disabled_yes_no);
        radio_group_taxation_YA2022_marital_status = findViewById(R.id.radio_group_taxation_YA2022_marital_status);
        radio_group_taxation_YA2022_husband_wife_disabled_yes_no = findViewById(R.id.radio_group_taxation_YA2022_husband_wife_disabled_yes_no);
        radio_group_taxation_YA2022_husband_wife_working_yes_no = findViewById(R.id.radio_group_taxation_YA2022_husband_wife_working_yes_no);
        radio_group_taxation_YA2022_do_you_have_child = findViewById(R.id.radio_group_taxation_YA2022_do_you_have_child);


        radio_group_taxation_YA2022_compensation_true_false.clearCheck();
        radio_group_taxation_YA2022_disabled_yes_no.clearCheck();
        radio_group_taxation_YA2022_marital_status.clearCheck();
        radio_group_taxation_YA2022_husband_wife_disabled_yes_no.clearCheck();
        radio_group_taxation_YA2022_husband_wife_working_yes_no.clearCheck();
        radio_group_taxation_YA2022_do_you_have_child.clearCheck();

        textViewSetTotalIncomeDetail = findViewById(R.id.textView_taxation_YA2022_amount_total_income_details);
        textViewSetTotalTaxReliefDetail = findViewById(R.id.textView_taxation_YA2022_amount_total_tax_relief_details);
        textViewSetTotalChildDetail =  findViewById(R.id.textView_taxation_YA2022_amount_total_child_details);
        textViewSetTotalParentDetail = findViewById(R.id.textView_taxation_YA2022_amount_total_parent_details);
        textViewSetTotalOtherDetail = findViewById(R.id.textView_taxation_YA2022_amount_total_other_details);





        RadioGroup radioGroupCompensation = findViewById(R.id.radio_group_taxation_YA2022_compensation_true_false);

        editText_taxation_YA2022_year_service_completed.setEnabled(false);
        editText_taxation_YA2022_year_service_completed.setBackgroundResource(R.drawable.border2);

        editText_taxation_YA2022_compensation_amount_received.setEnabled(false);
        editText_taxation_YA2022_compensation_amount_received.setBackgroundResource(R.drawable.border2);

        radioGroupCompensation.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButtonCompensationSelected = findViewById(radioGroupCompensation.getCheckedRadioButtonId());
                int selectedCompensation = radio_group_taxation_YA2022_compensation_true_false.getCheckedRadioButtonId();
                radioButtonCompensationSelected = findViewById(selectedCompensation);
                if (radioButtonCompensationSelected.getText().equals("True")) {
                    editText_taxation_YA2022_year_service_completed.setEnabled(true);
                    editText_taxation_YA2022_year_service_completed.setBackgroundResource(R.drawable.border);

                    editText_taxation_YA2022_compensation_amount_received.setEnabled(true);
                    editText_taxation_YA2022_compensation_amount_received.setBackgroundResource(R.drawable.border);
                } else {
                    editText_taxation_YA2022_year_service_completed.setEnabled(false);
                    editText_taxation_YA2022_year_service_completed.setBackgroundResource(R.drawable.border2);

                    editText_taxation_YA2022_compensation_amount_received.setEnabled(false);
                    editText_taxation_YA2022_compensation_amount_received.setBackgroundResource(R.drawable.border2);

                }
            }
        });

        RadioGroup radioGroupMaritalStatus = findViewById(R.id.radio_group_taxation_YA2022_marital_status);
//        radio_group_taxation_YA2022_marital_status.setBackgroundResource(R.drawable.border2);

        RadioButton radio_group_taxation_YA2022_husband_wife_disabled_yes = findViewById(R.id.radio_husband_wife_disabled_yes);
        RadioButton radio_group_taxation_YA2022_husband_wife_disabled_no = findViewById(R.id.radio_husband_wife_disabled_no);
        radio_group_taxation_YA2022_husband_wife_disabled_yes_no.setBackgroundResource(R.drawable.border2);

        RadioButton radio_group_taxation_YA2022_husband_wife_working_yes = findViewById(R.id.radio_husband_wife_working_yes);
        RadioButton radio_group_taxation_YA2022_husband_wife_working_no = findViewById(R.id.radio_husband_wife_working_no);
        radio_group_taxation_YA2022_husband_wife_working_yes_no.setBackgroundResource(R.drawable.border2);


        radio_group_taxation_YA2022_husband_wife_disabled_yes.setEnabled(false);

        radio_group_taxation_YA2022_husband_wife_disabled_no.setEnabled(false);

        radio_group_taxation_YA2022_husband_wife_working_yes.setEnabled(false);

        radio_group_taxation_YA2022_husband_wife_working_no.setEnabled(false);

        editText_taxation_YA2022_payment_alimony_to_former_wife.setEnabled(false);
        editText_taxation_YA2022_payment_alimony_to_former_wife.setBackgroundResource(R.drawable.border2);

        radioGroupMaritalStatus.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButtonMaritalStatusSelected = findViewById(radioGroupMaritalStatus.getCheckedRadioButtonId());
                int selectedMarital = radio_group_taxation_YA2022_marital_status.getCheckedRadioButtonId();
                radioButtonMaritalStatusSelected = findViewById(selectedMarital);
                if (radioButtonMaritalStatusSelected.getText().equals("Single")) {
                    radio_group_taxation_YA2022_husband_wife_disabled_yes_no.setBackgroundResource(R.drawable.border2);
                    radio_group_taxation_YA2022_husband_wife_working_yes_no.setBackgroundResource(R.drawable.border2);

                    radio_group_taxation_YA2022_husband_wife_disabled_yes.setEnabled(false);

                    radio_group_taxation_YA2022_husband_wife_disabled_no.setEnabled(false);

                    radio_group_taxation_YA2022_husband_wife_working_yes.setEnabled(false);

                    radio_group_taxation_YA2022_husband_wife_working_no.setEnabled(false);

                    editText_taxation_YA2022_compensation_amount_received.setEnabled(false);
                    editText_taxation_YA2022_compensation_amount_received.setBackgroundResource(R.drawable.border2);

                    editText_taxation_YA2022_payment_alimony_to_former_wife.setEnabled(false);
                    editText_taxation_YA2022_payment_alimony_to_former_wife.setBackgroundResource(R.drawable.border2);

                } else if (radioButtonMaritalStatusSelected.getText().equals("Married")){

                    radio_group_taxation_YA2022_husband_wife_disabled_yes_no.setBackgroundResource(R.drawable.border);
                    radio_group_taxation_YA2022_husband_wife_working_yes_no.setBackgroundResource(R.drawable.border);

                    radio_group_taxation_YA2022_husband_wife_disabled_yes.setEnabled(true);

                    radio_group_taxation_YA2022_husband_wife_disabled_no.setEnabled(true);

                    radio_group_taxation_YA2022_husband_wife_working_yes.setEnabled(true);

                    radio_group_taxation_YA2022_husband_wife_working_no.setEnabled(true);

                    editText_taxation_YA2022_payment_alimony_to_former_wife.setEnabled(false);
                    editText_taxation_YA2022_payment_alimony_to_former_wife.setBackgroundResource(R.drawable.border2);
                } else {
                    radio_group_taxation_YA2022_husband_wife_disabled_yes_no.setBackgroundResource(R.drawable.border2);
                    radio_group_taxation_YA2022_husband_wife_working_yes_no.setBackgroundResource(R.drawable.border2);

                    radio_group_taxation_YA2022_husband_wife_disabled_yes.setEnabled(false);

                    radio_group_taxation_YA2022_husband_wife_disabled_no.setEnabled(false);

                    radio_group_taxation_YA2022_husband_wife_working_yes.setEnabled(false);

                    radio_group_taxation_YA2022_husband_wife_working_no.setEnabled(false);

                    editText_taxation_YA2022_payment_alimony_to_former_wife.setEnabled(true);
                    editText_taxation_YA2022_payment_alimony_to_former_wife.setBackgroundResource(R.drawable.border);
                }
            }
        });


        RadioGroup radioGroupHaveChild = findViewById(R.id.radio_group_taxation_YA2022_do_you_have_child);
        Button button_start_calculate_child_details = findViewById(R.id.button_start_calculate_child_details);
        button_start_calculate_child_details.setEnabled(false);
        editText_taxation_YA2022_number_of_child_under_18.setEnabled(false);
        editText_taxation_YA2022_number_of_child_under_18.setBackgroundResource(R.drawable.border2);

        editText_taxation_YA2022_number_of_child_above_18_A_level.setEnabled(false);
        editText_taxation_YA2022_number_of_child_above_18_A_level.setBackgroundResource(R.drawable.border2);

        editText_taxation_YA2022_number_of_child_above_18_diploma.setEnabled(false);
        editText_taxation_YA2022_number_of_child_above_18_diploma.setBackgroundResource(R.drawable.border2);

        editText_taxation_YA2022_number_of_disabled_child.setEnabled(false);
        editText_taxation_YA2022_number_of_disabled_child.setBackgroundResource(R.drawable.border2);

        editText_taxation_YA2022_number_of_disabled_child_diploma_above_18.setEnabled(false);
        editText_taxation_YA2022_number_of_disabled_child_diploma_above_18.setBackgroundResource(R.drawable.border2);

        editText_taxation_YA2022_sspn_child_education_saving.setEnabled(false);
        editText_taxation_YA2022_sspn_child_education_saving.setBackgroundResource(R.drawable.border2);

        editText_taxation_YA2022_breastfeeding_equipment.setEnabled(false);
        editText_taxation_YA2022_breastfeeding_equipment.setBackgroundResource(R.drawable.border2);

        editText_taxation_YA2022_childcare_centres_kindergartens_fees.setEnabled(false);
        editText_taxation_YA2022_childcare_centres_kindergartens_fees.setBackgroundResource(R.drawable.border2);

        radioGroupHaveChild.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButtonHaveChildSelected = findViewById(radioGroupHaveChild.getCheckedRadioButtonId());
                int selectedHaveChild = radio_group_taxation_YA2022_do_you_have_child.getCheckedRadioButtonId();
                radioButtonHaveChildSelected = findViewById(selectedHaveChild);
                if (radioButtonHaveChildSelected.getText().equals("Yes")) {
                    editText_taxation_YA2022_number_of_child_under_18.setEnabled(true);
                    editText_taxation_YA2022_number_of_child_under_18.setBackgroundResource(R.drawable.border);

                    editText_taxation_YA2022_number_of_child_above_18_A_level.setEnabled(true);
                    editText_taxation_YA2022_number_of_child_above_18_A_level.setBackgroundResource(R.drawable.border);

                    editText_taxation_YA2022_number_of_child_above_18_diploma.setEnabled(true);
                    editText_taxation_YA2022_number_of_child_above_18_diploma.setBackgroundResource(R.drawable.border);

                    editText_taxation_YA2022_number_of_disabled_child.setEnabled(true);
                    editText_taxation_YA2022_number_of_disabled_child.setBackgroundResource(R.drawable.border);

                    editText_taxation_YA2022_number_of_disabled_child_diploma_above_18.setEnabled(true);
                    editText_taxation_YA2022_number_of_disabled_child_diploma_above_18.setBackgroundResource(R.drawable.border);

                    editText_taxation_YA2022_sspn_child_education_saving.setEnabled(true);
                    editText_taxation_YA2022_sspn_child_education_saving.setBackgroundResource(R.drawable.border);

                    editText_taxation_YA2022_breastfeeding_equipment.setEnabled(true);
                    editText_taxation_YA2022_breastfeeding_equipment.setBackgroundResource(R.drawable.border);

                    editText_taxation_YA2022_childcare_centres_kindergartens_fees.setEnabled(true);
                    editText_taxation_YA2022_childcare_centres_kindergartens_fees.setBackgroundResource(R.drawable.border);

                    button_start_calculate_child_details.setEnabled(true);
                }  else {
                    editText_taxation_YA2022_number_of_child_under_18.setEnabled(false);
                    editText_taxation_YA2022_number_of_child_under_18.setBackgroundResource(R.drawable.border2);

                    editText_taxation_YA2022_number_of_child_above_18_A_level.setEnabled(false);
                    editText_taxation_YA2022_number_of_child_above_18_A_level.setBackgroundResource(R.drawable.border2);

                    editText_taxation_YA2022_number_of_child_above_18_diploma.setEnabled(false);
                    editText_taxation_YA2022_number_of_child_above_18_diploma.setBackgroundResource(R.drawable.border2);

                    editText_taxation_YA2022_number_of_disabled_child.setEnabled(false);
                    editText_taxation_YA2022_number_of_disabled_child.setBackgroundResource(R.drawable.border2);

                    editText_taxation_YA2022_number_of_disabled_child_diploma_above_18.setEnabled(false);
                    editText_taxation_YA2022_number_of_disabled_child_diploma_above_18.setBackgroundResource(R.drawable.border2);

                    editText_taxation_YA2022_sspn_child_education_saving.setEnabled(false);
                    editText_taxation_YA2022_sspn_child_education_saving.setBackgroundResource(R.drawable.border2);

                    editText_taxation_YA2022_breastfeeding_equipment.setEnabled(false);
                    editText_taxation_YA2022_breastfeeding_equipment.setBackgroundResource(R.drawable.border2);

                    editText_taxation_YA2022_childcare_centres_kindergartens_fees.setEnabled(false);
                    editText_taxation_YA2022_childcare_centres_kindergartens_fees.setBackgroundResource(R.drawable.border2);

                    button_start_calculate_child_details.setEnabled(false);
                }
            }
        });

        Button button_start_calculate_income_details = findViewById(R.id.button_start_calculate_income_details);
        button_start_calculate_income_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                editText_taxation_YA2022_total_annual_income = findViewById(R.id.editText_taxation_YA2022_total_annual_income);
                editText_taxation_YA2022_year_service_completed = findViewById(R.id.editText_taxation_YA2022_year_service_completed);
                editText_taxation_YA2022_compensation_amount_received = findViewById(R.id.editText_taxation_YA2022_compensation_amount_received);

                String editText_taxation_YA2022_total_annual_income_value = editText_taxation_YA2022_total_annual_income.getText().toString();
                String editText_taxation_YA2022_year_service_completed_value = editText_taxation_YA2022_year_service_completed.getText().toString();
                String editText_taxation_YA2022_compensation_amount_received_value = editText_taxation_YA2022_compensation_amount_received.getText().toString();

                RadioButton radioButtonCompensationSelected = findViewById(radioGroupCompensation.getCheckedRadioButtonId());
                int selectedCompensation = radio_group_taxation_YA2022_compensation_true_false.getCheckedRadioButtonId();
                radioButtonCompensationSelected = findViewById(selectedCompensation);

                if (TextUtils.isEmpty(editText_taxation_YA2022_total_annual_income_value)) {
                    Toast.makeText(TaxationCalculationActivity.this, "Please enter your total annual income", Toast.LENGTH_LONG).show();
                    editText_taxation_YA2022_total_annual_income.setError("Total Annual Income Is Required");
                    editText_taxation_YA2022_total_annual_income.requestFocus();
                } else if (radioGroupCompensation.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(TaxationCalculationActivity.this, "Please select a compensation option", Toast.LENGTH_LONG).show();
                } else if (radioButtonCompensationSelected.getText().equals("True")) {
                    if (TextUtils.isEmpty(editText_taxation_YA2022_year_service_completed_value)){
                        Toast.makeText(TaxationCalculationActivity.this, "Please enter your year of service completed", Toast.LENGTH_LONG).show();
                        editText_taxation_YA2022_year_service_completed.setError("Year of Service Completed Is Required");
                        editText_taxation_YA2022_year_service_completed.requestFocus();
                    } else if (TextUtils.isEmpty(editText_taxation_YA2022_compensation_amount_received_value)) {
                        Toast.makeText(TaxationCalculationActivity.this, "Please enter your compensation amount received", Toast.LENGTH_LONG).show();
                        editText_taxation_YA2022_compensation_amount_received.setError("Compensation Amount Received Is Required");
                        editText_taxation_YA2022_compensation_amount_received.requestFocus();
                    } else {
                        double number1 = Double.parseDouble(editText_taxation_YA2022_total_annual_income_value);
                        int number2 = Integer.parseInt(editText_taxation_YA2022_year_service_completed_value);
                        double number3 = Double.parseDouble(editText_taxation_YA2022_compensation_amount_received_value);


                        double retrenchment_compensation = number3 - (number2 * 10000);
                        if (retrenchment_compensation < 0) {
                            retrenchment_compensation = 0;
                        }

                        double TotalIncomeDetailValue = number1 + retrenchment_compensation;
                        String formattedTotalIncomeDetailValue = String.format("%.2f", TotalIncomeDetailValue);
                        textViewSetTotalIncomeDetail.setText("Total Income Details : RM" + formattedTotalIncomeDetailValue);
                        totalIncomeTax(1, TotalIncomeDetailValue);
                    }
                } else if (radioButtonCompensationSelected.getText().equals("False/No loss of Employment")) {
                    double number1 = Double.parseDouble(editText_taxation_YA2022_total_annual_income_value);
                    String formattedTotalIncomeDetailValue = String.format("%.2f", number1);
                    textViewSetTotalIncomeDetail.setText("Total Income Details : RM" + formattedTotalIncomeDetailValue);
                    totalIncomeTax(1, number1);
                } else {
                    double number1 = Double.parseDouble(editText_taxation_YA2022_total_annual_income_value);
                    String formattedTotalIncomeDetailValue = String.format("%.2f", number1);
                    textViewSetTotalIncomeDetail.setText("Total Income Details : RM" + formattedTotalIncomeDetailValue);
                    totalIncomeTax(1, number1);

                }
            }

        });

        Button button_start_calculate_tax_relief_details = findViewById(R.id.button_start_calculate_tax_relief_details);
        button_start_calculate_tax_relief_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText_taxation_YA2022_payment_alimony_to_former_wife = findViewById(R.id.editText_taxation_YA2022_payment_alimony_to_former_wife);

                String editText_taxation_YA2022_payment_alimony_to_former_wife_value = editText_taxation_YA2022_payment_alimony_to_former_wife.getText().toString();

                radio_group_taxation_YA2022_disabled_yes_no = findViewById(R.id.radio_group_taxation_YA2022_disabled_yes_no);
                radio_group_taxation_YA2022_marital_status = findViewById(R.id.radio_group_taxation_YA2022_marital_status);
                radio_group_taxation_YA2022_husband_wife_disabled_yes_no = findViewById(R.id.radio_group_taxation_YA2022_husband_wife_disabled_yes_no);
                radio_group_taxation_YA2022_husband_wife_working_yes_no = findViewById(R.id.radio_group_taxation_YA2022_husband_wife_working_yes_no);

                RadioGroup radioGroupDisabled = findViewById(R.id.radio_group_taxation_YA2022_disabled_yes_no);
                RadioButton radioButtonDisabledSelected = findViewById(radioGroupDisabled.getCheckedRadioButtonId());
                int selectedDisabled = radio_group_taxation_YA2022_disabled_yes_no.getCheckedRadioButtonId();
                radioButtonDisabledSelected = findViewById(selectedDisabled);

                RadioGroup radioGroupMaritalStatus = findViewById(R.id.radio_group_taxation_YA2022_marital_status);
                RadioButton radioButtonMaritalStatusSelected = findViewById(radioGroupMaritalStatus.getCheckedRadioButtonId());
                int selectedMaritalStatus = radio_group_taxation_YA2022_marital_status.getCheckedRadioButtonId();
                radioButtonMaritalStatusSelected = findViewById(selectedMaritalStatus);

                RadioGroup radioGroupHusbandWifeDisabledStatus = findViewById(R.id.radio_group_taxation_YA2022_husband_wife_disabled_yes_no);
                RadioButton radioButtonHusbandWifeDisabledSelected = findViewById(radioGroupHusbandWifeDisabledStatus.getCheckedRadioButtonId());
                int selectedHusbandWifeDisabled = radio_group_taxation_YA2022_husband_wife_disabled_yes_no.getCheckedRadioButtonId();
                radioButtonHusbandWifeDisabledSelected = findViewById(selectedHusbandWifeDisabled);

                RadioGroup radioGroupHusbandWifeWorkingStatus = findViewById(R.id.radio_group_taxation_YA2022_husband_wife_working_yes_no);
                RadioButton radioButtonHusbandWifeWorkingSelected = findViewById(radioGroupHusbandWifeWorkingStatus.getCheckedRadioButtonId());
                int selectedHusbandWifeWorking = radio_group_taxation_YA2022_husband_wife_working_yes_no.getCheckedRadioButtonId();
                radioButtonHusbandWifeWorkingSelected = findViewById(selectedHusbandWifeWorking);


                if (radioGroupDisabled.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(TaxationCalculationActivity.this, "Please select a disabled status", Toast.LENGTH_LONG).show();
                } else if (radioButtonDisabledSelected.getText().equals("Yes")) {
                    double disabledYes = 6000;
                    double individualRelief = 9000;
                    double husbandWifeDisabledYes = 0;
                    double husbandWifeWorkingYes = 0;
                    if (radioGroupMaritalStatus.getCheckedRadioButtonId() == -1) {
                        Toast.makeText(TaxationCalculationActivity.this, "Please select a marital status", Toast.LENGTH_LONG).show();
                    } else if (radioButtonMaritalStatusSelected.getText().equals("Married")) {
                        if (radioGroupHusbandWifeDisabledStatus.getCheckedRadioButtonId() == -1) {
                            Toast.makeText(TaxationCalculationActivity.this, "Please select a husband/wife disabled status ", Toast.LENGTH_LONG).show();
                        } else if (radioGroupHusbandWifeWorkingStatus.getCheckedRadioButtonId() == -1) {
                            Toast.makeText(TaxationCalculationActivity.this, "Please select a husband/wife working status", Toast.LENGTH_LONG).show();
                        } else if(radioButtonHusbandWifeDisabledSelected.getText().equals("Yes")) {
                             husbandWifeDisabledYes = 5000;
                        } else if (radioButtonHusbandWifeDisabledSelected.getText().equals("No")) {
                             husbandWifeDisabledYes = 0;
                        }

                        if (radioButtonHusbandWifeWorkingSelected.getText().equals("No")) {
                             husbandWifeWorkingYes = 4000;
                        } else if (radioButtonHusbandWifeWorkingSelected.getText().equals("Yes")) {
                             husbandWifeWorkingYes = 0;
                        }
                        double marriedDisabledTotal = disabledYes + individualRelief + husbandWifeDisabledYes + husbandWifeWorkingYes;
                        String formattedMarriedDisabledTotalValue = String.format("%.2f", marriedDisabledTotal);
                        textViewSetTotalTaxReliefDetail.setText("Total Income Details : RM" + formattedMarriedDisabledTotalValue);
                        totalIncomeTax(2, marriedDisabledTotal);

                    } else if (radioButtonMaritalStatusSelected.getText().equals("Divorce/Widow")){
                        if (TextUtils.isEmpty(editText_taxation_YA2022_payment_alimony_to_former_wife_value)){
                            Toast.makeText(TaxationCalculationActivity.this, "Please enter your amount payment alimony to former wife", Toast.LENGTH_LONG).show();
                            editText_taxation_YA2022_payment_alimony_to_former_wife.setError("Payment Alimony To Former Wife Is Required");
                            editText_taxation_YA2022_payment_alimony_to_former_wife.requestFocus();
                        } else if (Integer.parseInt(editText_taxation_YA2022_payment_alimony_to_former_wife_value) > 4000){
                            Toast.makeText(TaxationCalculationActivity.this, "The payment alimony to former wife cannot greater than RM4000", Toast.LENGTH_LONG).show();
                            editText_taxation_YA2022_payment_alimony_to_former_wife.setError("Payment Alimony To Former Wife Cannot Greater than RM4000");
                            editText_taxation_YA2022_payment_alimony_to_former_wife.requestFocus();
                        } else if (Integer.parseInt(editText_taxation_YA2022_payment_alimony_to_former_wife_value) < 0){
                            Toast.makeText(TaxationCalculationActivity.this, "The payment alimony to former wife cannot less than RM0", Toast.LENGTH_LONG).show();
                            editText_taxation_YA2022_payment_alimony_to_former_wife.setError("Payment Alimony To Former Wife Cannot Less than RM0");
                            editText_taxation_YA2022_payment_alimony_to_former_wife.requestFocus();
                        } else {
                            double amountAlimony = Double.parseDouble(editText_taxation_YA2022_payment_alimony_to_former_wife_value);
                            double marriedDisabledTotal = disabledYes + individualRelief + amountAlimony;
                            String formattedMarriedDisabledTotalValue = String.format("%.2f", marriedDisabledTotal);
                            textViewSetTotalTaxReliefDetail.setText("Total Income Details : RM" + formattedMarriedDisabledTotalValue);
                            totalIncomeTax(2, marriedDisabledTotal);
                        }

                    }



                } else if (radioButtonDisabledSelected.getText().equals("No")) {
                    double disabledYes = 0;
                    double individualRelief = 9000;
                    double husbandWifeDisabledYes = 0;
                    double husbandWifeWorkingYes = 0;
                    if (radioGroupMaritalStatus.getCheckedRadioButtonId() == -1) {
                        Toast.makeText(TaxationCalculationActivity.this, "Please select a marital status", Toast.LENGTH_LONG).show();
                    } else if (radioButtonMaritalStatusSelected.getText().equals("Married")) {
                        if (radioGroupHusbandWifeDisabledStatus.getCheckedRadioButtonId() == -1) {
                            Toast.makeText(TaxationCalculationActivity.this, "Please select a husband/wife disabled status ", Toast.LENGTH_LONG).show();
                        } else if (radioGroupHusbandWifeWorkingStatus.getCheckedRadioButtonId() == -1) {
                            Toast.makeText(TaxationCalculationActivity.this, "Please select a husband/wife working status", Toast.LENGTH_LONG).show();
                        } else if(radioButtonHusbandWifeDisabledSelected.getText().equals("Yes")) {
                            husbandWifeDisabledYes = 5000;
                        } else if (radioButtonHusbandWifeDisabledSelected.getText().equals("No")) {
                            husbandWifeDisabledYes = 0;
                        }

                        if (radioButtonHusbandWifeWorkingSelected.getText().equals("No")) {
                            husbandWifeWorkingYes = 4000;
                        } else if (radioButtonHusbandWifeWorkingSelected.getText().equals("Yes")) {
                            husbandWifeWorkingYes = 0;
                        }
                        double marriedDisabledTotal = disabledYes + individualRelief + husbandWifeDisabledYes + husbandWifeWorkingYes;
                        String formattedMarriedDisabledTotalValue = String.format("%.2f", marriedDisabledTotal);
                        textViewSetTotalTaxReliefDetail.setText("Total Income Details : RM" + formattedMarriedDisabledTotalValue);
                        totalIncomeTax(2, marriedDisabledTotal);

                    } else if (radioButtonMaritalStatusSelected.getText().equals("Divorce/Widow")){
                        if (TextUtils.isEmpty(editText_taxation_YA2022_payment_alimony_to_former_wife_value)){
                            Toast.makeText(TaxationCalculationActivity.this, "Please enter your amount payment alimony to former wife", Toast.LENGTH_LONG).show();
                            editText_taxation_YA2022_payment_alimony_to_former_wife.setError("Payment Alimony To Former Wife Is Required");
                            editText_taxation_YA2022_payment_alimony_to_former_wife.requestFocus();
                        } else if (Integer.parseInt(editText_taxation_YA2022_payment_alimony_to_former_wife_value) > 4000){
                            Toast.makeText(TaxationCalculationActivity.this, "The payment alimony to former wife cannot greater than RM4000", Toast.LENGTH_LONG).show();
                            editText_taxation_YA2022_payment_alimony_to_former_wife.setError("Payment Alimony To Former Wife Cannot Greater than RM4000");
                            editText_taxation_YA2022_payment_alimony_to_former_wife.requestFocus();
                        } else if (Integer.parseInt(editText_taxation_YA2022_payment_alimony_to_former_wife_value) < 0){
                            Toast.makeText(TaxationCalculationActivity.this, "The payment alimony to former wife cannot less than RM0", Toast.LENGTH_LONG).show();
                            editText_taxation_YA2022_payment_alimony_to_former_wife.setError("Payment Alimony To Former Wife Cannot Less than RM0");
                            editText_taxation_YA2022_payment_alimony_to_former_wife.requestFocus();
                        } else {
                            double amountAlimony = Double.parseDouble(editText_taxation_YA2022_payment_alimony_to_former_wife_value);
                            double marriedDisabledTotal = disabledYes + individualRelief + amountAlimony;
                            String formattedMarriedDisabledTotalValue = String.format("%.2f", marriedDisabledTotal);
                            textViewSetTotalTaxReliefDetail.setText("Total Income Details : RM" + formattedMarriedDisabledTotalValue);
                            totalIncomeTax(2, marriedDisabledTotal);
                        }
                    }
                }
            }
        });

        button_start_calculate_child_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText_taxation_YA2022_number_of_child_under_18 = findViewById(R.id.editText_taxation_YA2022_number_of_child_under_18);
                editText_taxation_YA2022_number_of_child_above_18_A_level = findViewById(R.id.editText_taxation_YA2022_number_of_child_above_18_A_level);
                editText_taxation_YA2022_number_of_child_above_18_diploma = findViewById(R.id.editText_taxation_YA2022_number_of_child_above_18_diploma);
                editText_taxation_YA2022_number_of_disabled_child = findViewById(R.id.editText_taxation_YA2022_number_of_disabled_child);
                editText_taxation_YA2022_number_of_disabled_child_diploma_above_18 = findViewById(R.id.editText_taxation_YA2022_number_of_disabled_child_diploma_above_18);
                editText_taxation_YA2022_sspn_child_education_saving = findViewById(R.id.editText_taxation_YA2022_sspn_child_education_saving);
                editText_taxation_YA2022_breastfeeding_equipment = findViewById(R.id.editText_taxation_YA2022_breastfeeding_equipment);
                editText_taxation_YA2022_childcare_centres_kindergartens_fees = findViewById(R.id.editText_taxation_YA2022_childcare_centres_kindergartens_fees);

                String editText_taxation_YA2022_number_of_child_under_18_value = editText_taxation_YA2022_number_of_child_under_18.getText().toString();
                String editText_taxation_YA2022_number_of_child_above_18_A_level_value = editText_taxation_YA2022_number_of_child_above_18_A_level.getText().toString();
                String editText_taxation_YA2022_number_of_child_above_18_diploma_value = editText_taxation_YA2022_number_of_child_above_18_diploma.getText().toString();
                String editText_taxation_YA2022_number_of_disabled_child_value = editText_taxation_YA2022_number_of_disabled_child.getText().toString();
                String editText_taxation_YA2022_number_of_disabled_child_diploma_above_18_value = editText_taxation_YA2022_number_of_disabled_child_diploma_above_18.getText().toString();
                String editText_taxation_YA2022_sspn_child_education_saving_value = editText_taxation_YA2022_sspn_child_education_saving.getText().toString();
                String editText_taxation_YA2022_breastfeeding_equipment_value = editText_taxation_YA2022_breastfeeding_equipment.getText().toString();
                String editText_taxation_YA2022_childcare_centres_kindergartens_fees_value = editText_taxation_YA2022_childcare_centres_kindergartens_fees.getText().toString();

                if (TextUtils.isEmpty(editText_taxation_YA2022_number_of_child_under_18_value)){
                    Toast.makeText(TaxationCalculationActivity.this, "Please enter your number of child under 18, if no please enter 0", Toast.LENGTH_LONG).show();
                    editText_taxation_YA2022_number_of_child_under_18.setError("Number of child under 18 Is Required, If no please write 0");
                    editText_taxation_YA2022_number_of_child_under_18.requestFocus();
                } else if (TextUtils.isEmpty(editText_taxation_YA2022_number_of_child_above_18_A_level_value)){
                    Toast.makeText(TaxationCalculationActivity.this, "Please enter your number of child above 18(A-Level), if no please enter 0", Toast.LENGTH_LONG).show();
                    editText_taxation_YA2022_number_of_child_above_18_A_level.setError("Number of child above 18(A-Level) Is Required, If no please write 0");
                    editText_taxation_YA2022_number_of_child_above_18_A_level.requestFocus();
                } else if (TextUtils.isEmpty(editText_taxation_YA2022_number_of_child_above_18_diploma_value)){
                    Toast.makeText(TaxationCalculationActivity.this, "Please enter your number of child above 18(Diploma), if no please enter 0", Toast.LENGTH_LONG).show();
                    editText_taxation_YA2022_number_of_child_above_18_diploma.setError("Number of child above 18(Diploma) Is Required, If no please write 0");
                    editText_taxation_YA2022_number_of_child_above_18_diploma.requestFocus();
                } else if (TextUtils.isEmpty(editText_taxation_YA2022_number_of_disabled_child_value)){
                    Toast.makeText(TaxationCalculationActivity.this, "Please enter number of disabled child, if no please enter 0", Toast.LENGTH_LONG).show();
                    editText_taxation_YA2022_number_of_disabled_child.setError("Number of disabled child Is Required, If no please write 0");
                    editText_taxation_YA2022_number_of_disabled_child.requestFocus();
                } else if (TextUtils.isEmpty(editText_taxation_YA2022_number_of_disabled_child_diploma_above_18_value)){
                    Toast.makeText(TaxationCalculationActivity.this, "Please enter number of disabled child above 18, if no please enter 0", Toast.LENGTH_LONG).show();
                    editText_taxation_YA2022_number_of_disabled_child_diploma_above_18.setError("Number of disabled child above 18 Is Required, If no please write 0");
                    editText_taxation_YA2022_number_of_disabled_child_diploma_above_18.requestFocus();
                } else if (TextUtils.isEmpty(editText_taxation_YA2022_sspn_child_education_saving_value)){
                    Toast.makeText(TaxationCalculationActivity.this, "Please enter SSPN child education saving, if no please enter 0", Toast.LENGTH_LONG).show();
                    editText_taxation_YA2022_sspn_child_education_saving.setError("SSPN child education saving Is Required, If no please write 0");
                    editText_taxation_YA2022_sspn_child_education_saving.requestFocus();
                } else if (TextUtils.isEmpty(editText_taxation_YA2022_breastfeeding_equipment_value)){
                    Toast.makeText(TaxationCalculationActivity.this, "Please enter amount of breastfeeding equipment, if no please enter 0", Toast.LENGTH_LONG).show();
                    editText_taxation_YA2022_breastfeeding_equipment.setError("Amount of breastfeeding equipment Is Required, If no please write 0");
                    editText_taxation_YA2022_breastfeeding_equipment.requestFocus();
                } else if (TextUtils.isEmpty(editText_taxation_YA2022_childcare_centres_kindergartens_fees_value)){
                    Toast.makeText(TaxationCalculationActivity.this, "Please enter amount of childcare centres or kindergartens fees, if no please enter 0", Toast.LENGTH_LONG).show();
                    editText_taxation_YA2022_childcare_centres_kindergartens_fees.setError("Amount of childcare centres or kindergartens Is Required, If no please write 0");
                    editText_taxation_YA2022_childcare_centres_kindergartens_fees.requestFocus();
                } else if (Integer.parseInt(editText_taxation_YA2022_sspn_child_education_saving_value) > 8000) {
                    Toast.makeText(TaxationCalculationActivity.this, "SSPN child education saving cannot greater than RM8000", Toast.LENGTH_LONG).show();
                    editText_taxation_YA2022_sspn_child_education_saving.setError("SSPN child education saving is limited to RM8000");
                    editText_taxation_YA2022_sspn_child_education_saving.requestFocus();
                } else if (Integer.parseInt(editText_taxation_YA2022_breastfeeding_equipment_value) > 1000) {
                    Toast.makeText(TaxationCalculationActivity.this, "Breastfeeding equipment cannot greater than RM1000", Toast.LENGTH_LONG).show();
                    editText_taxation_YA2022_breastfeeding_equipment.setError("Breastfeeding equipment is limited to RM1000");
                    editText_taxation_YA2022_breastfeeding_equipment.requestFocus();
                } else if (Integer.parseInt(editText_taxation_YA2022_childcare_centres_kindergartens_fees_value) > 3000) {
                    Toast.makeText(TaxationCalculationActivity.this, "Childcare centres and kindergartens fees cannot greater than RM3000", Toast.LENGTH_LONG).show();
                    editText_taxation_YA2022_childcare_centres_kindergartens_fees.setError("Childcare centres and kindergartens fees is limited to RM3000");
                    editText_taxation_YA2022_childcare_centres_kindergartens_fees.requestFocus();
                } else {
                    int numberChildUnder18 = Integer.parseInt(editText_taxation_YA2022_number_of_child_under_18_value);
                    int numberChildAbove18ALevel = Integer.parseInt(editText_taxation_YA2022_number_of_child_above_18_A_level_value);
                    int numberChildAbove18Diploma = Integer.parseInt(editText_taxation_YA2022_number_of_child_above_18_diploma_value);
                    int numberChildDisabled = Integer.parseInt(editText_taxation_YA2022_number_of_disabled_child_value);
                    int numberChildDisabledAbove18Diploma = Integer.parseInt(editText_taxation_YA2022_number_of_disabled_child_diploma_above_18_value);

                    double amountSSPNChildEducation = Double.parseDouble(editText_taxation_YA2022_sspn_child_education_saving_value);
                    double amountBreastFeeding = Double.parseDouble(editText_taxation_YA2022_breastfeeding_equipment_value);
                    double amountChildcareKindergarten = Double.parseDouble(editText_taxation_YA2022_childcare_centres_kindergartens_fees_value);

                    double totalChildDetails = (numberChildUnder18 * 2000) + (numberChildAbove18ALevel * 2000) + (numberChildAbove18Diploma * 8000) + (numberChildDisabled * 6000) +(numberChildDisabledAbove18Diploma * 14000) +
                            amountSSPNChildEducation + amountBreastFeeding + amountChildcareKindergarten;
                    String formattedChildDetailsTotalValue = String.format("%.2f", totalChildDetails);
                    textViewSetTotalChildDetail.setText("Total Child Details : RM" + formattedChildDetailsTotalValue);
                    totalIncomeTax(3, totalChildDetails);
                }

            }
        });
        editText_taxation_YA2022_parent_medical = findViewById(R.id.editText_taxation_YA2022_parent_medical);
        String editText_taxation_YA2022_parent_medical_value = editText_taxation_YA2022_parent_medical.getText().toString();


        editText_taxation_YA2022_parent_medical.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Not needed
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Retrieve the double value from the EditText view
                double medicalExpenses = 0.0;
                if (!TextUtils.isEmpty(s)) {
                    medicalExpenses = Double.parseDouble(s.toString());
                }

                // Check that the value is not greater than 8000
                if (medicalExpenses > 8000) {
                    Toast.makeText(getApplicationContext(), "Medical expenses cannot be greater than 8000", Toast.LENGTH_SHORT).show();
                    medicalExpenses = 8000;
                    editText_taxation_YA2022_parent_medical.setText(String.format("%.2f", medicalExpenses));
                    editText_taxation_YA2022_parent_medical.setSelection(editText_taxation_YA2022_parent_medical.getText().length());
                }

                // Set the double value on the TextView view
                String formattedParentDetailsTotalValue = String.format("%.2f", medicalExpenses);
                textViewSetTotalParentDetail.setText("Total Parent Details : RM" + formattedParentDetailsTotalValue);
                totalIncomeTax(4, medicalExpenses);
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Not needed
            }
        });




        Button button_start_calculate_other_details = findViewById(R.id.button_start_calculate_other_details);

        button_start_calculate_other_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText_taxation_YA2022_annuity_prs = findViewById(R.id.editText_taxation_YA2022_annuity_prs);
                editText_taxation_YA2022_education_medical_insurance = findViewById(R.id.editText_taxation_YA2022_education_medical_insurance);
                editText_taxation_YA2022_education_fees_self = findViewById(R.id.editText_taxation_YA2022_education_fees_self);
                editText_taxation_YA2022_supporting_equipment = findViewById(R.id.editText_taxation_YA2022_supporting_equipment);
                editText_taxation_YA2022_medical_expenses = findViewById(R.id.editText_taxation_YA2022_medical_expenses);
                editText_taxation_YA2022_epf_kwsp = findViewById(R.id.editText_taxation_YA2022_epf_kwsp);
                editText_taxation_YA2022_life_insurance = findViewById(R.id.editText_taxation_YA2022_life_insurance);
                editText_taxation_YA2022_lifestyle = findViewById(R.id.editText_taxation_YA2022_lifestyle);
                editText_taxation_YA2022_lifestyle_additional = findViewById(R.id.editText_taxation_YA2022_lifestyle_additional);
                editText_taxation_YA2022_lifestyle_sport = findViewById(R.id.editText_taxation_YA2022_lifestyle_sport);
                editText_taxation_YA2022_socso_perkeso = findViewById(R.id.editText_taxation_YA2022_socso_perkeso);
                editText_taxation_YA2022_domestic_travel_expenses = findViewById(R.id.editText_taxation_YA2022_domestic_travel_expenses);
                editText_taxation_YA2022_electrical_vehicle_charging_expenses = findViewById(R.id.editText_taxation_YA2022_electrical_vehicle_charging_expenses);
                editText_taxation_YA2022_pcb = findViewById(R.id.editText_taxation_YA2022_pcb);
                editText_taxation_YA2022_zakat = findViewById(R.id.editText_taxation_YA2022_zakat);

                String editText_taxation_YA2022_annuity_prs_value = editText_taxation_YA2022_annuity_prs.getText().toString();
                String editText_taxation_YA2022_education_medical_insurance_value = editText_taxation_YA2022_education_medical_insurance.getText().toString();
                String editText_taxation_YA2022_education_fees_self_value = editText_taxation_YA2022_education_fees_self.getText().toString();
                String editText_taxation_YA2022_supporting_equipment_value = editText_taxation_YA2022_supporting_equipment.getText().toString();
                String editText_taxation_YA2022_medical_expenses_value = editText_taxation_YA2022_medical_expenses.getText().toString();
                String editText_taxation_YA2022_epf_kwsp_value = editText_taxation_YA2022_epf_kwsp.getText().toString();
                String editText_taxation_YA2022_life_insurance_value = editText_taxation_YA2022_life_insurance.getText().toString();
                String editText_taxation_YA2022_lifestyle_value = editText_taxation_YA2022_lifestyle.getText().toString();
                String editText_taxation_YA2022_lifestyle_additional_value = editText_taxation_YA2022_lifestyle_additional.getText().toString();
                String editText_taxation_YA2022_lifestyle_sport_value = editText_taxation_YA2022_lifestyle_sport.getText().toString();
                String editText_taxation_YA2022_socso_perkeso_value = editText_taxation_YA2022_socso_perkeso.getText().toString();
                String editText_taxation_YA2022_domestic_travel_expenses_value = editText_taxation_YA2022_domestic_travel_expenses.getText().toString();
                String editText_taxation_YA2022_electrical_vehicle_charging_expenses_value = editText_taxation_YA2022_electrical_vehicle_charging_expenses.getText().toString();
                String editText_taxation_YA2022_pcb_value = editText_taxation_YA2022_pcb.getText().toString();
                String editText_taxation_YA2022_zakat_value = editText_taxation_YA2022_zakat.getText().toString();

                if (TextUtils.isEmpty(editText_taxation_YA2022_annuity_prs_value)){
                    Toast.makeText(TaxationCalculationActivity.this, "Please enter annuity/prs, if no please enter 0", Toast.LENGTH_LONG).show();
                    editText_taxation_YA2022_annuity_prs.setError("This field Is Required, If no please write 0");
                    editText_taxation_YA2022_annuity_prs.requestFocus();
                } else if (TextUtils.isEmpty(editText_taxation_YA2022_education_medical_insurance_value)){
                    Toast.makeText(TaxationCalculationActivity.this, "Please enter education and medical insurance, if no please enter 0", Toast.LENGTH_LONG).show();
                    editText_taxation_YA2022_education_medical_insurance.setError("This field Is Required, If no please write 0");
                    editText_taxation_YA2022_education_medical_insurance.requestFocus();
                } else if (TextUtils.isEmpty(editText_taxation_YA2022_education_fees_self_value)){
                    Toast.makeText(TaxationCalculationActivity.this, "Please enter education fees(self), if no please enter 0", Toast.LENGTH_LONG).show();
                    editText_taxation_YA2022_education_fees_self.setError("This field Is Required, If no please write 0");
                    editText_taxation_YA2022_education_fees_self.requestFocus();
                } else if (TextUtils.isEmpty(editText_taxation_YA2022_supporting_equipment_value)){
                    Toast.makeText(TaxationCalculationActivity.this, "Please enter supporting equipment fees, if no please enter 0", Toast.LENGTH_LONG).show();
                    editText_taxation_YA2022_supporting_equipment.setError("This field Is Required, If no please write 0");
                    editText_taxation_YA2022_supporting_equipment.requestFocus();
                } else if (TextUtils.isEmpty(editText_taxation_YA2022_medical_expenses_value)){
                    Toast.makeText(TaxationCalculationActivity.this, "Please enter medical expenses, if no please enter 0", Toast.LENGTH_LONG).show();
                    editText_taxation_YA2022_medical_expenses.setError("This field Is Required, If no please write 0");
                    editText_taxation_YA2022_medical_expenses.requestFocus();
                } else if (TextUtils.isEmpty(editText_taxation_YA2022_epf_kwsp_value)){
                    Toast.makeText(TaxationCalculationActivity.this, "Please enter epf/kwsp, if no please enter 0", Toast.LENGTH_LONG).show();
                    editText_taxation_YA2022_epf_kwsp.setError("This field Is Required, If no please write 0");
                    editText_taxation_YA2022_epf_kwsp.requestFocus();
                } else if (TextUtils.isEmpty(editText_taxation_YA2022_life_insurance_value)){
                    Toast.makeText(TaxationCalculationActivity.this, "Please enter life insurance fees, if no please enter 0", Toast.LENGTH_LONG).show();
                    editText_taxation_YA2022_life_insurance.setError("This field Is Required, If no please write 0");
                    editText_taxation_YA2022_life_insurance.requestFocus();
                } else if (TextUtils.isEmpty(editText_taxation_YA2022_lifestyle_value)){
                    Toast.makeText(TaxationCalculationActivity.this, "Please enter lifestyle, if no please enter 0", Toast.LENGTH_LONG).show();
                    editText_taxation_YA2022_lifestyle.setError("This field Is Required, If no please write 0");
                    editText_taxation_YA2022_lifestyle.requestFocus();
                } else if (TextUtils.isEmpty(editText_taxation_YA2022_lifestyle_additional_value)){
                    Toast.makeText(TaxationCalculationActivity.this, "Please enter lifestyle(Additional), if no please enter 0", Toast.LENGTH_LONG).show();
                    editText_taxation_YA2022_lifestyle_additional.setError("This field Is Required, If no please write 0");
                    editText_taxation_YA2022_lifestyle_additional.requestFocus();
                } else if (TextUtils.isEmpty(editText_taxation_YA2022_lifestyle_sport_value)){
                    Toast.makeText(TaxationCalculationActivity.this, "Please enter lifestyle(Sport), if no please enter 0", Toast.LENGTH_LONG).show();
                    editText_taxation_YA2022_lifestyle_sport.setError("This field Is Required, If no please write 0");
                    editText_taxation_YA2022_lifestyle_sport.requestFocus();
                } else if (TextUtils.isEmpty(editText_taxation_YA2022_socso_perkeso_value)){
                    Toast.makeText(TaxationCalculationActivity.this, "Please enter socso perkeso, if no please enter 0", Toast.LENGTH_LONG).show();
                    editText_taxation_YA2022_socso_perkeso.setError("This field Is Required, If no please write 0");
                    editText_taxation_YA2022_socso_perkeso.requestFocus();
                } else if (TextUtils.isEmpty(editText_taxation_YA2022_domestic_travel_expenses_value)){
                    Toast.makeText(TaxationCalculationActivity.this, "Please enter domestic travel expenses, if no please enter 0", Toast.LENGTH_LONG).show();
                    editText_taxation_YA2022_domestic_travel_expenses.setError("This field Is Required, If no please write 0");
                    editText_taxation_YA2022_domestic_travel_expenses.requestFocus();
                } else if (TextUtils.isEmpty(editText_taxation_YA2022_electrical_vehicle_charging_expenses_value)){
                    Toast.makeText(TaxationCalculationActivity.this, "Please enter electrical vehicle charging expenses, if no please enter 0", Toast.LENGTH_LONG).show();
                    editText_taxation_YA2022_electrical_vehicle_charging_expenses.setError("This field Is Required, If no please write 0");
                    editText_taxation_YA2022_electrical_vehicle_charging_expenses.requestFocus();
                } else if (TextUtils.isEmpty(editText_taxation_YA2022_pcb_value)){
                    Toast.makeText(TaxationCalculationActivity.this, "Please enter amount of pcb, if no please enter 0", Toast.LENGTH_LONG).show();
                    editText_taxation_YA2022_pcb.setError("This field Is Required, If no please write 0");
                    editText_taxation_YA2022_pcb.requestFocus();
                } else if (TextUtils.isEmpty(editText_taxation_YA2022_zakat_value)){
                    Toast.makeText(TaxationCalculationActivity.this, "Please enter amount of zakat, if no please enter 0", Toast.LENGTH_LONG).show();
                    editText_taxation_YA2022_zakat.setError("This field Is Required, If no please write 0");
                    editText_taxation_YA2022_zakat.requestFocus();
                } else if (Integer.parseInt(editText_taxation_YA2022_annuity_prs_value) > 3000) {
                    Toast.makeText(TaxationCalculationActivity.this, "annuity and prc cannot greater than RM3000", Toast.LENGTH_LONG).show();
                    editText_taxation_YA2022_annuity_prs.setError("This field is limited to RM3000");
                    editText_taxation_YA2022_annuity_prs.requestFocus();
                } else if (Integer.parseInt(editText_taxation_YA2022_education_medical_insurance_value) > 3000){
                    Toast.makeText(TaxationCalculationActivity.this, "Please enter education and medical insurance, cannot greater than RM3000", Toast.LENGTH_LONG).show();
                    editText_taxation_YA2022_education_medical_insurance.setError("This field is limited to RM3000");
                    editText_taxation_YA2022_education_medical_insurance.requestFocus();
                } else if (Integer.parseInt(editText_taxation_YA2022_education_fees_self_value) > 7000){
                    Toast.makeText(TaxationCalculationActivity.this, "Please enter education fees(self), cannot greater than RM7000", Toast.LENGTH_LONG).show();
                    editText_taxation_YA2022_education_fees_self.setError("This field is limited to RM7000");
                    editText_taxation_YA2022_education_fees_self.requestFocus();
                } else if (Integer.parseInt(editText_taxation_YA2022_supporting_equipment_value) > 6000){
                    Toast.makeText(TaxationCalculationActivity.this, "Please enter supporting equipment fees, cannot greater than RM6000", Toast.LENGTH_LONG).show();
                    editText_taxation_YA2022_supporting_equipment.setError("This field is limited to RM6000");
                    editText_taxation_YA2022_supporting_equipment.requestFocus();
                } else if (Integer.parseInt(editText_taxation_YA2022_medical_expenses_value) > 8000){
                    Toast.makeText(TaxationCalculationActivity.this, "Please enter medical expenses, cannot greater than RM8000", Toast.LENGTH_LONG).show();
                    editText_taxation_YA2022_medical_expenses.setError("This field is limited to RM8000");
                    editText_taxation_YA2022_medical_expenses.requestFocus();
                } else if (Integer.parseInt(editText_taxation_YA2022_epf_kwsp_value) > 4000){
                    Toast.makeText(TaxationCalculationActivity.this, "Please enter epf/kwsp, cannot greater than RM4000", Toast.LENGTH_LONG).show();
                    editText_taxation_YA2022_epf_kwsp.setError("This field is limited to RM4000");
                    editText_taxation_YA2022_epf_kwsp.requestFocus();
                } else if (Integer.parseInt(editText_taxation_YA2022_life_insurance_value) > 3000){
                    Toast.makeText(TaxationCalculationActivity.this, "Please enter life insurance fees, cannot greater than RM3000", Toast.LENGTH_LONG).show();
                    editText_taxation_YA2022_life_insurance.setError("This field is limited to RM3000");
                    editText_taxation_YA2022_life_insurance.requestFocus();
                } else if (Integer.parseInt(editText_taxation_YA2022_lifestyle_value) > 2500){
                    Toast.makeText(TaxationCalculationActivity.this, "Please enter lifestyle, cannot greater than RM2500", Toast.LENGTH_LONG).show();
                    editText_taxation_YA2022_lifestyle.setError("This field is limited to RM2500");
                    editText_taxation_YA2022_lifestyle.requestFocus();
                } else if (Integer.parseInt(editText_taxation_YA2022_lifestyle_additional_value) > 2500){
                    Toast.makeText(TaxationCalculationActivity.this, "Please enter lifestyle(Additional), cannot greater than RM2500", Toast.LENGTH_LONG).show();
                    editText_taxation_YA2022_lifestyle_additional.setError("This field is limited to RM2500");
                    editText_taxation_YA2022_lifestyle_additional.requestFocus();
                } else if (Integer.parseInt(editText_taxation_YA2022_lifestyle_sport_value) > 500){
                    Toast.makeText(TaxationCalculationActivity.this, "Please enter lifestyle(Sport), cannot greater than RM500", Toast.LENGTH_LONG).show();
                    editText_taxation_YA2022_lifestyle_sport.setError("This field is limited to RM500");
                    editText_taxation_YA2022_lifestyle_sport.requestFocus();
                } else if (Integer.parseInt(editText_taxation_YA2022_socso_perkeso_value) > 350){
                    Toast.makeText(TaxationCalculationActivity.this, "Please enter socso/perkeso, cannot greater than RM350", Toast.LENGTH_LONG).show();
                    editText_taxation_YA2022_socso_perkeso.setError("This field is limited to RM350");
                    editText_taxation_YA2022_socso_perkeso.requestFocus();
                } else if (Integer.parseInt(editText_taxation_YA2022_domestic_travel_expenses_value) > 1000){
                    Toast.makeText(TaxationCalculationActivity.this, "Please enter domestic travel expenses, cannot greater than RM1000", Toast.LENGTH_LONG).show();
                    editText_taxation_YA2022_domestic_travel_expenses.setError("This field is limited to RM1000");
                    editText_taxation_YA2022_domestic_travel_expenses.requestFocus();
                } else if (Integer.parseInt(editText_taxation_YA2022_electrical_vehicle_charging_expenses_value) > 2500){
                    Toast.makeText(TaxationCalculationActivity.this, "Please enter electrical vehicle charging expenses, cannot greater than RM2500", Toast.LENGTH_LONG).show();
                    editText_taxation_YA2022_electrical_vehicle_charging_expenses.setError("This field is limited to RM2500");
                    editText_taxation_YA2022_electrical_vehicle_charging_expenses.requestFocus();
                } else {
                    double total = 0;

                    total += Double.parseDouble(editText_taxation_YA2022_annuity_prs.getText().toString());
                    total += Double.parseDouble(editText_taxation_YA2022_education_medical_insurance.getText().toString());
                    total += Double.parseDouble(editText_taxation_YA2022_education_fees_self.getText().toString());
                    total += Double.parseDouble(editText_taxation_YA2022_supporting_equipment.getText().toString());
                    total += Double.parseDouble(editText_taxation_YA2022_medical_expenses.getText().toString());
                    total += Double.parseDouble(editText_taxation_YA2022_epf_kwsp.getText().toString());
                    total += Double.parseDouble(editText_taxation_YA2022_life_insurance.getText().toString());
                    total += Double.parseDouble(editText_taxation_YA2022_lifestyle.getText().toString());
                    total += Double.parseDouble(editText_taxation_YA2022_lifestyle_additional.getText().toString());
                    total += Double.parseDouble(editText_taxation_YA2022_lifestyle_sport.getText().toString());
                    total += Double.parseDouble(editText_taxation_YA2022_socso_perkeso.getText().toString());
                    total += Double.parseDouble(editText_taxation_YA2022_domestic_travel_expenses.getText().toString());
                    total += Double.parseDouble(editText_taxation_YA2022_electrical_vehicle_charging_expenses.getText().toString());

                    String formattedOtherDetailsTotalValue = String.format("%.2f", total);
                    textViewSetTotalOtherDetail.setText("Total Income Details : RM" + formattedOtherDetailsTotalValue);
                    totalIncomeTax(5, total);

                    double pcb = Double.parseDouble(editText_taxation_YA2022_pcb_value);
                    double zakat = Double.parseDouble(editText_taxation_YA2022_zakat_value);

                    totalIncomeTax(6, pcb);
                    totalIncomeTax(7, zakat);





                }

            }
        });





    }

    private void totalIncomeTax(int i, double value) {
        if (i == 1) {
            grossIncomeBeforeDeduction = value;
        } else if (i == 2) {
            individualRelief = value;
        } else if (i == 3) {
            childRelief = value;
        } else if (i == 4) {
            parentRelief = value;
        } else if (i == 5) {
            otherRelief = value;
        } else if (i == 6) {
            pcb = value;
        } else if (i == 7) {
            zakat = value;
        }


        Button button_start_calculate = findViewById(R.id.button_start_calculate);
        double finalGrossIncomeBeforeDeduction = grossIncomeBeforeDeduction;
        double finalIndividualRelief = individualRelief;
        double finalChildRelief = childRelief;
        double finalParentRelief = parentRelief;
        double finalOtherRelief = otherRelief;
        double finalPcb = pcb; // get the pcb value
        double finalZakat = zakat; // get the zakat value
        button_start_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double taxable_income = finalGrossIncomeBeforeDeduction - (finalIndividualRelief + finalChildRelief + finalParentRelief + finalOtherRelief);
                double finalTax = 0;
                double rate1 = 0;
                double rate2 = 150;
                double rate3 = 450;
                double rate4 = 1200;
                double rate5 = 2600;
                double rate6 = 6300;
                double rate7 = 36000;
                double rate8 = 36750;
                double rate9 = 50000;
                double rate10 = 104000;
                double rate11 = 280000;



                if (taxable_income <= 5000) {
                    finalTax = 0;
                } else if (taxable_income <= 20000) {
                    finalTax = rate1 + (taxable_income - 5000) * 0.01;
                } else if (taxable_income <= 35000) {
                    finalTax = rate1 + rate2 + rate3 + rate4 + (taxable_income - 20000) * 0.03;
                } else if (taxable_income <= 50000) {
                    finalTax = rate1 + rate2 + rate3 + (taxable_income - 35000) * 0.08;
                } else if (taxable_income <= 70000) {
                    finalTax = rate1 + rate2 + rate3 + rate4 + (taxable_income - 50000) * 0.13;
                } else if (taxable_income <= 100000) {
                    finalTax = rate1 + rate2 + rate3 + rate4 + rate5 + (taxable_income - 70000) * 0.21;
                } else if (taxable_income <= 250000) {
                    finalTax = rate1 + rate2 + rate3 + rate4 + rate5 + rate6 + (taxable_income - 100000) * 0.24;
                } else if (taxable_income <= 400000) {
                    finalTax = rate1 + rate2 + rate3 + rate4 + rate5 + rate6 + rate7 + (taxable_income - 250000) * 0.245;
                } else if (taxable_income <= 600000) {
                    finalTax = rate1 + rate2 + rate3 + rate4 + rate5 + rate6 + rate7 + rate8 + (taxable_income - 400000) * 0.25;
                } else if (taxable_income <= 1000000) {
                    finalTax = rate1 + rate2 + rate3 + rate4 + rate5 + rate6 + rate7 + rate8 + rate9 + (taxable_income - 6000000) * 0.26;
                } else if (taxable_income <= 2000000) {
                    finalTax = rate1 + rate2 + rate3 + rate4 + rate5 + rate6 + rate7 + rate8 + rate9 + rate10 + (taxable_income - 1000000) * 0.28;
                } else {
                    finalTax = rate1 + rate2 + rate3 + rate4 + rate5 + rate6 + rate7 + rate8 + rate9 + rate10 + rate11 + (taxable_income - 2000000) * 0.3;
                }

                double finalTaxToBePaid = finalTax - finalPcb - finalZakat;
                if (finalTaxToBePaid < 0) {
                    finalTaxToBePaid = 0;
                    Toast.makeText(TaxationCalculationActivity.this, "You do not need to pay any tax, RM" + Double.toString(finalTaxToBePaid), Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(TaxationCalculationActivity.this, "You need to pay tax, RM" + Double.toString(finalTaxToBePaid), Toast.LENGTH_SHORT).show();
                }

                        textViewGrossIncome = findViewById(R.id.textView_gross_income);
                        textViewIndividualDeduction = findViewById(R.id.textView_individual_deduction);
                        textViewChildDeduction = findViewById(R.id.textView_child_deduction);
                        textViewParentDeduction = findViewById(R.id.textView_parent_deduction);
                        textViewOtherDeduction = findViewById(R.id.textView_other_deduction);
                        textViewTaxableIncome = findViewById(R.id.textView_taxable_income);
                        textViewTaxAmount = findViewById(R.id.textView_tax_amount);
                        textViewPCBLast = findViewById(R.id.textView_pcb_last);
                        textViewZakatLast = findViewById(R.id.textView_zakat_last);
                        textViewTaxNeededToPay = findViewById(R.id.textView_tax_needed_to_pay);

                textViewGrossIncome.setText(String.format("%.2f", finalGrossIncomeBeforeDeduction));
                textViewIndividualDeduction.setText(String.format("%.2f", finalIndividualRelief));
                textViewChildDeduction.setText(String.format("%.2f", finalChildRelief));
                textViewParentDeduction.setText(String.format("%.2f", finalParentRelief));
                textViewOtherDeduction.setText(String.format("%.2f", finalOtherRelief));
                textViewTaxableIncome.setText(String.format("%.2f", taxable_income));
                textViewTaxAmount.setText(String.format("%.2f", finalTax));
                textViewPCBLast.setText(String.format("%.2f", finalPcb));
                textViewZakatLast.setText(String.format("%.2f", finalZakat));
                textViewTaxNeededToPay.setText("RM " + String.format("%.2f", finalTaxToBePaid));




            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        // Convert putExtra to the format used by getDoubleExtra
        double income = getIntent().getDoubleExtra("income", 0.0);
        double expense = getIntent().getDoubleExtra("expense", 0.0);
        double totalAmount = getIntent().getDoubleExtra("totalAmount", 0.0);


        double salaries = getIntent().getDoubleExtra("salaries", 0.0); //taxable
        if(salaries < 0){
            salaries = 0;
        }
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
        double zakatTotal = getIntent().getDoubleExtra("zakatTotal", 0.0);

        double incomeTotalCalculation = salaries + wages + commissions + bonuses + allowances + pensions + rent + interest + gainsProfits + dividendsInterestDiscounts;
        String incomeTotalString = String.valueOf(incomeTotalCalculation);

        editText_taxation_YA2022_total_annual_income.setKeyListener(null);
        editText_taxation_YA2022_total_annual_income.setText(incomeTotalString);

        editText_taxation_YA2022_year_service_completed = findViewById(R.id.editText_taxation_YA2022_year_service_completed);

        editText_taxation_YA2022_compensation_amount_received.setKeyListener(null);
        String compensationLossEmploymentString = String.valueOf(compensationLossEmployment);
        editText_taxation_YA2022_compensation_amount_received.setText(compensationLossEmploymentString);

        editText_taxation_YA2022_payment_alimony_to_former_wife.setKeyListener(null);
        if (alimonyPayment >= 4000){
            alimonyPayment = 4000;
        }
        String alimonyPaymentString = String.valueOf(alimonyPayment);
        editText_taxation_YA2022_payment_alimony_to_former_wife.setText(alimonyPaymentString);


        editText_taxation_YA2022_number_of_child_under_18 = findViewById(R.id.editText_taxation_YA2022_number_of_child_under_18);
        editText_taxation_YA2022_number_of_child_above_18_A_level = findViewById(R.id.editText_taxation_YA2022_number_of_child_above_18_A_level);
        editText_taxation_YA2022_number_of_child_above_18_diploma = findViewById(R.id.editText_taxation_YA2022_number_of_child_above_18_diploma);
        editText_taxation_YA2022_number_of_disabled_child = findViewById(R.id.editText_taxation_YA2022_number_of_disabled_child);
        editText_taxation_YA2022_number_of_disabled_child_diploma_above_18 = findViewById(R.id.editText_taxation_YA2022_number_of_disabled_child_diploma_above_18);


        editText_taxation_YA2022_sspn_child_education_saving.setKeyListener(null);
        if (sspnChildEducationSaving >= 8000){
            sspnChildEducationSaving = 8000;
        }
        String sspnChildEducationSavingString = String.valueOf((int) Math.floor(sspnChildEducationSaving));
        editText_taxation_YA2022_sspn_child_education_saving.setText(sspnChildEducationSavingString);


        editText_taxation_YA2022_breastfeeding_equipment.setKeyListener(null);
        if (breastfeedingEquipment >= 1000){
            breastfeedingEquipment = 1000;
        }
        String breastfeedingEquipmentString = String.valueOf((int) Math.floor(breastfeedingEquipment));
        editText_taxation_YA2022_breastfeeding_equipment.setText(breastfeedingEquipmentString);



        editText_taxation_YA2022_childcare_centres_kindergartens_fees.setKeyListener(null);
        if (childrenCentresKindergartenFees >= 3000){
            childrenCentresKindergartenFees = 3000;
        }
        String childrenCentresKindergartenFeesString = String.valueOf((int) Math.floor(childrenCentresKindergartenFees));
        editText_taxation_YA2022_childcare_centres_kindergartens_fees.setText(childrenCentresKindergartenFeesString);

        editText_taxation_YA2022_parent_medical.setKeyListener(null);
        if (parentMedical >= 8000){
            parentMedical = 8000;
        }
        String parentMedicalString = String.valueOf((int) Math.floor(parentMedical));
        editText_taxation_YA2022_parent_medical.setText(parentMedicalString);


        editText_taxation_YA2022_annuity_prs.setKeyListener(null);
        if (annuityPRS >= 3000){
            annuityPRS = 3000;
        }
        String annuityPRSString = String.valueOf((int) Math.floor(annuityPRS));
        editText_taxation_YA2022_annuity_prs.setText(annuityPRSString);


        editText_taxation_YA2022_education_medical_insurance.setKeyListener(null);
        if (educationMedicalInsurance >= 3000){
            educationMedicalInsurance = 3000;
        }
        String educationMedicalInsuranceString = String.valueOf((int) Math.floor(educationMedicalInsurance));
        editText_taxation_YA2022_education_medical_insurance.setText(educationMedicalInsuranceString);

        editText_taxation_YA2022_education_fees_self.setKeyListener(null);
        if (educationFeesSelf >= 7000){
            educationFeesSelf = 7000;
        }
        String educationFeesSelfString = String.valueOf((int) Math.floor(educationFeesSelf));
        editText_taxation_YA2022_education_fees_self.setText(educationFeesSelfString);



        editText_taxation_YA2022_supporting_equipment.setKeyListener(null);
        if (supportingEquipment >= 6000){
            supportingEquipment = 6000;
        }
        String supportingEquipmentString = String.valueOf((int) Math.floor(supportingEquipment));
        editText_taxation_YA2022_supporting_equipment.setText(supportingEquipmentString);


        editText_taxation_YA2022_medical_expenses.setKeyListener(null);
        if (medicalExpenses >= 8000){
            medicalExpenses = 8000;
        }
        String medicalExpensesString = String.valueOf((int) Math.floor(medicalExpenses));
        editText_taxation_YA2022_medical_expenses.setText(medicalExpensesString);

        editText_taxation_YA2022_epf_kwsp.setKeyListener(null);
        if (epfKwsp >= 4000){
            epfKwsp = 4000;
        }
        String epfKwspString = String.valueOf((int) Math.floor(epfKwsp));
        editText_taxation_YA2022_epf_kwsp.setText(epfKwspString);


        editText_taxation_YA2022_life_insurance.setKeyListener(null);
        if (lifeInsurance >= 3000){
            lifeInsurance = 3000;
        }
        String lifeInsuranceString = String.valueOf((int) Math.floor(lifeInsurance));
        editText_taxation_YA2022_life_insurance.setText(lifeInsuranceString);


        editText_taxation_YA2022_lifestyle.setKeyListener(null);
        if (lifestyle >= 2500){
            lifestyle = 2500;
        }
        String lifestyleString = String.valueOf((int) Math.floor(lifestyle));
        editText_taxation_YA2022_lifestyle.setText(lifestyleString);


        editText_taxation_YA2022_lifestyle_additional.setKeyListener(null);
        if (lifestyleAdditional >= 2500){
            lifestyleAdditional = 2500;
        }
        String lifestyleAdditionalString = String.valueOf((int) Math.floor(lifestyleAdditional));
        editText_taxation_YA2022_lifestyle_additional.setText(lifestyleAdditionalString);


        editText_taxation_YA2022_lifestyle_sport.setKeyListener(null);
        if (lifestyleSport >= 500){
            lifestyleSport = 500;
        }
        String lifestyleSportString = String.valueOf((int) Math.floor(lifestyleSport));
        editText_taxation_YA2022_lifestyle_sport.setText(lifestyleSportString);


        editText_taxation_YA2022_socso_perkeso.setKeyListener(null);
        if (socsoPerkeso >= 350){
            socsoPerkeso = 350;
        }
        String socsoPerkesoString = String.valueOf((int) Math.floor(socsoPerkeso));
        editText_taxation_YA2022_socso_perkeso.setText(socsoPerkesoString);


        editText_taxation_YA2022_domestic_travel_expenses.setKeyListener(null);
        if (domesticTravelExpenses >= 1000){
            domesticTravelExpenses = 1000;
        }
        String domesticTravelExpensesString = String.valueOf((int) Math.floor(domesticTravelExpenses));
        editText_taxation_YA2022_domestic_travel_expenses.setText(domesticTravelExpensesString);


        editText_taxation_YA2022_electrical_vehicle_charging_expenses.setKeyListener(null);
        if (electricalVehicleChargingExpenses >= 2500){
            electricalVehicleChargingExpenses = 2500;
        }
        String electricalVehicleChargingExpensesString = String.valueOf((int) Math.floor(electricalVehicleChargingExpenses));
        editText_taxation_YA2022_electrical_vehicle_charging_expenses.setText(electricalVehicleChargingExpensesString);



        editText_taxation_YA2022_pcb.setKeyListener(null);
        String monthlyTaxDeductionString = String.valueOf((int) Math.floor(monthlyTaxDeduction));
        editText_taxation_YA2022_pcb.setText(monthlyTaxDeductionString);


        editText_taxation_YA2022_zakat.setKeyListener(null);
        String zakatTotalString = String.valueOf((int) Math.floor(zakatTotal));
        editText_taxation_YA2022_zakat.setText(zakatTotalString);

    }




}