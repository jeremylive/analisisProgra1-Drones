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

    private String id;
    private int idOrigen;
    private int idDestino;
    private double distancia;
    
    public Conexion(String id, int origin, int destination, double weight) 

    {
        this.id = id;
        this.idOrigen = origin;
        this.idDestino = destination;
        this.distancia = weight;
    }
    
    //Gets and sets
    public String getId() 
    {
        return id;
    }
    
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