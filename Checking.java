/**
 *  Final Project
 *  Checking can hold charges, and also deposits/withdrawals, uses manager to handle balance
 *  CS108-4
 *  5/08/20
 *  @author  Shane Wechsler 823526399
 */

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Checking implements Account {
    private Manager checkingManager;
    private String name;
    private PriorityQueue<Double> depositHistory;
    private double initDep;

    public Checking(double initialDeposit, String name){
        this.name = name;
        initDep = initialDeposit;
        checkingManager = new Manager(initialDeposit);
        depositHistory = new PriorityQueue<>();
    }

    public Checking(){
        name = "Checking";
        checkingManager = new Manager(0); //different from Savings, default balance for checking is 0
        depositHistory = new PriorityQueue<>();
    }

    @Override
    public double getAccountBalance() {
        return checkingManager.calculateBalance();
    }

    @Override
    public void makeDeposit(double amount){
        System.out.println("Added $" + amount + " to " + name);
        checkingManager.newDeposit(amount);
        depositHistory.add(amount);
    }

    @Override
    public void showHistory(){
        System.out.println("Showing Deposit History for Checking: " + name);
        System.out.println("Oldest to Newest");
        System.out.println("Initial Deposit: $" + initDep);
        int i = 0;
        if (depositHistory.size() == 0){
            System.out.println("No Deposit History on Record!");
        }
        for(Double dep: depositHistory){
            i++;
            System.out.println("Deposit " + i + ": $" + dep);
        }
        //Has same method as Savings, but also prints the charges found on the account, using the Manager
        System.out.println("Charges on your account:");
        checkingManager.sortCharges(); //sorts charges beforehand
        checkingManager.printCharges();
    }

    public void showAndWipeHistory(){
        System.out.println("Showing and Wiping Deposit History for Checking: " + name);
        System.out.println("Oldest to Newest");
        System.out.println("Initial Deposit: $" + initDep);
        int initSize = depositHistory.size();
        for(int i = 0; i < initSize; i++){
            System.out.println("Deposit " + (i + 1) + ": $" +  depositHistory.poll());
        }
        //Different from Savings, prints the charges found on your account before wipe
        System.out.println("Charges on your account before wipe:");
        checkingManager.printCharges();
        Manager newAccM = new Manager(checkingManager.calculateBalance()); //resets the manager in account after wipe
        checkingManager = newAccM;
    }

    //Same as savings, can transfer to Savings or to cash(checking)
    public double transfer(double amount){
        checkingManager.cashWithdrawal(amount);
        return amount;
    }

    //Uses manager to add a charge to your account
    public void chargeAcc(Charge charge){
        checkingManager.addCharge(charge);
    }

    //makes a call to the binary/recursive method findCharge on date
    public Charge findCharge(int date){
        return checkingManager.findChargeOnDate(date, checkingManager.size() - 1, 0);
    }

    //Returns the List in the Manager
    public ArrayList<Charge> returnAccountCharges(){
        return checkingManager.getCharges();
    }
}

