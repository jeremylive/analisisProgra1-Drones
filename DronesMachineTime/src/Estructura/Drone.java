package Estructura;

import Librerias.Dijkstra;
import java.util.Vector;
/**
*
*█▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀█
*█░░╦─╦╔╗╦─╔╗╔╗╔╦╗╔╗░░█
*█░░║║║╠─║─║─║║║║║╠─░░█
*█░░╚╩╝╚╝╚╝╚╝╚╝╩─╩╚╝░░█
*█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█
*
**/
public class Drone 
{
    //Variables globales
    private Vector origen;
    private Vector destino;
    private Vector actual;

    /**
    * Constructor.
    * 
    * @param dijkstra 
    **/
    public Drone(Dijkstra pD)
    {
    	this.origen = new Vector();
    	this.destino = new Vector();
    	this.actual = new Vector();
    }

    //
    public Vector getOrigen() 
    {
        return origen;
    }

    public void setOrigen(Vector origen) 
    {
        this.origen = origen;
    }

    public Vector getDestino() 
    {
        return destino;
    }

    public void setDestino(Vector destino) 
    {
        this.destino = destino;
    }

    public Vector getActual() 
    {
        return actual;
    }

    public void setActual(Vector actual) 
    {
        this.actual = actual;
    }
    
    
}
