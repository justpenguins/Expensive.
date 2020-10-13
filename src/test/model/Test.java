package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    private Account testAccount;

    Expense testExp1 = new Expense(15.75, "13/09/2020", "Surrey", "Bubble Tea");
    Expense testExp2 = new Expense(1375.99, "02/10/2020", "Richmond", "Sus birthday gift");
    Expense testExp3 = new Expense(9.00, "25/05/2008", "Seoul", "SHINee debut album");

    @BeforeEach
    public void setUpAcct() {
        testAccount = new Account("David");
    }

    @Test
    public void testConstructor() {
        assertEquals( "David",testAccount.getAcctName());
        assertEquals(1, testAccount.getId());
    }

    @Test
    public void testAddExp() {
        assertEquals(0, testAccount.length());
        testAccount.addExpense(testExp1);
        assertEquals(1, testAccount.length());

    }

    @Test
    public void testManyAdd() {
        for (int i = 0; i < 250; i++) {
            testAccount.addExpense(testExp2);
        }
        assertEquals(250, testAccount.length());
    }

    @Test
    public void testRemoveExp() {
        testAccount.addExpense(testExp3);
        assertEquals(testAccount.length(), 1);
        testAccount.removeExpense(testExp3);
        assertEquals(testAccount.length(), 0);
    }

    @Test
    public void testManyRemove() {
        for (int i = 0; i < 143; i++) {
            testAccount.addExpense(testExp2);
        }
        assertEquals(143, testAccount.length());

        for (int i = 0; i < 143; i++) {
            testAccount.removeExpense(testExp2);
        }
        assertEquals(testAccount.length(), 0);
    }

    @Test
    public void testShowExp() {

    }

    @Test
    public void testGetAcctName() {
        assertEquals(testAccount.getAcctName(), "David");
    }

    @Test
    public void testGetId() {
        assertEquals(testAccount.getId(), 1);
    }
}

class ExpensesTest {

    Expense testExp1 = new Expense(15.75, "13/09/2020", "Surrey", "Bubble Tea");
    Expense testExp2 = new Expense(1375.99, "01/01/2019", "Seattle", "Laptop");

    @Test
    public void testConstructor() {
        assertEquals(15.75, testExp1.getExpAmt());
        assertEquals("13/09/2020", testExp1.getExpDate());
        assertEquals("Surrey", testExp1.getExpLocation());
        assertEquals("Laptop", testExp2.getExpDesc());
        assertEquals(testExp1.getExpID(), 1);
    }

}