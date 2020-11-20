package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class RemoveExpensePanel extends GUI implements ActionListener {
    private JFrame frame;

    private JPanel panel;
    private JButton removeExpense;

    private JLabel question;
    private JTextField questionField;

    public RemoveExpensePanel() {
        makeFrame();
        setUpLabelAndFields();
    }

    public void makeFrame() {
        frame = new JFrame("Remove Expense");
        frame.setTitle("removeExpense.");
        frame.setSize(500, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    public void setUpLabelAndFields() {
        panel = new JPanel(new GridLayout(3,1));

        question = new JLabel("What's the ID of what you want to remove?");
        questionField = new JTextField();
        removeExpense = new JButton("Remove Expense");

        panel.add(question);
        panel.add(questionField);
        panel.add(removeExpense);

        frame.add(panel);
        panel.setVisible(true);
    }

}
