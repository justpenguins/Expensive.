package ui;

import model.Account;
import model.Expense;

import javax.swing.*;
import java.awt.*;

// Represents a panel to show the expenses
public class ShowExpenses extends GUI {
    private Account account;
    private Expense expense;

    private JFrame frame;

    // EFFECTS: Constructs a show expenses panel
    public ShowExpenses() {
        makeFrame();
        expenses();
    }

    // EFFECTS: creates the frame for the panel
    public void makeFrame() {
        frame = new JFrame("Show Expenses");
        frame.setTitle("showExpense.");
        frame.setSize(500, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    // EFFECTS: Initializes the panel, places it on frame
    public void expenses() {
        JPanel panel = new JPanel(new GridLayout(2,1));
        JLabel label = new JLabel("Expenses list: ");

        JLabel label1 = new JLabel();


        panel.add(label);
        frame.add(panel);
    }
}
