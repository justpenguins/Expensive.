package persistence;

import model.Account;
import model.Expense;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

// Source: JsonSerialization Demo, JsonReaderTest class
public class ReaderTest extends TestJson{

    @Test
    public void readerFileNoExist() {
        Reader reader = new Reader("./data/readerFileNoExist.json");
        try {
            Account account = reader.read();
            fail("IOException was supposed to be thrown.");
        } catch (IOException e) {
            //expected
        }
    }

    @Test
    void readerYesExistsTestEmpty() {
        Reader reader = new Reader("./data/readerYesExistsTestEmpty.json");
        try {
            tA = reader.read();
            tA.addExpense(testExp3);
            tA.addExpense(exoExpense);
            assertEquals("Sleep", tA.getAcctName());
            assertEquals(2, tA.length());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void readerYesExistsNotEmpty() {
        Reader reader = new Reader("./data/readerYesExistsNotEmpty.json");
        try {
            Account tA = reader.read();
            assertEquals("Sleep", tA.getAcctName());
            List<Expense> exps = tA.showExpenses();
            assertEquals(0, exps.size());
            testAccount("Sleep",tA);
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

}
