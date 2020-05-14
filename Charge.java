/**
 *  Final Project
 *  Same methods as Withdrawal, with added category
 *  CS108-4
 *  5/08/20
 *  @author  Shane Wechsler 823526399
 */

public class Charge extends Withdrawl{
    private String category;

    public Charge(String name, double amount, int date, String category) {
        super(name, amount, date); //calls constructor in Withdrawal
        this.category = category;
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

    public String getCategory(){
        return category;
    }

}
