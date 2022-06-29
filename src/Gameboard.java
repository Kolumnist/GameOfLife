/**
 * @author Michel Jouaux, Collin Hoss, Lara Mangi
 * @Matrikelnummer: 212455 [mjouaux], 212848 [choss], 212467 [lmangi]
 * @version 1 02.06.2022
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;

public class Gameboard extends JInternalFrame implements Runnable {

    enum Figure {//All different Figures that can be set into the gameboard:
        NOTHING,
        OKTAGON, PENTADECATHLON_HORIZONTALLY, PENTADECATHLON_VERTICALLY,//Oscillators
        GLIDER_DOWN, GLIDER_RIGHT, GLIDER_UP, GLIDER_LEFT,//All Glider versions
        LIGHT_SPACESHIP_DOWN, LIGHT_SPACESHIP_UP, //All Light Spaceship versions
        MIDDLE_SPACESHIP_DOWN, MIDDLE_SPACESHIP_UP, //All Middle Spaceship versions
        HEAVY_SPACESHIP_RIGHT, HEAVY_SPACESHIP_LEFT //All Heavy Spaceship versions
    }

    enum State {//All different States the gameboard can be in:
        RUNNING, //-> the gameboard is currently going through its lifecycle
        SETUP, //-> With a single mouseclick a cell comes to life or dies
        DRAWING //-> When the mouse is entering that cells come to life or dies
    }

    public Cell[][] board_cells; //The Gameboard is made out of these Cell
    public int stop = 0;
    public int t_wait = 1500; //the t_wait = thread_wait is used for the speed of the lifecycle

    private final Lifecycle life;
    private final HardCodingofTheFigures hardFig;
    private final ColorPanelAlive c_p_alive;
    private final ColorPanelDead c_p_dead;
    private final Slider slider;

    private State state = State.SETUP; //This saves the current state of the gameboard
    private Figure figure = Figure.NOTHING;//This saves the current figure selected
    private static int title_nr;

    private JMenuBar menuBar = new JMenuBar();
    private JMenu[] menu = {new JMenu("Modus"), new JMenu("Geschwindigkeit"), new JMenu("Fenster"), new JMenu("Figuren"), new JMenu("Fenster leeren")};
    private JMenu[] fensterMenu = {new JMenu("Farben")};
    private JMenu[] farbenMenu = {new JMenu("tot"), new JMenu("lebendig")};
    private JMenu[] figurenMenu = {new JMenu("Oktagon"), new JMenu("Pentadecathlon"), new JMenu("Gleiter"),
            new JMenu("Kleines Raumschiff"), new JMenu("Mittlers Raumschiff"), new JMenu("Schweres Raumschiff")};
    private JMenuItem[]
            modusMenuItem = {new JMenuItem("Laufen"), new JMenuItem("Setzen"), new JMenuItem("Malen")},
            fensterMenuItem = {new JMenuItem("wechseln")},
            fensterLeerenMenuItem = {new JMenuItem("leere")},
            figurenItemOktagon = {new JMenuItem("go")},
            figurenItemPentadecathlon = {new JMenuItem("horizontal"), new JMenuItem("vertikal")},
            figurenItemGleiter = {new JMenuItem("down"), new JMenuItem("right"), new JMenuItem("up"), new JMenuItem("left")},
            figurenItemLSpaceship = {new JMenuItem("down"), new JMenuItem("up")},
            figurenItemMSpaceship = {new JMenuItem("down"), new JMenuItem("up")},
            figurenItemHSpaceship = {new JMenuItem("down"), new JMenuItem("up")};

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

                //switch case checks for the current figure
                switch(figure)
                {
                    case NOTHING: c.switchAlive(); break;
                    case OKTAGON: hardFig.oktagon(c); figure = Figure.NOTHING; break;

                    case PENTADECATHLON_HORIZONTALLY: hardFig.pentadecathlonHorizontal(c); figure = Figure.NOTHING; break;
                    case PENTADECATHLON_VERTICALLY: hardFig.pentadecathlonVertical(c); figure = Figure.NOTHING; break;

                    case GLIDER_DOWN: hardFig.gliderDown(c); figure = Figure.NOTHING; break;
                    case GLIDER_RIGHT: hardFig.gliderRight(c); figure = Figure.NOTHING; break;
                    case GLIDER_UP: hardFig.gliderUp(c); figure = Figure.NOTHING; break;
                    case GLIDER_LEFT: hardFig.gliderLeft(c); figure = Figure.NOTHING; break;

                    case LIGHT_SPACESHIP_DOWN: hardFig.lightSpaceshipDown(c); figure = Figure.NOTHING; break;
                    case LIGHT_SPACESHIP_UP: hardFig.lightSpaceshipUp(c); figure = Figure.NOTHING; break;

                    case MIDDLE_SPACESHIP_DOWN: hardFig.middleSpaceshipDown(c); figure = Figure.NOTHING; break;
                    case MIDDLE_SPACESHIP_UP: hardFig.middleSpaceshipUp(c); figure = Figure.NOTHING; break;

                    case HEAVY_SPACESHIP_RIGHT: hardFig.heavySpaceshipRight(c); figure = Figure.NOTHING; break;
                    case HEAVY_SPACESHIP_LEFT: hardFig.heavySpaceshipLeft(c); figure = Figure.NOTHING; break;
                    default : figure = Figure.NOTHING; break;
                }
            }
        }
    }

    /*Just a tiny method to make a part of the code smaller -> changes the color*/
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

        board_cells = new Cell[width][height];
        c_p_alive = new ColorPanelAlive();
        c_p_dead = new ColorPanelDead();

        setLayout(new GridLayout(width, height, 1, 1));
        setBackground(Color.white);
        setSize(640, 640);
        setLocation(50, 50);

        /*board_cells get created for real with mouseListener*/
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                board_cells[i][j] = new Cell(false, i, j, c_p_alive.colors[0], c_p_dead.colors[4]);
                board_cells[i][j].addMouseListener(new MouseListener());
                add(board_cells[i][j]);
            }
        }
        life = new Lifecycle(this);
        hardFig = new HardCodingofTheFigures(board_cells);
        slider = new Slider(this);

        //region A LOT of ActionListeners for the GuI and other GuI stuff

        //region ActionListener for the different States
        modusMenuItem[0].addActionListener(e -> {
            state = State.RUNNING;
            if(stop <= 1) new Thread(this).start();
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
        figurenItemOktagon[0].addActionListener(e -> figure = Figure.OKTAGON);

        figurenItemPentadecathlon[0].addActionListener(e -> figure = Figure.PENTADECATHLON_HORIZONTALLY);
        figurenItemPentadecathlon[1].addActionListener(e -> figure = Figure.PENTADECATHLON_VERTICALLY);

        figurenItemGleiter[0].addActionListener(e -> figure = Figure.GLIDER_DOWN);
        figurenItemGleiter[1].addActionListener(e -> figure = Figure.GLIDER_RIGHT);
        figurenItemGleiter[2].addActionListener(e -> figure = Figure.GLIDER_UP);
        figurenItemGleiter[3].addActionListener(e -> figure = Figure.GLIDER_LEFT);

        figurenItemLSpaceship[0].addActionListener(e -> figure = Figure.LIGHT_SPACESHIP_DOWN);
        figurenItemLSpaceship[1].addActionListener(e -> figure = Figure.LIGHT_SPACESHIP_UP);

        figurenItemMSpaceship[0].addActionListener(e -> figure = Figure.MIDDLE_SPACESHIP_DOWN);
        figurenItemMSpaceship[1].addActionListener(e -> figure = Figure.MIDDLE_SPACESHIP_UP);

        figurenItemHSpaceship[0].addActionListener(e -> figure = Figure.HEAVY_SPACESHIP_RIGHT);
        figurenItemHSpaceship[1].addActionListener(e -> figure = Figure.HEAVY_SPACESHIP_LEFT);
        //endregion

        //region Adding all menu stuff to the menuBar
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
        for (JMenuItem jMenuItem : figurenItemOktagon) figurenMenu[0].add(jMenuItem);
        for (JMenuItem jMenuItem : figurenItemPentadecathlon) figurenMenu[1].add(jMenuItem);
        for (JMenuItem jMenuItem : figurenItemGleiter) figurenMenu[2].add(jMenuItem);
        for (JMenuItem jMenuItem : figurenItemLSpaceship) figurenMenu[3].add(jMenuItem);
        for (JMenuItem jMenuItem : figurenItemMSpaceship) figurenMenu[4].add(jMenuItem);
        for (JMenuItem jMenuItem : figurenItemHSpaceship) figurenMenu[5].add(jMenuItem);
        fensterMenu[0].add(fensterMenuItem[0]);
        menu[4].add(fensterLeerenMenuItem[0]);
        menuBar.add(Box.createHorizontalGlue());
        menuBar.add(menu[4]);
        //endregion

        //endregion

        title_nr++;
        show();
        setVisible(true);
    }

    /*Calls nextCycle from the responsible lifeCycle object and handles the speed via Thread.sleep*/
    public void run() {
        while (state == State.RUNNING) {
            stop++;
            //System.out.println("Hallo ich funktioniere!");
            life.nextCycle();
            try {
                Thread.sleep(2000 - t_wait);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        stop = 0;
    }

}