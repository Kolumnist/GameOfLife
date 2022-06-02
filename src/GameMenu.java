import javax.swing.*;
import java.awt.*;

public class GameMenu extends JPanel {

    private static JDesktopPane myDesktop;
    private static JComboBox gridList;
    static JFrame myFrame = new JFrame();
    static JButton drückMich = new JButton("Create new board!");
    private Gameboard gameboard;

    public GameMenu() {
        drückMich.setSize(200, 50);
        drückMich.setFont(new Font("Arial", Font.BOLD, 18));
        drückMich.setBackground(Color.BLUE);
        drückMich.setForeground(Color.white);
        drückMich.setLocation(650, 475);
        drückMich.setVisible(true);
        // drückMich.addActionListener(this);
        gridList = new JComboBox(new String[]{"8x8", "16x16", "24x24", "32x32", "64x64"});
        gridList.setSelectedIndex(4);
        gridList.setVisible(true);
        gridList.setSize(200, 20);
        gridList.setLocation(650, 525);
        drückMich.addActionListener(e -> {
            switch (gridList.getSelectedIndex()) {
                case 0:
                    gameboard = new Gameboard(8, 8);
                    myDesktop.add(gameboard);
                    break;
                case 1:
                    gameboard = new Gameboard(16, 16);
                    myDesktop.add(gameboard);
                    break;
                case 2:
                    gameboard = new Gameboard(24, 24);
                    myDesktop.add(gameboard);
                    break;
                case 3:
                    gameboard = new Gameboard(32, 32);
                    myDesktop.add(gameboard);
                    break;
                case 4:
                    gameboard = new Gameboard(64, 64);
                    myDesktop.add(gameboard);
                    break;
                default:
                    System.out.println("Wow! How did you do this? That shouldn't be possible!");
            }
        });
    }

    public static void main(String[] args) {
        new GameMenu();
        myDesktop = new JDesktopPane();
        myDesktop.setDesktopManager(new DefaultDesktopManager());
        myFrame.setContentPane(myDesktop);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setSize(1500, 1000);
        myFrame.setLocationRelativeTo(null);
        myFrame.setTitle("Game of Life");
        myFrame.add(gridList);
        myFrame.add(drückMich);
        myFrame.setVisible(true);
    }
}

