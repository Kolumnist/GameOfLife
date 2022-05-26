import javax.swing.*;
import java.awt.*;

public class Cell extends JPanel {

    private boolean alive = false; // alive or dead

    private int x_pos, y_pos;
    private Color color_alive, color_dead;

    public Cell(boolean alive, int x_pos, int y_pos)
    {
        this.alive = alive;
        this.x_pos = x_pos;
        this.y_pos = y_pos;

        color_alive = Color.BLACK;
        color_dead = Color.WHITE;
    }

    public Cell(boolean alive, int x_pos, int y_pos, Color color_alive, Color color_dead)
    {
        this.alive = alive;
        this.x_pos = x_pos;
        this.y_pos = y_pos;
        this.color_alive = color_alive;
        this.color_dead = color_dead;

        setBackground(color_dead);
    }

    public int getX_pos() {
        return x_pos;
    }
    public int getY_pos() {
        return y_pos;
    }

    public void changeAlive(int t_wait) throws InterruptedException {
        if(alive == true)
        {
            setBackground(color_dead);
            alive = false;
        }
        else
        {
            setBackground(color_alive);
            alive = true;
        }
        Thread.sleep(t_wait);
    }

}
