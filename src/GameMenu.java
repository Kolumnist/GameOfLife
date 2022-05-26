import javax.swing.*;

public class GameMenu extends JPanel {

    private static JDesktopPane myDesktop;
    static JFrame myFrame = new JFrame();

  /*  static JMenuBar menuBar = new JMenuBar();
    static JMenu[] menu = {
            new JMenu("Modus"), new JMenu("Geschwindigkeit"), new JMenu("Fenster"), new JMenu("Figuren")};
    JMenuItem[] modusMenuItem = {
            new JMenuItem("Laufen"), new JMenuItem("Setzen"), new JMenuItem("Malen")};
    JMenuItem[] geschwindigkeitMenuItem = {
            new JMenuItem(""), new JMenuItem(""), new JMenuItem("")};
    JMenu[] fensterMenu = {
            new JMenu("Farben")};
    JMenuItem[] fensterMenuItem = {
            new JMenuItem("tot"), new JMenuItem("lebendig"), new JMenuItem("wechseln")};
    JMenuItem[] figurenMenuItem = {
            new JMenuItem("Gleiter")};


    GameMenu() {
        for (int i = 0; i <= menu.length - 1; i++) {
            menuBar.add(menu[i]);
        }
        for (int i = 0; i <= modusMenuItem.length - 1; i++) {
            menu[0].add(modusMenuItem[i]);
        }
        for (int i = 0; i <= geschwindigkeitMenuItem.length - 1; i++) {
            menu[1].add(geschwindigkeitMenuItem[i]);
        }
        for (int i = 0; i <= fensterMenu.length - 1; i++) {
            menu[2].add(fensterMenu[i]);
        }
        for (int i = 0; i <= figurenMenuItem.length - 1; i++) {
            menu[3].add(figurenMenuItem[i]);
        }
        for (int i = 0; i <= fensterMenuItem.length - 1; i++) {
            fensterMenu[0].add(fensterMenuItem[i]);
        }
    }

    public static void main(String[] args) {
        JFrame myFrame = new JFrame();
        myFrame.setJMenuBar(menuBar);
        JComponent contentPane = new GameMenu();
        myFrame.setContentPane(contentPane);
        myFrame.pack();
        myFrame.setSize(500, 500);
        myFrame.setVisible(true);
    }*/

    public static void main(String[] args) {
        myDesktop = new JDesktopPane();
        myDesktop.setDesktopManager(new DefaultDesktopManager());
        myFrame.setContentPane(myDesktop);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setSize(1500, 1000);
        myFrame.setLocationRelativeTo(null);
        myFrame.setTitle("Game of Life");
        myFrame.setVisible(true);
        myDesktop.add(new Gameboard());
    }
}
