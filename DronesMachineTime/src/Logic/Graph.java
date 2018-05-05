package Logic;

import Libraries.Dijkstra;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
public class Graph {

    private List<GraphNode> nodes;
    private List<Connection> connections;
    private Dijkstra dijkstra;

    /**
     * Constructor.
     */
    public Graph() {
        nodes = new ArrayList<>();
        connections = new ArrayList<>();
        dijkstra = new Dijkstra();
    }

    /**
     * Gets and Sets
     *
     */
    public List<GraphNode> getNodes() {
        return nodes;
    }

    public List<Connection> getConnections() {
        return connections;
    }

    /**
     * Add nodo to list
     *
     * @param node GraphNode to be insert.
     */
    public void addNode(GraphNode node) {
        nodes.add(node);
    }

    /**
     * Returns the GraphNode object corresponding to index
     *
     * @param index Position of the node in the list.
     * @return The corresponding GraphNode.
     */
    public GraphNode getNode(int index) {
        return nodes.get(index);
    }

    /**
     * Calculates using Dijkstra all the paths from origin
     *
     * @param node The node the paths start at.
     */
    private void getDijkstraPaths(GraphNode node) {
        dijkstra = new Dijkstra(this);
        dijkstra.buscarRutas(node);
    }

    /**
     * Gets the path to destination
     *
     * @param destination Destination node.
     * @return List of GraphNodes that conforms the path.
     */
    private LinkedList<GraphNode> getPathTo(GraphNode destination) {
        return dijkstra.getRuta(destination);
    }

    /**
     * Bring the nearest path between two nodes
     *
     * @param origin Origin node
     * @param destination Destination node
     * @return The list of nodes that conform the path.
     */
    public LinkedList<GraphNode> getPathFromAtoB(GraphNode origin, GraphNode destination) {
        //Calculates all the paths from origin
        getDijkstraPaths(origin);
        //Gets the path to destination
        LinkedList<GraphNode> path = getPathTo(destination);
        if (path != null) {
            if (path.size() < 2) {
                System.out.println("No hay ruta");
            }
        }
        return path;
    }

    /**
     * Return the weight of the connection between origin and destination
     *
     * @param origin Origin node
     * @param destination Destination node
     * @return The weight (distance) bewteen the two nodes
     */
    public double getWeight(GraphNode origin, GraphNode destination) {
        double weight = 0.0;
        int idOrigin = origin.getNodeID();
        int idDestination = destination.getNodeID();

        for (Connection currentConection : connections) {
            if (currentConection.getOriginID() == idOrigin && currentConection.getDestinationID() == idDestination) {
                weight = currentConection.getWeight();
                break;
            }
        }
        return weight;
    }

    public boolean hasConnection(GraphNode node) {
        for (Connection connection : connections) {
            if (connection.getOriginID() == node.getNodeID() || connection.getDestinationID() == node.getNodeID()) {
                return true;
            }
        }
        return false;
    }

    public void printConnections() {
        for (Connection connection : connections) {
            System.out.println("Orig:" + connection.getOriginID() + " Dest:" + connection.getDestinationID() + " Weight:" + connection.getWeight());
        }
    }
}
