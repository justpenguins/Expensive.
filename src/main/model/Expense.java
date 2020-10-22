package model;

//class comment
public class Expense {

    private double expenseAmount; // The mount of the expense
    private String expenseDate; // The date of the expense in dd/mm/yyyy
    private String expenseLocation; // The location of the expense
    private String expenseCategory; // Short description of what the expense was for
    private int expenseID;

    // REQUIRES: Amount > 0, Date is in the format dd/mm/yyyy
    // MODIFIES: n/a
    // EFFECTS: Constructs an expense, using inputted amt for expense amount, id for the expense id, and strings
    //          for the date, location, and short description
    public Expense(double amt, int id, String date, String location, String type) {
        expenseAmount = amt;
        expenseDate = date;
        expenseLocation = location;
        expenseCategory = type;
        expenseID = id;
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
