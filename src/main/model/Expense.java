package model;

public class Expense {

    private double expenseAmount; // The mount of the expense
    private String expenseDate; // The date of the expense in dd/mm/yyyy
    private String expenseLocation; // The location of the expense
    private String expenseCategory; // Short description of what the expense was for
    private int expenseID;

    // REQUIRES:
    // MODIFIES:
    // EFFECTS: Constructs an expense
    public Expense(double amt, String date, String location, String type) {
        expenseAmount = amt;
        expenseDate = date;
        expenseLocation = location;
        expenseCategory = type;
        expenseID = expenseID + 1;
    }

    // Getter
    public double getExpAmt() {
        return expenseAmount;
    }

    // Getter
    public String getExpDate() {
        return expenseDate;
    }

    // Getter
    public String getExpLocation() {
        return expenseLocation;
    }

    // Getter
    public String getExpDesc() {
        return expenseCategory;
    }

    // Getter
    public int getExpID() {
        return expenseID;
    }

}
