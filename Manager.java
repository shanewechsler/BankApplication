/**
 *  Final Project
 *  Holds charges, and handles everything involved with sorting, searching, and printing the charges added.
 *  CS108-4
 *  5/08/20
 *  @author  Shane Wechsler 823526399
 */

import java.util.ArrayList;

public class Manager {
    private ArrayList<Charge> record; //holds all charges added
    private double accountBalance; //current account balance without being charged
    double monthlyIncome; //set income every 31 days

    public Manager(double initDeposit){ //without set income, can still make deposits.
        record = new ArrayList<>();
        accountBalance = initDeposit;
    }

    public Manager(double initDeposit, double monthlyIncome){
        record = new ArrayList<>();
        accountBalance = initDeposit;
        this.monthlyIncome = monthlyIncome;
    }

    public void addCharge(Charge newCharge){
        record.add(newCharge);
    }

    //Prints the charges in the List in a set format
    public void printCharges(){
        sortCharges();
        for(int i = 0; i < record.size(); i++){
            int currentDate = record.get(i).getDate();
            String currentName = record.get(i).getName();
            double amount = record.get(i).getAmount();
            System.out.println("Charge on: " + currentDate + " " + currentName + " for: $" + amount);
        }
    }

    //takes accountBalance and charges it with the Charges in the List
    public double calculateBalance(){
        double currentBalance = accountBalance;
        for(int i = 0; i < record.size(); i++){
            currentBalance -= record.get(i).getAmount();
        }
        return currentBalance;
    }

    //sorts charges by date
    public void sortCharges(){
        int smallestIndex;
        Charge temp; //temporary Charge aids in swap
        for(int i = 0; i < record.size() - 1; i++){
            int smaller = i;//in case no change, sets both to i
            smallestIndex = i;
            for(int j = i + 1; j < record.size(); j++){
                if(record.get(j).getDate() < record.get(smaller).getDate()){
                    smallestIndex = j; //if j is less than the tested index, sets this index to be tested next
                    smaller = smallestIndex;
                }
            }
            temp = record.get(smallestIndex); //swaps smallest found index compared to i with the outer index i
            record.set(smallestIndex, record.get(i));
            record.set(i, temp);
        }
    }

    public double calculateIncomeAfterMonths(int months){ //uses recursion to calculate your total income after months
        double totalIncomeAfterMonths = monthlyIncome;
        if(months == 1){ //bases case 1, just returns monthlyIncome
            return monthlyIncome;
        }
        else{
            //Calls itself if not base case, decreases months and returns the total income after addition
            //returns to the previous call or outside entity
            totalIncomeAfterMonths += calculateIncomeAfterMonths(months - 1);
            return totalIncomeAfterMonths;
        }
    }

    //Uses binary search to find a charge at a certain date
    public Charge findChargeOnDate(int date, int high, int low){
        sortCharges(); //makes sure the ArrayList is sorted
        int midIndex = (high + low)/2; //sets the mid index in the middle of the give high and low
        if(date == record.get(midIndex).getDate()){
            System.out.println("Charge Found: " + date + " " + record.get(midIndex).getName());
            return record.get(midIndex); //returns the found charge if there is one
        } else if(date > record.get(midIndex).getDate()){
            return findChargeOnDate(date, high, midIndex + 1); //if the charge date is higher sets the low to the mid to
            //search the upper bound
        } else if(date < record.get(midIndex).getDate()){
            return findChargeOnDate(date, midIndex, low);
            //if charge date is lower, sets search to the lower bound
        }
        System.out.println("Charge Not Found, returning null");
        return null; //returns null if the desired date is not found
    }

    //adds a given amount to the base balance
    public void newDeposit(double add){
        accountBalance += add;
    }

    //removes a given amount from the base balance
    public void cashWithdrawal(double sub){
        accountBalance -= sub;
    }

    //Returns the size of the List
    public int size(){
        return record.size();
    }

    //returns the List
    public ArrayList<Charge> getCharges(){
        return record;
    }
//    public Charge[] chargesOnDate(int date){
//        sortCharges();
//
//    }
}
