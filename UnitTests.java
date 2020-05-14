/**
 *  Final Project
 *  Tests all methods including void/print methods to make sure they give the desired output/function
 *  CS108-4
 *  5/08/20
 *  @author  Shane Wechsler 823526399
 */

import javax.sound.midi.SysexMessage;
import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class UnitTests {
    public static void main(String[] args){
        chargeTest();
        billTest();
        managerTest();
        savingsTest();
        adviserTest();
        checkingTest();
        printChargeTest();
        showHistoryTestSavings();
        showHistoryTestChecking();
    }
    public static void chargeTest(){
        System.out.println();
        boolean passedAll = true;
        Charge test = new Charge("correct", 100, 426, "Goods");
        System.out.println("Testing Class: Charge");
        if(test.getName().equals("correct")){
            System.out.println("Name returns correct, passed");
        } else {
            System.out.println("Incorrect name, FAILED");
            passedAll = false;
        }
        if(test.getAmount() == 100.00){
            System.out.println("Correct amount returned, passed");
        }else{
            System.out.println("Incorrect amount, FAILED");
            passedAll = false;
        }
        if(test.getDate() == 426){
            System.out.println("Correct date returned, passed");
        } else {
            System.out.println("Incorrect date, FAILED");
            passedAll = false;
        }
        if(passedAll){
            System.out.println("Charge passed all tests!");
        }
    }
    public static void billTest(){
        System.out.println();
        boolean passedAll = true;
        Bill test = new Bill("Bill", 100, 426, 31);
        System.out.println("Testing Class: Bill");
        if(test.getName().equals("Bill")){
            System.out.println("Name returns correct, passed");
        } else {
            System.out.println("Incorrect name, FAILED");
            passedAll = false;
        }
        if(test.getAmount() == 100.00){
            System.out.println("Correct amount returned, passed");
        }else{
            System.out.println("Incorrect amount, FAILED");
            passedAll = false;
        }
        if(test.getDate() == 426){
            System.out.println("Correct date returned, passed");
        } else {
            System.out.println("Incorrect date, FAILED");
            passedAll = false;
        }
        if(test.getTimeInDays() == 31){
            System.out.println("Correct time in days returned, passed");
        } else{
            System.out.println("Incorrect days on bill, FAILED");
            passedAll = false;
        }
        if(test.billCharge().getName() ==  test.getName()){
            System.out.println("billCharge returns itself, passed");
        } else {
            System.out.println("billCharge returns incorrectly, FAILED");
            passedAll = false;
        }
        test.dayPassed();
        if(test.getDaysLeft() == 30){
            System.out.println("Successfully decreased daysLeft, passed");
        } else {
            System.out.println("incorrectly decreased daysLeft, failed");
            passedAll = false;
        }
        while(test.getDaysLeft() != 1) {
            test.dayPassed();
        }
        if(test.dayPassed().getName() == test.getName()){
            System.out.println("dayPassed returns the correct charge after cycle, passed");
        } else {
            System.out.println("Incorrect charge returned, FAILED");
            passedAll = false;
        }
        if(passedAll){
            System.out.println("Bill passed all tests!");
        }
    }
    public static void managerTest(){
        System.out.println();
        boolean passedAll = true;
        Manager test = new Manager(1000);
        System.out.println("Testing Class: Manager");
        test.addCharge(new Charge("Cat Food", 20.00, 426, "Pet"));
        if(test.size() == 1){
            System.out.println("Successfully added charge, passed");
        } else {
            System.out.println("Failed to add charge, FAILED");
            passedAll = false;
        }
        test.addCharge(new Charge("AC", 500.00, 1225, "Goods"));
        test.addCharge(new Charge("Snacks", 5.00, 102, "Food"));
        test.addCharge(new Charge("Clothes", 30.00, 311, "Goods"));
        if(test.calculateBalance() == 445.00){
            System.out.println("CalculateBalance returns correct amount, passed");
        } else {
            System.out.println("Wrong amount returned for calculateBalance, FAILED");
            passedAll = false;
        }
        test.sortCharges();
        boolean sorted = true;
        ArrayList<Charge> testArray = test.getCharges();
        for(int i = 0; i < test.size() - 1; i++){
            if(testArray.get(i).getDate() > testArray.get(i+1).getDate()){
                sorted = false;
            }
        }
        if(sorted == true){
            System.out.println("Sorted charges correctly, passed");
        } else{
            System.out.println("Incorrectly sorted charges, FAILED");
            passedAll = false;
        }
        if(test.findChargeOnDate(1225, test.size(), 0).getDate() == testArray.get(3).getDate()){
            System.out.println("Found correct charge in search, passed");
        } else {
            System.out.println("Incorrect charge returned after search, failed");
            passedAll = false;
        }
        test.newDeposit(100);
        if (test.calculateBalance() == 545.00) {
            System.out.println("Deposit added correctly, passed");
        } else {
            System.out.println("Deposit added incorrectly, failed");
            passedAll = false;
        }
        test.cashWithdrawal(50);
        if(test.calculateBalance() == 495.00){
            System.out.println("Withdrawal decreased correctly, passed");
        } else {
            System.out.println("Didn't decrease balance correctly, FAILED");
            passedAll = false;
        }
        if(passedAll){
            System.out.println("Manager passed all tests!");
        }
    }
    public static void savingsTest(){
        System.out.println();
        boolean passedAll = true;
        System.out.println("Testing Class: Savings");
        Savings test = new Savings(10000, "testSave");
        if(test.getAccountBalance() == 10000.00){
            System.out.println("getAccountBalance returns the correct account balance, passed");
        } else {
            System.out.println("Wrong account balance, FAILED");
            passedAll = false;
        }
        test.makeDeposit(100);
        if(test.getAccountBalance() == 10100.00){
            System.out.println("Correct account balance returned after deposit, passed");
        } else {
            System.out.println("Wrong account balance after attempted deposit, FAILED");
            passedAll = false;
        }
        double testTransfer = test.transfer(100.00);
        if(testTransfer == 100.00 && test.getAccountBalance() == 10000.00){
            System.out.println("Transfer works correctly, gave correct amount and correct balance after calling, passed");
        } else {
            System.out.println("Transfer worked incorrectly, FAILED");
            passedAll = false;
        }
        if(passedAll){
            System.out.println("Savings passed all tests!");
        }
    }
    public static void adviserTest(){
        System.out.println();
        boolean passedAll = true;
        Adviser<Bill> test = new Adviser<>(10000, 2500);
        System.out.println("Testing Adviser with the Generic type, Bill");
        test.addBill(new Bill("testBill", 100.00, 208, 31));
        ArrayList<Bill> testArray = test.returnArray();
        if(testArray.size() == 1 && testArray.get(0).getName() == "testBill"){
            System.out.println("Successfully added bill to the arrayList, passed");
        } else {
            System.out.println("Incorrectly added bill, FAILED");
            passedAll = false;
        }
        test.addBill(new Bill("testBill2", 150.00, 311, 31));
        test.addBill(new Bill("testBill3", 200.00, 911, 31));
        if(test.spendingMoney(12) == 34600.00){
            System.out.println("Spending money returns calculated amount, passed");
        } else {
            System.out.println("Wrong calculation for spending money, FAILED");
            passedAll = false;
        }
        if(test.budget() == 2050){
            System.out.println("Correct budget returned, passed");
        } else {
            System.out.println("Wrong calculation for budget, FAILED");
            passedAll = false;
        }
        if(test.total() == 450.00){
            System.out.println("Correct added up monthly total, passed");
        } else {
            System.out.println("Incorrect calculation for total, FAILED");
            passedAll = false;
        }
        System.out.println("Testing Adviser with the Generic type, Charge");
        Adviser<Charge> testB = new Adviser<>(10000, 2500);
        testB.addBill(new Charge("testCharge", 100.00, 311, "charge"));
        ArrayList<Charge> testArrayB = testB.returnArray();
        if(testArrayB.size() == 1 && testArrayB.get(0).getName() == "testCharge"){
            System.out.println("Successfully added bill to the arrayList, passed");
        } else {
            System.out.println("Incorrectly added bill, FAILED");
            passedAll = false;
        }
        testB.addBill(new Charge("testCharge2", 150.00, 208, "charge"));
        testB.addBill(new Charge("testCharge2", 200.00, 208, "charge"));
        if(testB.spendingMoney(12) == 34600.00){
            System.out.println("Spending money returns calculated amount, passed");
        } else {
            System.out.println("Wrong calculation for spending money, FAILED");
            passedAll = false;
        }
        if(testB.budget() == 2050){
            System.out.println("Correct budget returned, passed");
        } else {
            System.out.println("Wrong calculation for budget, FAILED");
            passedAll = false;
        }
        if(testB.total() == 450.00){
            System.out.println("Correct added up monthly total, passed");
        } else {
            System.out.println("Incorrect calculation for total, FAILED");
            passedAll = false;
        }
        if(passedAll){
            System.out.println("Adviser passed all tests!");
        }
    }
    public static void checkingTest(){
        boolean passedAll = true;
        System.out.println();
        Checking test = new Checking(10000, "testCheck");
        System.out.println("Testing Class: Checking");
        if(test.getAccountBalance() == 10000.00){
            System.out.println("getAccountBalance returns the correct account balance, passed");
        } else {
            System.out.println("Wrong account balance, FAILED");
            passedAll = false;
        }
        test.makeDeposit(100);
        if(test.getAccountBalance() == 10100.00){
            System.out.println("Correct account balance returned after deposit, passed");
        } else {
            System.out.println("Wrong account balance after attempted deposit, FAILED");
            passedAll = false;
        }
        double testTransfer = test.transfer(100.00);
        if(testTransfer == 100.00 && test.getAccountBalance() == 10000.00){
            System.out.println("Transfer works correctly, gave correct amount and correct balance after calling, passed");
        } else {
            System.out.println("Transfer worked incorrectly, FAILED");
            passedAll = false;
        }
        test.chargeAcc(new Charge("testCharge", 100.00, 308, "charge"));
        ArrayList<Charge> testCharges = test.returnAccountCharges();
        if(testCharges.size() == 1 && testCharges.get(0).getName() == "testCharge"){
            System.out.println("Correctly added charge to checking account, passed");
        } else {
            System.out.println("Failed in adding charge to account, FAILED");
            passedAll = false;
        }
        test.chargeAcc(new Charge("testCharge2", 400.00, 426, "charge"));
        test.chargeAcc(new Charge("testCharge3", 200.00, 102, "charge"));
        if(test.getAccountBalance() == 9300.00){
            System.out.println("Successfully charged account, passed");
        } else {
            System.out.println("Didn't charge account properly, FAILED");
            passedAll = false;
        }
        if(test.findCharge(102).getName() == "testCharge3"){
            System.out.println("Successfully found charge, passed");
        } else {
            System.out.println("Wrong charge found, FAILED");
            passedAll = false;
        }
        if(passedAll){
            System.out.println("Checking passed all tests!");
        }
    }
    public static void printChargeTest(){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream output = new PrintStream(baos);
        System.setOut(output);
        String expectedPrintedCharges = "Charge on: 208 testingPrint for: $100.0\nCharge on: 317 testingPrint2 for: $200.0\n";
        expectedPrintedCharges = expectedPrintedCharges + "Charge on: 426 testingPrint3 for: $300.17\n";

        Manager testManager = new Manager(1000);
        testManager.addCharge(new Charge("testingPrint2", 200, 317, "charge"));
        testManager.addCharge(new Charge("testingPrint", 100, 208, "charge"));
        testManager.addCharge(new Charge("testingPrint3", 300.17, 426, "charge"));
        testManager.printCharges();
        String actualPrinted = baos.toString();
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        if(actualPrinted.compareTo(expectedPrintedCharges) == 0){
            System.out.println("Correct string was printed from Manager printCharges(), passed");
        } else {
            System.out.println("Incorrect strings printed in Manager printCharges(), FAILED");
            System.out.print("Expected String:\n" + expectedPrintedCharges);
            System.out.print("Returned String:\n" + actualPrinted);
        }
    }
    public static void showHistoryTestSavings(){
        System.out.println();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream output = new PrintStream(baos);
        System.setOut(output);
        String expectedOutput = "Added $100.0 to test\nAdded $200.0 to test\n";
        expectedOutput += "Showing Deposit History for Savings: test\nOldest to Newest\n";
        expectedOutput += "Initial Deposit: $1000.0\n";
        expectedOutput += "Deposit 1: $100.0\nDeposit 2: $200.0\n";
        Savings test = new Savings(1000, "test");
        test.makeDeposit(100);
        test.makeDeposit(200);
        test.showHistory();
        String actual = baos.toString();
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        if(actual.compareTo(expectedOutput) == 0){
            System.out.println("Correct Strings returned for ShowHistory, passed");
        } else {
            System.out.println("Wrong outputted strings, FAILED");
            System.out.print("Expected Strings:\n" + expectedOutput);
            System.out.print("Returned Strings\n" + actual);
        }
        baos.reset();
        System.setOut(output);
        expectedOutput = "Showing and Wiping Deposit History for Savings: test\n";
        expectedOutput += "Oldest to Newest\n";
        expectedOutput += "Initial Deposit: $1000.0\n";
        expectedOutput += "Deposit 1: $100.0\nDeposit 2: $200.0\n";
        expectedOutput += "History Wiped, Fresh Start\n";
        test.showAndWipeHistory();
        actual = baos.toString();
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        if(actual.compareTo(expectedOutput) == 0){
            System.out.println("Correct Strings returned for ShowAndWipeHistory, passed");
        } else {
            System.out.println("Wrong outputted strings, FAILED");
            System.out.print("Expected Strings:\n" + expectedOutput);
            System.out.print("Returned Strings\n" + actual);
        }
        test.showHistory();
    }
    public static void showHistoryTestChecking(){
        System.out.println();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream output = new PrintStream(baos);
        System.setOut(output);
        String expectedOutput = "Added $100.0 to test\nAdded $200.0 to test\n";
        expectedOutput += "Showing Deposit History for Checking: test\nOldest to Newest\n";
        expectedOutput += "Initial Deposit: $1000.0\n";
        expectedOutput += "Deposit 1: $100.0\nDeposit 2: $200.0\n";
        expectedOutput += "Charges on your account:\n";
        expectedOutput += "Charge on: 208 testingPrint for: $100.0\nCharge on: 317 testingPrint2 for: $200.0\n";
        expectedOutput += "Charge on: 426 testingPrint3 for: $300.17\n";
        Checking test = new Checking(1000, "test");
        test.makeDeposit(100);
        test.makeDeposit(200);
        test.chargeAcc(new Charge("testingPrint", 100.00, 208, "charge"));
        test.chargeAcc(new Charge("testingPrint2", 200.00, 317, "charge"));
        test.chargeAcc(new Charge("testingPrint3", 300.17, 426, "charge"));
        test.showHistory();
        String actual = baos.toString();
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        if(actual.compareTo(expectedOutput) == 0){
            System.out.println("Correct Strings returned for ShowHistory, passed");
        } else {
            System.out.println("Wrong outputted strings, FAILED");
            System.out.print("Expected Strings:\n" + expectedOutput);
            System.out.print("Returned Strings\n" + actual);
        }
        test.showAndWipeHistory();
        test.showHistory();
    }
}
