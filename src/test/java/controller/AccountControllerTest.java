package controller;

import models.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AccountControllerTest {
    AccountController controller;

    @BeforeEach
    void setUp() {
        Account account = new Account(1, 2000.00, 2);
        ArrayList<Account> accounts = new ArrayList();
        accounts.add(account);
        controller = new AccountController(accounts);
    }

    @Test
    void getBalanceAccount() {
        double output = 0;
        try {
            output = controller.getBalanceAccount(1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Assertions.assertEquals(2000.00, output);
    }

    @Test
    void checkValidNumber() {
        Assertions.assertEquals(true, controller.checkValidNumber(1) instanceof Account);
    }


    @Test
    void checkifInValidNumber() {
        Assertions.assertEquals(null, controller.checkValidNumber(2));
    }

    @Test
    void updateBalanceFail() {
        Throwable exception = assertThrows(Exception.class,() -> controller.updateBalance(1,-3000));
        Assertions.assertEquals("Cant Allow Negative result", exception.getMessage());


    }

    @Test
    void updateBalance() {
        try {
            assertEquals(2200.00, controller.updateBalance(1, 200));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    void calculateIntrestOneYear() {
    }
}