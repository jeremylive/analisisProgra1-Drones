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
public class Connection {

    private int originID;
    private int destinationID;
    private double weight;

    public Connection(int origin, int destination, double weight) {
        this.originID = origin;
        this.destinationID = destination;
        this.weight = weight;
    }

    //Gets and sets
    public int getDestinationID() {
        return destinationID;
    }

    public int getOriginID() {
        return originID;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return originID + "--" + weight + "-->" + destinationID;
    }
}
