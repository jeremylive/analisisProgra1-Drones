package Programa;

import Estructura.Conexion;
import Estructura.Grafo;
import Estructura.NodoGrafo;
import Estructura.Trip;
import Interfaz.Circulo;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import javax.swing.JFrame;

/**
 *
 * █▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀█ █░░╦─╦╔╗╦─╔╗╔╗╔╦╗╔╗░░█ █░░║║║╠─║─║─║║║║║╠─░░█
 * █░░╚╩╝╚╝╚╝╚╝╚╝╩─╩╚╝░░█ █▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█
 *
 *
 */
public class DroneCounty {

    //Variables globales.
    private boolean bandera1;
    private Random random;
    private JFrame frame;
    private int contador;

    private Grafo grafo;
    private ArrayList<ArrayList<Integer>> shortRoutes;
    private ArrayList<ArrayList<Integer>> durations;
    private ArrayList<Trip> tripList;

    /**
     * Constructor.
     *
     */
    public DroneCounty(JFrame pFrame) {

        this.bandera1 = false;
        this.random = new Random();
        this.frame = pFrame;
        this.contador = 0;

        this.grafo = new Grafo();
        shortRoutes = new ArrayList<>();
        durations = new ArrayList<>();
        tripList = new ArrayList<>();
    }

    public ArrayList<Trip> getTripList() {
        return tripList;
    }

    public Grafo getGrafo() {
        return grafo;
    }

    /**
     * Menu.
     *
     */
    /**
     * Le asigno valor de coordenadas aleatorias a los nodos del grafo.
     *
     *
     */
    public void crearCordenadasAleatoriasNodos() {
        //
        int totalDrones = IConstants.cantEstaciones, circlesCreated = 0;
        while (circlesCreated < totalDrones) {
            //randoms
            int rX = random.nextInt(IConstants.WINDOW_WIDTH - Circulo.d) + Circulo.d/2;
            int rY = random.nextInt(IConstants.WINDOW_HEIGHT - Circulo.d) + Circulo.d/2;
            //validate(rX, rY);

            //Creo y agrego el circulo a la variable global
            if (isNotOver(rX, rY)) {
                Circulo pCirculo = new Circulo(rX, rY);
                IConstants.circulosList.add(pCirculo);
                circlesCreated++;
            }
        }
        //
        for (int i = 0; i < IConstants.circulosList.size(); i++) {
            System.out.println("cordenadas>>" + IConstants.circulosList.get(i).getIndiceX()
                    + " "
                    + IConstants.circulosList.get(i).getIndiceY());
        }

    }

    /**
     * Validate
     */
    public int[] validate(int rX, int rY) {
        int[] result = {rX, rY};
        //1.rX no puede existir en el grafo y rY no puede ser rGlobal ni estar en grafo
        if (!IConstants.circulosList.isEmpty()) {
            result = validarRandomNodosGrafo(rX, rY);
        }
        return result;
    }

    /**
     * Valido que no sean los mismos randoms.
     *
     * @param puntos del nodo actual, el que se va dibujar.
     * @return
     *
     */
    public int[] validarRandomNodosGrafo(int rX, int rY) {
        for (Circulo pCirculo : IConstants.circulosList) {
            if (rX == pCirculo.getIndiceX()) {
                rX = random.nextInt(IConstants.WINDOW_WIDTH);
            }
            if (rY == pCirculo.getIndiceY()) {
                rY = random.nextInt(IConstants.WINDOW_HEIGHT);
            }
        }
        int[] result = {rX, rY};
        return result;
    }

    /**
     * Indica si esta en el area del nodo, para que no caiga encima los nodos
     * aleatorios.
     *
     * @param Punto actual de la iteracion por la que va evaluando si el
     * aleatorio es valido.
     * @return bandera si es valida entonces las coordenadas no caeran sobre
     * algun otro nodo existente.
     *
     */
    public boolean isNotOver(int x, int y) {
        //
        Rectangle figura = new Rectangle(x - Circulo.d / 2, y - Circulo.d / 2, Circulo.d, Circulo.d);
        //
        for (Circulo pCircle : IConstants.circulosList) {
            if (new Rectangle(pCircle.getIndiceX() - Circulo.d / 2, pCircle.getIndiceY() - Circulo.d / 2, Circulo.d, Circulo.d).intersects(figura)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Creat nodo and insert to the Grafo
     *
     * @param Grafo
     */
    public void crearNodoCoordenadas() {
        int totalEst = (int) IConstants.cantEstaciones;
        contador = 0;
        for (Circulo coordenadas : IConstants.circulosList) {
            System.out.println(totalEst);
            System.out.println(contador);
            if (contador < totalEst) {
                NodoGrafo nodo = new NodoGrafo(contador);
                nodo.setPosX(coordenadas.getIndiceX());
                nodo.setPosY(coordenadas.getIndiceY());
                grafo.addNodo(nodo);
            }
            contador += 1;
        }

        System.out.println("......." + grafo.getNodos().size());

        for (int i = 0; i < grafo.getNodos().size(); i++) {
            System.out.println(grafo.getNodo(i).getPosX() + "-" + grafo.getNodo(i).getPosY());
        }
    }

    /**
     *
     */
    public void calculateMaxDronesPerTrip() {
        int maxDrones;
        maxDrones = (IConstants.anchoPistas / IConstants.DRONE_WIDTH);
        maxDrones *= (IConstants.altoPistas / IConstants.DRONE_HEIGHT);
        IConstants.MAX_DRONES_PER_TRIP = maxDrones;
    }

    /**
     * Recorre el grafo y le va dando arcos de nodos aleatorios
     */
    public void setArcosRandom() {
        NodoGrafo origin, destination;
        int selectedDestination, connections, currentConnection = 0;
        ArrayList<NodoGrafo> nodesNotConnected = getNodesNotConneted();
        while (!nodesNotConnected.isEmpty() && !(nodesNotConnected.size() == 1)) {
            origin = nodesNotConnected.get(0);
            selectedDestination = random.nextInt(nodesNotConnected.size() - 1) + 1;
            destination = nodesNotConnected.get(selectedDestination);
            addBorde(origin, destination, calculateDistance(origin, destination));
            nodesNotConnected = getNodesNotConneted();
        }
        ArrayList<ArrayList<Double>> closestNodes;
        for (NodoGrafo node : grafo.getNodos()) {
            if (nodesNotConnected.contains(node)) {
                connections = 0;
            } else {
                connections = 1;
            }
            currentConnection = 0;
            closestNodes = getClosestNodes(node);
            while (connections < IConstants.cantArcos) {
                int destinationNodeID = closestNodes.get(currentConnection).get(1).intValue();
                if (addBorde(node, grafo.getNodo(destinationNodeID), closestNodes.get(currentConnection).get(0))) {
                    connections++;
                }
                currentConnection++;
            }
        }
    }

    private ArrayList<NodoGrafo> getNodesNotConneted() {
        ArrayList<NodoGrafo> result = new ArrayList<>();
        for (NodoGrafo node : grafo.getNodos()) {
            if (!grafo.hasConnection(node)) {
                result.add(node);
            }
        }
        return result;
    }

    private ArrayList<ArrayList<Double>> getClosestNodes(NodoGrafo node) {
        ArrayList<ArrayList<Double>> nodeDistanceID = new ArrayList<>();
        ArrayList<Double> distanceIDPair;
        for (NodoGrafo currentNode : grafo.getNodos()) {
            if (!currentNode.equals(node)) {
                distanceIDPair = new ArrayList<>();
                distanceIDPair.add(calculateDistance(node, currentNode));
                distanceIDPair.add((new Double(currentNode.getId())));
                nodeDistanceID.add(distanceIDPair);
            }
        }
        //Sort Array
        ArrayList<ArrayList<Double>> sortedNodeList = new ArrayList<>();
        Double lowestDistance, lowestNodeID;
        while (!nodeDistanceID.isEmpty()) {
            lowestDistance = Double.MAX_VALUE;
            lowestNodeID = 0.0;
            for (ArrayList<Double> currentPair : nodeDistanceID) {
                if (currentPair.get(0) < lowestDistance) {
                    lowestDistance = currentPair.get(0);
                    lowestNodeID = currentPair.get(1);
                }
            }
            distanceIDPair = new ArrayList<>();
            distanceIDPair.add(lowestDistance);
            distanceIDPair.add(lowestNodeID);
            sortedNodeList.add(distanceIDPair);
            nodeDistanceID.remove(distanceIDPair);
        }
        return sortedNodeList;
    }

    private double calculateDistance(NodoGrafo origin, NodoGrafo destination) {
        int xSum = Math.abs(origin.getPosX() - destination.getPosX());
        int ySum = Math.abs(origin.getPosY() - destination.getPosY());
        return xSum + ySum;
    }

    /**
     * Validate the equals of the exist rute.
     *
     * @param idCamino Identificacion de ruta
     * @param fuente origen point
     * @param destino destiny point
     * @param distancia Peso of the rute
     *
     * @return true: Not exits in the program, false: Exist yet.
     */
    private boolean addBorde(NodoGrafo fuente, NodoGrafo destino, double distancia) {
        for (Conexion conexion : grafo.getConexiones()) {
            if (conexion.getIDOrigen() == fuente.getId() && conexion.getIDDestino() == destino.getId()) {
                return false;
            }
        }
        Conexion ida = new Conexion(fuente.getId(), destino.getId(), distancia);
        Conexion vuelta = new Conexion(destino.getId(), fuente.getId(), distancia);
        grafo.getConexiones().add(ida);
        grafo.getConexiones().add(vuelta);
        return true;
    }

    public void createShortRoutes() {

        NodoGrafo origen; //a temporal of the nodes of the graph
        NodoGrafo destino;

        int cantNodes = this.grafo.getNodos().size(); //size of all nodes in the graph

        for (int i = 0; i < cantNodes; i++) {
            origen = grafo.getNodo(i); //get node

            for (int j = 0; j < cantNodes; j++) {
                if (i != j) {
                    destino = grafo.getNodo(j);

                    LinkedList<NodoGrafo> ruta = grafo.getPathFromAtoB(origen, destino);

                    insertarShortRoutes(ruta);

                }

                //get dijstra
                //insertar la ruta y la distancias.(hacer nuevo metodo)
            }
        }

    }

    public void insertarShortRoutes(LinkedList<NodoGrafo> ruta) {
        ArrayList<Integer> ids = new ArrayList();
        ArrayList<Integer> duraciones = new ArrayList();

        for (int i = 0; i < ruta.size(); i++) {
            NodoGrafo nodoActual = ruta.get(i);
            ids.add(nodoActual.getId());
        }

        for (int i = 0; i + 1 < ruta.size(); i++) {
            NodoGrafo nodoActual = ruta.get(i);
            NodoGrafo nodoSiguiente = ruta.get(i + 1);

            double distance = grafo.getDistancia(nodoActual, nodoSiguiente);

            int duration = (int) (((distance / IConstants.velocidadConstante) * 60) * 60);

            duraciones.add(duration);

        }

        this.shortRoutes.add(ids);
        this.durations.add(duraciones);

    }

    public void createTrips() {
        for (int currentTrip = 0; currentTrip < (IConstants.cantViajes / IConstants.MAX_DRONES_PER_TRIP); currentTrip++) {
            int selectedOption = random.nextInt(shortRoutes.size());
            tripList.add(new Trip(shortRoutes.get(selectedOption), durations.get(selectedOption)));
        }
    }

}
