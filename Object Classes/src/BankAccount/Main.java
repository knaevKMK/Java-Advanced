package BankAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<BankAccount> accounts = new ArrayList<>();
        String read;
        while (!"End".equals(read = scanner.nextLine())) {
            String[] token = read.split("\\s");
            int id = 0;
            if (token.length > 1 && !token[0].equals("SetInterest")) {
                id = Integer.parseInt(token[1]);
                if (id > accounts.size()) {
                    System.out.println("Account does not exist");
                    continue;
                }
            }
            switch (token[0]) {
                case "Create":
                    BankAccount account = new BankAccount();
                    sout(String.format("Account ID%d created", account.getId()));
                    accounts.add(account);
                    break;
                case "Deposit":
                    account = accounts.get(id - 1);
                    double balance = Double.parseDouble(token[2]);
                    account.deposit(balance);
                    accounts.set(id - 1, account);
                    sout( "Deposited " + token[2] + " to ID" + token[1]);
                    break;
                case "SetInterest":
                    double interestRate = Double.parseDouble(token[1]);
                    BankAccount.setInterestRate(interestRate);
                    break;
                case "GetInterest":
                    account = accounts.get(id - 1);
                    int year = Integer.parseInt(token[2]);
                   sout(String.format("%.2f",account.getInterest(year)));
                    break;
            }

        }
    }

    private static void sout(String s) {
        System.out.println(s);
    }
}
