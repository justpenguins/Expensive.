package persistence;

import model.Account;
import model.Expense;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

// Source: JsonSerialization Demo, JsonWriterTest class
public class WriterTest extends TestJson{

    @Test
    void fileNoGood() {
        try {
            Account account = new Account("Boaty1");
            Writer writer = new Writer("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void writeAllGoodButEmpty() {
        try {
            Account account = new Account("Empty");
            Writer writer = new Writer("./data/writeAllGoodButEmpty.json");
            writer.open();
            writer.write(account);
            writer.close();

            Reader reader = new Reader("./data/writeAllGoodButEmpty.json");
            account = reader.read();
            assertEquals("Empty", account.getAcctName());
            assertEquals(0, account.length());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void writeWorksNormallyHopefully() {
        try {
            Account account = new Account("Sheesh doing this at 4am is not fun");
            account.addExpense(testExp3);
            account.addExpense(exoExpense);
            Writer writer = new Writer("./data/writeWorksNormallyHopefully.json");
            writer.open();
            writer.write(account);
            writer.close();

            Reader reader = new Reader("./data/writeWorksNormallyHopefully.json");
            account = reader.read();
            assertEquals("Sheesh doing this at 4am is not fun", account.getAcctName());
            List<Expense> exps = account.showExpenses();
            assertEquals(2, exps.size());
            testAccount("Sheesh doing this at 4am is not fun", account);

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
