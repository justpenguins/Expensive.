package model;

import exceptions.NoSuchExpenseException;
import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writeable;

import java.util.ArrayList;
import java.util.Random;


// Creates an instance of an account
public class Account implements Writeable {

    private String accountName; // Name of Account holder
    protected static int accountId; // Identifier of account
    private ArrayList<Expense> listOfExpenses; // List of Expenses associated with the account

    // EFFECTS: Make a new account, list of expenses is empty
    public Account(String name) {
        accountName = name;
        accountId = makeAcctNumber();
        listOfExpenses = new ArrayList<>();
    }

    // REQUIRES: n/a
    // MODIFIES: this
    // EFFECTS: Add an expense to the list of expenses
    public void addExpense(Expense expense) {
        listOfExpenses.add(expense);
    }

    // REQUIRES: Expense be in the list
    // MODIFIES: this
    // EFFECTS: Removes the expense from the list of Expenses.
    public void removeExpense(Expense expense) throws NoSuchExpenseException {
        if (!listOfExpenses.contains(expense)) {
            throw new NoSuchExpenseException("This expense does not exist!");
        } else {
            listOfExpenses.remove(expense);
        }

    }

    // EFFECTS: Returns the list of expenses.
    public ArrayList<Expense> showExpenses() {
        return listOfExpenses;
    }

    // REQUIRES: list not be empty
    // MODIFIES: n/a
    // EFFECTS: Finds the expense with the inputted id from the list of Expenses.
    //          If not found return null
    public Expense findExpense(int expenseId) {
        for (Expense expense : listOfExpenses) {
            if (expenseId == expense.getExpID()) {
                return expense;
            }
        }
        return null;
    }

    // Source: JsonSerializationDemo, Workroom.java, line 43
    // EFFECTS: convert an Account to a JSONObject
    @Override
    public JSONObject toJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name",accountName);
        jsonObject.put("ID",accountId);
        jsonObject.put("Expenses",expensesToJson());
        return jsonObject;
    }

    // EFFECTS: converts the ArrayList to a JSONArray
    // Source: JsonSerializationDemo, Workroom.java, line 51
    public JSONArray expensesToJson() {
        JSONArray listOfExp = new JSONArray();

        for (Expense ex : listOfExpenses) {
            listOfExp.put(ex.toJson());
        }

        return listOfExp;
    }

    // MODIFIES: Account constructor
    // EFFECTS: generate a random Account Number
    public int makeAcctNumber() {
        Random rand = new Random();
        return accountId = rand.nextInt(9999 - 1);
    }

    // EFFECTS: Return the length of the size of the list of Expenses
    public int length() {
        return listOfExpenses.size();
    }

    // Getter
    public String getAcctName() {
        return accountName;
    }

    // Getter
    public int getId() {
        return accountId;
    }

}
