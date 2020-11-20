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
    private JTextField inputDate;
    private JTextField inputLoc;
    private JTextField inputNote;

    private JPanel panel;

    private Double amtToInput;
    private int idToInput;

    // EFFECTS: Constructs an Add Expense Panel
    public AddExpensePanel(Account account) {
        this.account = account;
        makeExpFrame();
        addExp();
    }

    // EFFECTS: Constructs the frame of the panel
    public void makeExpFrame() {
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
        inputNote = new JTextField("Add description here");
        panel.add(notes);
        panel.add(inputNote);
    }

    public void question4() {
        JLabel date = new JLabel("Date");
        inputDate = new JTextField("01/01/1900");
        panel.add(date);
        panel.add(inputDate);
    }

    public void question5() {
        JLabel location = new JLabel("Location");
        inputLoc = new JTextField("UBC");
        panel.add(location);
        panel.add(inputLoc);

    }

    // Effects: creates and adds things to accountPanel
    public void addExp() {
        panel = new JPanel(new GridLayout(8,2));

        question1();
        question2();
        question4();
        question5();
        question3();

        JButton addExpButton = new JButton("Add Expense");
        addExpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Expense exp = new Expense(amtToInput, idToInput, inputDate.getText(),
                        inputLoc.getText(), inputNote.getText());
                account.addExpense(exp);
                System.out.println("Expense added.");
            }
        });

        panel.add(addExpButton);
        add(panel);
    }

    public String getNote() {
        return inputNote.getText();
    }

}