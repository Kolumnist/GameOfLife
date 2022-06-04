/**
 * @author Michel Jouaux, Collin Hoss, Lara Mangi
 * @Matrikelnummer: 212455 [mjouaux], 212848 [choss], 212467 [lmangi]
 * @version 1 02.06.2022
 */

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundButton extends JButton {

    private int arc;
    private boolean isQuadratic;
    private Dimension size;


    // Constructor which calls the method initComponent
    public RoundButton(String text, int arc, boolean isQuadratic) {
        super(text);
        this.arc = arc;
        this.isQuadratic = isQuadratic;

        initComponent();
    }


    // This method checks if boolean isQuadratic is true or false
    // If its true then the button get a selected size
    private void initComponent() {
        if (isQuadratic) {
            setSize(20, 20);
            size = getSize();
            size.width = size.height = Math.max(size.width, size.height);
            setPreferredSize(size);
        }
        setContentAreaFilled(false);
        setFocusable(false);
    }

    // This methode paint the inside of a button
    // if a button gets clicked the inside of the button will turned white for a moment
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        // blend the existed colors of pixel along the boundary of a button.
        // So we won't get reduce aliasing along the edges of shapes.
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // the selection between speed and quality of a Rendering should lay on the quality
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setColor(getModel().isArmed() ? Color.white : getBackground());
        g2d.fill(new RoundRectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1, arc, arc));
    }


    // This methode paint the border of a button
    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        // blend the existed colors of pixel along the boundary of a button.
        // So we won't get reduce aliasing along the edges of shapes.
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // the selection between speed and quality of a Rendering should lay on the quality
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setColor(getBackground().darker());
        g2d.draw(new RoundRectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1, arc, arc));
    }
}

