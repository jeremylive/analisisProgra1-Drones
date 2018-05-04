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
public class IConstants 
{
    public static ArrayList<Circulo> circulosList = new ArrayList<>();    
    public static int cantEstaciones = 0;
    public static int altoPistas = 0;
    public static int anchoPistas = 0;
    public static int cantViajes = 0;
    public static int cantTiempo = 0;
    public static int cantArcos = 0;
    public static int velocidadConstante = 120;
    public static int cantDronesPistaMax = 0; //falta algoritmo..
    public static int cantPista = 0; //calcular cant pista..
    public static int alturaDrone = 3;
    public static int anchutaDrone = 2;
    public static ArrayList<Movement> moveGlobal= new ArrayList<Movement>();
}
