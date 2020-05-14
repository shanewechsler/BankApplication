/**
 *  Final Project
 *  Differs from charge, user can create time system that adds a "charge" of type bill every so amount of days
 *  CS108-4
 *  5/08/20
 *  @author  Shane Wechsler 823526399
 */

public class Bill extends Withdrawl {
    final private int timeInDays;
    private int daysLeft;

    public Bill(String name, double amount, int date, int days){
        super(name, amount, date); //calls Withdrawal constructor
        timeInDays = days; //does not change, set number of days each cycle
        daysLeft = days; //decreases as "days" goes on, by calling dayPassed()
    }

    @Override
    public double getAmount() {
        return super.getAmount();
    }

    @Override
    public String getName(){
        return super.getName();
    }

    @Override
    public int getDate(){
        return super.getDate();
    }

    public int getTimeInDays(){
        return timeInDays;
    }

    public int getDaysLeft(){return daysLeft;}

    //Used by dayPassed, to return a charge when the cycle is over, of a category "Bill"
    public Charge billCharge(){
        return new Charge(getName(), getAmount(), getDate(), "Bill");
    }

    //decreases daysLeft, and checks to see if cycle is over, if cycle is over returns the charge of type bill
    public Charge dayPassed(){
        daysLeft--;
        if(daysLeft == 0){
            daysLeft = timeInDays;
            return billCharge();
        }
        return null;
    }

}
