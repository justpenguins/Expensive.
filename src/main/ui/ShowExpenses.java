package ui;

import model.Account;
import model.Expense;

import javax.swing.*;
import java.awt.*;

public class ShowExpenses extends GUI {
    private Account account;
    private Expense expense;

    private JFrame frame;


    public ShowExpenses() {
        makeFrame();
        expenses();
    }

    public void makeFrame() {
        frame = new JFrame("Show Expenses");
        frame.setTitle("showExpense.");
        frame.setSize(500, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    public void expenses() {
        JPanel panel = new JPanel(new GridLayout(2,1));
        JLabel label = new JLabel("Expenses list: ");

        JLabel label1 = new JLabel();

        panel.setSize(100,200);

        panel.add(label);
    }
}
