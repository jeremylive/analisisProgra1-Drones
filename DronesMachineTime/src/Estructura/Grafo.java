package Estructura;
//Bibliotecas a usar
import Programa.IConstants;
import Librerias.Dijkstra;
import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
/**
 * Clase Singleton para manejo global de esta
 *
 * @author live y edgerik
 */
public class Grafo {
    //Variables globales
    private List<NodoGrafo> nodos;
    private List<Conexion> conexiones;
    private Dijkstra dijkstra;
    private Random random;
    private ArrayList<Point> puntosEnPantalla;
    /**
     * Constructor, defaultf
     */
    public Grafo() {
        this.nodos = new ArrayList<>();
        this.conexiones = new ArrayList<>();
        this.dijkstra = new Dijkstra();
        this.random = new Random();
        this.puntosEnPantalla = new ArrayList<>();
    }

    /**
     * Constructor del grafo
     *
     * @param nodos Lista de nodos
     * @param conexiones Lista de arcos o bordes
     */
    private Grafo(List<NodoGrafo> nodos, List<Conexion> conexiones) {
        this.nodos = nodos;
        this.conexiones = conexiones;
        this.dijkstra = new Dijkstra();
        this.random = new Random();
        this.puntosEnPantalla = new ArrayList<>();
    }
    

    /**
     * Agregar nodo a la lista
     *
     * @param nuevo El nodo a insertar
     */
    public void addNodo(NodoGrafo nuevo) 
    {
        nodos.add(nuevo);
    }

    /**
     * Tomar las rutas más cercanas a nodos
     *
     * @param nodo El nodo del cual sacar rutas
     */
    public void getDijkstraPaths(NodoGrafo nodo) 
    {
        dijkstra = new Dijkstra(this);
        dijkstra.buscarRutas(nodo);
    }

    
    /**
     * Devuelve la ruta más cercana del nodo fuente al nodo destino
     *
     * @param fuente Punto de salida
     * @param destino Punto de llegada
     * @param player
     * @return Lista de nodos por los cuales pasar para llegar (Ruta más corta)
     */
    public LinkedList<NodoGrafo> getPathFromAtoB(NodoGrafo fuente, NodoGrafo destino, boolean player) 
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
     * Saca la distancia de una coordenada
     * @param origen nodo inicio
     * @param destino nodo al cual llegar
     * @return la distancia de origen a destino
     */
    public double getDistancia(double origen, double destino)
    {
        double diferencia;
        
        if(origen < destino)
            diferencia = destino - origen;
        else
            diferencia = origen - destino;
        
        return diferencia;
    }
    
    /**
     * Dice si la posicion aleatoria dada es valida
     * @param x en pantalla
     * @param y en pantalla
     * @return true si el punto(x,y) es valido
     */
    public boolean inListaPuntos(int x, int y)
    {
        boolean encontrado = false;
        int medida = IConstants.medidaNodo;
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
    
    /**d
     * Saca ruta a destino
     *
     * @param destino Nodo al cual llegar
     * @return
     */
    public LinkedList<NodoGrafo> getPathTo(NodoGrafo destino) 
    {
        return dijkstra.getRuta(destino);
    }

    
    /**
     * @param idCamino Identificacion de ruta
     * @param fuente Nodo Fuente
     * @param destino Nodo Destino
     * @param distancia Peso de la ruta
     */
    public void addBorde(String idCamino, NodoGrafo fuente, NodoGrafo destino, double distancia) 
    {
        
        boolean existe = false;
        for (Conexion conexion : conexiones) 
        {
            if( conexion.getOrigen().equals(fuente) && conexion.getDestino().equals(destino))
            {
                existe = true;
                break;
            }
        }
        if(!existe)
        {
            Conexion ida = new Conexion(idCamino, fuente, destino, distancia);
            Conexion vuelta = new Conexion(idCamino, destino, fuente, distancia);

            conexiones.add(ida);
            conexiones.add(vuelta);
        }
    }

    /**
     *
     * @return Lista de nodos del grafo
     */
    public List<NodoGrafo> getNodos() {
        return nodos;
    }

    /**
     *
     * @return Lista de conexiones, puentes o arcos
     */
    public List<Conexion> getConexiones() {
        return conexiones;
    }

    
}
