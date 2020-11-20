package ui;

import javax.swing.*;
import java.awt.event.ActionListener;

public class SaveLoadPanel extends GUI implements ActionListener {
    private JFrame frame;
    private JButton back;
    private JButton save;
    private JButton load;
    private JPanel mainpanel;

    public SaveLoadPanel() {
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

        save = new JButton("Save Expenses");
        load = new JButton("Load Expenses");

        mainpanel.add(save);
        mainpanel.add(load);

        frame.add(mainpanel);
    }


}
