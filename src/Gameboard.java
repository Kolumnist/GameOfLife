import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;

public class Gameboard extends JInternalFrame implements Runnable {

    enum State {
        RUNNING, SETUP, DRAWING
    } //The different States:
    //-> Running state means the gameboard is currently going through its lifecycle
    //-> Setup state means that with a single mouseclick a cell comes to life or dies
    //-> Drawing state is like Setup but with the mouse only entering a cell

    public State state = State.SETUP; //This displays the current state of the gameboard
    public Cell[][] board_cells = new Cell[8][8]; //The Gameboard is made out of these Cell
    public int t_wait = 2000; //the t_wait = thread_wait is used for the speed of the lifecycle

    private Lifecycle life;
    //private Color[] colors_alive = new Color[8]; // 8 different Colors for now can add some more later
    //private Color[] colors_dead = new Color[8]; //for the different colors plus every window has more color

    private static int title_nr;
    private int width, height; //is the width and height of the gameboard(in cells)

    private JMenuBar menuBar = new JMenuBar();
    private JMenu[] menu = {new JMenu("Modus"), new JMenu("Geschwindigkeit"), new JMenu("Fenster"), new JMenu("Figuren")};
    private JMenu[] fensterMenu = {new JMenu("Farben")};
    private JMenu[] farbenMenu = {new JMenu("tot"), new JMenu("lebendig")};
    private JMenuItem[]
            modusMenuItem = {new JMenuItem("Laufen"), new JMenuItem("Setzen"), new JMenuItem("Malen")},
            geschwindigkeitMenuItem = {new JMenuItem("Standard"), new JMenuItem("Schneller(100)"), new JMenuItem("Langsamer(100)"),
                    new JMenuItem("Schneller(1000)"), new JMenuItem("Langsamer(1000)")},
            fensterMenuItem = {new JMenuItem("wechseln")},
            figurenMenuItem = {new JMenuItem("Gleiter")};
    //totMenuItem = {new JMenuItem("")};

    class MouseListener extends MouseAdapter implements Serializable {

        /*Only used when state is DRAWING. Handles the drawing*/
        public void mouseEntered(MouseEvent e) {
            if (state == State.DRAWING) {
                Cell c = (Cell) e.getComponent();
                c.changeAlive();
            }
        }

        /*Only used when state is SETUP. Handles the clicking and setting of Cells*/
        public void mouseReleased (MouseEvent e){
            if (state == State.SETUP) {
                Cell c = (Cell) e.getComponent();
                c.changeAlive();
            }
        }
    }

    public Gameboard(int width, int height) {
        super("Alive " + title_nr, true, true, true, true);
        this.width = width;
        this.height = height;

        setLayout(new GridLayout(this.width, this.height, 1, 1));
        setBackground(Color.white);
        setSize(640, 640);
        setLocation(50, 50);

        /*board_cells get created for real with mouselistener*/
        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {
                board_cells[i][j] = new Cell(false, i, j, /*colors_alive[0]*/ Color.BLUE, /*colors_dead[0]*/ Color.CYAN);
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
        geschwindigkeitMenuItem[1].addActionListener(e -> {
            if (t_wait > 100) t_wait -= 100;
        });
        geschwindigkeitMenuItem[2].addActionListener(e -> {
            if (t_wait < 10000) t_wait += 100;
        });
        geschwindigkeitMenuItem[3].addActionListener(e -> {
            if (t_wait > 1000) t_wait -= 1000;
        });
        geschwindigkeitMenuItem[4].addActionListener(e -> {
            if (t_wait < 10000) t_wait += 1000;
        });

        setJMenuBar(menuBar);
        for (int i = 0; i < menu.length; i++) menuBar.add(menu[i]);
        for (int i = 0; i < modusMenuItem.length; i++) menu[0].add(modusMenuItem[i]);
        for (int i = 0; i < geschwindigkeitMenuItem.length; i++) menu[1].add(geschwindigkeitMenuItem[i]);
        for (int i = 0; i < fensterMenu.length; i++) menu[2].add(fensterMenu[i]);
        for (int i = 0; i < farbenMenu.length; i++) fensterMenu[0].add(farbenMenu[i]);
        for (int i = 0; i < farbenMenu.length; i++) farbenMenu[i].add(new ColorPanel());
        for (int i = 0; i < figurenMenuItem.length; i++) menu[3].add(figurenMenuItem[i]);
        for (int i = 0; i < fensterMenuItem.length; i++) fensterMenu[0].add(fensterMenuItem[0]);

        //endregion

        title_nr++;
        show();
        setVisible(true);
    }

    /*Calls nextCycle from the responsible lifeCycle object and handles the speed via Thread.sleep*/
    public void run() {
        while (state == State.RUNNING) {
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