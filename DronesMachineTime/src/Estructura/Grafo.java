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
    /**
     * Constructor.
     */
    public Grafo() 
    {
        this.random = new Random();
        this.nodos = new ArrayList<>();
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
     * Validate the equals of the exist rute.
     *
     * @param idCamino Identificacion de ruta
     * @param fuente origen point
     * @param destino destiny point
     * @param distancia Peso of the rute
     * 
     * @return true: Not exits in the program, false: Exist yet.
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
     * The distance bewteen in to points
     *
     * @param origen Start nodo
     * @param destino Destiny nodo
     * @return The distance bewteen in to points
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
    
    
//fin de la estructura del programa calculo de drones.................................................................100%    
}
