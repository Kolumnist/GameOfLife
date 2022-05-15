import javax.swing.*;
import java.awt.*;

public class Cell extends JPanel {

    private boolean[] status = {false, false}; // alive, dead, next generation. Maybe as integer

    private Color[] color = new Color[8]; // 8 different Colors for now can add some more later
    private int x_pos, y_pos;

    public Cell(int x_pos, int y_pos)
    {
        this.x_pos = x_pos;
        this.y_pos = y_pos;
    }

    public Cell(boolean status, int x_pos, int y_pos)
    {

        setBackground(Color.white);
    }


    public int getX_pos() {
        return x_pos;
    }
    public int getY_pos() {
        return y_pos;
    }

}
