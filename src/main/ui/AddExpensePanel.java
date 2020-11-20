package ui;

import model.Account;
import model.Expense;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.util.Calendar;

public class AddExpensePanel extends GUI implements ActionListener {
    private Account account;
    private JFrame frame;
    private JLabel amount;
    private JLabel id;
    private JLabel notes;

    private JTextField inputAmt;
    private JTextField inputID;
    private JTextField inputNote;

    private JPanel panel;

    private Double amtToInput;
    private int idToInput;
    private String desc;


    public AddExpensePanel() {
        account = new Account("Your account");
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

    public void question1() {
        amount = new JLabel("How much?");
        inputAmt = new JTextField();
        String amt = inputAmt.getText();

        if (amt.length() > 0) {
            amtToInput = Double.parseDouble(amt);
        } else {
            System.out.println("Must be a double > 0");
        }

        panel.add(amount);
        panel.add(inputAmt);
    }

    public Boolean integerChecker(String string) {
        if (string.length() > 0) {
            for (char c : string.toCharArray()) {
                if (!Character.isDigit(c)) {
                    return false;
                }
            }

            BigInteger bigBoy = new BigInteger("2147483647");
            BigInteger littleBoy = new BigInteger("-2147483648");
            BigInteger answer = new BigInteger(string);

            if (bigBoy.compareTo(answer) <= 0) {
                return false;
            } else if (littleBoy.compareTo(answer) >= 0) {
                return false;
            } else {
                return true;
            }
        }
        return true;
    }

    public void question2() {
        id = new JLabel("Purchase ID");
        inputID = new JTextField();
        String idToParse = inputID.getText();
        integerChecker(idToParse);
        idToInput = Integer.parseInt(idToParse);
        panel.add(id);
        panel.add(inputID);
    }

    public void question3() {
        notes = new JLabel("Notes: ");
        inputNote = new JTextField();
        desc = inputNote.getText();
        panel.add(notes);
        panel.add(inputNote);
    }

    public void addExp() {
        panel = new JPanel(new GridLayout(5,1));

        question1();
        question2();
        question3();

        JButton addExpButton = new JButton("Add Expense");
        addExpButton.addActionListener(this);

        panel.add(addExpButton);
        frame.add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Expense exp = new Expense(amtToInput, idToInput, "01/01/2002","Vancouver", desc);
        account.addExpense(exp);
    }
}