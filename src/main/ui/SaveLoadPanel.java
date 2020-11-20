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


public class SaveLoadPanel extends GUI implements ActionListener {
    private JFrame frame;
    private JButton save;
    private JButton load;
    private JPanel panel;

    private Account account;

    public SaveLoadPanel() {
        makeFrame();
        setUpLabelAndFields();
    }

    public void makeFrame() {
        frame = new JFrame("Save/Load Expense");
        frame.setTitle("saveLoadExpense.");
        frame.setSize(500, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

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
        load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    load();
                } catch (IOException ioException) {
                    System.out.println("Could not be loaded");
                }
            }
        });
        panel.add(load);

        frame.add(panel);
    }

    public void save() throws FileNotFoundException {
        try {
            Writer writer = new Writer("./data/guiSave.json");
            account = new Account("Your account");
            writer.open();
            writer.write(account);
            writer.close();
            System.out.println("Saved to file.");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

    public void load() throws IOException {
        try {
            Reader reader = new Reader("./data/guiSave.json");
            reader.read();
            System.out.println("Loaded from file.");
        } catch (IOException e) {
            System.out.println("Nothing in here!");
        }

    }


}
