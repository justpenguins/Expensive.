package persistence;

import model.Expense;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ReaderTest extends testJson{

    @Test
    public void fileNoExist() {
        Reader reader = new Reader("./data/fileNoExist.json");
        try {
            boatyMcBoatface = reader.read();
            fail("IOException was supposed to be thrown.");
        } catch (IOException e) {
            //expected
        }
    }

    @Test
    public void yesExistButEmptyFile() {
        Reader reader = new Reader("./data/yesExistButEmptyFile.json");
        try {
            boatyMcBoatface = reader.read();
            assertEquals("Boaty McBoatFace", boatyMcBoatface.getAcctName());
            assertEquals(0, boatyMcBoatface.length());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void yesExistsYesStuffInside() {
        Reader reader = new Reader("./data/yesExistsYesStuffInside.json");
        try {
            boatyMcBoatface = reader.read();
            assertEquals("Boaty McBoatFace", boatyMcBoatface.getAcctName());
            List<Expense> expenses = boatyMcBoatface.showExpenses();
            assertEquals(2, boatyMcBoatface.length());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

}
