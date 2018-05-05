package Interface;

import Program.IConstants;
import java.awt.Graphics;

/**
 *
 * █▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀█ █░░╦─╦╔╗╦─╔╗╔╗╔╦╗╔╗░░█ █░░║║║╠─║─║─║║║║║╠─░░█
 * █░░╚╩╝╚╝╚╝╚╝╚╝╩─╩╚╝░░█ █▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█
 *
 *
 */
public class Circle {

    private int xPosition = 0;
    private int yPosition = 0;

    /**
     * Constructor.
     *
     * @param pXPos X position where the circle will be drawn.
     * @param pYPos Y position where the circle will be drawn.
     *
     */
    public Circle(int pXPos, int pYPos) {
        this.setxPosition(pXPos);
        this.setyPosition(pYPos);
    }

    /**
     * Gets and Sets
     *
     */
    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    /**
     * Draw circle.
     *
     * @param g
     *
     */
    public void draw(Graphics g) {
        g.drawOval(getxPosition(), getyPosition(), IConstants.CIRCLE_DIAMETER, IConstants.CIRCLE_DIAMETER);
    }
     
}
