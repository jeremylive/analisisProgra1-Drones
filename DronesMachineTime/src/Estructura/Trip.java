package Estructura;

import java.util.ArrayList;
import java.util.List;

public class Trip 
{

    public int droneAmount;
    public ArrayList<Integer> tripStations;

    public Trip(ArrayList<Integer> pStations) 
    {
        droneAmount = 0;
        tripStations = pStations;
    }

    public void addDrone() 
    {
        droneAmount++;
    }

    public boolean isFull() 
    {
        return droneAmount == 50;
    }
}
