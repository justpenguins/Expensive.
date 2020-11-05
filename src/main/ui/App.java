package ui;


import model.*;
import persistence.Reader;
import persistence.Writer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class App {
    private static final String store = "./data/saved.json";
    private Account newAccount;
    private Scanner input;
    private Writer writer;
    private Reader reader;
    private int levelSet = 1;

    // EFFECTS: Runs the app
    public App() {
        input = new Scanner(System.in);
        writer = new Writer(store);
        reader = new Reader(store);
        startApp();
    }

    // EFFECTS: Processes input
    // Note: cited from TellerApp
    private void startApp() {
        boolean run = true;

        input = new Scanner(System.in);

        login();

        String command = null;
        while (run) {
            showMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("e")) {
                run = false;
            } else {
                doMenu(command);
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: asks user for name, creates account
    private void login() {
        System.out.println("Please enter your name:");
        String acctName = input.next();

        newAccount = new Account(acctName);

        System.out.println("Welcome, " + acctName + " . We're gonna save some money or you're going to get roasted.");
    }

    // REQUIRES: n/a
    // MODIFIES: n/a
    // EFFECTS: Shows the main menu of options
    private void showMenu() {
        System.out.println("\n");
        System.out.println("Welcome to Expensive.");
        System.out.println("***************************************");
        System.out.println("How can we help you today?");
        System.out.println("\n");
        System.out.println("add. Add expense");
        System.out.println("rem. Remove expense");
        System.out.println("show. Show expenses");
        System.out.println("find. Find expense");
        System.out.println("acc. Save new/load saved expenses.");
        System.out.println("get. Get feedback");
        System.out.println("set. Set alert level");
        System.out.println("e. Exit application");
    }

    // MODIFIES: this
    // EFFECTS: takes in the user input
    // Cite: TellerApp
    private void doMenu(String option) {
        do {
            switch (option) {
                case "add": addExpense();
                    break;
                case "rem": removeExpense();
                    break;
                case "show": showExpense();
                    break;
                case "find": findExpense();
                    break;
                case "acc": accessSaves();
                    break;
                case "get": getFeedback();
                    break;
                case "set": setLevel();
                    break;
                case "e": break;
                default: System.out.println("Selection not valid.");
                    break;
            }
        } while (option.equals("e"));
    }

    // MODIFIES: this
    // EFFECTS: add an expense to the Account list
    public void addExpense() {
        System.out.println("How much did you spend?");
        double toAddAmt = input.nextDouble();
        System.out.println("Purchase Id");
        int toAddId = input.nextInt();
        System.out.println("When did you buy it? (dd/mm/yyyy)");
        String toAddDate = input.next();
        System.out.println("Where did you buy it?");
        String toAddLocation = input.next();
        System.out.println("Notes: ");
        String toAddDesc = input.next();

        Expense newExp = new Expense(toAddAmt, toAddId, toAddDate, toAddLocation, toAddDesc);

        newAccount.addExpense(newExp);

    }

    // REQUIRES: Expense must be in the list.
    // MODIFIES: this
    // EFFECTS: remove an existing expense from the list
    public void removeExpense() {
        System.out.println("What's the purchase ID of the expense you want to remove?");
        int nextInt = input.nextInt();
        System.out.println("Remove expense? Type y or n");
        char nextChar = input.next().charAt(0);


        if (nextChar == 'y') {
            Expense toRemove = newAccount.findExpense(nextInt);
            newAccount.removeExpense(toRemove);
        } else {
            System.out.println("The expense was not deleted.");
        }

    }

    // REQUIRES: Expense must be in the list.
    // MODIFIES: this
    // EFFECTS: Shows all expenses in the list
    public void showExpense() {
        if (newAccount.showExpenses().isEmpty()) {
            System.out.println("There's nothing here...for now.");
        } else {
            for (Expense expense : newAccount.showExpenses()) {
                System.out.println("Purchase ID: " + expense.getExpID());
                System.out.println("********************************");
                System.out.println("Purchase Amount: " + expense.getExpAmt());
                System.out.println("Purchase Description: " + expense.getExpDesc());
                System.out.println("Purchase Date: " + expense.getExpDate());
                System.out.println("Purchase Location: " + expense.getExpLocation());
                System.out.println("\n");
            }
        }
    }

    // REQUIRES: Expense must be in the list.
    // MODIFIES: this
    // EFFECTS: Finds an existing expense from the list
    public void findExpense() {
        System.out.println("What's the purchase ID of the expense you would like to find?");
        int findExp = input.nextInt();

        Expense foundExp = newAccount.findExpense(findExp);

        System.out.println("There's a special energy about this one. ID: " + foundExp.getExpID());
        System.out.println("Did you buy " + foundExp.getExpDesc() + " ?");
    }

    // REQUIRES: Selected choice must be 1, 2 or 3
    // MODIFIES: App
    // EFFECTS: Sets the level of the reminder
    public void setLevel() {
        System.out.println("The levels are: ");

        System.out.println("1 -> Gentle, kind reminders. Things your mum would say to you");

        System.out.println("2 -> Slightly spicier. Things that your friends would say as jokes");

        System.out.println("3 -> Absolute Zingers. Things that would come up about you if you attended a roast battle");

        levelSet = input.nextInt();
    }

    // REQUIRES: Must have expenses in your account
    // MODIFIES: n/a
    // EFFECTS: Gives feedback based on level and whether expenses > max size
    public void getFeedback() {
        String[] reminder1 = {"Let's not spend too much. Think about the future!",
                "Save some money for a chicken nuggets later!",
                "Did you really have to spend money on that?"};
        String[] reminder2 = {"WAI SO EXPENSIVE ONE",
                "That's so *bleep* expensive! What are you thinking?",
                "You've really screwed up this time. What on earth have you bought?"};
        String[] reminder3 = {"Dishonour on you, dishonour on your family, dishonour on your cow, "
                + "and especially dishonour on your expenses.",
                "That purchase was so unnecessary that the extra gods are convulsing above us.",
                "You can retire with the money you have left, if you only plan on living for the next 2 days."};

        Random r = new Random();
        int rand = r.nextInt(reminder1.length); //Cite: W3schools random

        int maxLimit = 1;

        if (newAccount.showExpenses().size() > maxLimit && levelSet == 1) {
            System.out.println(reminder1[rand]);
        } else if (newAccount.showExpenses().size() > maxLimit && levelSet == 2) {
            System.out.println(reminder2[rand]);
        } else if (newAccount.showExpenses().size() > maxLimit && levelSet == 3) {
            System.out.println(reminder3[rand]);
        } else if (newAccount.showExpenses().size() <= maxLimit) {
            System.out.println("You're doing great, which is very unusual of you. Congratulations?");
        }
    }

    // EFFECTS: saves account to file specified
    // Sourced from JsonSerialization demo, WorkroomApp, line 112
    public void save() {
        try {
            writer.open();
            writer.write(newAccount);
            writer.close();
            System.out.println("Expenses automatically saved.");
        } catch (FileNotFoundException e) {
            System.out.println("Expenses not found. That's unfortunate.");
        }

    }

    // MODIFIES: this
    // EFFECTS: loads account from file
    // Sourced from JsonSerialization demo WorkroomApp, line 125
    public void load() {
        try {
            newAccount = reader.read();
            System.out.println("Loaded past expenses.");
        } catch (IOException e) {
            System.out.println("Can't read the file.");
        }
    }

    // MODIFIES: n/a
    // EFFECTS: Lets users pick between saving or loading a save file
    public void accessSaves() {
        System.out.println("Do you wanna save something, or lead something?");
        System.out.println("Enter *load* or *save*");

        String choice = input.next();

        if (choice.equalsIgnoreCase("load")) {
            load();
        } else if (choice.equalsIgnoreCase("save")) {
            save();
        } else {
            System.out.println("That's not a choice. Try again.");
        }
    }


}





