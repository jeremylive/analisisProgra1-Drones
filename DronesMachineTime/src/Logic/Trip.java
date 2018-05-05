package Logic;

import java.util.ArrayList;

public class Trip {

    private ArrayList<Integer> tripStations;
    private ArrayList<Integer> tripDurations;

    public Trip(ArrayList<Integer> pStations, ArrayList<Integer> pTimes) {
        tripStations = pStations;
        tripDurations = pTimes;
    }

    public ArrayList<Integer> getTripStations() {
        return tripStations;
    }

    public ArrayList<Integer> getTripDurations() {
        return tripDurations;
    }
}
