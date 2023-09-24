package com.example.aiexpensestracker.expensesManagerModule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aiexpensestracker.R;
import com.example.aiexpensestracker.taxationModule.TaxationActivity;

public class TaxLimitActivity extends AppCompatActivity {

    ProgressBar progressBarSalaries, progressBarWages, progressBarCommissions, progressBarBonuses, progressBarAllowances,
            progressBarGratuities, progressBarPensions, progressBarRent, progressBarInterest, progressBarRoyalties,
            progressBarGainProfits, progressBarDividendDiscounts, progressBarCompensationLoss, progressBarGift,
            progressBarInheritance, progressBarFoodDrinks, progressBarShopping, progressBarHousing, progressBarTransportation,
            progressBarVehicle, progressBarLifeEntertainment, progressBarCommunication, progressBarInvestments,
            progressBarPaymentAlimony, progressBarSSPN, progressBarBreastfeeding, progressBarChildrenCentres,
            progressBarParentMedical, progressBarAnnuityPRS, progressBarEducationMedicalInsurance,
            progressBarEducationSelf, progressBarSupportingEquipment, progressBarMedicalExpenses, progressBarEPFKWSP,
            progressBarLifeInsurance, progressBarLifeStyle, progressBarLifeStyleAdditional, progressBarLifeStyleSport,
            progressBarSocsoPerkeso, progressBarDomesticTravelExpenses, progressBarElectricalVehicle,
            progressBarMonthlyTaxDeduction, progressBarZakat;

    TextView textviewSalaries, textviewWages, textviewCommissions, textviewBonuses, textviewAllowances,
            textviewGratuities, textviewPensions, textviewRent, textviewInterest, textviewRoyalties,
            textviewGainProfits, textviewDividendDiscounts, textviewCompensationLoss, textviewGift,
            textviewInheritance, textviewFoodDrinks, textviewShopping, textviewHousing, textviewTransportation,
            textviewVehicle, textviewLifeEntertainment, textviewCommunication, textviewInvestments,
            textviewPaymentAlimony, textviewSSPN, textviewBreastfeeding, textviewChildrenCentres,
            textviewParentMedical, textviewAnnuityPRS, textviewEducationMedicalInsurance,
            textviewEducationSelf, textviewSupportingEquipment, textviewMedicalExpenses, textviewEPFKWSP,
            textviewLifeInsurance, textviewLifeStyle, textviewLifeStyleAdditional, textviewLifeStyleSport,
            textviewSocsoPerkeso, textviewDomesticTravelExpenses, textviewElectricalVehicle,
            textviewMonthlyTaxDeduction, textviewZakat;

    private int progressValueSalaries = 0, progressValueWages = 0, progressValueCommissions = 0, progressValueBonuses = 0, progressValueAllowances = 0,
            progressValueGratuities = 0, progressValuePensions = 0, progressValueRent = 0, progressValueInterest, progressValueRoyalties = 0,
            progressValueGainProfits = 0, progressValueDividendDiscounts = 0, progressValueCompensationLoss = 0, progressValueGift = 0,
            progressValueInheritance = 0, progressValueFoodDrinks = 0, progressValueShopping = 0, progressValueHousing, progressValueTransportation = 0,
            progressValueVehicle = 0, progressValueLifeEntertainment = 0, progressValueCommunication = 0, progressValueInvestments = 0,
            progressValuePaymentAlimony = 0, progressValueSSPN = 0, progressValueBreastfeeding = 0, progressValueChildrenCentres = 0,
            progressValueParentMedical = 0, progressValueAnnuityPRS = 0, progressValueEducationMedicalInsurance = 0,
            progressValueEducationSelf = 0, progressValueSupportingEquipment = 0, progressValueMedicalExpenses = 0, progressValueEPFKWSP = 0,
            progressValueLifeInsurance = 0, progressValueLifeStyle = 0, progressValueLifeStyleAdditional = 0, progressValueLifeStyleSport = 0,
            progressValueSocsoPerkeso = 0, progressValueDomesticTravelExpenses = 0, progressValueElectricalVehicle = 0,
            progressValueMonthlyTaxDeduction = 0, progressValueZakat = 0;

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
        setContentView(R.layout.activity_tax_limit);

        getSupportActionBar().setTitle("Expenses Tracking");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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

        progressBarSalaries = findViewById(R.id.progressBarSalaries);
        progressBarWages = findViewById(R.id.progressBarWages);
        progressBarCommissions = findViewById(R.id.progressBarCommissions);
        progressBarBonuses = findViewById(R.id.progressBarBonuses);
        progressBarAllowances = findViewById(R.id.progressBarAllowances);
        progressBarPensions = findViewById(R.id.progressBarPensions);
        progressBarRent = findViewById(R.id.progressBarRent);
        progressBarInterest = findViewById(R.id.progressBarInterest);
        progressBarGainProfits = findViewById(R.id.progressBarGainProfits);
        progressBarDividendDiscounts = findViewById(R.id.progressBarDividendDiscounts);
        progressBarCompensationLoss = findViewById(R.id.progressBarCompensationLoss);
        progressBarGift = findViewById(R.id.progressBarGift);
        progressBarInheritance = findViewById(R.id.progressBarInheritance);
        progressBarFoodDrinks = findViewById(R.id.progressBarFoodDrinks);
        progressBarShopping = findViewById(R.id.progressBarShopping);
        progressBarHousing = findViewById(R.id.progressBarHousing);
        progressBarTransportation = findViewById(R.id.progressBarTransportation);
        progressBarVehicle = findViewById(R.id.progressBarVehicle);
        progressBarLifeEntertainment = findViewById(R.id.progressBarLifeEntertainment);
        progressBarCommunication = findViewById(R.id.progressBarCommunication);
        progressBarInvestments = findViewById(R.id.progressBarInvestments);
        progressBarPaymentAlimony = findViewById(R.id.progressBarPaymentAlimony);
        progressBarSSPN = findViewById(R.id.progressBarSSPN);
        progressBarBreastfeeding = findViewById(R.id.progressBarBreastfeeding);
        progressBarChildrenCentres = findViewById(R.id.progressBarChildrenCentres);
        progressBarParentMedical = findViewById(R.id.progressBarParentMedical);
        progressBarAnnuityPRS = findViewById(R.id.progressBarAnnuityPRS);
        progressBarEducationMedicalInsurance = findViewById(R.id.progressBarEducationMedicalInsurance);
        progressBarEducationSelf = findViewById(R.id.progressBarEducationSelf);
        progressBarSupportingEquipment = findViewById(R.id.progressBarSupportingEquipment);
        progressBarMedicalExpenses = findViewById(R.id.progressBarMedicalExpenses);
        progressBarEPFKWSP = findViewById(R.id.progressBarEPFKWSP);
        progressBarLifeInsurance = findViewById(R.id.progressBarLifeInsurance);
        progressBarLifeStyle = findViewById(R.id.progressBarLifeStyle);
        progressBarLifeStyleAdditional = findViewById(R.id.progressBarLifeStyleAdditional);
        progressBarLifeStyleSport = findViewById(R.id.progressBarLifeStyleSport);
        progressBarSocsoPerkeso = findViewById(R.id.progressBarSocsoPerkeso);
        progressBarDomesticTravelExpenses = findViewById(R.id.progressBarDomesticTravelExpenses);
        progressBarElectricalVehicle = findViewById(R.id.progressBarElectricalVehicle);
        progressBarMonthlyTaxDeduction = findViewById(R.id.progressBarMonthlyTaxDeduction);
        progressBarZakat = findViewById(R.id.progressBarZakat);

        textviewSalaries = findViewById(R.id.textviewSalaries);
        textviewWages = findViewById(R.id.textviewWages);
        textviewCommissions = findViewById(R.id.textviewCommissions);
        textviewBonuses = findViewById(R.id.textviewBonuses);
        textviewAllowances = findViewById(R.id.textviewAllowances);
        textviewPensions = findViewById(R.id.textviewPensions);
        textviewRent = findViewById(R.id.textviewRent);
        textviewInterest = findViewById(R.id.textviewInterest);
        textviewGainProfits = findViewById(R.id.textviewGainProfits);
        textviewDividendDiscounts = findViewById(R.id.textviewDividendDiscounts);
        textviewCompensationLoss = findViewById(R.id.textviewCompensationLoss);
        textviewGift = findViewById(R.id.textviewGift);
        textviewInheritance = findViewById(R.id.textviewInheritance);
        textviewFoodDrinks = findViewById(R.id.textviewFoodDrinks);
        textviewShopping = findViewById(R.id.textviewShopping);
        textviewHousing = findViewById(R.id.textviewHousing);
        textviewTransportation = findViewById(R.id.textviewTransportation);
        textviewVehicle = findViewById(R.id.textviewVehicle);
        textviewLifeEntertainment = findViewById(R.id.textviewLifeEntertainment);
        textviewCommunication = findViewById(R.id.textviewCommunication);
        textviewInvestments = findViewById(R.id.textviewInvestments);
        textviewPaymentAlimony = findViewById(R.id.textviewPaymentAlimony);
        textviewSSPN = findViewById(R.id.textviewSSPN);
        textviewBreastfeeding = findViewById(R.id.textviewBreastfeeding);
        textviewChildrenCentres = findViewById(R.id.textviewChildrenCentres);
        textviewParentMedical = findViewById(R.id.textviewParentMedical);
        textviewAnnuityPRS = findViewById(R.id.textviewAnnuityPRS);
        textviewEducationMedicalInsurance = findViewById(R.id.textviewEducationMedicalInsurance);
        textviewEducationSelf = findViewById(R.id.textviewEducationSelf);
        textviewSupportingEquipment = findViewById(R.id.textviewSupportingEquipment);
        textviewMedicalExpenses = findViewById(R.id.textviewMedicalExpenses);
        textviewEPFKWSP = findViewById(R.id.textviewEPFKWSP);
        textviewLifeInsurance = findViewById(R.id.textviewLifeInsurance);
        textviewLifeStyle = findViewById(R.id.textviewLifeStyle);
        textviewLifeStyleAdditional = findViewById(R.id.textviewLifeStyleAdditional);
        textviewLifeStyleSport = findViewById(R.id.textviewLifeStyleSport);
        textviewSocsoPerkeso = findViewById(R.id.textviewSocsoPerkeso);
        textviewDomesticTravelExpenses = findViewById(R.id.textviewDomesticTravelExpenses);
        textviewElectricalVehicle = findViewById(R.id.textviewElectricalVehicle);
        textviewMonthlyTaxDeduction = findViewById(R.id.textviewMonthlyTaxDeduction);
        textviewZakat = findViewById(R.id.textviewZakat);

        String formattedIncome = String.format("%.2f", income);
        String formattedExpense = String.format("%.2f", expense);
        String formattedtotalAmount = String.format("%.2f", totalAmount);
        String formattedsalaries = String.format("%.2f", salaries);
        String formattedwages = String.format("%.2f", wages);
        String formattedcommissions = String.format("%.2f", commissions);
        String formattedbonuses = String.format("%.2f", bonuses);
        String formattedallowances = String.format("%.2f", allowances);
        String formattedpensions = String.format("%.2f", pensions);
        String formattedrent = String.format("%.2f", rent);
        String formattedinterest = String.format("%.2f", interest);
        String formattedgainsProfits = String.format("%.2f", gainsProfits);
        String formatteddividendsInterestDiscounts = String.format("%.2f", dividendsInterestDiscounts);
        String formattedcompensationLossEmployment = String.format("%.2f", compensationLossEmployment);
        String formattedgift = String.format("%.2f", gift);
        String formattedinheritance = String.format("%.2f", inheritance);

        String formattedfoodDrinks = String.format("%.2f", foodDrinks);
        String formattedshopping = String.format("%.2f", shopping);
        String formattedhousing = String.format("%.2f", housing);
        String formattedtransportation = String.format("%.2f", transportation);
        String formattedvehicle = String.format("%.2f", vehicle);
        String formattedlifeEntertainment = String.format("%.2f", lifeEntertainment);
        String formattedcommunication = String.format("%.2f", communication);
        String formattedinvestments = String.format("%.2f", investments);
        String formattedalimonyPayment = String.format("%.2f", alimonyPayment);
        String formattedsspnChildEducationSaving = String.format("%.2f", sspnChildEducationSaving);
        String formattedbreastfeedingEquipment = String.format("%.2f", breastfeedingEquipment);
        String formattedchildrenCentresKindergartenFees = String.format("%.2f", childrenCentresKindergartenFees);
        String formattedparentMedical = String.format("%.2f", parentMedical);
        String formattedannuityPRS = String.format("%.2f", annuityPRS);
        String formattededucationMedicalInsurance = String.format("%.2f", educationMedicalInsurance);
        String formattededucationFeesSelf = String.format("%.2f", educationFeesSelf);
        String formattedsupportingEquipment = String.format("%.2f", supportingEquipment);
        String formattedmedicalExpenses = String.format("%.2f", medicalExpenses);
        String formattedepfKwsp = String.format("%.2f", epfKwsp);
        String formattedlifeInsurance = String.format("%.2f", lifeInsurance);
        String formattedlifestyle = String.format("%.2f", lifestyle);
        String formattedlifestyleAdditional = String.format("%.2f", lifestyleAdditional);
        String formattedlifestyleSport = String.format("%.2f", lifestyleSport);
        String formattedsocsoPerkeso = String.format("%.2f", socsoPerkeso);
        String formatteddomesticTravelExpenses = String.format("%.2f", domesticTravelExpenses);
        String formattedelectricalVehicleChargingExpenses = String.format("%.2f", electricalVehicleChargingExpenses);
        String formattedmonthlyTaxDeduction = String.format("%.2f", monthlyTaxDeduction);
        String formattedzakatTotal = String.format("%.2f", zakatTotal);



        double IncomeDouble = Double.parseDouble(formattedIncome);
        double ExpenseDouble = Double.parseDouble(formattedExpense);
        double TotalAmountDouble = Double.parseDouble(formattedtotalAmount);
        double SalariesDouble = Double.parseDouble(formattedsalaries);
        double WagesDouble = Double.parseDouble(formattedwages);
        double CommissionsDouble = Double.parseDouble(formattedcommissions);
        double BonusesDouble = Double.parseDouble(formattedbonuses);
        double AllowancesDouble = Double.parseDouble(formattedallowances);
        double PensionsDouble = Double.parseDouble(formattedpensions);
        double RentDouble = Double.parseDouble(formattedrent);
        double InterestDouble = Double.parseDouble(formattedinterest);
        double ProfitsDouble = Double.parseDouble(formattedgainsProfits);
        double DividendsDouble = Double.parseDouble(formatteddividendsInterestDiscounts);
        double CompensationLossDouble = Double.parseDouble(formattedcompensationLossEmployment);
        double GiftDouble = Double.parseDouble(formattedgift);
        double InheritanceDouble = Double.parseDouble(formattedinheritance);

        double FoodDrinksDouble = Double.parseDouble(formattedfoodDrinks);
        double ShoppingDouble = Double.parseDouble(formattedshopping);
        double HousingDouble = Double.parseDouble(formattedhousing);
        double TransportationDouble = Double.parseDouble(formattedtransportation);
        double VehicleDouble = Double.parseDouble(formattedvehicle);
        double LifeEntertainmentDouble = Double.parseDouble(formattedlifeEntertainment);
        double CommunicationDouble = Double.parseDouble(formattedcommunication);
        double InvestmentsDouble = Double.parseDouble(formattedinvestments);
        double AlimonyPaymentDouble = Double.parseDouble(formattedalimonyPayment);
        double SSPNChildEducationDouble = Double.parseDouble(formattedsspnChildEducationSaving);
        double BreastFeedingDouble = Double.parseDouble(formattedbreastfeedingEquipment);
        double ChildrenCentresDouble = Double.parseDouble(formattedchildrenCentresKindergartenFees);
        double ParentMedicalDouble = Double.parseDouble(formattedparentMedical);
        double AnnuityPRSDouble = Double.parseDouble(formattedannuityPRS);
        double MedicalInsuranceDouble = Double.parseDouble(formattededucationMedicalInsurance);
        double EducationFeesSelfDouble = Double.parseDouble(formattededucationFeesSelf);
        double SupportingEquipmentDouble = Double.parseDouble(formattedsupportingEquipment);
        double MedicalExpensesDouble = Double.parseDouble(formattedmedicalExpenses);
        double EPFKWSPDouble = Double.parseDouble(formattedepfKwsp);
        double LifeInsuranceDouble = Double.parseDouble(formattedlifeInsurance);
        double LifestyleDouble = Double.parseDouble(formattedlifestyle);
        double LifestyleAdditionalDouble = Double.parseDouble(formattedlifestyleAdditional);
        double LifeStyleSportDouble = Double.parseDouble(formattedlifestyleSport);
        double SocsePerkesoDouble = Double.parseDouble(formattedsocsoPerkeso);
        double DomesticTravelDouble = Double.parseDouble(formatteddomesticTravelExpenses);
        double ElectricalVehicleDouble = Double.parseDouble(formattedelectricalVehicleChargingExpenses);
        double MTBPCBDouble = Double.parseDouble(formattedmonthlyTaxDeduction);
        double ZakatDouble = Double.parseDouble(formattedzakatTotal);

        textviewSalaries.setText("Salaries: (RM " + salaries + ")");
        textviewWages.setText("Wages: (RM " + wages + ")");
        textviewCommissions.setText("Commisions: (RM " + commissions + ")");
        textviewBonuses.setText("Bonuses: (RM " + bonuses + ")");
        textviewAllowances.setText("Allowances: (RM " + allowances + ")");
        textviewPensions.setText("Pensions: (RM " + pensions + ")");
        textviewRent.setText("Rent: (RM " + rent + ")");
        textviewInterest.setText("Interest: (RM " + interest + ")");
        textviewGainProfits.setText("Gain or Profits: (RM " + gainsProfits + ")");
        textviewDividendDiscounts.setText("Dividend: (RM "+ dividendsInterestDiscounts + ")");
        textviewCompensationLoss.setText("Compensation Loss: (RM " +compensationLossEmployment + ")");
        textviewGift.setText("Gift: (RM "+gift + ")");
        textviewInheritance.setText("Inheritance: (RM "+inheritance + ")");
        textviewFoodDrinks.setText("Food Drinks: (RM "+foodDrinks + ")");
        textviewShopping.setText("Shopping: (RM "+shopping + ")");
        textviewHousing.setText("Housing: (RM "+housing + ")");
        textviewTransportation.setText("Transportation: (RM "+transportation + ")");
        textviewVehicle.setText("Vehicle: (RM "+vehicle + ")");
        textviewLifeEntertainment.setText("Life Entertainment: (RM " +lifeEntertainment+ ")");
        textviewCommunication.setText("Communication: (RM "+communication + ")");
        textviewInvestments.setText("Investments: (RM "+investments + ")");
        textviewPaymentAlimony.setText("Payment Alimony: (RM "+alimonyPayment + ")");
        textviewSSPN.setText("SSPN - Child Education Saving: (RM "+sspnChildEducationSaving + ")");
        textviewBreastfeeding.setText("Breastfeeding Equipment: (RM "+breastfeedingEquipment + ")");
        textviewChildrenCentres.setText("Children Centres: (RM"+childrenCentresKindergartenFees + ")");
        textviewParentMedical.setText("Parent Medical: (RM "+parentMedical + ")");
        textviewAnnuityPRS.setText("Annuity/PRS: (RM"+annuityPRS + ")");
        textviewEducationMedicalInsurance.setText("Education/Medical Insu.: (RM "+educationMedicalInsurance + ")");
        textviewEducationSelf.setText("Education Self: (RM "+educationFeesSelf + ")");
        textviewSupportingEquipment.setText("Supporting Equipment: (RM "+supportingEquipment + ")");
        textviewMedicalExpenses.setText("Medical Expenses: (RM "+medicalExpenses + ")");
        textviewEPFKWSP.setText("EFP/KWSP: (RM "+epfKwsp + ")");
        textviewLifeInsurance.setText("Life Insurance: (RM "+lifeInsurance + ")");
        textviewLifeStyle.setText("LifeStyle: (RM "+lifestyle + ")");
        textviewLifeStyleAdditional.setText("LifeStyle Additional: (RM "+lifestyleAdditional + ")");
        textviewLifeStyleSport.setText("LifeStyle Sport: (RM " +lifestyleSport+ ")");
        textviewSocsoPerkeso.setText("Socso/Perkeso: (RM "+socsoPerkeso + ")");
        textviewDomesticTravelExpenses.setText("Domestic Travel: (RM "+ domesticTravelExpenses+ ")");
        textviewElectricalVehicle.setText("Electrical Vehi. Char. (RM "+electricalVehicleChargingExpenses + ")");
        textviewMonthlyTaxDeduction.setText("MTB/PCB: (RM"+monthlyTaxDeduction + ")");
        textviewZakat.setText("Zakat: (RM"+zakatTotal + ")");

        progressValueSalaries = (int) ((SalariesDouble/IncomeDouble)*100);
        progressBarSalaries.setProgress(progressValueSalaries);

        progressValueWages = (int) ((WagesDouble/IncomeDouble)*100);
        progressBarWages.setProgress(progressValueWages);

        progressValueCommissions = (int) ((CommissionsDouble/IncomeDouble)*100);
        progressBarCommissions.setProgress(progressValueCommissions);

        progressValueCommissions = (int) ((CommissionsDouble/IncomeDouble)*100);
        progressBarCommissions.setProgress(progressValueCommissions);

        progressValueBonuses = (int) ((BonusesDouble/IncomeDouble)*100);
        progressBarBonuses.setProgress(progressValueBonuses);

        progressValueBonuses = (int) ((BonusesDouble/IncomeDouble)*100);
        progressBarBonuses.setProgress(progressValueBonuses);

        progressValueAllowances = (int) ((AllowancesDouble/IncomeDouble)*100);
        progressBarAllowances.setProgress(progressValueAllowances);

        progressValuePensions = (int) ((PensionsDouble/IncomeDouble)*100);
        progressBarPensions.setProgress(progressValuePensions);

        progressValueRent = (int) ((RentDouble/IncomeDouble)*100);
        progressBarRent.setProgress(progressValueRent);

        progressValueInterest = (int) ((InterestDouble/IncomeDouble)*100);
        progressBarInterest.setProgress(progressValueInterest);

        progressValueGainProfits = (int) ((ProfitsDouble/IncomeDouble)*100);
        progressBarGainProfits.setProgress(progressValueGainProfits);

        progressValueDividendDiscounts = (int) ((DividendsDouble/IncomeDouble)*100);
        progressBarDividendDiscounts.setProgress(progressValueDividendDiscounts);

        progressValueCompensationLoss = (int) ((CompensationLossDouble/IncomeDouble)*100);
        progressBarCompensationLoss.setProgress(progressValueCompensationLoss);

        progressValueGift = (int) ((GiftDouble/IncomeDouble)*100);
        progressBarGift.setProgress(progressValueGift);

        progressValueInheritance = (int) ((InheritanceDouble/IncomeDouble)*100);
        progressBarInheritance.setProgress(progressValueInheritance);

        progressValueFoodDrinks = (int) ((FoodDrinksDouble/ExpenseDouble)*100);
        progressBarFoodDrinks.setProgress(progressValueFoodDrinks);

        progressValueShopping = (int) ((ShoppingDouble/ExpenseDouble)*100);
        progressBarShopping.setProgress(progressValueShopping);

        progressValueHousing = (int) ((HousingDouble/ExpenseDouble)*100);
        progressBarHousing.setProgress(progressValueHousing);

        progressValueTransportation = (int) ((TransportationDouble/ExpenseDouble)*100);
        progressBarTransportation.setProgress(progressValueTransportation);

        progressValueVehicle = (int) ((VehicleDouble/ExpenseDouble)*100);
        progressBarVehicle.setProgress(progressValueVehicle);

        progressValueLifeEntertainment = (int) ((LifeEntertainmentDouble/ExpenseDouble)*100);
        progressBarLifeEntertainment.setProgress(progressValueLifeEntertainment);

        progressValueCommunication = (int) ((CommunicationDouble/ExpenseDouble)*100);
        progressBarCommunication.setProgress(progressValueCommunication);

        progressValueInvestments = (int) ((InvestmentsDouble/ExpenseDouble)*100);
        progressBarInvestments.setProgress(progressValueInvestments);

        progressValuePaymentAlimony = (int) ((AlimonyPaymentDouble/ExpenseDouble)*100);
        progressBarPaymentAlimony.setProgress(progressValuePaymentAlimony);

        progressValueSSPN = (int) ((SSPNChildEducationDouble/ExpenseDouble)*100);
        progressBarSSPN.setProgress(progressValueSSPN);

        progressValueBreastfeeding = (int) ((BreastFeedingDouble/ExpenseDouble)*100);
        progressBarBreastfeeding.setProgress(progressValueBreastfeeding);

        progressValueChildrenCentres = (int) ((ChildrenCentresDouble/ExpenseDouble)*100);
        progressBarChildrenCentres.setProgress(progressValueChildrenCentres);

        progressValueParentMedical = (int) ((ParentMedicalDouble/ExpenseDouble)*100);
        progressBarParentMedical.setProgress(progressValueParentMedical);

        progressValueAnnuityPRS = (int) ((AnnuityPRSDouble/ExpenseDouble)*100);
        progressBarAnnuityPRS.setProgress(progressValueAnnuityPRS);

        progressValueEducationMedicalInsurance = (int) ((MedicalInsuranceDouble/ExpenseDouble)*100);
        progressBarEducationMedicalInsurance.setProgress(progressValueEducationMedicalInsurance);

        progressValueEducationSelf = (int) ((EducationFeesSelfDouble/ExpenseDouble)*100);
        progressBarEducationSelf.setProgress(progressValueEducationSelf);

        progressValueSupportingEquipment = (int) ((SupportingEquipmentDouble/ExpenseDouble)*100);
        progressBarSupportingEquipment.setProgress(progressValueSupportingEquipment);

        progressValueMedicalExpenses = (int) ((MedicalExpensesDouble/ExpenseDouble)*100);
        progressBarMedicalExpenses.setProgress(progressValueMedicalExpenses);

        progressValueEPFKWSP = (int) ((EPFKWSPDouble/ExpenseDouble)*100);
        progressBarEPFKWSP.setProgress(progressValueEPFKWSP);

        progressValueLifeInsurance = (int) ((LifeInsuranceDouble/ExpenseDouble)*100);
        progressBarLifeInsurance.setProgress(progressValueLifeInsurance);

        progressValueLifeStyle = (int) ((LifestyleDouble/ExpenseDouble)*100);
        progressBarLifeStyle.setProgress(progressValueLifeStyle);

        progressValueLifeStyleAdditional = (int) ((LifestyleAdditionalDouble/ExpenseDouble)*100);
        progressBarLifeStyleAdditional.setProgress(progressValueLifeStyleAdditional);

        progressValueLifeStyleSport = (int) ((LifeStyleSportDouble/ExpenseDouble)*100);
        progressBarLifeStyleSport.setProgress(progressValueLifeStyleSport);

        progressValueSocsoPerkeso = (int) ((SocsePerkesoDouble/ExpenseDouble)*100);
        progressBarSocsoPerkeso.setProgress(progressValueSocsoPerkeso);

        progressValueDomesticTravelExpenses = (int) ((DomesticTravelDouble/ExpenseDouble)*100);
        progressBarDomesticTravelExpenses.setProgress(progressValueDomesticTravelExpenses);

        progressValueElectricalVehicle = (int) ((ElectricalVehicleDouble/ExpenseDouble)*100);
        progressBarElectricalVehicle.setProgress(progressValueElectricalVehicle);

        progressValueMonthlyTaxDeduction = (int) ((MTBPCBDouble/ExpenseDouble)*100);
        progressBarMonthlyTaxDeduction.setProgress(progressValueMonthlyTaxDeduction);

        progressValueZakat = (int) ((ZakatDouble/ExpenseDouble)*100);
        progressBarZakat.setProgress(progressValueZakat);

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

        Toast.makeText(this, "Income: " + zakatTotal, Toast.LENGTH_SHORT).show();

    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(TaxLimitActivity.this, ExpensesManagerActivity.class);
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
