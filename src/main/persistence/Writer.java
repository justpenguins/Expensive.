package persistence;

import model.Account;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

// Creates a writer to parse info from account into a JSON format
// Source: JsonSerialization demo, JsonWriter
public class Writer {
    private PrintWriter writer;
    private String writeTo;

    // EFFECTS: constructs writer to write to writeTo file
    public Writer(String writeTo) {
        this.writeTo = writeTo;
    }

    // MODIFIES: this
    // EFFECTS: opens writer; throws FileNotFoundException if writeTo file cannot
    //          be opened for writing
    public void open() throws FileNotFoundException {
        writer = new PrintWriter(new File(writeTo));
    }

    // MODIFIES: this
    // EFFECTS: closes writer
    public void close() {
        writer.close();
    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of account to file
    public void write(Account account) {
        JSONObject jsonObject = account.toJson();
        save(jsonObject.toString(3));
    }

    // MODIFIES: this
    // EFFECTS: writes string to file
    public void save(String json) {
        writer.print(json);
    }
}
