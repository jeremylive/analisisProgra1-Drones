package Librerias;

import Estructura.Grafo;
import Estructura.NodoGrafo;
import java.util.List;
import java.util.Random;

public class Probabilistico 
{
    /**
     * Constructor.
     * 
     */
    public Probabilistico(int cantViajes, Grafo grafo)
    {
        int cantEstaciones = grafo.getNodos().size();
        
        for(int i=0; i<cantEstaciones; i++)
        {
        
            Random aleatorio = new Random(System.currentTimeMillis());

            int estacionAleatoria = aleatorio.nextInt(cantEstaciones);

            List<NodoGrafo> Nodos = grafo.getNodos();

            NodoGrafo estacionElegida = Nodos.get(estacionAleatoria);

            establecerHorario(estacionElegida, cantViajes);

        }
        
        
        
               
    };
    void establecerHorario(NodoGrafo estacionElegida, int cantViajes)
    {
        
    }
    };
