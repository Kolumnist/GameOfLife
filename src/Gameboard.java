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

    private State state = State.SETUP;
    private Color[] colors_alive = new Color[8]; // 8 different Colors for now can add some more later
    private Color[] colors_dead = new Color[8]; //for the different colors plus every window has more color

    private Cell[] board_cells = new Cell[64]; //Wird allet nochmal geändert will erstmal was reinsetzen

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

        //setJMenuBar();
        for (int i = 0; i <= menu.length - 1; i++) menuBar.add(menu[i]);
        for (int i = 0; i <= modusMenuItem.length - 1; i++) menu[0].add(modusMenuItem[i]);
        for (int i = 0; i <= geschwindigkeitMenuItem.length - 1; i++) menu[1].add(geschwindigkeitMenuItem[i]);
        for (int i = 0; i <= fensterMenu.length - 1; i++) menu[2].add(fensterMenu[i]);
        for (int i = 0; i <= figurenMenuItem.length - 1; i++) menu[3].add(figurenMenuItem[i]);
        for (int i = 0; i <= fensterMenuItem.length - 1; i++) fensterMenu[0].add(fensterMenuItem[i]);

        menu[0].addActionListener(e -> {
            JMenuItem source = (JMenuItem)e.getSource();
            if (modusMenuItem[0].equals(source)) state = State.RUNNING;
            else if (modusMenuItem[1].equals(source)) state = State.SETUP;
            else if (modusMenuItem[2].equals(source)) state = State.DRAWING;
        });
        menu[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(geschwindigkeitMenuItem[0].equals(e.getSource())) t_wait -= 100;
            }
        });

        //***

        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
                board_cells[i*j] = new Cell(false ,j, i, colors_alive[0], colors_dead[0]);
            }
        }
        for(JPanel panels : board_cells)
        {
            panels.addMouseListener(new MouseListener());
            add(panels);
        }

        title_nr++;
        setVisible(true);
    }
}