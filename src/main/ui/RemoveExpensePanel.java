package ui;

import javax.swing.*;
import java.awt.event.ActionListener;

public class RemoveExpensePanel extends GUI implements ActionListener {
    private JFrame frame;

    private JPanel mainpanel;
    private JButton back;

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
        mainpanel = new JPanel();

        back = new JButton("Home");
        mainpanel.add(back);

        question = new JLabel("What's the ID of what you want to remove?");
        questionField = new JTextField();

        mainpanel.add(question);
        mainpanel.add(questionField);

        frame.add(mainpanel);
    }

}
