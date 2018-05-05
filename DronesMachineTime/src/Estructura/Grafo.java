package Estructura;

import Programa.IConstants;
import Librerias.Dijkstra;
import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
/**
*
*█▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀█
*█░░╦─╦╔╗╦─╔╗╔╗╔╦╗╔╗░░█
*█░░║║║╠─║─║─║║║║║╠─░░█
*█░░╚╩╝╚╝╚╝╚╝╚╝╩─╩╚╝░░█
*█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█
*
**/
public class Grafo 
{
    private Random random;
    private List<NodoGrafo> nodos;
    private ArrayList<List<NodoGrafo>> rutasPosiblesGrafo;
    private List<Conexion> conexiones;
    private Dijkstra dijkstra;    
    private ArrayList<Point> puntosEnPantalla;
    private ArrayList<Trip> listTrip;

    /**
     * Constructor.
     */
    public Grafo() 
    {
        this.random = new Random();
        this.nodos = new ArrayList<NodoGrafo>();
        this.rutasPosiblesGrafo = new ArrayList<List<NodoGrafo>>();
        this.conexiones = new ArrayList<>();
        
        this.dijkstra = new Dijkstra();
        this.puntosEnPantalla = new ArrayList<Point>();
   }

    /**
     * Constructor del grafo
     *
     * @param nodos Lista de nodos
     * @param conexiones Lista de arcos
     */
    private Grafo(List<NodoGrafo> nodos, List<Conexion> conexiones, 
            ArrayList<List<NodoGrafo>> pRutasPosiblesGrafo) 
    {
        this.random = new Random();
        this.nodos = nodos;
        this.rutasPosiblesGrafo = pRutasPosiblesGrafo;
        this.conexiones = conexiones;
        
        this.dijkstra = new Dijkstra();
        this.puntosEnPantalla = new ArrayList<>();
    }
    
    /**
    * Gets and Sets
    **/
    
    
    public List<NodoGrafo> getNodos() 
    {
        return nodos;
    }

    public List<Conexion> getConexiones() 
    {
        return conexiones;
    }

    /**
     * Take the most near rute to nodos
     *
     * @param nodo 
     */
    public void getDijkstraPaths(NodoGrafo nodo) 
    {
        dijkstra = new Dijkstra(this);
        dijkstra.buscarRutas(nodo);
    }

    /**
     * Add nodo to list
     *
     * @param nuevo Nodo to going to insert
     */
    public void addNodo(NodoGrafo nuevo) 
    {
        nodos.add(nuevo);
    }

    /**
     * Devuelve el nodo en la lista de nodos del grafo
     *
     * @param indice para buscar en lista
     * @return El nodo buscado
     */
    public NodoGrafo getNodo(int indice) 
    {
        return nodos.get(indice);
    }

    /**
     * Take out the rute to the destiny
     *
     * @param destino destiny
     * @return the nodos list
     */
    public LinkedList<NodoGrafo> getPathTo(NodoGrafo destino) 
    {
        return dijkstra.getRuta(destino);
    }

    /**
     * Bring the most neraly ruto to two point, origen and destiny
     *
     * @param fuente origen point
     * @param destino destiny point
     * @return The list of the rute most nearly for thougth
     */
    public LinkedList<NodoGrafo> getPathFromAtoB(NodoGrafo fuente, NodoGrafo destino) 
    {
        //Saco el mapa de conexiones con el nodo fuente
        getDijkstraPaths(fuente);
        
        LinkedList<NodoGrafo> ruta = getPathTo(destino);
        if(ruta!= null){
            if(ruta.size()<2){
                System.out.println("No hay ruta");
            }
        }
        return ruta;
    }

    /**
     * The distance bewteen in to points
     *
     * @param origen Start nodo
     * @param destino Destiny nodo
     * @return The distance bewteen in to points
     */
    public double getDistancia(NodoGrafo origen, NodoGrafo destino)
    {
        double distance = 0.0;
        int idOrigin = origen.getId();
        int idDestination = origen.getId();
        
        for(Conexion currentConection : conexiones) {
            if(currentConection.getIDOrigen() == idOrigin && currentConection.getIDDestino() == idDestination) {
                distance = currentConection.getDistancia();
                break;
            } 
        }
        return distance;
    }

    
    /**
     * Validate if the new posicion is not exits in the program
     *
     * @param x point view
     * @param y point view
     * @return True: if the point not exits in the program False: if yet.
     */
    public boolean inListaPuntos(int x, int y)
    {
        boolean encontrado = false;
        int medida = 0;
        for (Point punto : puntosEnPantalla) 
        {
            if( ( punto.x + medida > x   &&   x >= punto.x - medida))
                encontrado = true;
            if( ( punto.y + medida > y  &&    y >= punto.y - medida))
                encontrado = true;
        }
        if(!encontrado)
        {
            puntosEnPantalla.add(new Point(x, y));
        }
        return encontrado;
    }
     
    public boolean hasConnection(NodoGrafo node) {
        for(Conexion connection : conexiones) {
            if(connection.getIDOrigen() == node.getId() || connection.getIDDestino() == node.getId()) {
                return true;
            }
        }
        return false;
    }
    
}
