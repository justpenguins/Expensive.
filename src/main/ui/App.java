package ui;

import java.util.ArrayList;
import java.util.Scanner;
import model.*;

public class App {
    private Account newAccount;
    private Scanner input;

    // MODIFIES: this
    // EFFECTS: takes in the user input
    private void showMenu(String option) {
        do {
            switch (option) {
                case "a":
                    addExpense();
                case "b":
                    removeExpense();
                case "c":
                    newAccount.showExpenses();
                case "d":
                    break;
            }

        } while (option.equals("d"));
    }

    public void addExpense() {
        newAccount.addExpense(null);
    }

    public void removeExpense() {
        newAccount.removeExpense(null);
    }

    


}

