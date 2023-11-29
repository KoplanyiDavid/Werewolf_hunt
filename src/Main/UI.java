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
    JLabel[] lifeLabel = new JLabel[6];
    JPanel inventoryPanel;
    public JLabel swordLabel, shieldLabel, lanternLabel;
    public UI(GameManager gm) {
        this.gm = gm;
        createMainField();
        createPlayerField();
        generateScene();
        window.setVisible(true);
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
        inventoryPanel.setBounds(650,0,150,50);
        inventoryPanel.setBackground(Color.blue);
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
        window.setSize(1920,1080);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);

        messageText = new JTextArea("THIS IS TEST");
        messageText.setBounds(560,880,800,200);
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
        bgPanel[bgNum].setBounds(0,0,1920,880);
        bgPanel[bgNum].setLayout(null);
        window.add(bgPanel[bgNum]);

        bgLabel[bgNum] = new JLabel();
        bgLabel[bgNum].setBounds(0,0,1920,880);

        ImageIcon bgIcon = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource(bgFileName)));
        Image image = bgIcon.getImage();
        Image newImg = image.getScaledInstance(1920,880,Image.SCALE_SMOOTH);
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
        createBackground(0, "main_bgd.png");
        createObject(0,1200,285,900,700,"house.png","Look","Talk","Rest", "lookHouse", "talkHouse", "restHouse");
        createObject(0,300,500,100,300,"knight.png","Look","Talk","Attack", "lookKnight", "talkKnight", "attackKnight");
        createObject(0,1000,800,200,100,"chest.png","Look","Talk","Open", "lookChest", "talkChest", "openChest");

        createArrowButton(0, 0, 150, 50, 50,"goScene2", "leftarrow.png");
        bgPanel[0].add(bgLabel[0]);

        // Scene 2
        createBackground(1, "cave_entrance.jpg");
        createObject(1,0,500,200,300,"empty.png","Look","Talk","Enter", "lookCave", "talkCave", "enterCave");
        createObject(1,500,500,200,300,"empty.png","Look","Talk","Search", "lookWoods", "talkWoods", "enterWoods");
        createArrowButton(1, 1500, 150, 50, 50,"goScene1", "rightarrow.png");
        bgPanel[1].add(bgLabel[1]);
    }
}
