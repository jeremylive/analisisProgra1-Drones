package Programa;

import Interfaz.Ventana;
import javax.swing.JFrame;

/**
*
*█▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀█
*█░░╦─╦╔╗╦─╔╗╔╗╔╦╗╔╗░░█
*█░░║║║╠─║─║─║║║║║╠─░░█
*█░░╚╩╝╚╝╚╝╚╝╚╝╩─╩╚╝░░█
*█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█
*
**/
public class DroneStart 
{
    public static void main(String[] args) 
    {
        //Clase con variables globles
        IConstants pGlobales = new IConstants();
        //Clase logica
        DroneCounty pDrone = new DroneCounty(pGlobales);
        //Creamos coordenadas
        pDrone.crearCordenadasAleatoriasNodos();
        //
        if(isOver(e.getPoint())){

        }
        //Inicializar interfaz
        JFrame pView = new JFrame("PROGRA_DRONES");
        pView.add(new Ventana(pGlobales));
        pView.setSize(600,600);
        pView.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        pView.setVisible(true);
        
        //seguimos con el programa.....................................................
        
        //Inserto coordenadas en el grafo
//        pDrone.setCoordenadasPoints();
        
        //1.Crear nodos dentro grafo con sus coordenados 

        //2.cantArcos debe ser menor que la cantEstaciones
        
        //3.Creo random de arcos por nodo(osea tambien un random del nodo destino). Calculos la distancia
        
        //4.Crear con el alto y ancho de la pistaGrande, cuantos drones caben.
        
        //4.1.Crear drones, origen y destino aleatorio. Insertar al grafo el drone en el nodo origen
        
        //5.Calcular el sleep
        
        //2.Calcular la distancion que va
    }


//fin de la estructura del programa calculo de drones.................................................................100%   
}
