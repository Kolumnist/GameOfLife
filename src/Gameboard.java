import javax.swing.*;
import java.awt.*;

public class Gameboard extends JInternalFrame {

    private Cell[] board_cells = new Cell[64]; //Wird allet nochmal geändert will erstmal was reinsetzen
    private int title_nr;

    public Gameboard()
    {
        setTitle("Alive " + title_nr);
        setLayout(new GridLayout(8, 8));
        setBackground(Color.BLACK);
        setVisible(true);
    }


}
