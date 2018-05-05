package Librerias;

import Estructura.Trip;
import java.util.ArrayList;
import java.util.Hashtable;

public class BacktrackingSolution extends Solution {

    @Override
    public void scheduleTrips(ArrayList<Trip> pTripList,ArrayList<String> pHashKeys) {
        hashKeys = pHashKeys;
        tripList = pTripList;
        initializeMovementList();
        totalTime = System.currentTimeMillis();
        if (scheduleATrip(0)) {
            System.out.println("All trips scheduled");
        } else {
            System.out.println("Error while scheduling trips");
        }
        totalTime = System.currentTimeMillis() - totalTime;
        printResult();
    }

    private boolean scheduleATrip(int pCurrentTrip) {
        //Stop condition : All trips scheduled.
        if (pCurrentTrip == tripList.size()) {
            return true;
        }
        //Gets the current Trip object and its possible spaces.
        Trip currentTrip = tripList.get(pCurrentTrip);
        ArrayList<Integer> possibleSpaces = getPossibleSpaces(currentTrip);
        //Consider each possible space
        for (int chosenSpace : possibleSpaces) {
            //Make tentative placement.
            insertTrip(currentTrip, chosenSpace);
            //Schedules the next trip.
            if (scheduleATrip(pCurrentTrip + 1)) {
                return true;
            }
            //A trip after this one failed, undo the placement and try again.
            removeTrip(currentTrip, chosenSpace);
        }
        return false;
    }

}
