package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener {
    private AddExpensePanel aep;
    private JFrame frame;

    private JPanel accountPanel;
    private JPanel removeExp;
    private JPanel showExp;
    private JPanel saveLoad;
    private JPanel feedback;
    private JPanel setLevel;

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
        addPanel();
    }

    public void makeFrame() {
        frame = new JFrame("Expensive.");
        frame.setTitle("Expensive.");
        frame.setSize(500, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void setUpPanelsButtons() {
        CardLayout cardLayout = new CardLayout();
        aep = new AddExpensePanel();
        accountPanel = new JPanel(cardLayout);
        removeExp = new JPanel();
        saveLoad = new JPanel();
        feedback = new JPanel();
        setLevel = new JPanel();

        addExpButton = new JButton();
        revExpButton = new JButton();
        savButton = new JButton();
        getFeedbackButton = new JButton();
        setFeedbackButton = new JButton();
    }

    public void addPanel() {
        accountPanel.add(aep, "addExp");
    }


    public void makeButton(JButton button, String name) {
        button = new JButton(name);
        accountPanel.add(button);
        button.addActionListener(this);
    }

    public void makeLabel(JLabel label, String name) {
        label = new JLabel(name);
        accountPanel.add(label);
    }

    // set button method
    // create class, construct object set new class visible, dispose current screen
    public void accountPanel() {
        makeLabel(name, "Welcome!");
        makeButton(addExpButton,"Add expenses");
        addExpButton.addActionListener(e -> cardLayout.show(accountPanel,"addExp"));

        makeButton(revExpButton, "Remove Expenses");
        revExpButton.setActionCommand("remExpButton");

        makeButton(savButton, "Save/Load Expenses");
        savButton.setActionCommand("saveExpButton");

        makeButton(getFeedbackButton, "Get Feedback");
        getFeedbackButton.setActionCommand("getButton");

        makeButton(setFeedbackButton, "Set Feedback");
        setFeedbackButton.setActionCommand("setExpButton");

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



    @Override
    public void actionPerformed(ActionEvent e) {



    }
}
