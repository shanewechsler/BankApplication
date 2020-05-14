public class TestApp {
    public static void main(String[] args){
//        double balance = 1000.00;
//        Bill electric = new Bill("electric",50.00, 426, 31);
//        Manager testM = new Manager(100000.00, 100.00);
//        Charge first = new Charge("Burritos", 1000.00, 426, "Food");
//        testM.addCharge(first);
//        testM.addCharge(new Charge("Dog", 90.00, 530, "Pets"));
//        testM.addCharge(new Charge("TV", 900.00, 509, "Goods"));
//        testM.printCharges();
//        System.out.println(testM.calculateBalance());
//        testM.calculateBalance();
//        testM.sortCharges();
//        testM.printCharges();
//        System.out.println(testM.calculateIncomeAfterMonths(12));
//        Savings savings = new Savings(100.00, "Test");
//        savings.makeDeposit(100.00);
//        savings.makeDeposit(400.00);
//        savings.makeDeposit(600.00);
//        System.out.println(savings.getAccountBalance());
//        savings.showHistory();
//        savings.showAndWipeHistory();
//        savings.showHistory();
        Checking checking = new Checking(1000.00, "Test");
        checking.makeDeposit(100);
        checking.makeDeposit(200);
        checking.makeDeposit(300);
        checking.chargeAcc(new Charge("Cat Food", 20.00, 426, "Pet"));
        checking.chargeAcc(new Charge("AC", 500.00, 220, "Goods"));
        checking.chargeAcc(new Charge("Shells", 13.50, 310, "Pet"));
        checking.chargeAcc(new Charge("Dog food", 20.00, 128, "Pet"));
        checking.chargeAcc(new Charge("Xbox", 500.00, 402, "Goods"));
        checking.chargeAcc(new Charge("Water", 13.50, 911, "Pet"));
        checking.chargeAcc(new Charge("test", 300.00, 102, "AHHHHHH"));
        System.out.println(checking.findCharge(911));
        Manager newT = new Manager(1000.00);
        newT.addCharge(checking.findCharge(310));
        newT.addCharge(checking.findCharge(911));
        newT.addCharge(checking.findCharge(402));
        newT.printCharges();
        System.out.println("$" + checking.getAccountBalance());
        checking.showHistory();
        checking.showAndWipeHistory();
        checking.showHistory();
    }
}
