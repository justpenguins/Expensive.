package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddExpensePanel extends GUI implements ActionListener {
    private JFrame frame;
    private JLabel amount;
    private JLabel id;
    private JLabel date;
    private JLabel location;
    private JLabel notes;

    private JTextField inputAmt;
    private JTextField inputID;
    private JTextField inputDate;
    private JTextField inputLoc;
    private JTextField inputNote;

    private JPanel panel;

    private CardLayout cardLayout;

    public AddExpensePanel() {
        makeExpFrame();
        addExp();
    }

    public void makeExpFrame() {
        frame = new JFrame("Add Expense");
        frame.setTitle("AddExpense.");
        frame.setSize(500, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    public void addExp() {
        panel = new JPanel();
        amount = new JLabel("How much?");
        inputAmt = new JTextField();
        inputAmt.setBounds(10,20,165,20);
        panel.add(amount);
        panel.add(inputAmt);

        id = new JLabel("Purchase ID");
        inputID = new JTextField();
        panel.add(id);
        panel.add(inputID);

        notes = new JLabel("Notes: ");
        inputNote = new JTextField();
        panel.add(notes);
        panel.add(inputNote);

        JButton goBack = new JButton("Home");
        panel.add(goBack);

        JButton addExpButton = new JButton("Add Expense");

        panel.add(addExpButton);
        frame.add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}