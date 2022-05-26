import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;

public class Gameboard extends JInternalFrame {

    enum State
    {
        RUNNING, SETUP, DRAWING;
    }

    private State state;
    private Color[] colors_alive = new Color[8]; // 8 different Colors for now can add some more later
    private Color[] colors_dead = new Color[8]; //for the different colors plus every window has more color

    private Cell[] board_cells = new Cell[64]; //Wird allet nochmal geändert will erstmal was reinsetzen

    private static int title_nr;


    class MouseListener extends MouseAdapter implements Serializable {

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        public void mouseReleased(MouseEvent e)
        {
            if(state == State.SETUP)
            {
                Cell c = (Cell)e.getComponent();

                try {
                    c.changeAlive();
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