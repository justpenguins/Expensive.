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
    private JPanel removeExp;
    private JPanel showExp;
    private JPanel saveLoad;

    private JButton addExpButton;
    private JButton revExpButton;
    private JButton savButton;
    private JButton getFeedbackButton;
    private JButton setFeedbackButton;
    private JButton funsies;

    private JLabel name;

    private CardLayout cardLayout;

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

    public void makeLabel(JLabel label, String name) {
        label = new JLabel(name);
        accountPanel.add(label);
    }

    public void setUpPanelsButtons() {
        cardLayout = new CardLayout();
        accountPanel = new JPanel();
        removeExp = new JPanel();
        saveLoad = new JPanel();

        addExpButton = new JButton();
        revExpButton = new JButton();
        savButton = new JButton();
        getFeedbackButton = new JButton();
        setFeedbackButton = new JButton();
    }


    // set button method
    // create class, construct object set new class visible, dispose current screen
    public void accountPanel() {

        addExpButton = new JButton("Add Expenses");
        accountPanel.add(addExpButton);
        addExpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addExpense();
            }
        });

        revExpButton = new JButton("Remove Expenses");
        accountPanel.add(revExpButton);
        revExpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeExpense();
            }
        });

        savButton = new JButton("Save/Load Expenses");
        accountPanel.add(savButton);
        savButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveLoadExpenses();
            }
        });

        funsies = new JButton("funsies");
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
