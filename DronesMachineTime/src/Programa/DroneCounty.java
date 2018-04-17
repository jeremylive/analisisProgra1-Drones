package Programa;

import Interfaz.GUI;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DroneCounty 
{
    //Variables globales
    String cantEstaciones;
    String altoPistas;
    String anchoPistas;
    String cantViajes;
    String cantTiempo;
    String cantArcos;
    int velocidadConstante;
    

    public DroneCounty()
    {
        start();
    }
    
    public void start()
    {
        //Interfaz de pedido de datos
        JFrame frame = new GUI();
        frame.setVisible(true);
        cantEstaciones = JOptionPane.showInputDialog(frame,"Cantidad de estaciones? (max 30)");
        altoPistas = JOptionPane.showInputDialog(frame,"Alto de las pistas?");
        anchoPistas = JOptionPane.showInputDialog(frame,"Ancho de las pistas?");
        cantViajes = JOptionPane.showInputDialog(frame,"Cantidad de viajes a realizar?");
        cantTiempo = JOptionPane.showInputDialog(frame,"Cantidad de tiempo?");
        cantArcos = JOptionPane.showInputDialog(frame,"Cantidad de pistas(arcos) por estacion?");
        velocidadConstante = 120;
   
        /*
        //Construir Grafo....graficar
        (cantEstaciones, cantArcos)
        
        //SISTEMA DE CONTROL
        //Colocar los drones en los nodos del grafo como nos favorezca. Se pone el origen
        (Grafo, cantViajes) 
        //Ponerle destino aleatorio a cada viaje
        (Grafo, listaOrigen, listaDestino, listaNodosPos)
         
        //Sacar la cantidad de vias en base al alto y ancho......graficar
        (altoPistas, anchoPistas)
                
        //Creo matriz con el dijkstra de todas las rutas de los destinos mas cortos por viaje
        (Grafo)
                
        //probabilista, backtracking o divide y vencerás
        logicaAlgoritmo(Strin[][] matrizViajesCortos, int cantTiempo, int velocidadConstante)
        
        //http://javapiola.blogspot.com/2009/11/tutorial-de-jtextarea-en-java.html
    
        */
    }

}
