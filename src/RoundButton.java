/**
 * @author Michel Jouaux, Collin Hoss, Lara Mangi
 * @Matrikelnummer: 212455 [mjouaux], 212848 [choss], 212467 [lmangi]
 * @version 1 02.06.2022
 */
import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundButton extends JButton {

        private Shape shape;
        private int arc;
        private boolean isQuadratic;
        private Dimension size;

        public RoundButton(String text, int arc) {
            this(text, arc, true);
        }

        public RoundButton(String text, int arc, boolean isQuadratic) {
            super(text);
            this.arc = arc;
            this.isQuadratic= isQuadratic;

            initComponent();
        }

        private void initComponent() {
            if(isQuadratic) {
                setSize(20,20);
                size = getSize();
                size.width = size.height = Math.max(size.width, size.height);
                setPreferredSize(size);
            }
            setContentAreaFilled(false);
            setFocusable(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);


            g2d.setColor(getModel().isArmed() ? Color.white: getBackground());
            g2d.fill(new RoundRectangle2D.Double(0, 0, getWidth()-1, getHeight()-1, arc, arc));
            super.paintComponent(g);
        }

        @Override
        protected void paintBorder(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

            g2d.setColor(getBackground().darker());
            g2d.draw(new RoundRectangle2D.Double(0, 0, getWidth()-1, getHeight()-1, arc, arc));
        }

        @Override
        public boolean contains( int x, int y ) {
            if(shape == null || !shape.getBounds().equals(getBounds())) {
                this.shape = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), arc, arc);
            }
            return shape.contains(x, y);
        }
    }

