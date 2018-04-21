package Programa;

import Interfaz.Circulo;
import Interfaz.GUI;
import java.util.Random;
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
**/
public class DroneCounty 
{
    //Variables globales.
    IConstants pConstants;
    boolean bandera1 = false;
    Random r = new Random();

    /**
    * Constructor.
    *
    * @param variables del programa.
    **/
    public DroneCounty(IConstants pGlobales)
    {
        start();
        
        this.pConstants = pGlobales;
        
    }
    
    /**
    * Menu inicial.
    **/
    public void start()
    {
        //Creo y muestro la interfaz principal del programa.
        JFrame frame = new GUI();
        frame.setVisible(true);
        //Datos del programa a digitar por el cliente.
        pConstants.cantEstaciones = JOptionPane.showInputDialog(frame,"Cantidad de estaciones? (max 30)");
        pConstants.altoPistas = JOptionPane.showInputDialog(frame,"Alto de las pistas?");
        pConstants.anchoPistas = JOptionPane.showInputDialog(frame,"Ancho de las pistas?");
        pConstants.cantViajes = JOptionPane.showInputDialog(frame,"Cantidad de viajes a realizar?");
        pConstants.cantTiempo = JOptionPane.showInputDialog(frame,"Cantidad de tiempo?");
        pConstants.cantArcos = JOptionPane.showInputDialog(frame,"Cantidad de pistas(arcos) por estacion?");
        pConstants.velocidadConstante = 120;
   
    }
    
    
    /**
    * Le asigno valor de coordenadas aleatorias a los nodos del grafo.
    *
    **/
    public void crearCordenadasAleatoriasNodos()
    {
        //
        int totalDrones = Integer.parseInt(pConstants.cantEstaciones);
        //
        for (int i = 0; i < totalDrones; i++) 
        {    
            //randoms
            int rX = r.nextInt(600);
            int rY = r.nextInt(600);
            
            //1.rX no puede existir en el grafo y rY no puede ser rGlobal ni estar en grafo
            if(!pConstants.circulosList.isEmpty())
            {
                validarRandomNodosGrafo(rX, rY);  
            }
            //no deben ser iguales el x y y
            if(rY==rX)
            {
                rY = r.nextInt(600);
            }
           
            //Creo y agrego el circulo a la variable global
            Circulo pCirculo = new Circulo(rX, rY);
            pConstants.circulosList.add(pCirculo);
        }
        //
        for (int i = 0; i < pConstants.circulosList.size(); i++) 
        {
            System.out.println("cordenadas>>"+pConstants.circulosList.get(i).getIndiceX()
                    +" "
                    +pConstants.circulosList.get(i).getIndiceX());
        }
        
    }

    /**
    * Valido que no sean los mismos randoms.
    * 
    * @param puntos del nodo actual, el que se va dibujar.
    **/
    public void validarRandomNodosGrafo(int rX, int rY)
    {
        for (Circulo pCirculo : pConstants.circulosList) 
        {
            if(rX != pCirculo.getIndiceX())
            {
                if(rY != pCirculo.getIndiceY())
                {
                    bandera1 = true;
                }else{
                    rY = r.nextInt();
                }
            }else{
                rX = r.nextInt();
                rY = r.nextInt();
            }
        }
    }

    /**
    * Indica si esta en el area del nodo, para que no caiga encima los nodos aleatorios.
    *
    * @param Punto actual de la iteracion por la que va evaluando si el aleatorio es valido.
    * @return bandera si es valida entonces las coordenadas no caeran sobre algun otro nodo existente.
    **/
    public boolean isOver(Point p)
    {
        //
        Rectangle figura = new Rectangle(p.x-Circulo.d/2, p.y - Circulo.d/2, Circulo.d,Circulo.d);
        //
        for(Circulo pCircle : pConstants.circulosList)
        {
            if(new Rectangle(pCircle.getX()-Circulo.d/2, pCircle.getY()-Circulo.d/2, Circulo.d, Circulo.d).intersects(figura)
            {
                return false;
            }
        }
        return true;
    }

//    Inserto coordenadas en el grafo
//    public void setCoordenadasPoints()
//    {
//        for (int i = 0; i < pConstants.circulosList.size(); i++) {
//           pConstants.circulosList.get(i).getIndiceX();
//        }
//    }


//fin de la estructura del programa calculo de drones.................................................................100%   
}
