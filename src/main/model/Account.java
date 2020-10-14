package model;

import java.util.ArrayList;

public class Account {

    private String accountName; // Name of Account holder
    private int accountId; // Identifier of account
    private ArrayList<Expense> listOfExpenses; // List of Expenses associated with the account

    // EFFECTS: Make a new account, list of expenses is empty
    public Account(String name) {
        accountName = name;
        accountId = accountId + 1;
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
    public void removeExpense(Expense expense) {
        listOfExpenses.remove(expense);
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
