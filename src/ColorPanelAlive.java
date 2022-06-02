import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorPanelAlive extends JPanel {

 private Gameboard gameboard;

    JButton[] colorButtons = {new JButton(""), new JButton(""),
            new JButton(""), new JButton(""), new JButton(""),
            new JButton(""), new JButton(""), new JButton("")};

    Color[] colors = {Color.blue, Color.cyan,
            Color.green, Color.magenta, Color.orange,
            Color.pink, Color.red, Color.yellow};

    ColorPanelAlive(Gameboard gameboard) {
        this.gameboard = gameboard;
        for (int i = 0; i < colorButtons.length; i++) {
            this.colorButtons[i] = colorButtons[i];
            colorButtons[i] = new RoundButton("", 360, true);
            colorButtons[i].setVisible(true);
            add(colorButtons[i]);
            colorButtons[i].addActionListener((ActionListener) this);
            setSize(100, 100);
            setBackground(Color.white);
            setVisible(true);
            colorButtons[i].addActionListener((ActionListener) this);
        }
        colorButtons[0].setBackground(colors[0]);
        colorButtons[1].setBackground(colors[1]);
        colorButtons[2].setBackground(colors[2]);
        colorButtons[3].setBackground(colors[3]);
        colorButtons[4].setBackground(colors[4]);
        colorButtons[5].setBackground(colors[5]);
        colorButtons[6].setBackground(colors[6]);
        colorButtons[7].setBackground(colors[7]);
    }

    class MyDeadColors implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals(colorButtons[0])) {
                gameboard.changeColors(Color.blue);
            } else if (e.getActionCommand().equals(colorButtons[1])) {
                gameboard.changeColors(Color.cyan);
            } else if (e.getActionCommand().equals(colorButtons[2])) {
                gameboard.changeColors(Color.green);
            } else if (e.getActionCommand().equals(colorButtons[3])) {
                gameboard.changeColors(Color.magenta);
            } else if (e.getActionCommand().equals(colorButtons[4])) {
                gameboard.changeColors(Color.orange);
            } else if (e.getActionCommand().equals(colorButtons[5])) {
                gameboard.changeColors(Color.pink);
            } else if (e.getActionCommand().equals(colorButtons[6])) {
                gameboard.changeColors(Color.red);
            } else if (e.getActionCommand().equals(colorButtons[7])) {
                gameboard.changeColors(Color.yellow);
            }
        }
    }

    class MyAliveColors implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals(colorButtons[0])) {
                gameboard.changeColors(Color.blue);
            } else if (e.getActionCommand().equals(colorButtons[1])) {
                gameboard.changeColors(Color.cyan);
            } else if (e.getActionCommand().equals(colorButtons[2])) {
                gameboard.changeColors(Color.green);
            } else if (e.getActionCommand().equals(colorButtons[3])) {
                gameboard.changeColors(Color.magenta);
            } else if (e.getActionCommand().equals(colorButtons[4])) {
                gameboard.changeColors(Color.orange);
            } else if (e.getActionCommand().equals(colorButtons[5])) {
                gameboard.changeColors(Color.pink);
            } else if (e.getActionCommand().equals(colorButtons[6])) {
                gameboard.changeColors(Color.red);
            } else if (e.getActionCommand().equals(colorButtons[7])) {
                gameboard.changeColors(Color.yellow);
            }
        }
    }
}


