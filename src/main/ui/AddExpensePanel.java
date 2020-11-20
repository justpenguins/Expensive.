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

    protected JPanel panel;

    private CardLayout cardLayout;

    public AddExpensePanel() {
        panel = new JPanel();
        makeExpFrame();
        addExp();
    }

    public void makeExpFrame() {
        frame = new JFrame("Add Expense");
        frame.setTitle("AddExpense.");
        frame.setSize(500, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void makeLabel(JLabel label, String name) {
        label = new JLabel(name);
        panel.add(label);
    }

    public void makeTF(JTextField field) {
        field = new JTextField();
        panel.add(field);
    }


    public void addExp() {
        amount = new JLabel("How much?");
        amount.add(panel);

        makeLabel(id, "Purchase ID");
        makeTF(inputID);

        makeLabel(date, "When did you buy it? (dd/mm/yyyy)");
        makeTF(inputDate);

        makeLabel(location, "Where did you buy it?");
        makeTF(inputLoc);

        makeLabel(notes, "Additional Notes: ");
        makeTF(inputNote);

        JButton addExpButton = new JButton("Add Expense");
        panel.add(addExpButton);
        frame.add(panel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}