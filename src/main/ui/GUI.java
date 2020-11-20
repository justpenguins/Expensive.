package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener {
    private AddExpensePanel aep;
    private RemoveExpensePanel rep;
    private SaveLoadPanel slp;
    private JFrame frame;

    private JPanel accountPanel;

    private JButton addExpButton;
    private JButton revExpButton;
    private JButton savButton;
    private JButton funsies;


    public GUI() {
        super("Expensive.");
        makeFrame();
        setUpPanelsButtons();
        accountPanel();
    }

    public void makeFrame() {
        frame = new JFrame("Expensive.");
        frame.setTitle("Expensive.");
        frame.setSize(500, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


    public void setUpPanelsButtons() {
        accountPanel = new JPanel();

        addExpButton = new JButton("Add Expense");
        revExpButton = new JButton("Remove Expense");
        savButton = new JButton("Save/load Expense");
        funsies = new JButton("Don't click here");
    }

    public void button1() {
        accountPanel.add(addExpButton);
        addExpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addExpense();
            }
        });
    }

    public void button2() {
        accountPanel.add(revExpButton);
        revExpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeExpense();
            }
        });
    }

    public void button3() {
        accountPanel.add(savButton);
        savButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveLoadExpenses();
            }
        });
    }

    // set button method
    // create class, construct object set new class visible, dispose current screen
    public void accountPanel() {
        button1();
        button2();
        button3();

        accountPanel.add(funsies);
        funsies.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                troll();
            }
        });
        frame.add(accountPanel);
    }

    // Source from: https://stackoverflow.com/questions/15513380/how-to-open-a-new-window-by-clicking-a-button
    //              for the parts on opening a new window.
    public void troll() {

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame frame = new JFrame("Surprise!");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                JPanel panel = new JPanel();
                panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
                panel.setOpaque(true);

                ImageIcon icon = new ImageIcon("./data/tobs.png");

                JLabel img = new JLabel(icon);
                panel.add(img);

                frame.getContentPane().add(BorderLayout.CENTER, panel);
                frame.pack();
                frame.setLocationByPlatform(true);
                frame.setVisible(true);
                frame.setResizable(false);
            }
        });
    }

    public void addExpense() {

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame frame = new JFrame("Surprise!");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                JPanel panel = new JPanel();
                panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
                panel.setOpaque(true);

                aep = new AddExpensePanel();
                frame.add(aep);

                frame.getContentPane().add(BorderLayout.CENTER, panel);
                frame.pack();
                frame.setLocationByPlatform(true);
                frame.setVisible(true);
                frame.setResizable(false);
            }
        });

    }

    public void removeExpense() {

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame frame = new JFrame("Surprise!");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                JPanel panel = new JPanel();
                panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
                panel.setOpaque(true);

                rep = new RemoveExpensePanel();
                accountPanel.add(rep);


                frame.getContentPane().add(BorderLayout.CENTER, panel);
                frame.pack();
                frame.setLocationByPlatform(true);
                frame.setVisible(true);
                frame.setResizable(false);
            }
        });

    }

    public void saveLoadExpenses() {

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame frame = new JFrame("Surprise!");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                JPanel panel = new JPanel();
                panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
                panel.setOpaque(true);

                slp = new SaveLoadPanel();
                accountPanel.add(slp);

                frame.getContentPane().add(BorderLayout.CENTER, panel);
                frame.pack();
                frame.setLocationByPlatform(true);
                frame.setVisible(true);
                frame.setResizable(false);
            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
