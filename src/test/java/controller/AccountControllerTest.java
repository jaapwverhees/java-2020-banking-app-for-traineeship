package controller;

import models.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AccountControllerTest {
    AccountController controller;

    @BeforeEach
    void setUp() {
        Account account = new Account(1, 2000.00, 2);
        Account account2 = new Account(2, 2000.00, 2);
        ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(account);
        accounts.add(account2);
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
        Assertions.assertNotNull(controller.checkValidNumber(1));
    }


    @Test
    void checkifInValidNumber() {
        Assertions.assertNull(controller.checkValidNumber(2));
    }

    @Test
    void updateBalanceFail() {
        Throwable exception = assertThrows(Exception.class, () -> controller.updateBalance(1, -3000));
        Assertions.assertEquals("Cant Allow Negative result", exception.getMessage());


    }

    @Test
    void updateBalance() {
        try {
            assertEquals(2200.00, controller.updateBalance(1, 200));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    void calculateIntrestOneYear() {
        double test = 0.00;
        try {
            test = controller.calculateIntrestOneYear(1);
        } catch (Exception e) {
            fail();
        }
        assertEquals(40, test);
    }

    @Test
    void tranferFundsSuccesfull() {
        try {
            controller.TranferFunds(1, 2, 200);
        } catch (Exception e) {
            fail();
        }
        double amount = 0;
        try {
            amount = controller.getBalanceAccount(2);
        } catch (Exception e) {
            fail();
        }

        assertEquals(2200.00, amount);

        amount = 0;
        try {
            amount = controller.getBalanceAccount(1);
        } catch (Exception e) {
            fail();
        }
        assertEquals(amount, 1800.00);
    }
}