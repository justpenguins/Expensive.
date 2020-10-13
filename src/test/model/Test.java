package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    private Account testAccount;

    Expense testExp1 = new Expense(15.75, 1, "13/09/2020", "Surrey", "Bubble Tea");
    Expense testExp2 = new Expense(1375.99, 2,"02/10/2020", "Richmond", "Sus birthday gift");
    Expense testExp3 = new Expense(9.00, 3,"25/05/2008", "Seoul", "SHINee debut album");

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


    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (obj.getClass() != this.getClass()) return false;


        return super.equals(obj);
    }

    @Test
    public void testShowExp() {
        // show one
        assertEquals(testAccount.length(), 0);
        testAccount.addExpense(testExp2);
        for (int i = 0; i < testAccount.length(); i++) {
            assertTrue(testAccount.showExpenses().equals(testExp2));
        }

        // show many
        for (int i = 0; i < 100; i++) {
            testAccount.addExpense(testExp3);
        }

        for (int i = 0; i < 100; i++) {
            assertTrue(testAccount.showExpenses().equals(testExp3));
        }

    }

    @Test
    public void testFindExpense() {
        testAccount.addExpense(testExp3);
        testAccount.addExpense(testExp1);
        testAccount.addExpense(testExp3);
        testAccount.addExpense(testExp2);

        assertEquals(testAccount.findExpense(2), testExp2);
        assertEquals(testAccount.findExpense(6), null);
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

    Expense testExp1 = new Expense(15.75, 1,"13/09/2020", "Surrey", "Bubble Tea");
    Expense testExp2 = new Expense(1375.99,1,"01/01/2019", "Seattle", "Laptop");

    @Test
    public void testConstructor() {
        assertEquals(15.75, testExp1.getExpAmt());
        assertEquals("13/09/2020", testExp1.getExpDate());
        assertEquals("Surrey", testExp1.getExpLocation());
        assertEquals("Laptop", testExp2.getExpDesc());
        assertEquals(testExp1.getExpID(), 1);
    }

    @Test
    public void testGetExpAmt() {
        assertEquals(testExp2.getExpAmt(),15.75);
    }

    @Test
    public void testGetExpDate() {
        assertEquals(testExp1.getExpDate(), "13/09/2020");
    }

    @Test
    public void testGetExpLocation() {
        assertEquals(testExp2.getExpLocation(), "Seattle");
    }

    @Test
    public void testGetExpDesc() {
        assertEquals(testExp1.getExpDesc(), "Laptop");
    }

    @Test
    public void testGetExpId() {
        assertEquals(testExp2.getExpID(), 2);
    }

}