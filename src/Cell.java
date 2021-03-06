/**
 * @author Michel Jouaux, Collin Hoss, Lara Mangi
 * @Matrikelnummer: 212455 [mjouaux], 212848 [choss], 212467 [lmangi]
 * @version 1 02.06.2022
 */
import javax.swing.*;
import java.awt.*;

public class Cell extends JPanel {

    private boolean alive = false; // alive or dead

    private int x_pos, y_pos;
    public Color color_alive, color_dead;

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
    public boolean getAlive()
    {
        return alive;
    }
    public Color getColor_alive()
    {
        return color_alive;
    }
    public Color getColor_dead()
    {
        return color_dead;
    }
//---//
    public void setAlive(boolean alive)
    {
        this.alive = alive;
    }
    public void setColor_alive(Color c_alive)
    {
        this.color_alive = c_alive;
        if(alive)setBackground(color_alive);
        else setBackground(color_dead);
    }
    public void setColor_dead(Color c_dead)
    {
        this.color_dead = c_dead;
        if(alive)setBackground(color_alive);
        else setBackground(color_dead);
    }

    public void switchColor()
    {
        Color new_dead = color_alive;

        color_alive = color_dead;
        color_dead = new_dead;

        if(alive)setBackground(color_alive);
        else setBackground(color_dead);
    }

    public void switchAlive() {
        if(alive)
        {
            setBackground(color_dead);
            alive = false;
        }
        else
        {
            setBackground(color_alive);
            alive = true;
        }
    }

}
