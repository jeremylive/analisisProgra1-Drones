package Estructura;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
/**
*
*█▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀█
*█░░╦─╦╔╗╦─╔╗╔╗╔╦╗╔╗░░█
*█░░║║║╠─║─║─║║║║║╠─░░█
*█░░╚╩╝╚╝╚╝╚╝╚╝╩─╩╚╝░░█
*█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█
*
**/
public class NodoGrafo 
{
    final private String id;
    private int posX;
    private int posY;
    private boolean isProcesado;    
    private ArrayList<TimeInstance> lineaTiempo;
    private ArrayList<Trip> listTrip;

    /**
     * Constructor.
     */
    public NodoGrafo(String id) 
    {
        this.id = id;
        this.posX = 0;
        this.posY = 0;
        this.isProcesado = false;
        this.lineaTiempo = new ArrayList<TimeInstance>();
        this.listTrip = new ArrayList<Trip>();
    }

    /**
    *
    * Gets and sets
    * 
    **/
    public String getId() 
    {
        return id;
    }
   
    public int getPosX() 
    {
        return posX;
    }
    
    public void setPosX(int posX) 
    {
        this.posX = posX;
    }
    
    public int getPosY() 
    {
        return posY;
    }
    
    public void setPosY(int posY) 
    {
        this.posY = posY;
    }

    /**
     * Functions;
    **/   
    public boolean isIsProcesado() 
    {
        return isProcesado;
    }

    public void procesar()
    {
        this.isProcesado = true;
    }
    
    public void limpiar()
    {
        this.isProcesado = false;
    }
    
    public void setIsProcesado(boolean isProcesado) 
    {
        this.isProcesado = isProcesado;
    }
//
//    /**
//     * Crea codigo hash para manejo de nodos
//     *
//     * @return La posicion a insertar en la tabla
//     */
//    @Override
//    public int hashCode() 
//    {
//        final int prime = 31;
//        int result = 1;
//        result = prime * result + ((id == null) ? 0 : id.hashCode());
//        return result;
//    }
//
//    /**
//     * Para comparar con otros nodos
//     *
//     * @param obj con el cual comparar
//     * @return true si es igual, false si no
//     */
//    @Override
//    public boolean equals(Object obj) 
//    {
//        if (this == obj)
//            return true;
//        if (obj == null)
//            return false;
//        if (getClass() != obj.getClass())
//            return false;
//        NodoGrafo other = (NodoGrafo) obj;
//        if (id == null) {
//            if (other.id != null)
//                return false;
//        } else if (!id.equals(other.id))
//            return false;
//        return true;
//    }

//fin de la estructura del programa calculo de drones.................................................................100%    
}