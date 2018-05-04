package Librerias;

import Estructura.Trip;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;

public class ProbabilisticSolution extends Solution {

    @Override
    public void scheduleTrips(ArrayList<Trip> pTripList) {
        trackMovementList = new Hashtable<>();
        tripList = pTripList;
        for (Trip currentTrip : pTripList) {
            if (!scheduleATrip(currentTrip)) {
                System.out.println("Error while scheduling trip");
                return;
            }
        }
        System.out.println("All trips scheduled");
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
