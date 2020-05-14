/**
 *  Final Project
 *  Creates the base methods that Savings and Checking will implement in their own way
 *  CS108-4
 *  5/08/20
 *  @author  Shane Wechsler 823526399
 */

public interface Account {
    public double getAccountBalance();
    public void makeDeposit(double amount);
    public void showHistory();
    public void showAndWipeHistory();
    public double transfer(double amount);
}
