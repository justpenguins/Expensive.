package persistence;

import model.Account;
import model.Expense;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

// Source: JsonSerialization Demo, JsonReaderTest class
public class ReaderTest extends testJson{

    @Test
    public void readerFileNoExist() {
        Reader reader = new Reader("./data/readerFileNoExist.json");
        try {
            account = reader.read();
            fail("IOException was supposed to be thrown.");
        } catch (IOException e) {
            //expected
        }
    }

    @Test
    void readerYesExistsTesEmpty() {
        Reader reader = new Reader("./data/readerYesExistsTesEmpty.json");
        try {
            Account account = reader.read();
            assertEquals("Sheesh", account.getAcctName());
            assertEquals(0, account.length());
        } catch (IOException e) {
            //fail("Couldn't read from file");
        }
    }

    @Test
    void readerYesExistsNotEmpty() {
        Reader reader = new Reader("./data/readerYesExistsNotEmpty.json");
        try {
            Account account = reader.read();
            assertEquals("sleep", account.getAcctName());
            List<Expense> exps = account.showExpenses();
            assertEquals(2, exps.size());
            testAccount("sleep",account);
        } catch (IOException e) {
            //fail("Couldn't read from file");
        }
    }

}
