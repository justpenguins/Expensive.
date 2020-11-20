package ui;

import model.Account;
import model.Expense;

import javax.swing.*;
import java.awt.*;

// Represents a panel to show the expenses
public class ShowExpenses extends JFrame {
    private Account account;
    private Expense expense;

    private AddExpensePanel aep;

    private JList list;

    private JFrame frame;

    // EFFECTS: Constructs a show expenses panel
    public ShowExpenses(Account account, AddExpensePanel aep) {
        this.aep = aep;
        this.account = account;
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
        JPanel panel = new JPanel(new GridLayout(9,9));
        JLabel label = new JLabel("Expenses list: ");

        DefaultListModel<String> expList = new DefaultListModel<>();
        expList.addElement(aep.getNote());

        list = new JList(expList);

        panel.add(label);
        panel.add(list);
        frame.add(panel);
    }
}
