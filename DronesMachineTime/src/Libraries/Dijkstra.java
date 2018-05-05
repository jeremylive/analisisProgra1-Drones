package Libraries;

import Logic.Connection;
import Logic.Graph;
import Logic.GraphNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
*
*█▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀█
*█░░╦─╦╔╗╦─╔╗╔╗╔╦╗╔╗░░█
*█░░║║║╠─║─║─║║║║║╠─░░█
*█░░╚╩╝╚╝╚╝╚╝╚╝╩─╩╚╝░░█
*█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█
*
**/
public class Dijkstra {

    //Variables globales
    private List<GraphNode> nodos;
    private List<Connection> bordes;
    private Set<GraphNode> nodosListos;
    private Set<GraphNode> nodosNoListos;
    private Map<GraphNode, GraphNode> predecesores;
    private Map<GraphNode, Double> distancia;

    /**
     * Constructor, Le pasa el grafo al dijkstra
     *
     * @param graph El grafo a manejar
     */
    public Dijkstra(Graph graph) {
        this.nodos = new ArrayList<>(graph.getNodes());
        this.bordes = new ArrayList<>(graph.getConnections());
    }

    /**
     * Constructor, Crea un dijkstra para luego darle el grafo y buscar rutas
     */
    public Dijkstra() {
        this.nodos = null;
        this.bordes = null;
    }

    /**
     * Busca rutas
     *
     * @param origen Nodo del cual se empezará
     */
    public void buscarRutas(GraphNode origen) {
        nodosListos = new HashSet<>();
        nodosNoListos = new HashSet<>();
        distancia = new HashMap<>();
        predecesores = new HashMap<>();
        //Le doy al mapa el peso de origen a origen
        distancia.put(origen, 0.0);
        //Y a;ado al set de nodos por process
        nodosNoListos.add(origen);
        //mientras haya nodos sin process
        while (nodosNoListos.size() > 0) {

            //Consigo el minimo de los nodos no procesados
            GraphNode nodo = getMinimo(nodosNoListos);
            //Se marca listo a;adiendo a lista de procesados 
            nodosListos.add(nodo);
            //y eliminando de lista de no procesados
            nodosNoListos.remove(nodo);
            //Encuentro distancia minima 
            encontrarDistanciaMinima(nodo);
        }
    }

    /**
     * Busca en la lista de nodos adyacentes el nodo con la distancia minima
     *
     * @param nodo Con el cual hacer el recorrido
     */
    private void encontrarDistanciaMinima(GraphNode nodo) {
        List<GraphNode> adyacentes = (List<GraphNode>) getAdyacentes(nodo);
        //Recorro los nodos que lo conectan
        for (GraphNode objetivo : adyacentes) {
            //Si la distancia mas corta del objetivo es mayor a la distancia de
            //mas corta del nodo + la distancia del nodo al objetivo
            //Lo inserto 
            if (getDistanciaMasCorta(objetivo) > getDistanciaMasCorta(nodo) + getDistancia(nodo, objetivo)) {
                distancia.put(objetivo, getDistanciaMasCorta(nodo) + getDistancia(nodo, objetivo));
                predecesores.put(objetivo, nodo);
                nodosNoListos.add(objetivo);
            }
        }

    }

    /**
     * Obtengo distancia
     *
     * @param origen Nodo fuente
     * @param objetivo Nodo destino
     * @return Peso de la conexion
     */
    public double getDistancia(GraphNode origen, GraphNode destino) {
        for (Connection edge : bordes) {
            if (edge.getOriginID() == origen.getNodeID() && edge.getDestinationID() == destino.getNodeID()) {
                return edge.getWeight();
            }
        }
        throw new RuntimeException("Should not happen");
    }

    /**
     * Obtengo lista nodos adyacentes
     *
     * @param nodo Con el cual buscar
     * @return Lista de nodos que estan conectados a este
     */
    public List<GraphNode> getAdyacentes(GraphNode nodo) {
        List<GraphNode> neighbors = new ArrayList<>();
        for (Connection borde : bordes) {
            if (borde.getOriginID() == nodo.getNodeID() && !hayConexion(nodos.get(borde.getDestinationID()))) {
                neighbors.add(nodos.get(borde.getDestinationID()));
            }
        }
        return neighbors;
    }

    /**
     * Busca en nodos no procesados el nodo mas cercano
     *
     * @param bordes
     * @return El nodo más cercano
     */
    private GraphNode getMinimo(Set<GraphNode> bordes) {
        GraphNode minimo = null;
        //Recorro la lista de nodos por process
        for (GraphNode borde : bordes) {
            if (minimo == null) {
                minimo = borde;
            } else {
                //Saco el minimo de esta lista
                if (getDistanciaMasCorta(borde) < getDistanciaMasCorta(minimo)) {
                    minimo = borde;
                }
            }
        }
        return minimo;
    }

    /**
     * Revisa si hay conexion
     *
     * @param borde Busca la ruta
     * @return true si existe, false si no
     */
    private boolean hayConexion(GraphNode borde) {
        return nodosListos.contains(borde);
    }

    /**
     * Busca la distancia minima
     *
     * @param destino
     * @return La distancia minima
     */
    private double getDistanciaMasCorta(GraphNode destino) {
        //Devuelve el peso de la conexion con destino del Mapa recien creado
        Double d = distancia.get(destino);
        if (d == null) {
            //Devuelve el mayor numero posible para que no se tome en cuenta
            return Integer.MAX_VALUE;
        } else {
            return d;
        }
    }

    /**
     * Obtengo ruta mas corta
     *
     * @param objetivo Al cual se requiere llegar
     * @return Ruta más corta al destino
     */
    public LinkedList<GraphNode> getRuta(GraphNode objetivo) {
        LinkedList<GraphNode> ruta = new LinkedList<>();
        GraphNode paso = objetivo;
        // Verifico si existe conexion
        if (predecesores.get(paso) == null) {
            return null;
        }
        //Inserto para comenzar a buscar la ruta con este
        ruta.add(paso);
        //Añado los caminos más cortos desde el destino al origen
        while (predecesores.get(paso) != null) {
            paso = predecesores.get(paso);
            //Agrego hasta llegar al origen
            ruta.add(paso);
        }
        // Le damos la vuelta para leerlo correctamente
        Collections.reverse(ruta);
        return ruta;
    }

//fin de la estructura del programa calculo de drones.................................................................100% 
    public void getDistancia() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
