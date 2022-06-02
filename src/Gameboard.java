import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;

public class Gameboard extends JInternalFrame implements Runnable {

    enum Figure {
        NOTHING,
        PENTADECATHLON, OKTAGON,
        GLIDER, LIGHT_SPACESHIP, MIDDLE_SPACESHIP, HEAVY_SPACESHIP
    }

    enum State {//The different States the gameboard can be in:
        RUNNING, SETUP, DRAWING
        //-> Running state means the gameboard is currently going through its lifecycle
        //-> Setup state means that with a single mouseclick a cell comes to life or dies
        //-> Drawing state is like Setup but with the mouse only entering a cell
    }

    public Cell[][] board_cells; //The Gameboard is made out of these Cell
    public int t_wait = 8000; //the t_wait = thread_wait is used for the speed of the lifecycle

    private final Lifecycle life;
    private final HardCodingofTheFigures hardFig;
    private final ColorPanelAlive c_p_alive;
    private final ColorPanelDead c_p_dead;
    private final Slider slider;

    private State state = State.SETUP; //This displays the current state of the gameboard
    private Figure figure = Figure.NOTHING;
    private static int title_nr;

    private JMenuBar menuBar = new JMenuBar();
    private JMenu[] menu = {new JMenu("Modus"), new JMenu("Geschwindigkeit"), new JMenu("Fenster"), new JMenu("Figuren"), new JMenu("Fenster leeren")};
    private JMenu[] fensterMenu = {new JMenu("Farben")};
    private JMenu[] farbenMenu = {new JMenu("tot"), new JMenu("lebendig")};
    private JMenu[] figurenMenu = {new JMenu("Pentadecathlon"), new JMenu("Oktagon"), new JMenu("Gleiter"),
            new JMenu("Kleines Raumschiff"), new JMenu("Mittlers Raumschiff"), new JMenu("Schweres Raumschiff")};
    private JMenuItem[]
            modusMenuItem = {new JMenuItem("Laufen"), new JMenuItem("Setzen"), new JMenuItem("Malen")},
            fensterMenuItem = {new JMenuItem("wechseln")},
            fensterLeerenMenuItem = {new JMenuItem("leere")},
            figurenItemPentadecathlon = {new JMenuItem("90°"), new JMenuItem("180°"), new JMenuItem("270°"), new JMenuItem("360°")},
            figurenItemOktagon = {new JMenuItem("90°"), new JMenuItem("180°"), new JMenuItem("270°"), new JMenuItem("360°")},
            figurenItemGleiter = {new JMenuItem("90°"), new JMenuItem("180°"), new JMenuItem("270°"), new JMenuItem("360°")},
            figurenItemLSpaceship = {new JMenuItem("90°"), new JMenuItem("180°"), new JMenuItem("270°"), new JMenuItem("360°")},
            figurenItemMSpaceship = {new JMenuItem("90°"), new JMenuItem("180°"), new JMenuItem("270°"), new JMenuItem("360°")},
            figurenItemHSpaceship = {new JMenuItem("90°"), new JMenuItem("180°"), new JMenuItem("270°"), new JMenuItem("360°")};

    class MouseListener extends MouseAdapter implements Serializable {

        /*Only used when state is DRAWING.
         Handles the drawing*/
        public void mouseEntered(MouseEvent e) {
            if (state == State.DRAWING) {
                Cell c = (Cell) e.getComponent();
                c.switchAlive();
            }
        }

        /*Only used when state is SETUP.
        Handles the clicking and setting of Cells*/
        public void mouseReleased(MouseEvent e) {
            if (state == State.SETUP) {
                Cell c = (Cell) e.getComponent();
                switch(figure)
                {
                    case NOTHING: c.switchAlive(); break;
                    case PENTADECATHLON: hardFig.pentadecathlon(c); figure = Figure.NOTHING; break;
                    case OKTAGON: hardFig.oktagon(c); figure = Figure.NOTHING; break;
                    case GLIDER: hardFig.glider(c); figure = Figure.NOTHING; break;
                    case LIGHT_SPACESHIP: hardFig.lightSpaceship(c); figure = Figure.NOTHING; break;
                    case MIDDLE_SPACESHIP: hardFig.middleSpaceship(c); figure = Figure.NOTHING; break;
                    case HEAVY_SPACESHIP: hardFig.heavySpaceship(c); figure = Figure.NOTHING; break;
                    default : figure = Figure.NOTHING; break;
                }
            }
        }
    }

    private void littleHelper(Color new_color, boolean alive) {
        if (!alive) {
            for (Cell[] board_cell : board_cells) {
                for (int j = 0; j < board_cells[0].length; j++) {
                    board_cell[j].setColor_dead(new_color);
                }
            }
        } else {
            for (Cell[] board_cell : board_cells) {
                for (int j = 0; j < board_cells[0].length; j++) {
                    board_cell[j].setColor_alive(new_color);
                }
            }
        }
    }

    public Gameboard(int width, int height) {
        super("Alive " + title_nr, true, true, true, true);
        //is the width and height of the gameboard(in cells)

        board_cells = new Cell[width][height];

        setLayout(new GridLayout(width, height, 1, 1));
        setBackground(Color.white);
        setSize(640, 640);
        setLocation(50, 50);

        /*board_cells get created for real with mouselistener*/
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                board_cells[i][j] = new Cell(false, i, j, Color.BLUE, Color.CYAN);
                board_cells[i][j].addMouseListener(new MouseListener());
                add(board_cells[i][j]);
            }
        }
        life = new Lifecycle(this);
        hardFig = new HardCodingofTheFigures(board_cells);
        c_p_alive = new ColorPanelAlive(this);
        c_p_dead = new ColorPanelDead(this);
        slider = new Slider(this);

        //region MOTHERFLIPPING GOD OF A MOTHER MAN IS THAT ANNOYING


        //region ActionListener for the different States
        modusMenuItem[0].addActionListener(e -> {
            state = State.RUNNING;
            new Thread(this).start();
        });
        modusMenuItem[1].addActionListener(e -> state = State.SETUP);
        modusMenuItem[2].addActionListener(e -> state = State.DRAWING);
        //endregion

        //region ActionListener for the color management and switching
        for (int i = 0; i < 8; i++) {
            c_p_alive.colorButtons[i].addActionListener(e -> {
                if (e.getSource().equals(c_p_alive.colorButtons[0])) {
                    littleHelper(c_p_alive.colors[0], true);
                } else if (e.getSource().equals(c_p_alive.colorButtons[1])) {
                    littleHelper(c_p_alive.colors[1], true);
                } else if (e.getSource().equals(c_p_alive.colorButtons[2])) {
                    littleHelper(c_p_alive.colors[2], true);
                } else if (e.getSource().equals(c_p_alive.colorButtons[3])) {
                    littleHelper(c_p_alive.colors[3], true);
                } else if (e.getSource().equals(c_p_alive.colorButtons[4])) {
                    littleHelper(c_p_alive.colors[4], true);
                } else if (e.getSource().equals(c_p_alive.colorButtons[5])) {
                    littleHelper(c_p_alive.colors[5], true);
                } else if (e.getSource().equals(c_p_alive.colorButtons[6])) {
                    littleHelper(c_p_alive.colors[6], true);
                } else if (e.getSource().equals(c_p_alive.colorButtons[7])) {
                    littleHelper(c_p_alive.colors[7], true);
                }
            });

            c_p_dead.colorButtons[i].addActionListener(e -> {
                if (e.getSource().equals(c_p_dead.colorButtons[0])) {
                    littleHelper(c_p_dead.colors[0], false);
                } else if (e.getSource().equals(c_p_dead.colorButtons[1])) {
                    littleHelper(c_p_dead.colors[1], false);
                } else if (e.getSource().equals(c_p_dead.colorButtons[2])) {
                    littleHelper(c_p_dead.colors[2], false);
                } else if (e.getSource().equals(c_p_dead.colorButtons[3])) {
                    littleHelper(c_p_dead.colors[3], false);
                } else if (e.getSource().equals(c_p_dead.colorButtons[4])) {
                    littleHelper(c_p_dead.colors[4], false);
                } else if (e.getSource().equals(c_p_dead.colorButtons[5])) {
                    littleHelper(c_p_dead.colors[5], false);
                } else if (e.getSource().equals(c_p_dead.colorButtons[6])) {
                    littleHelper(c_p_dead.colors[6], false);
                } else if (e.getSource().equals(c_p_dead.colorButtons[7])) {
                    littleHelper(c_p_dead.colors[7], false);
                }
            });
        }

        fensterMenuItem[0].addActionListener(e -> {
            for (Cell[] board_cell : board_cells) {
                for (int j = 0; j < board_cells[0].length; j++) {
                    board_cell[j].switchColor();
                }
            }
        });

        fensterLeerenMenuItem[0].addActionListener(e -> {
            for (Cell[] board_cell : board_cells) {
                for (int j = 0; j < board_cells[0].length; j++) {
                    board_cell[j].setAlive(false);
                    board_cell[j].setBackground(board_cell[j].getColor_dead());
                }
            }
        });
        //endregion

        //region ActionListener for the figure management
        figurenItemPentadecathlon[0].addActionListener(e -> figure = Figure.PENTADECATHLON);
        figurenItemOktagon[0].addActionListener(e -> figure = Figure.OKTAGON);
        figurenItemGleiter[0].addActionListener(e -> figure = Figure.GLIDER);
        figurenItemLSpaceship[0].addActionListener(e -> figure = Figure.LIGHT_SPACESHIP);
        figurenItemMSpaceship[0].addActionListener(e -> figure = Figure.MIDDLE_SPACESHIP);
        figurenItemHSpaceship[0].addActionListener(e -> figure = Figure.HEAVY_SPACESHIP);
        //endregion

        setJMenuBar(menuBar);
        for (JMenu jMenu : menu) menuBar.add(jMenu);
        for (JMenuItem jMenuItem : modusMenuItem) menu[0].add(jMenuItem);
        for (int i = 0; i < menu.length; i++) menu[1].add(slider);
        for (JMenu jMenu : fensterMenu) menu[2].add(jMenu);
        for (JMenu jMenu : farbenMenu) fensterMenu[0].add(jMenu);
        for (JMenu jMenu : farbenMenu) jMenu.add(c_p_alive);
        for (JMenu jMenu : figurenMenu) menu[3].add(jMenu);
        for (int i = 0; i < farbenMenu.length; i++) farbenMenu[0].add(c_p_dead);
        for (int i = 0; i < farbenMenu.length; i++) farbenMenu[1].add(c_p_alive);
        for (JMenuItem jMenuItem : figurenItemPentadecathlon) figurenMenu[0].add(jMenuItem);
        for (JMenuItem jMenuItem : figurenItemOktagon) figurenMenu[1].add(jMenuItem);
        for (JMenuItem jMenuItem : figurenItemGleiter) figurenMenu[2].add(jMenuItem);
        for (JMenuItem jMenuItem : figurenItemLSpaceship) figurenMenu[3].add(jMenuItem);
        for (JMenuItem jMenuItem : figurenItemMSpaceship) figurenMenu[4].add(jMenuItem);
        for (JMenuItem jMenuItem : figurenItemHSpaceship) figurenMenu[5].add(jMenuItem);

        fensterMenu[0].add(fensterMenuItem[0]);
        menu[4].add(fensterLeerenMenuItem[0]);

        menuBar.add(Box.createHorizontalGlue());
        menuBar.add(menu[4]);
        //endregion

        title_nr++;
        show();
        setVisible(true);
    }

    /*Calls nextCycle from the responsible lifeCycle object and handles the speed via Thread.sleep*/
    public void run() {
        while (state == State.RUNNING) {
            //System.out.println("Hallo ich funktioniere!");
            life.nextCycle();
            try {
                Thread.sleep(2000 - t_wait);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}