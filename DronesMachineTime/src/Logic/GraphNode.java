package Logic;

/**
 *
 * █▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀█
 * █░░╦─╦╔╗╦─╔╗╔╗╔╦╗╔╗░░█
 * █░░║║║╠─║─║─║║║║║╠─░░█
 * █░░╚╩╝╚╝╚╝╚╝╚╝╩─╩╚╝░░█
 * █▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█
 *
 *
 */
public class GraphNode {

    private int nodeID;
    private int xPosition;
    private int yPosition;

    /**
     * Constructor.
     */
    public GraphNode(int id) {
        this.nodeID = id;
        this.xPosition = 0;
        this.yPosition = 0;
    }

    /**
     *
     * Gets and sets
     *
     *
     */
    public int getNodeID() {
        return nodeID;
    }

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

}
