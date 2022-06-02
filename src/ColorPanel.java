import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorPanel extends Cell {

    JButton[] colorButtons = {new JButton(""), new JButton(""),
            new JButton(""), new JButton(""), new JButton(""),
            new JButton(""), new JButton(""), new JButton("")};

    Color[] colors = {Color.blue, Color.cyan,
            Color.green, Color.magenta, Color.orange,
            Color.pink, Color.red, Color.yellow};

    ColorPanel() {
        super();
        int i;
        for (i = 0; i < colorButtons.length; i++) {
            colorButtons[i] = new RoundButton("", 360, true);
            colorButtons[0].setBackground(colors[0]);
            colorButtons[1].setBackground(colors[1]);
            colorButtons[2].setBackground(colors[2]);
            colorButtons[3].setBackground(colors[3]);
            colorButtons[4].setBackground(colors[4]);
            colorButtons[5].setBackground(colors[5]);
            colorButtons[6].setBackground(colors[6]);
            colorButtons[7].setBackground(colors[7]);
            colorButtons[i].setVisible(true);
            add(colorButtons[i]);
            setSize(100, 100);
            setBackground(Color.white);
            setVisible(true);
            colorButtons[i].addActionListener((ActionListener) this);
        }
    }

    class MyDeadColors implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals(colorButtons[0])) {
                setColor_dead(Color.blue);
            } else if (e.getActionCommand().equals(colorButtons[1])) {
                setColor_dead(Color.cyan);
            } else if (e.getActionCommand().equals(colorButtons[2])) {
                setColor_dead(Color.green);
            } else if (e.getActionCommand().equals(colorButtons[3])) {
                setColor_dead(Color.magenta);
            } else if (e.getActionCommand().equals(colorButtons[4])) {
                setColor_dead(Color.orange);
            } else if (e.getActionCommand().equals(colorButtons[5])) {
                setColor_dead(Color.pink);
            } else if (e.getActionCommand().equals(colorButtons[6])) {
                setColor_dead(Color.red);
            } else if (e.getActionCommand().equals(colorButtons[7])) {
                setColor_dead(Color.yellow);
            }
        }
    }

    class MyAliveColors implements ActionListener {
            public void actionPerformed (ActionEvent e){
                if (e.getActionCommand().equals(colorButtons[0])) {
                    setColor_alive(Color.blue);
                } else if (e.getActionCommand().equals(colorButtons[1])) {
                    setColor_alive(Color.cyan);
                } else if (e.getActionCommand().equals(colorButtons[2])) {
                    setColor_alive(Color.green);
                } else if (e.getActionCommand().equals(colorButtons[3])) {
                    setColor_alive(Color.magenta);
                } else if (e.getActionCommand().equals(colorButtons[4])) {
                    setColor_alive(Color.orange);
                } else if (e.getActionCommand().equals(colorButtons[5])) {
                    setColor_alive(Color.pink);
                } else if (e.getActionCommand().equals(colorButtons[6])) {
                    setColor_alive(Color.red);
                } else if (e.getActionCommand().equals(colorButtons[7])) {
                    setColor_alive(Color.yellow);
                }
            }
        }
}


