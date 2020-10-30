package persistence;

import model.Account;
import model.Expense;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// Reader that reads account data from the JSON data
// Source: JsonSerializationDemo, JsonReader Class
public class Reader {
    private String toRead;

    // EFFECTS: constructs reader, reads the provided file
    public Reader(String source) {
        this.toRead = source;
    }

    // EFFECTS: read and return file, throw IO exception if error happens
    public Account read() throws IOException {
        String data = readFile(toRead);
        JSONObject object = new JSONObject(data);
        return parse(object);
    }

    // EFFECTS: reads file, return as string
    // NOTE: sourced from JsonSerializationDemo
    public String readFile(String source) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> stringBuilder.append(s));
        }
        return stringBuilder.toString();
    }

    // EFFECTS: parses and returns a Account from a JSON file
    public Account parse(JSONObject obj) {
        String name = obj.getString("Name");
        Account acct = new Account(name);
        addExpenses(acct,obj);
        return acct;
    }

    // MODIFIES: ac
    // EFFECTS: parses an expense from the JSON object, adds to Account
    private void addExpense(Account ac, JSONObject jsonObject) {
        Expense expense = new Expense(100.00,2,"01/01/2020","UBC","COFFEE");
        ac.addExpense(expense);
    }

    // MODIFIES: ac
    // EFFECTS: parses expenses from JSON object, adds to Account
    private void addExpenses(Account ac, JSONObject object) {
        JSONArray jsonArray = object.getJSONArray("Expenses");
        for (Object json : jsonArray) {
            JSONObject nextExp = (JSONObject) json;
            addExpense(ac,nextExp);

        }
    }
}
