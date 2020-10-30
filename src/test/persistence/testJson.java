package persistence;

import model.Account;
import model.Expense;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Source: JsonSerialization Demo, JsonTest class
public class testJson {
    protected Expense testExp3 = new Expense(9.00, 2008,"25/05/2008", "Seoul", "Replay: 1st Mini Album");
    protected Expense exoExpense = new Expense(30.99,2012, "08/04/2012","Seoul", "MAMA");

    protected Account tA = new Account("Sleep");

    protected void testAccount(String name, Account acct) {
        assertEquals(name,acct.getAcctName());
    }

}
