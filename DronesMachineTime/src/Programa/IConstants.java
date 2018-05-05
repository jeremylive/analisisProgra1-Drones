package Programa;

import Estructura.Movement;
import Estructura.Trip;
import Interfaz.Circulo;
import java.util.ArrayList;

/**
*
*█▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀█
*█░░╦─╦╔╗╦─╔╗╔╗╔╦╗╔╗░░█
*█░░║║║╠─║─║─║║║║║╠─░░█
*█░░╚╩╝╚╝╚╝╚╝╚╝╩─╩╚╝░░█
*█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█
*
**/
public class IConstants {

    public static ArrayList<Circulo> circulosList = new ArrayList<>();
    public static int cantEstaciones;
    public static int altoPistas;
    public static int anchoPistas;
    public static int cantViajes;
    public static int SIMULATION_TIME;
    public static int cantArcos;
    public static int velocidadConstante;
    public static int MAX_DRONES_PER_TRIP = 0; //falta algoritmo..
    public static int cantPista = 0; //calcular cant pista..
    public static int DRONE_HEIGHT = 3;
    public static int DRONE_WIDTH = 2;
    public static int MAX_POSSIBLE_SPACES;
    public static int WINDOW_WIDTH = 1000;
    public static int WINDOW_HEIGHT = 700;
}
