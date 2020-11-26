package BankAccount;

public class BankAccount {
    private final static double DEFALUTY_RATE = 0.02;
    private static double interstRate= DEFALUTY_RATE;

    private static int countId = 1;
    private int id;
    private double balance;


    BankAccount() {
        this.id = countId++;
    }

    public int getId() {
        return id;
    }

    static void setInterestRate(double interestRate) {
        BankAccount.interstRate = interestRate;
    }

    void deposit(double deposit) {
        this.balance +=deposit;
    }

    double getInterest(int years) {
        return BankAccount.interstRate*years*this.balance;
    }

}
