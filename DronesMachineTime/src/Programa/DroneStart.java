package Programa;

import Estructura.Grafo;
import Estructura.NodoGrafo;
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
        JFrame pView = new JFrame("PROGRA_DRONES");
        IConstants pGlobales = new IConstants();
        DroneCounty pDrone = new DroneCounty(pGlobales, pView);
        pDrone.crearCordenadasAleatoriasNodos();  // cirList = { [x,y] ..... }
        Grafo grafo = new Grafo();
        pView.add(new Ventana(pGlobales));
        pView.setSize(600,600);
        pView.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        pView.setVisible(true);
        
        
        
        //pGlobales.cantEstaciones;
        
        
        //seguimos con el programa.....................................................
        
        //1.Crear nodos dentro grafo con sus coordenados 
        pDrone.crearNodoCoordenadas(grafo);
        
        //1.1validacion = cantArcos debe ser menor que la cantEstaciones
        
        
        //1.2.Creo random de arcos por nodo(int). Random del nodoadyasente.
        
        //1.2 Calcular la distancia del camino mas corto
        
        //2.Crear con el alto y ancho de la pistaGrande, cuantos drones caben(x1).
        
        //2.1.Crear drones, origen y destino aleatorio. Insertar al grafo el drone en el nodo origen
        
        
        //3.Pesos!!!!/velozDrones!!!172km
        
        
        //2.Calcular la distancion que va
        
        //.....
        
        //backtracking;
        
        // (matrizTotalCaminosGrafo)
        
        //Probabilistico
        
        // (matrizTotalCaminosGrafo)
        
        //Merge
        
        // (matrizTotalCaminosGrafo)
        
        //simulacion:
            //1.viajes que llegan.
            //2.tiempo que va 
        
        
    }


//fin de la estructura del programa calculo de drones.................................................................100%   
}
