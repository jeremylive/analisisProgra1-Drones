package Programa;

import Estructura.Grafo;
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
 *
 */
public class DroneStart {

    public static void main(String[] args) {
        JFrame pView = new JFrame("PROGRA_DRONES");
        DroneCounty pDrone = new DroneCounty(pView);
        pDrone.crearCordenadasAleatoriasNodos();  // cirList = { [x,y] ..... }
        Grafo grafo = new Grafo();
        pView.add(new Ventana());
        pView.setSize(600, 600);
        pView.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        pView.setVisible(true);

        pDrone.crearNodoCoordenadas(grafo);
        pDrone.setCantEstaciones();

        //1.1 validacion = cantArcos debe ser menor que la cantEstaciones
        //1.2 Creo random de arcos por nodo(int). Random del nodoadyasente.
        //2.Crear con el alto y ancho de la pistaGrande, cuantos drones caben(x1).        
        //3.Pesos!!!!/velozDrones!!!172km
        //Crear la matriz de todos los caminos posibles. del grafo
        //Conexto trip con camino
        //merge
        //
        //(ArrayList<Trip> trips, ArrayList<Movement> moveGlobal)
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
