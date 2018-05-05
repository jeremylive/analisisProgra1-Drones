package Program;

import Interface.Circle;
import java.util.ArrayList;

/**
 *
 * █▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀█ 
 * █░░╦─╦╔╗╦─╔╗╔╗╔╦╗╔╗░░█ 
 * █░░║║║╠─║─║─║║║║║╠─░░█
 * █░░╚╩╝╚╝╚╝╚╝╚╝╩─╩╚╝░░█ 
 * █▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█
 *
 *
 */
public class IConstants {

    //Interface
    public static ArrayList<Circle> CIRCLE_LIST = new ArrayList<>();
    public static int CIRCLE_DIAMETER = 60;
    //Logic
    public static int DRONE_SPEED_KM_H = 120;
    public static int MAX_DRONES_PER_TRIP;
    public static int DRONE_HEIGHT = 3;
    public static int DRONE_WIDTH = 2;
    public static int WINDOW_WIDTH = 1000;
    public static int WINDOW_HEIGHT = 700;
    //Algorithms
    public static int MAX_POSSIBLE_SPACES = 3;
    public static int SIMULATION_TIME;
    //User input
    public static int STATION_TOTAL;
    public static int TRACK_HEIGHT;
    public static int TRACK_WIDTH;
    public static int DRONE_TRIP_TOTAL;
    public static int ARCH_TOTAL;

}
