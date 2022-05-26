import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;

public class Gameboard extends JInternalFrame implements Runnable {

    enum State
    {
        RUNNING, SETUP, DRAWING
    }

    private Lifecycle life;
    private Color[] colors_alive = new Color[8]; // 8 different Colors for now can add some more later
    private Color[] colors_dead = new Color[8]; //for the different colors plus every window has more color

    public State state = State.SETUP;
    public Cell[][] board_cells = new Cell[8][8]; //Wird allet nochmal geändert will erstmal was reinsetzen
    public int t_wait = 2000;

    private static int title_nr;
    private int width, height;

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
                c.changeAlive();
            }
        }

        public void mouseReleased(MouseEvent e)
        {
            if(state == State.SETUP)
            {
                Cell c = (Cell)e.getComponent();
                c.changeAlive();
            }
        }
    }

    public Gameboard()
    {
        super("Alive " + title_nr, true, true, true, true);
        setLayout(new GridLayout(8, 8));
        setBackground(Color.BLACK);
        setSize(640, 640);
        setLocation(50, 50);

        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
                board_cells[i][j] = new Cell(false, i, j, /*colors_alive[0]*/ Color.BLUE, /*colors_dead[0]*/ Color.CYAN);;
                board_cells[i][j].addMouseListener(new MouseListener());
                add(board_cells[i][j]);
            }
        }
        life = new Lifecycle(this);

        //region MOTHERFLIPPING GOD OF A MOTHER MAN IS THAT ANNOYING

        modusMenuItem[0].addActionListener(e -> {
            state = State.RUNNING;
            new Thread(this).start();
        });
        modusMenuItem[1].addActionListener(e -> state = State.SETUP);
        modusMenuItem[2].addActionListener(e -> state = State.DRAWING);

        geschwindigkeitMenuItem[0].addActionListener(e -> t_wait = 2000);
        geschwindigkeitMenuItem[1].addActionListener(e -> {if(t_wait > 100) t_wait -= 100;});
        geschwindigkeitMenuItem[2].addActionListener(e -> {if(t_wait < 10000) t_wait += 100;});
        geschwindigkeitMenuItem[3].addActionListener(e -> {if(t_wait > 1000) t_wait -= 1000;});
        geschwindigkeitMenuItem[4].addActionListener(e -> {if(t_wait < 10000) t_wait += 1000;});

        setJMenuBar(menuBar);
        for (int i = 0; i < menu.length; i++) menuBar.add(menu[i]);
        for (int i = 0; i < modusMenuItem.length; i++) menu[0].add(modusMenuItem[i]);
        for (int i = 0; i < geschwindigkeitMenuItem.length; i++) menu[1].add(geschwindigkeitMenuItem[i]);
        for (int i = 0; i < fensterMenu.length; i++) menu[2].add(fensterMenu[i]);
        for (int i = 0; i < figurenMenuItem.length; i++) menu[3].add(figurenMenuItem[i]);
        for (int i = 0; i < fensterMenuItem.length; i++) fensterMenu[0].add(fensterMenuItem[i]);

        //endregion

        title_nr++;
        show();
        setVisible(true);
    }

    public void run()
    {
        while(state == State.RUNNING)
        {
            System.out.println("Hallo ich funktioniere!");
            life.nextCycle();
            try {
                Thread.sleep(t_wait);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}