package ui;

import exceptions.NoSuchExpenseException;
import model.Account;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Creates a class that removes expenses
public class RemoveExpensePanel extends GUI implements ActionListener {
    private JFrame frame;

    private Account account;

    private JPanel panel;
    private JButton removeExpense;

    private JLabel question;
    private JTextField questionField;

    private int idToRemove;

    // EFFECTS: constructs a removeExpense panel
    public RemoveExpensePanel(Account account) {
        this.account = account;
        makeFrame();
        setUpLabelAndFields();
    }

    // EFFECTS: makes the frame of the class
    public void makeFrame() {
        frame = new JFrame("Remove Expense");
        frame.setTitle("removeExpense.");
        frame.setSize(500, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    // EFFECTS: Initializes the label, fields and buttons of class and adds them to the frame
    public void setUpLabelAndFields() {
        panel = new JPanel(new GridLayout(3, 1));

        question = new JLabel("What's the ID of what you want to remove?");
        questionField = new JTextField("2");
        idToRemove = Integer.parseInt(questionField.getText());

        removeExpense = new JButton("Remove Expense");
        removeExpense.addActionListener(this);

        panel.add(question);
        panel.add(questionField);
        panel.add(removeExpense);

        frame.add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            account.removeExpense(account.findExpense(idToRemove));
            System.out.println("Expense removed.");
        } catch (NoSuchExpenseException noSuchExpenseException) {
            System.out.println("You sure you bought that? I don't remember that one...");
        }
    }
}
