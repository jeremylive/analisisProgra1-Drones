package Libraries;

import Logic.Trip;
import java.util.ArrayList;

public class DivideAndConquerSolution extends Solution {

    @Override
    public void scheduleTrips(ArrayList<Trip> pTripList,ArrayList<String> pHashKeys) {
        hashKeys = pHashKeys;
        tripList = pTripList;
        initializeMovementList();
    }

}
