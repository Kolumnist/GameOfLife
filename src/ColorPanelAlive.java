/**
 * @author Michel Jouaux, Collin Hoss, Lara Mangi
 * @Matrikelnummer: 212455 [mjouaux], 212848 [choss], 212467 [lmangi]
 * @version 1 02.06.2022
 */
import javax.swing.*;
import java.awt.*;


public class ColorPanelAlive extends JPanel {

    // create rgb colors
    Color midnightblue = new Color(25,25,112);
    Color aquamarine = new Color(127,255,212);
    Color salmon = new Color(250,140,105);
    Color darkred = new Color(139,0,0);
    Color darkslategray = new Color(47,79,79);
    Color darkolivegreen2 = new Color(188,238,104);
    Color orchid = new Color(218,112,214);
    Color darkgoldenrod = new Color(139,101,8);

    // create an button array and save buttons in there (for the later color buttons)
    JButton[] colorButtons = {new JButton(""), new JButton(""),
            new JButton(""), new JButton(""), new JButton(""),
            new JButton(""), new JButton(""), new JButton("")};

    // create array and save the rgb colors in there
    Color[] colors = {darkgoldenrod, orchid,
            darkolivegreen2, midnightblue, aquamarine,
            darkred, darkslategray, salmon};


    ColorPanelAlive() {
        for (int i = 0; i < colorButtons.length; i++) {
            this.colorButtons[i] = colorButtons[i];
            // call the class RoundButton so that every button in the buttonarray gets round
            colorButtons[i] = new RoundButton("", 360, true);
            colorButtons[i].setVisible(true);
            add(colorButtons[i]);
            setSize(100, 100);
            setBackground(Color.white);
            setVisible(true);
        }
        // set all the buttons in the color of the selected color array
        colorButtons[0].setBackground(colors[0]);
        colorButtons[1].setBackground(colors[1]);
        colorButtons[2].setBackground(colors[2]);
        colorButtons[3].setBackground(colors[3]);
        colorButtons[4].setBackground(colors[4]);
        colorButtons[5].setBackground(colors[5]);
        colorButtons[6].setBackground(colors[6]);
        colorButtons[7].setBackground(colors[7]);
    }
}


