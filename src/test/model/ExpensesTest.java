package model;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


public class ExpensesTest extends TestInfo{


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
        assertEquals(testExp1.getExpAmt(),15.75);
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
        assertEquals(testExp1.getExpDesc(), "Bubble Tea");
    }

    @Test
    public void testGetExpId() {
        assertEquals(testExp2.getExpID(), 2);
    }

}