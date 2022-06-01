import javax.swing.*;
import java.awt.*;

public class ColorPanel extends JPanel {

    JButton[] colorButtons = {new JButton(""), new JButton(""),
            new JButton(""), new JButton(""), new JButton(""),
            new JButton(""), new JButton(""), new JButton("")};

    Color[] colors = {Color.blue, Color.cyan,
            Color.green, Color.magenta, Color.orange,
            Color.pink, Color.red, Color.yellow};

    ColorPanel() {

        for (int i = 0; i < colorButtons.length; i++) {
            colorButtons[i] = new RoundButton("", 360, true);
            add(colorButtons[i]);
            colorButtons[i].setVisible(true);
            setSize(100, 100);
            setBackground(Color.white);
            setVisible(true);
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
}
 /*
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JComponent contentPane = new ColorPanel();
        f.setContentPane(contentPane);

        f.pack();
        f.setSize(100, 100);
        f.setVisible(true);
    }
}*/
