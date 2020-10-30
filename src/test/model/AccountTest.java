package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class AccountTest extends TestInfo{
        private Account testAccount;

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
            // show one
            assertEquals(testAccount.length(), 0);
            testAccount.addExpense(testExp2);
            assertEquals(testAccount.showExpenses().get(0),testExp2);


            // show many
            for (int i = 0; i < 100; i++) {
                testAccount.addExpense(testExp3);
            }

            for (int i = 0; i < testAccount.length(); i++) {
                assertEquals(testAccount.showExpenses().get(1), testExp3);
            }

        }

        @Test
        public void testFindExpense() {
            testAccount.addExpense(testExp3);
            testAccount.addExpense(testExp1);
            testAccount.addExpense(testExp3);
            testAccount.addExpense(testExp2);

            assertEquals(testAccount.findExpense(2), testExp2);
            assertNull(testAccount.findExpense(6));
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


