package com.example.aiexpensestracker.expensesManagerModule;

import java.io.Serializable;

public class ExpenseModel implements Serializable {

    private String expenseID;
    private double amount;
    private String type;
    private String category;
    private String itemName;
    private String note;
    private String date;
    private String time;
    private String shopName;
    private String phoneNumber;
    private String address;

    private String uid;

    public ExpenseModel() {


    }

    public ExpenseModel(String expenseID, double amount, String type, String category, String itemName, String note, String date, String time, String shopName, String phoneNumber, String address, String uid) {

        this.expenseID = expenseID;
        this.amount = amount;
        this.type = type;
        this.category = category;
        this.itemName = itemName;
        this.note = note;
        this.date = date;
        this.time = time;
        this.shopName = shopName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.uid = uid;
    }

    public String getExpenseID() {
        return expenseID;
    }

    public void setExpenseID(String expenseID) {
        this.expenseID = expenseID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

}
