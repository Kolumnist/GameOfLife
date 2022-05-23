import javax.swing.*;
import java.awt.*;

public class Gameboard extends JInternalFrame {

    private Color[] colors_alive = new Color[8]; // 8 different Colors for now can add some more later
    private Color[] colors_dead = new Color[8]; //for the different colors plus every window has more color

    private Cell[] board_cells = new Cell[64]; //Wird allet nochmal geändert will erstmal was reinsetzen

    private static int title_nr;

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
                board_cells[i*j] = new Cell(j, i, colors_alive[0], colors_dead[0]);
            }
        }
        for(JPanel panels : board_cells)
        {
            add(panels);
        }

        title_nr++;
        setVisible(true);
    }


}
