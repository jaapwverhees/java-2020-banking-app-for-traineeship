package models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AccountTest {

    Account account;

    @BeforeEach
    void setUp() {
        account = new Account(1, 2000.00, 2.2);
    }

    @Test
    void testToString() {
        Assertions.assertEquals("AccountNumber : 1 \nBalance : 2000.0 \nIntrestRate : 2,2", account.toString());
    }
}