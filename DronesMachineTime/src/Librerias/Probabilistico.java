package Librerias;

import Estructura.Drone;
import Estructura.Grafo;
import Estructura.NodoGrafo;
import Estructura.TimeInstance;
import Estructura.Trip;
import static Programa.IConstants.cantDronesPistaMax;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Probabilistico 
{
    /**
     * Constructor.
     * 
     */
    public Probabilistico(Grafo grafo, int cantViajes)
    {
        int cantEstaciones = grafo.getNodos().size();
        int cantViajesRealizados=0;
        int numeroViaje=1;
        
        while(cantViajesRealizados<cantViajes)
        {
        
            Random aleatorio = new Random(System.currentTimeMillis());

            int estacionAleatoria = aleatorio.nextInt(cantEstaciones); // conseguimos un valor aleatorio entre la cantidad de nodos del grafo
           

            List<NodoGrafo> Nodos = grafo.getNodos();

            NodoGrafo estacionElegida = Nodos.get(estacionAleatoria); //conseguimos el nodo aleatorio y lo guardamos
            
            //elegir de la matriz de viajes mas cortos un destino aleatorio.
            
            //guardamos esa ruta para asignarselas a la cantidad de drones.
            //sacamos el largo de la ruta y lo guardamos en este valor
            
            int largoRuta = 0;//ruta.size();//ruta falta de conseguir
           
            //almacenar el nodoGrafo siguiente
            //avanzamos en la ruta y conforme avanzamos actualizamos la linea de tiempo.
            for(int i = 0; i<largoRuta; i++)
            {
                int PesoViaje=0;
                
                if (i==0)
                {
                    //actuializamos la linea de tiempo del primer nodo de la ruta
                    
                    //ruta[i].lineaTiempo.get(0).out = [1,numeroViaje]; //linea del tiempo le falta un get
                }
                if (i==largoRuta-1)
                {
                    //en la estacion destino actuliazmos su linea de tiempo
                    
                    //PesoViaje=PesoVijae + ruta[i-1].distancia + ruta[i].distancia;
                   // int valorLineaTiempo = PesoViaje/TiempoTotal;
                    //ruta[i].lineaTiempo.get(valorLineaTiempo).in = [1,numeroViaje]; 
                    
                            
                
                }
                else
                {
                    //actualizamos la linea del tiempo estaciones del medio
                    // int valorLineaTiempo = PesoViaje/TiempoTotal;
                    
                    //ruta[i].lineaTiempo.get(valorLineaTiempo).in = [1,numeroViaje];
                    //ruta[i].lineaTiempo.get(valorLineaTiempo).out = [1,numeroViaje];
                }
            
            }
            

           cantViajesRealizados+=cantDronesPistaMax;
           numeroViaje+=1;

        }
        
        
        
               
    };
   
    };
