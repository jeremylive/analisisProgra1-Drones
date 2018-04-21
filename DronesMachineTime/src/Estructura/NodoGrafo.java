package Estructura;

import java.awt.Image;
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
public class NodoGrafo 
{
    //Variables globales
    final private String id;
    //Coordenadas de la posicion del nodo
    private int posX;
    private int posY;
    private boolean isProcesado;
    
    //Estacion atributos
    private ArrayList<Drone> droneList;  //no puede ser mayor al total de drones que caben
    private int cantDronesPistaActualmente = droneList.size();
        

    /**
     * Constructor, Nodo con la imagen del lugar
     *
     * @param id para el nodo en el hash table
     * @param lugar info del lugar 
     */
    public NodoGrafo(String id) {
        this.id = id;
        this.posX = 0;
        this.posY = 0;
        this.isProcesado = false;
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
    * Estado del nodo actual, por donde esta pasando el drone, el nodo actual en el que cae!
    *
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

    /**
     * Crea codigo hash para manejo de nodos
     *
     * @return La posicion a insertar en la tabla
     */
    @Override
    public int hashCode() 
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    /**
     * Para comparar con otros nodos
     *
     * @param obj con el cual comparar
     * @return true si es igual, false si no
     */
    @Override
    public boolean equals(Object obj) 
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        NodoGrafo other = (NodoGrafo) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

//fin de la estructura del programa calculo de drones.................................................................100%    
}