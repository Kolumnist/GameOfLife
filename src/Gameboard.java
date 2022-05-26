import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;

public class Gameboard extends JInternalFrame {

    enum State
    {
        RUNNING, SETUP, DRAWING;
    }

    private Color[] colors_alive = new Color[8]; // 8 different Colors for now can add some more later
    private Color[] colors_dead = new Color[8]; //for the different colors plus every window has more color

    public State state = State.SETUP;
    public Cell[][] board_cells = new Cell[8][8]; //Wird allet nochmal geändert will erstmal was reinsetzen

    private int t_wait = 2000;

    private static int title_nr;

    private JMenuBar menuBar = new JMenuBar();
    private JMenu[] menu = {new JMenu("Modus"), new JMenu("Geschwindigkeit"), new JMenu("Fenster"), new JMenu("Figuren")};
    private JMenu[] fensterMenu = {new JMenu("Farben")};
    private JMenuItem[]
            modusMenuItem = {new JMenuItem("Laufen"), new JMenuItem("Setzen"), new JMenuItem("Malen")},
            geschwindigkeitMenuItem = {new JMenuItem("Standard"), new JMenuItem("Schneller(100)"), new JMenuItem("Langsamer(100)"),
                    new JMenuItem("Schneller(1000)"), new JMenuItem("Langsamer(1000)")},
            fensterMenuItem = {new JMenuItem("tot"), new JMenuItem("lebendig"), new JMenuItem("wechseln")},
            figurenMenuItem = {new JMenuItem("Gleiter")};

    class MouseListener extends MouseAdapter implements Serializable {
        public void mouseEntered(MouseEvent e) {
            if(state == State.DRAWING)
            {
                Cell c = (Cell)e.getComponent();
                try {
                    c.changeAlive(t_wait);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }

        public void mouseReleased(MouseEvent e)
        {
            if(state == State.SETUP)
            {
                Cell c = (Cell)e.getComponent();
                try {
                    c.changeAlive(t_wait);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public Gameboard()
    {
        setTitle("Alive " + title_nr);
        setLayout(new GridLayout(8, 8));
        setBackground(Color.BLACK);

        // ***

        setJMenuBar(menuBar);
        for (int i = 0; i < menu.length; i++) menuBar.add(menu[i]);
        for (int i = 0; i < modusMenuItem.length; i++) menu[0].add(modusMenuItem[i]);
        for (int i = 0; i < geschwindigkeitMenuItem.length; i++) menu[1].add(geschwindigkeitMenuItem[i]);
        for (int i = 0; i < fensterMenu.length; i++) menu[2].add(fensterMenu[i]);
        for (int i = 0; i < figurenMenuItem.length; i++) menu[3].add(figurenMenuItem[i]);
        for (int i = 0; i < fensterMenuItem.length; i++) fensterMenu[0].add(fensterMenuItem[i]);

        menu[0].addActionListener(e -> {
            if (modusMenuItem[0].equals(e.getSource())) state = State.RUNNING;
            else if (modusMenuItem[1].equals(e.getSource())) state = State.SETUP;
            else if (modusMenuItem[2].equals(e.getSource())) state = State.DRAWING;
        });
        menu[1].addActionListener(e -> {
            if(geschwindigkeitMenuItem[0].equals(e.getSource())) t_wait = 2000;
            else if (geschwindigkeitMenuItem[1].equals(e.getSource()) && t_wait > 100) t_wait -= 100;
            else if (geschwindigkeitMenuItem[2].equals(e.getSource()) && t_wait > 10000) t_wait += 100;
            else if (geschwindigkeitMenuItem[3].equals(e.getSource()) && t_wait > 100) t_wait -= 1000;
            else if (geschwindigkeitMenuItem[4].equals(e.getSource()) && t_wait > 10000) t_wait += 1000;
        });

        //***

        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
                board_cells[j][i] = new Cell(false, j, i, /*colors_alive[0]*/ Color.BLUE, /*colors_dead[0]*/ Color.CYAN);;
                board_cells[j][i].addMouseListener(new MouseListener());
                add(board_cells[j][i]);
            }
        }

        title_nr++;
        setVisible(true);
    }
}