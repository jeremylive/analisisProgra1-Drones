package Program;

import Logic.Connection;
import Logic.Graph;
import Logic.GraphNode;
import Logic.Trip;
import Interface.Circle;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import javax.swing.JFrame;

/**
 *
 * █▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀█ █░░╦─╦╔╗╦─╔╗╔╗╔╦╗╔╗░░█ █░░║║║╠─║─║─║║║║║╠─░░█
 * █░░╚╩╝╚╝╚╝╚╝╚╝╩─╩╚╝░░█ █▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█
 *
 *
 */
public class DroneCounty {

    private Random random;
    private Graph graph;
    private ArrayList<ArrayList<Integer>> graphPaths;
    private ArrayList<ArrayList<Integer>> pathDurations;
    private ArrayList<Trip> tripList;

    /**
     * Constructor.
     *
     */
    public DroneCounty() {
        random = new Random();
        graph = new Graph();
        graphPaths = new ArrayList<>();
        pathDurations = new ArrayList<>();
        tripList = new ArrayList<>();
    }

    public ArrayList<Trip> getTripList() {
        return tripList;
    }

    public Graph getGraph() {
        return graph;
    }

    /**
     * Creates a new circle for each station. These circles have a random X and
     * Y position.
     *
     */
    public void createRandomCircles() {
        int circlesCreated = 0;
        while (circlesCreated < IConstants.STATION_TOTAL) {
            //Sets the coordinates randomly.
            int xCoordinate = random.nextInt(IConstants.WINDOW_WIDTH - IConstants.CIRCLE_DIAMETER) + IConstants.CIRCLE_DIAMETER / 2;
            int yCoordinate = random.nextInt(IConstants.WINDOW_HEIGHT - IConstants.CIRCLE_DIAMETER) + IConstants.CIRCLE_DIAMETER / 2;

            //If the new circle won't be over an existing circle
            if (isNotOver(xCoordinate, yCoordinate)) {
                //Adds the circle to IConstants.CIRCLE_LIST
                Circle newCircle = new Circle(xCoordinate, yCoordinate);
                IConstants.CIRCLE_LIST.add(newCircle);
                circlesCreated++;
            }
        }
    }

    /**
     * Checks if a new figure using xCoordinate and yCoordinate will collide
     * with an existing figure in IConstants.CIRCLE_LIST
     *
     * @param xCoordinate
     * @param yCoordinate
     * @return true if there's no collision, false if otherwise.
     *
     */
    private boolean isNotOver(int xCoordinate, int yCoordinate) {
        Rectangle figura = new Rectangle(xCoordinate - IConstants.CIRCLE_DIAMETER / 2, yCoordinate - IConstants.CIRCLE_DIAMETER / 2,
                IConstants.CIRCLE_DIAMETER, IConstants.CIRCLE_DIAMETER);
        for (Circle pCircle : IConstants.CIRCLE_LIST) {
            if (new Rectangle(pCircle.getxPosition() - IConstants.CIRCLE_DIAMETER / 2, pCircle.getyPosition() - IConstants.CIRCLE_DIAMETER / 2,
                    IConstants.CIRCLE_DIAMETER, IConstants.CIRCLE_DIAMETER).intersects(figura)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Creates new nodes, assigns them a random position (Circle) and inserts
     * them into the graph
     *
     */
    public void createNodes() {
        int nodeTotal = 0;
        for (Circle coordinate : IConstants.CIRCLE_LIST) {
            if (nodeTotal < IConstants.STATION_TOTAL) {
                GraphNode nodo = new GraphNode(nodeTotal);
                nodo.setxPosition(coordinate.getxPosition());
                nodo.setyPosition(coordinate.getyPosition());
                graph.addNode(nodo);
            }
            nodeTotal += 1;
        }
    }

    /**
     * Calculates the total number of drones for all the trips and updates its
     * value in IConstants.MAX_DRONES_PER_TRIP.
     *
     */
    public void calculateMaxDronesPerTrip() {
        int maxDrones;
        maxDrones = (IConstants.TRACK_WIDTH / IConstants.DRONE_WIDTH);
        maxDrones *= (IConstants.TRACK_HEIGHT / IConstants.DRONE_HEIGHT);
        IConstants.MAX_DRONES_PER_TRIP = maxDrones;
    }

    /**
     * Randomly connects all the nodes in the graph.
     */
    public void connectNodesRandomly() {
        GraphNode origin, destination;
        int selectedDestination, connections, currentConnection = 0;
        ArrayList<GraphNode> nodesNotConnected = getNodesNotConneted();
        while (!nodesNotConnected.isEmpty() && !(nodesNotConnected.size() == 1)) {
            origin = nodesNotConnected.get(0);
            selectedDestination = random.nextInt(nodesNotConnected.size() - 1) + 1;
            destination = nodesNotConnected.get(selectedDestination);
            addConnection(origin, destination, calculateDistance(origin, destination));
            nodesNotConnected = getNodesNotConneted();
        }
        ArrayList<ArrayList<Double>> closestNodes;
        for (GraphNode node : graph.getNodes()) {
            if (nodesNotConnected.contains(node)) {
                connections = 0;
            } else {
                connections = 1;
            }
            currentConnection = 0;
            closestNodes = getClosestNodes(node);
            while (connections < IConstants.ARCH_TOTAL) {
                int destinationNodeID = closestNodes.get(currentConnection).get(1).intValue();
                if (addConnection(node, graph.getNode(destinationNodeID), closestNodes.get(currentConnection).get(0))) {
                    connections++;
                }
                currentConnection++;
            }
        }
    }

    private ArrayList<GraphNode> getNodesNotConneted() {
        ArrayList<GraphNode> result = new ArrayList<>();
        for (GraphNode node : graph.getNodes()) {
            if (!graph.hasConnection(node)) {
                result.add(node);
            }
        }
        return result;
    }

    private ArrayList<ArrayList<Double>> getClosestNodes(GraphNode node) {
        ArrayList<ArrayList<Double>> nodeDistanceID = new ArrayList<>();
        ArrayList<Double> distanceIDPair;
        for (GraphNode currentNode : graph.getNodes()) {
            if (!currentNode.equals(node)) {
                distanceIDPair = new ArrayList<>();
                distanceIDPair.add(calculateDistance(node, currentNode));
                distanceIDPair.add((new Double(currentNode.getNodeID())));
                nodeDistanceID.add(distanceIDPair);
            }
        }
        //Sort array by distance
        ArrayList<ArrayList<Double>> sortedNodeList = new ArrayList<>();
        Double lowestDistance, lowestNodeID;
        while (!nodeDistanceID.isEmpty()) {
            lowestDistance = Double.MAX_VALUE;
            lowestNodeID = 0.0;
            for (ArrayList<Double> currentPair : nodeDistanceID) {
                if (currentPair.get(0) < lowestDistance) {
                    lowestDistance = currentPair.get(0);
                    lowestNodeID = currentPair.get(1);
                }
            }
            distanceIDPair = new ArrayList<>();
            distanceIDPair.add(lowestDistance);
            distanceIDPair.add(lowestNodeID);
            sortedNodeList.add(distanceIDPair);
            nodeDistanceID.remove(distanceIDPair);
        }
        return sortedNodeList;
    }

    private double calculateDistance(GraphNode origin, GraphNode destination) {
        int xSum = Math.abs(origin.getxPosition() - destination.getxPosition());
        int ySum = Math.abs(origin.getyPosition() - destination.getyPosition());
        return xSum + ySum;
    }

    /**
     * Adds a new connection from origin to destination in the graph.
     *
     * @param origin The path's origin Node.
     * @param destination The path's destination Node.
     * @param weight The path's weight.
     *
     * @return true if the connection was added, false if it already exists.
     */
    private boolean addConnection(GraphNode origin, GraphNode destination, double weight) {
        for (Connection connection : graph.getConnections()) {
            if (connection.getOriginID() == origin.getNodeID() && connection.getDestinationID() == destination.getNodeID()) {
                return false;
            }
        }
        Connection connectAtoB = new Connection(origin.getNodeID(), destination.getNodeID(), weight);
        Connection connectBtoA = new Connection(destination.getNodeID(), origin.getNodeID(), weight);
        graph.getConnections().add(connectAtoB);
        graph.getConnections().add(connectBtoA);
        return true;
    }

    /**
     * *
     * Obtains all the paths in the graph for each node.
     */
    public void createPaths() {
        GraphNode origin;
        GraphNode destination;
        int nodeTotal = this.graph.getNodes().size(); //total of nodes in the graph
        for (int currentOrigin = 0; currentOrigin < nodeTotal; currentOrigin++) {
            origin = graph.getNode(currentOrigin); //get node
            for (int currentDestination = 0; currentDestination < nodeTotal; currentDestination++) {
                if (currentOrigin != currentDestination) {
                    destination = graph.getNode(currentDestination);
                    LinkedList<GraphNode> path = graph.getPathFromAtoB(origin, destination);
                    insertPath(path);

                }
            }
        }
    }

    private void insertPath(LinkedList<GraphNode> pPath) {
        ArrayList<Integer> nodesIDList = new ArrayList();
        ArrayList<Integer> durationList = new ArrayList();
        for (int currentNode = 0; currentNode < pPath.size(); currentNode++) {
            GraphNode node = pPath.get(currentNode);
            nodesIDList.add(node.getNodeID());
        }
        for (int currentConnection = 0; currentConnection + 1 < pPath.size(); currentConnection++) {
            GraphNode originNode = pPath.get(currentConnection);
            GraphNode destinationNode = pPath.get(currentConnection + 1);
            double distance = graph.getWeight(originNode, destinationNode);
            int duration = (int) (((distance / IConstants.DRONE_SPEED_KM_H) * 60) * 60);
            durationList.add(duration);
        }
        this.graphPaths.add(nodesIDList);
        this.pathDurations.add(durationList);
    }

    /**
     * *
     * Creates every trip and assigns it a random path and its corresponding
     * duration.
     */
    public void createTrips() {
        int tripTotal = IConstants.DRONE_TRIP_TOTAL / IConstants.MAX_DRONES_PER_TRIP;
        System.out.println("Total de viajes:" + tripTotal);
        for (int currentTrip = 0; currentTrip < tripTotal; currentTrip++) {
            int selectedOption = random.nextInt(graphPaths.size());
            tripList.add(new Trip(graphPaths.get(selectedOption), pathDurations.get(selectedOption)));
        }
    }

    /**
     * *
     * Creates all the String keys used to represent each connection. Each key
     * has a NodeID-NodeID format.
     *
     * @return ArrayList<String> with all the keys.
     */
    public ArrayList<String> createHashKeys() {
        ArrayList<String> keys = new ArrayList<>();
        for (Connection connection : graph.getConnections()) {
            keys.add(connection.getOriginID() + "-" + connection.getDestinationID());
        }
        return keys;
    }

    public void printTrips() {
        for (Trip t : tripList) {
            System.out.print("Estaciones: ");
            for (Integer i : t.getTripStations()) {
                System.out.print(i + ",");
            }
            System.out.print("Duraciones: ");
            for (Integer j : t.getTripDurations()) {
                System.out.print(j + ",");
            }
            System.out.println("");
        }
    }

}
