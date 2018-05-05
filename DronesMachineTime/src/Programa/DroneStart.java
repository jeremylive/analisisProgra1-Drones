package Programa;

import Interfaz.Ventana;
import Librerias.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
        Solution algorithm;
        int opcionAlgoritmo;
        
        String convert = "";
        convert = JOptionPane.showInputDialog(pView, "Cantidad de estaciones? (max 30)");
        IConstants.cantEstaciones = Integer.parseInt(convert);
        convert = JOptionPane.showInputDialog(pView, "Alto de las pistas?");
        IConstants.altoPistas = Integer.parseInt(convert);
        convert = JOptionPane.showInputDialog(pView, "Ancho de las pistas?");
        IConstants.anchoPistas = Integer.parseInt(convert);
        convert = JOptionPane.showInputDialog(pView, "Cantidad de viajes a realizar?");
        IConstants.cantViajes = Integer.parseInt(convert);
        convert = JOptionPane.showInputDialog(pView, "Cantidad de tiempo?");
        IConstants.SIMULATION_TIME = Integer.parseInt(convert);
        convert = JOptionPane.showInputDialog(pView, "Cantidad de pistas(arcos) por estacion?");
        IConstants.cantArcos = Integer.parseInt(convert);
        convert = JOptionPane.showInputDialog(pView, "Algoritmo a realizar");
        opcionAlgoritmo = Integer.parseInt(convert);
        
        pDrone.calculateMaxDronesPerTrip();
        pDrone.crearCordenadasAleatoriasNodos();  // cirList = { [x,y] ..... }
        pDrone.crearNodoCoordenadas();
        pDrone.setArcosRandom();
        pDrone.createShortRoutes();
        pDrone.createTrips();
        //pDrone.printTrips();
        
        pView.add(new Ventana(pDrone.getGrafo()));
        pView.setSize(IConstants.WINDOW_WIDTH, IConstants.WINDOW_HEIGHT);
        pView.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        pView.setVisible(true);
        
        switch(opcionAlgoritmo) {
            case 1:algorithm = new DivideAndConquerSolution();
            break;
            case 2:algorithm = new BacktrackingSolution();
            break;
            default:algorithm = new ProbabilisticSolution();
        }
        algorithm.scheduleTrips(pDrone.getTripList(),pDrone.createHashKeys());

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
