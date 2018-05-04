package Estructura;

import Programa.IConstants;
import java.util.ArrayList;

public class Trip {

    public int droneAmount;
    private ArrayList<Integer> tripStations;
    private ArrayList<Integer> tripDurations;

    public Trip(ArrayList<Integer> pStations, ArrayList<Integer> pTimes) {
        droneAmount = 0;
        tripStations = pStations;
        tripDurations = pTimes;
    }

    public void addDrone() {
        droneAmount++;
    }

    public boolean isFull() {
        return droneAmount == IConstants.MAX_DRONES_PER_TRIP;
    }

    public int getDroneAmount() {
        return droneAmount;
    }

    public ArrayList<Integer> getTripStations() {
        return tripStations;
    }

    public ArrayList<Integer> getTripDurations() {
        return tripDurations;
    }
}
