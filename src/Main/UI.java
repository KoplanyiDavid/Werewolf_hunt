package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Objects;

public class UI {
    GameManager gm;
    JFrame window;
    public JTextArea messageText;
    public JPanel[] bgPanel = new JPanel[10];
    public JLabel[] bgLabel = new JLabel[10];

    //player ui
    JPanel lifePanel;
    public JLabel[] lifeLabel = new JLabel[6];
    JPanel inventoryPanel;
    public JLabel swordLabel, shieldLabel, lanternLabel;

    // game over ui
    public JLabel titleLabel;
    public JButton restartButton;
    public UI(GameManager gm) {
        this.gm = gm;
        createMainField();
        createPlayerField();
        createGameOverField();
        generateScene();
        window.setVisible(true);
    }

    public void createGameOverField() {
        titleLabel = new JLabel("",JLabel.CENTER);
        titleLabel.setBounds(400,100,500,300);
        titleLabel.setForeground(Color.red);
        titleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 90));
        titleLabel.setVisible(false);
        window.add(titleLabel);

        restartButton = new JButton();
        restartButton.setBounds(550,320,200,100);
        restartButton.setBorder(null);
        restartButton.setBackground(null);
        restartButton.setForeground(Color.white);
        restartButton.setFocusPainted(false);
        restartButton.addActionListener(gm.aHandler);
        restartButton.setActionCommand("restart");
        restartButton.setVisible(false);
        window.add(restartButton);
    }

    private void createPlayerField() {
        lifePanel = new JPanel();
        lifePanel.setBounds(50,0,250,50);
        lifePanel.setBackground(Color.black);
        lifePanel.setLayout(new GridLayout(1,5));
        window.add(lifePanel);

        ImageIcon lifeIcon = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("heart.png")));
        Image image = lifeIcon.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        lifeIcon = new ImageIcon(image);

        int i=1;
        while(i<6) {
            lifeLabel[i] = new JLabel();
            lifeLabel[i].setIcon(lifeIcon);
            lifePanel.add(lifeLabel[i]);
            i++;
        }

        inventoryPanel = new JPanel();
        inventoryPanel.setBounds(1080,0,150,50);
        inventoryPanel.setBackground(Color.black);
        inventoryPanel.setLayout(new GridLayout(1,3));
        window.add(inventoryPanel);

        //items
        swordLabel = new JLabel();
        ImageIcon swordIcon = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("sword.png")));
        image = swordIcon.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        swordIcon = new ImageIcon(image);
        swordLabel.setIcon(swordIcon);
        inventoryPanel.add(swordLabel);

        shieldLabel = new JLabel();
        ImageIcon shieldIcon = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("shield.png")));
        image = shieldIcon.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        shieldIcon = new ImageIcon(image);
        shieldLabel.setIcon(shieldIcon);
        inventoryPanel.add(shieldLabel);

        lanternLabel = new JLabel();
        ImageIcon lanternIcon = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("lantern.png")));
        image = lanternIcon.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        lanternIcon = new ImageIcon(image);
        lanternLabel.setIcon(lanternIcon);
        inventoryPanel.add(lanternLabel);
    }

    public void createMainField() {
        window = new JFrame();
        window.setSize(1280,720);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);

        messageText = new JTextArea("THIS IS TEST");
        messageText.setBounds(50,570,1280,150);
        messageText.setBackground(Color.black);
        messageText.setForeground(Color.white);
        messageText.setEditable(false);
        messageText.setLineWrap(true);
        messageText.setWrapStyleWord(true);
        messageText.setFont(new Font("Book Antiqua", Font.PLAIN, 26));
        window.add(messageText);
    }
    public void createBackground(int bgNum, String bgFileName) {
        bgPanel[bgNum] = new JPanel();
        bgPanel[bgNum].setBounds(50,50,1180,530);
        bgPanel[bgNum].setLayout(null);
        bgPanel[bgNum].setBackground(Color.black);
        bgPanel[bgNum].setVisible(false);
        window.add(bgPanel[bgNum]);

        bgLabel[bgNum] = new JLabel();
        bgLabel[bgNum].setBounds(0,0,1180,530);

        ImageIcon bgIcon = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource(bgFileName)));
        Image image = bgIcon.getImage();
        Image newImg = image.getScaledInstance(1180,530,Image.SCALE_SMOOTH);
        bgIcon = new ImageIcon(newImg);
        bgLabel[bgNum].setIcon(bgIcon);
    }
    public void createObject(int bgNum, int x, int y, int w, int h, String fileName, String choice0Name,
                             String choice1Name, String choice2Name, String choice0Command, String choice1Command,
                             String choice2Command) {
        /* Pop Menu for objects */
        JPopupMenu popMenu = new JPopupMenu();
        /* Pop menu items */
        JMenuItem[] menuItem = new JMenuItem[3];
        menuItem[0] = new JMenuItem(choice0Name);
        menuItem[0].addActionListener(gm.aHandler);
        menuItem[0].setActionCommand(choice0Command);
        popMenu.add(menuItem[0]);

        menuItem[1] = new JMenuItem(choice1Name);
        menuItem[1].addActionListener(gm.aHandler);
        menuItem[1].setActionCommand(choice1Command);
        popMenu.add(menuItem[1]);

        menuItem[2] = new JMenuItem(choice2Name);
        menuItem[2].addActionListener(gm.aHandler);
        menuItem[2].setActionCommand(choice2Command);
        popMenu.add(menuItem[2]);
        /* objects */
        JLabel objectLabel = new JLabel();
        objectLabel.setBounds(x,y,w,h);
        ImageIcon objectIcon = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource(fileName)));
        Image image = objectIcon.getImage();
        Image newImg = image.getScaledInstance(w,h,Image.SCALE_SMOOTH);
        objectIcon = new ImageIcon(newImg);
        objectLabel.setIcon(objectIcon);

        objectLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    popMenu.show(objectLabel, e.getX(), e.getY());
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        bgPanel[bgNum].add(objectLabel);

    }

    public void createArrowButton(int bgNum, int x, int y, int w, int h, String command, String arrowFilePath) {
        ImageIcon arrowIcon = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource(arrowFilePath)));
        Image image = arrowIcon.getImage();
        Image newImg = image.getScaledInstance(w,h,Image.SCALE_SMOOTH);
        arrowIcon = new ImageIcon(newImg);

        JButton arrowButton = new JButton();
        arrowButton.setIcon(arrowIcon);
        arrowButton.setBorderPainted(false);
        arrowButton.setBounds(x, y, w, h);
        arrowButton.setBackground(null);
        arrowButton.setContentAreaFilled(false);
        arrowButton.setFocusPainted(false);

        arrowButton.addActionListener(gm.aHandler);
        arrowButton.setActionCommand(command);

        bgPanel[bgNum].add(arrowButton);
    }
    public void generateScene() {
        // Scene 1
        createBackground(0, "main_bgd.jpg");
        createObject(0,800,0,600,500,"house.png","Look","Talk","Rest", "lookHouse", "talkHouse", "restHouse");
        createObject(0,200,160,80,250,"knight.png","Look","Talk","Attack", "lookKnight", "talkKnight", "attackKnight");
        createObject(0,500,300,200,100,"chest.png","Look","Talk","Open", "lookChest", "talkChest", "openChest");

        createArrowButton(0, 50, 290, 75, 100,"goScene2", "leftarrow.png");
        bgPanel[0].add(bgLabel[0]);

        // Scene 2
        createBackground(1, "cave_entrance.jpg");
        createObject(1,0,300,200,300,"empty.png","Look","Talk","Enter", "lookCave", "talkCave", "enterCave");
        createObject(1,350,280,400,150,"empty.png","Look","Talk","Search", "lookWoods", "talkWoods", "searchWoods");
        createArrowButton(1, 1000, 370, 100, 150,"goScene1", "rightarrow.png");
        bgPanel[1].add(bgLabel[1]);

        //Scene 3
        createBackground(2, "cave.png");
        createObject(2,200,100,250,300,"girl01.png","Look","Talk","Enter", "lookCave", "talkCave", "enterCave");
        createObject(2,700,200,250,330,"girl02.png","Look","Talk","Search", "lookWoods", "talkWoods", "searchWoods");
        //createArrowButton(2, 1000, 150, 75, 100,"goScene1", "rightarrow.png");
        bgPanel[2].add(bgLabel[2]);
    }
}
