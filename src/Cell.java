import javax.swing.*;
import java.awt.*;

public class Cell extends JPanel {

    private boolean[] status = {false, false}; // alive, dead, next generation. Maybe as integer

    private int x_pos, y_pos;
    private Color color_alive, color_dead;

    public Cell(int x_pos, int y_pos, Color color_alive, Color color_dead)
    {
        this.x_pos = x_pos;
        this.y_pos = y_pos;
        this.color_alive = color_alive;
        this.color_dead = color_dead;
    }

    public Cell(boolean status, int x_pos, int y_pos, Color color_alive, Color color_dead)
    {
        this.x_pos = x_pos;
        this.y_pos = y_pos;
        this.color_alive = color_alive;
        this.color_dead = color_dead;

    }

    public int getX_pos() {
        return x_pos;
    }
    public int getY_pos() {
        return y_pos;
    }

    public void changeStatus()
    {
        if(status[0] == true && status[1] == true)
        {
            status = new boolean[]{false, false};
        }
        else
        {
            status = new boolean[]{true, true};
        }
    }

}
