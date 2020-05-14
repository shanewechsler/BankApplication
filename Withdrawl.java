/**
 *  Final Project
 *  Parent class of Bill and Charge, sets necessary methods needed
 *  CS108-4
 *  5/08/20
 *  @author  Shane Wechsler 823526399
 */

public abstract class Withdrawl{
    private String name; //basic fields held by child classes
    private double amount;
    private int date;

    public Withdrawl(String name, double amount, int date){
        this.name = name;
        this.amount = amount;
        this.date = date;
    }

    public String getName(){
        return name;
    }

    public int getDate(){
        return date;
    }

    public double getAmount(){
        return amount;
    }

}
