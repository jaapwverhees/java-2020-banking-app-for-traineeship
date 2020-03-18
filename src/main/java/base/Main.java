package base;

import controller.AccountController;
import models.Account;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Account account = new Account(1, 2000.00f, 2.2f);
        ArrayList<Account> array = new ArrayList<Account>();
        array.add(account);
        AccountController controller = new AccountController(array);

        System.out.println("id?");

        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        System.out.println("update?");
        double update = Double.parseDouble(scanner.next());
        try {
            System.out.println(controller.updateBalance(id, update));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(account.toString());
    }
}
