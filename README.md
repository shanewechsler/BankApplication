# BankApplication
Shane Wechsler
823526399
05/14/2020
Banking Application is intended to create accounts, and manage them using charges, withdrawals, and deposits. Holds your current balance for each and can transfer money into each. Includes a rudimentary financial adviser that gives you a monthy budget, and estimated spending money in a given time frame.
Withdrawal: abstract class, basis of both Bill and Charge
Charge: Holds an amount, name, date, and category for each intended to charge the balance of a checking account
Bill: Simular to Charge, Bill has an amount, name, date but user can choose how often the bill is charged, and if the user sets up a time system can take the money out automatically after a certain number of days passed. Used primarly in Adviser for this project
Manager: Holds a List of Charges, and your account balance. Primarily intended to handle the List of Charges. Can sort, and search the list. Gives estimated income for a time frame. Able to calculate your current balance using the given charges. Prints all charges given. Can add money through a deposit, and can take money out through cash withdrawal no charge needed.
Account: Interface that sets the necessary methods in both Savings and Checking. Allows them to implement them as they want
Savings: Account that does not carry charges, able to transfer money out and deposit money to account. Holds its current balance. Uses Manager to accomplish tasks. Can show and wipe deposit history. 
Checking: Simular to savings, but holds charges. The charges added effects the balance, aswell as being able to transfer and create deposits. Holds the current balance after deposits, withdrawals, and charges. Shows and wipes history with an added printCharges() from manager. Also uses Manager to accomplish tasks
Adviser: Generic class that can use either Charges or Bills, to calculate your monthly budget after Charges/Bills, your spending money in a given time frame after Charges/Bills. Asks for a set income to aid budget, and uses manager to accomplish tasks.
