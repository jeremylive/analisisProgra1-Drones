package Libraries;

import Logic.Trip;
import Logic.Movement;
import Program.IConstants;
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
        trackMovementList = new Hashtable<>(); //+1
        for(String key : hashKeys) {//+1(+3
            trackMovementList.put(key, new ArrayList<Movement>());//+1
        }
    }
    //1+1+(3+1)*N = 2+4N
    /**
     * *
     * Gets up to N spaces where a Trip can be placed. The spaces are
     * represented by the second they start at. N = MAX_POSSIBLE_SPACES
     *
     * @param pTrip The Trip object to be placed.
     * @return An ArrayList containing the start second of the possible spaces.
     */
    protected ArrayList<Integer> getPossibleSpaces(Trip pTrip) {
        ArrayList<Integer> possibleSpaces = new ArrayList<>();//1
        int currentSecond = 0;//+1
        while (possibleSpaces.size() < IConstants.MAX_POSSIBLE_SPACES && currentSecond < IConstants.SIMULATION_TIME) {//(+2
            if (isTripPossible(pTrip, currentSecond)) {//2+5+28N´6N^2
                possibleSpaces.add(currentSecond);//+1
            }
            currentSecond++;//+1
        }//)*N
        return possibleSpaces; //1
    }//+1+1(+2+2+5+28N+6N^2+1+1)*N +1= 3+11N+28N^2+6N^3

    /**
     * *
     * Checks if a trip can be done at a certain time, one movement at the time.
     *
     * @param pTrip The Trip object we want to do.
     * @param pStartTime The second we want to start the trip at.
     * @return true if possible, false if not.
     */
    protected boolean isTripPossible(Trip pTrip, int pStartTime) {
        int startNode, endNode, movementTime;//+3
        for (int currentMovement = 0; currentMovement < pTrip.getTripDurations().size(); currentMovement++) {//+1(+3
            //Gets the movement's data.
            startNode = pTrip.getTripStations().get(currentMovement);//+2
            endNode = pTrip.getTripStations().get(currentMovement + 1);//+3
            movementTime = pTrip.getTripDurations().get(currentMovement);//+2
            //Checks if the movement can be placed.
            if (!isMovementPossible(startNode, endNode, movementTime, pStartTime)) {//5+9+6N
                return false;//+1
            }
            //Updates the start time for the next movement.
            pStartTime += movementTime;//+2
        }
        return true;//+1
    }//3+1(+3+2+3+2+5+9+6N)*n + 1 = 5+28N +6N^2

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
        if (pStartTime + pMovementTime > IConstants.SIMULATION_TIME) {//+2
            return false;//+1
        }
        //Checks for conflicting movements in the same track.
        String hashKey = pStartNode + "-" + pEndNode;//+3
        ArrayList<Movement> trackMovements = trackMovementList.get(hashKey);//+2
        for (Movement currentMovement : trackMovements) {//1+(+3
            if (currentMovement.getEndSecond() > pStartTime) {//+1
                if (currentMovement.getStartSecond() < (pStartTime + pMovementTime)) {//+2
                    return false;//+1
                }
            }
        }//)*N
        return true;//+1
    }//2+1+3+2+1+(3+1+2)*N+1= 9 + 6N

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
