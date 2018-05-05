package Librerias;

import Estructura.Trip;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;

public class ProbabilisticSolution extends Solution {

    @Override
    public void scheduleTrips(ArrayList<Trip> pTripList, ArrayList<String> pHashKeys) {
        hashKeys = pHashKeys;
        tripList = pTripList;
        initializeMovementList();
        boolean success = true;
        totalTime = System.currentTimeMillis();
        for (Trip currentTrip : pTripList) {
            if (!scheduleATrip(currentTrip)) {
                success = false;
                break;
            }
        }
        totalTime = System.currentTimeMillis() - totalTime;
        if (success) {
            System.out.println("All trips scheduled");
        } else {
            System.out.println("Error while scheduling trip");
        }
        printResult();
    }

    private boolean scheduleATrip(Trip pTrip) {
        Random numberGenerator = new Random();
        ArrayList<Integer> possibleSpaces = getPossibleSpaces(pTrip);
        if (possibleSpaces.isEmpty()) {
            return false;
        }
        int chosenSpace = numberGenerator.nextInt(possibleSpaces.size());
        insertTrip(pTrip, chosenSpace);
        return true;
    }
}
