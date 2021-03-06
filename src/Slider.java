/**
 * @author Michel Jouaux, Collin Hoss, Lara Mangi
 * @Matrikelnummer: 212455 [mjouaux], 212848 [choss], 212467 [lmangi]
 * @version 1 02.06.2022
 */
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Slider extends JPanel implements ChangeListener {

    private Gameboard gameboard;
    private JTextField slidertext;
    private JSlider source;

    public Slider(Gameboard gameboard) {
        this.gameboard = gameboard;
        JSlider mySlider = new JSlider(SwingConstants.HORIZONTAL, 0, 2000, gameboard.t_wait);
        mySlider.setMajorTickSpacing(200);
        mySlider.setMinorTickSpacing(50);
        mySlider.setPaintTicks(true);
        mySlider.setPaintLabels(true);
        mySlider.setPreferredSize(new Dimension(500, 100));
        mySlider.addChangeListener(this);
        mySlider.setToolTipText("Geschwindigkeitsregler");
        slidertext = new JTextField(5);
        slidertext.setText(mySlider.getValue() + " ");
        slidertext.setToolTipText("Ergebnis");
        slidertext.setVisible(true);
        slidertext.setEditable(false);
        add(slidertext);
        add(mySlider);
        setVisible(true);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        source = (JSlider) e.getSource();
        if (!source.getValueIsAdjusting())
            slidertext.setText(source.getValue() + " ");
        gameboard.t_wait = source.getValue();
    }

}
