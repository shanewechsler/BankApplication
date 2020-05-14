/**
 *  Final Project
 *  Savings, cannot add charges and holds deposits and the balance, can transfer out of savings to a checking(preferred)
 *  CS108-4
 *  5/08/20
 *  @author  Shane Wechsler 823526399
 */

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.PriorityQueue;

public class Savings implements Account {
    private Manager savingsManager; //manager to handle the balance of savings and withdrawals/deposits
    private String name;
    private PriorityQueue<Double> depositHistory; //keeps the history of all deposits made on account
    private double initDep; //initial deposit

    public Savings(double initialDeposit, String name){
        this.name = name;
        initDep = initialDeposit;
        savingsManager = new Manager(initialDeposit); //creates manager with the given initDep
        depositHistory = new PriorityQueue<>();
    }

    public Savings(){ //default, sets default balance and name
        name = "Savings";
        savingsManager = new Manager(100.00);
        depositHistory = new PriorityQueue<>();
    }

    @Override
    public double getAccountBalance() {
        return savingsManager.calculateBalance();
    }

    @Override
    public void makeDeposit(double amount){
        System.out.println("Added $" + amount + " to " + name);
        savingsManager.newDeposit(amount); //calls manager to manage balance
        depositHistory.add(amount); //adds the deposit to the history
    }

    @Override
    public void showAndWipeHistory(){
        System.out.println("Showing and Wiping Deposit History for Savings: " + name);
        System.out.println("Oldest to Newest");
        System.out.println("Initial Deposit: $" + initDep);
        int initSize = depositHistory.size();
        for(int i = 0; i < initSize; i++){
            //Shows each deposit, but pops the Queue each time to wipe dep history
            System.out.println("Deposit " + (i + 1) + ": $" +  depositHistory.poll());
        }
        initDep = savingsManager.calculateBalance();
        System.out.println("History Wiped, Fresh Start");
    }

    @Override
    public void showHistory(){
        System.out.println("Showing Deposit History for Savings: " + name);
        System.out.println("Oldest to Newest");
        System.out.println("Initial Deposit: $" + initDep);
        int i = 0;
        //If no deposits are found/dep history is empty
        if (depositHistory.size() == 0){
            System.out.println("No Deposit History on Record!");
        }
        //uses enhanced for loop to show the history, but not remove it
        for(Double dep: depositHistory){
            i++;
            System.out.println("Deposit " + i + ": $" + dep);
        }
    }

    //takes money out of account, and returns the amount to be given to another account or entity
    public double transfer(double amount){
        savingsManager.cashWithdrawal(amount);
        return amount;
    }
}
