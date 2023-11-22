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
    public UI(GameManager gm) {
        this.gm = gm;
        createMainField();
        generateScreen();
        window.setVisible(true);
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
    public void createObject(int bgNum, int x, int y, int w, int h, String fileName, String choice1Name, String choice2Name, String choice3Name) {
        /* Pop Menu for objects */
        JPopupMenu popMenu = new JPopupMenu();
        /* Pop menu items */
        JMenuItem[] menuItem = new JMenuItem[3];
        menuItem[0] = new JMenuItem(choice1Name);
        popMenu.add(menuItem[0]);
        menuItem[1] = new JMenuItem(choice2Name);
        popMenu.add(menuItem[1]);
        menuItem[2] = new JMenuItem(choice3Name);
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
        bgPanel[bgNum].add(bgLabel[bgNum]);
    }
    public void generateScreen() {
        // Screen 1
        createBackground(0, "main_bgd.png");
        createObject(0,1200,285,900,700,"house.png","Look","Talk","Rest");
        createObject(0,300,500,100,300,"knight.png","Look","Talk","Attack");
        createObject(0,1150,800,200,100,"chest.png","Look","Talk","Open");
    }
}
