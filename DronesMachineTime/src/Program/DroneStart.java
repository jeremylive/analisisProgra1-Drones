package Program;

import Libraries.Solution;
import Libraries.DivideAndConquerSolution;
import Libraries.BacktrackingSolution;
import Libraries.ProbabilisticSolution;
import Interface.Window;
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
        JFrame pView = new JFrame("I Proyecto - Drone County");
        DroneCounty pDrone = new DroneCounty();
        Solution algorithm;
        int algorithmOption;
        
        String convert = "";
        convert = JOptionPane.showInputDialog(pView, "Cantidad de estaciones? (max 30)");
        IConstants.STATION_TOTAL = Integer.parseInt(convert);
        convert = JOptionPane.showInputDialog(pView, "Alto de las pistas?");
        IConstants.TRACK_HEIGHT = Integer.parseInt(convert);
        convert = JOptionPane.showInputDialog(pView, "Ancho de las pistas?");
        IConstants.TRACK_WIDTH = Integer.parseInt(convert);
        convert = JOptionPane.showInputDialog(pView, "Cantidad de viajes a realizar?");
        IConstants.DRONE_TRIP_TOTAL = Integer.parseInt(convert);
        convert = JOptionPane.showInputDialog(pView, "Cantidad de tiempo?");
        IConstants.SIMULATION_TIME = Integer.parseInt(convert);
        convert = JOptionPane.showInputDialog(pView, "Cantidad de pistas(arcos) por estacion?");
        IConstants.ARCH_TOTAL = Integer.parseInt(convert);
        convert = JOptionPane.showInputDialog(pView, "Algoritmo a realizar");
        algorithmOption = Integer.parseInt(convert);
        
        pDrone.calculateMaxDronesPerTrip();
        pDrone.createRandomCircles();  // circleList = { [x,y] ..... }
        pDrone.createNodes();
        pDrone.connectNodesRandomly();
        pDrone.createPaths();
        pDrone.createTrips();
        //pDrone.printTrips();
        
        pView.add(new Window(pDrone.getGraph()));
        pView.setSize(IConstants.WINDOW_WIDTH, IConstants.WINDOW_HEIGHT);
        pView.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        pView.setVisible(true);
        
        switch(algorithmOption) {
            case 1:algorithm = new DivideAndConquerSolution();
            break;
            case 2:algorithm = new BacktrackingSolution();
            break;
            default:algorithm = new ProbabilisticSolution();
        }
        algorithm.scheduleTrips(pDrone.getTripList(),pDrone.createHashKeys());
    }

}
