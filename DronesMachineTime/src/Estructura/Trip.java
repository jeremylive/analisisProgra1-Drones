package Estructura;

import java.util.ArrayList;

public class Trip 
{
    //Global variable
    private ArrayList<Drone> droneList;  //no puede ser mayor al total de drones que caben
    
    /**
     * Constructor.
     * 
     */
    public Trip()
    {
        this.droneList = new ArrayList<Drone>();
    }

    /**
     * Gets and Sets 
     */
    public ArrayList<Drone> getDroneList() 
    {
        return droneList;
    }

    public void setDroneList(ArrayList<Drone> droneList) 
    {
        this.droneList = droneList;
    }
    
    
}
