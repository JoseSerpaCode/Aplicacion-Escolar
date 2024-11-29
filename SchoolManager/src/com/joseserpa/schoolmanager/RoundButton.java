package com.joseserpa.schoolmanager;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JButton;

/**
 * @author joses
 */

public class RoundButton extends JButton {

    public RoundButton(String string) {
        super(string);
        this.setContentAreaFilled(false);
        this.setFocusPainted(false);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        if (this.getModel().isArmed()) {
            graphics.setColor(Color.gray);
        } else {
            graphics.setColor(this.getBackground());
        }
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.fill(new RoundRectangle2D.Double(0.0, 0.0, this.getWidth(), this.getHeight(), 20.0, 20.0));
        super.paintComponent(graphics);
    }

    @Override
    protected void paintBorder(Graphics graphics) {
        graphics.setColor(this.getForeground());
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.draw(new RoundRectangle2D.Double(0.0, 0.0, this.getWidth() - 1, this.getHeight() - 1, 20.0, 20.0));
    }
}
