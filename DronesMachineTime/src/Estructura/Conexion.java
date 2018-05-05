package Estructura;
/**
*
*█▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀█
*█░░╦─╦╔╗╦─╔╗╔╗╔╦╗╔╗░░█
*█░░║║║╠─║─║─║║║║║╠─░░█
*█░░╚╩╝╚╝╚╝╚╝╚╝╩─╩╚╝░░█
*█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█
*
**/
public class Conexion  
{

    private int idOrigen;
    private int idDestino;
    private double distancia;
    
    public Conexion(int origin, int destination, double weight) 

    {
        this.idOrigen = origin;
        this.idDestino = destination;
        this.distancia = weight;
    }
    
    //Gets and sets
    public int getIDDestino() 
    {
        return idDestino;
    }
    
    public int getIDOrigen() 
    {
        return idOrigen;
    }
    
    public double getDistancia() 
    {
        return distancia;
    }
    
    @Override
    public String toString() 
    {
        return idOrigen + "--" + distancia + "-->" + idDestino;
    }
}