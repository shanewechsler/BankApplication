/**
 *  Final Project
 *  Advises the user on the budget/spending money on a given time period
 *  CS108-4
 *  5/08/20
 *  @author  Shane Wechsler 823526399
 */

import java.util.ArrayList;

//Adviser can use both charges or bills to give you budget and spending money, if your charges are consistent each month
public class Adviser<T extends Withdrawl> {
    private Manager adManager; //uses manager to calculate your total income and balance
    private ArrayList<T> bills; //Creates a List of either charges or bills
    private double income;

    public Adviser(double currentAccountB, double income){ //given your current account balance and set income
        adManager = new Manager(currentAccountB, income);
        bills = new ArrayList<>();
        this.income = income;
    }

    public void addBill(T bill){
        bills.add(bill);
    } //this adds a charge or bill to the List

    public double spendingMoney(int months){
        double billTotal = months*total(); //takes your monthly total and multiplies it for the given months
        //Takes your total income for the amount of months and adds it to the original balance
        double totIncome = adManager.calculateIncomeAfterMonths(months) + adManager.calculateBalance();
        System.out.println("Your spending money for " + months + " is $" + (totIncome - billTotal));
        return totIncome - billTotal; //returns spending money you have for given months
    }

    //Same as spending money, but for each month, ignores init balance
    public double budget(){
        System.out.println("Your spending money budget for each month is: " + (income - total()));
        return income - total();
    }

    //Adds all the amounts in your Charges/Bills to give you monthly total
    public double total(){
        double billTotal = 0;
        for(T current: bills){ //Uses the generic type safely to call their shared method
            billTotal += current.getAmount();
        }
        return billTotal;
    }

    public ArrayList<T> returnArray(){
        return bills;
    } //returns the List of type Charge or Bill
}
