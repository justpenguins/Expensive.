package ui;

import model.Account;
import model.Expense;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;


// Represents a panel where expenses are added
public class AddExpensePanel extends JFrame {
    private Account account;
    private JPanel frame;
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

    // EFFECTS: Constructs an Add Expense Panel
    public AddExpensePanel() {
        account = new Account("Your account");
        makeExpFrame();
        addExp();
    }

    // EFFECTS: Constructs the frame of the panel
    public void makeExpFrame() {
        //frame = new JPanel();
        //add(frame);
        setTitle("AddExpense.");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    // EFFECTS: creates a question
    public void question1() {
        amount = new JLabel("How much?");
        inputAmt = new JTextField("5.0");
        String amt = inputAmt.getText();

        if (!amt.isEmpty()) {
            amtToInput = Double.parseDouble(amt);
        } else {
            System.out.println("Must be a double > 0");
        }

        panel.add(amount);
        panel.add(inputAmt);
    }

    // EFFECTS: Checks to see if the numbers parsed are integers
    public Boolean integerChecker(String string) {
        string = string.replaceAll("\\s","");
        if (!string.isEmpty()) {
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

    // Effects: Creates a question asking for purchase ID
    public void question2() {
        id = new JLabel("Purchase ID");
        inputID = new JTextField("5");
        String idToParse = inputID.getText();
        integerChecker(idToParse);
        idToInput = Integer.parseInt(idToParse);
        panel.add(id);
        panel.add(inputID);
    }

    // Effects: creates a question asking about the notes of the purchase
    public void question3() {
        notes = new JLabel("Notes: ");
        inputNote = new JTextField("5");
        desc = inputNote.getText();
        panel.add(notes);
        panel.add(inputNote);
    }

    // Effects: creates and adds things to accountPanel
    public void addExp() {
        panel = new JPanel(new GridLayout(5,1));

        question1();
        question2();
        question3();

        JButton addExpButton = new JButton("Add Expense");
        addExpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Expense exp = new Expense(amtToInput, idToInput, "01/01/2002","Vancouver", desc);
                account.addExpense(exp);
                System.out.println("Expense added.");
            }
        });

        panel.add(addExpButton);
        add(panel);
    }

}