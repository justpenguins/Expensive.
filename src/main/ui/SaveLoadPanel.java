package ui;

import model.Account;
import persistence.Reader;
import persistence.Writer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

// Represents a Save/load panel
public class SaveLoadPanel extends JFrame implements ActionListener {
    private JFrame frame;
    private JButton save;
    private JButton load;
    private JPanel panel;

    private Account account;

    // EFFECTS: Constructs a save/load panel
    public SaveLoadPanel() {
        makeFrame();
        setUpLabelAndFields();
    }

    // EFFECTS: makes the frame for the panel
    public void makeFrame() {
        frame = new JFrame("Save/Load Expense");
        frame.setTitle("saveLoadExpense.");
        frame.setSize(500, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    // EFFECTS: sets up the labels,buttons and fields and adds them to the panel.
    public void setUpLabelAndFields() {
        panel = new JPanel(new GridLayout(2,1));
        save = new JButton("Save Expenses");
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    save();
                } catch (FileNotFoundException fileNotFoundException) {
                    System.out.println("File not found");
                }
            }
        });
        panel.add(save);
        load = new JButton("Load Expenses");
        load.addActionListener(this);
        panel.add(load);
        frame.add(panel);
    }

    // EFFECTS: Helper function for saving things to a json file
    public void save() throws FileNotFoundException {
        try {
            Writer writer = new Writer("./data/guiSave.json");
            account = new Account("Account");
            writer.open();
            writer.write(account);
            writer.close();
            System.out.println("Saved to file.");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

    // EFFECT: helper function for loading things from a json file
    public void load() throws IOException {
        try {
            Reader reader = new Reader("./data/guiSave.json");
            reader.read();
            System.out.println("Loaded from file.");
        } catch (IOException e) {
            System.out.println("Nothing in here!");
        }

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            load();
        } catch (IOException ioException) {
            System.out.println("File not loaded");
        }
    }
}
