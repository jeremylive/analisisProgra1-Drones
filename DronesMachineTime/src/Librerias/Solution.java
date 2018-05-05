package Librerias;

import Programa.IConstants;
import Estructura.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

public abstract class Solution {

    protected Hashtable<String, ArrayList<Movement>> trackMovementList;
    protected ArrayList<Trip> tripList;
    protected ArrayList<String> hashKeys;
    protected long totalTime;

    public abstract void scheduleTrips(ArrayList<Trip> pTripList,ArrayList<String> pHashKeys);

    protected void initializeMovementList() {
        trackMovementList = new Hashtable<>();
        for(String key : hashKeys) {
            trackMovementList.put(key, new ArrayList<Movement>());
        }
    }
    
    /**
     * *
     * Gets up to N spaces where a Trip can be placed. The spaces are
     * represented by the second they start at. N = MAX_POSSIBLE_SPACES
     *
     * @param pTrip The Trip object to be placed.
     * @return An ArrayList containing the start second of the possible spaces.
     */
    protected ArrayList<Integer> getPossibleSpaces(Trip pTrip) {
        ArrayList<Integer> possibleSpaces = new ArrayList<>();
        int currentSecond = 0;
        while (possibleSpaces.size() < IConstants.MAX_POSSIBLE_SPACES && currentSecond < IConstants.SIMULATION_TIME) {
            if (isTripPossible(pTrip, currentSecond)) {
                possibleSpaces.add(currentSecond);
            }
            currentSecond++;
        }
        return possibleSpaces;
    }

    /**
     * *
     * Checks if a trip can be done at a certain time, one movement at the time.
     *
     * @param pTrip The Trip object we want to do.
     * @param pStartTime The second we want to start the trip at.
     * @return true if possible, false if not.
     */
    protected boolean isTripPossible(Trip pTrip, int pStartTime) {
        int startNode, endNode, movementTime;
        for (int currentMovement = 0; currentMovement < pTrip.getTripDurations().size(); currentMovement++) {
            //Gets the movement's data.
            startNode = pTrip.getTripStations().get(currentMovement);
            endNode = pTrip.getTripStations().get(currentMovement + 1);
            movementTime = pTrip.getTripDurations().get(currentMovement);
            //Checks if the movement can be placed.
            if (!isMovementPossible(startNode, endNode, movementTime, pStartTime)) {
                return false;
            }
            //Updates the start time for the next movement.
            pStartTime += movementTime;
        }
        return true;
    }

    /**
     * *
     * Checks if a movement can be done at a certain time.
     *
     * @param pStartNode Movement's start node's ID.
     * @param pEndNode Movement's end node's ID.
     * @param pMovementTime The amount of seconds the movement takes.
     * @param pStartTime The second we want to start the movement at.
     * @return true if possible, false if not.
     */
    protected boolean isMovementPossible(int pStartNode, int pEndNode, int pMovementTime, int pStartTime) {
        //Checks that the end time is not higher than the simulation's maximum.
        if (pStartTime + pMovementTime > IConstants.SIMULATION_TIME) {
            return false;
        }
        //Checks for conflicting movements in the same track.
        String hashKey = pStartNode + "-" + pEndNode;
        ArrayList<Movement> trackMovements = trackMovementList.get(hashKey);
        for (Movement currentMovement : trackMovements) {
            if (currentMovement.getEndSecond() > pStartTime) {
                if (currentMovement.getStartSecond() < (pStartTime + pMovementTime)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * *
     * Inserts all the Movement objects that represent a trip in
     * trackMovementList.
     *
     * @param pTrip The trip to insert.
     * @param pStartTime The second to place the first movement.
     */
    protected void insertTrip(Trip pTrip, int pStartTime) {
        int startNode, endNode, movementTime;
        String hashkey;
        for (int currentMovement = 0; currentMovement < pTrip.getTripDurations().size(); currentMovement++) {
            //Gets the movement's data.
            startNode = pTrip.getTripStations().get(currentMovement);
            endNode = pTrip.getTripStations().get(currentMovement + 1);
            movementTime = pTrip.getTripDurations().get(currentMovement);
            //Creates a new Movement object.
            Movement newMovement = new Movement(startNode, endNode, pStartTime, pStartTime + movementTime);
            //Adds the Movement object to it's corresponding array in trackMovementList
            hashkey = startNode + "-" + endNode;
            trackMovementList.get(hashkey).add(newMovement);
            //Updates the start time for the next movement.
            pStartTime += movementTime;
        }
    }

    /**
     * *
     * Removes all the Movement objects that represent a trip in
     * trackMovementList.
     *
     * @param pTrip The trip to remove.
     * @param pStartTime The second where the first movement occurs.
     */
    protected void removeTrip(Trip pTrip, int pStartTime) {
        int startNode, endNode, movementTime;
        String hashkey;
        for (int currentMovement = 0; currentMovement < pTrip.getTripDurations().size(); currentMovement++) {
            //Gets the movement's data.
            startNode = pTrip.getTripStations().get(currentMovement);
            endNode = pTrip.getTripStations().get(currentMovement + 1);
            movementTime = pTrip.getTripDurations().get(currentMovement);
            //Creates a new Movement object.
            Movement newMovement = new Movement(startNode, endNode, pStartTime, pStartTime + movementTime);
            //Removes the Movement object from it's corresponding array in trackMovementList
            hashkey = startNode + "-" + endNode;
            trackMovementList.get(hashkey).remove(newMovement);
            //Updates the start time for the next movement.
            pStartTime += movementTime;
        }
    }
    
    protected void printResult() {
        System.out.println("Total time: " + totalTime + " ms");
        Set<String> keys = trackMovementList.keySet();
        for(String hashKey : keys) {
            System.out.print(hashKey + ": ");
            ArrayList<Movement> movementList = trackMovementList.get(hashKey);
            for(Movement currentMovement : movementList) {
                System.out.print(currentMovement.toString() + ", ");
            }
            System.out.println("");
        }
    }
}
