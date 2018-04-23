package Programa;

import Estructura.Grafo;
import Estructura.NodoGrafo;
import Interfaz.Circulo;
import java.awt.Point;
import java.awt.Rectangle;
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
    private IConstants pConstants;
    private boolean bandera1;
    private Random random;
    private JFrame frame;
    private int contador;

    
    /**
    * Constructor.
    **/
    public DroneCounty(IConstants pGlobales, JFrame pFrame)
    {
        start();
        
        this.pConstants = pGlobales;
        this.bandera1 = false;
        this.random = new Random();
        this.frame = pFrame;
        this.contador = 0;
    }
    
    /**
    * Menu.
    **/
    public void start()
    {
        String convert = "";
        convert = JOptionPane.showInputDialog(frame,"Cantidad de estaciones? (max 30)");
        pConstants.cantEstaciones = Integer.parseInt(convert);
        convert = JOptionPane.showInputDialog(frame,"Alto de las pistas?");
        pConstants.altoPistas = Integer.parseInt(convert);
        convert = JOptionPane.showInputDialog(frame,"Ancho de las pistas?");
        pConstants.anchoPistas = Integer.parseInt(convert);
        convert =  JOptionPane.showInputDialog(frame,"Cantidad de viajes a realizar?");
        pConstants.cantViajes = Integer.parseInt(convert);
        convert = JOptionPane.showInputDialog(frame,"Cantidad de tiempo?");
        pConstants.cantTiempo = Integer.parseInt(convert);
        convert = JOptionPane.showInputDialog(frame,"Cantidad de pistas(arcos) por estacion?");
        pConstants.cantArcos = Integer.parseInt(convert);
        pConstants.velocidadConstante = 120;
    }
    
    
    /**
    * Le asigno valor de coordenadas aleatorias a los nodos del grafo.
    *
    **/
    public void crearCordenadasAleatoriasNodos()
    {
        //
        int totalDrones = pConstants.cantEstaciones;
        //
        for (int i = 0; i <= totalDrones; i++) 
        {    
            //randoms
            int rX = random.nextInt(600);
            int rY = random.nextInt(600);
            validate(rX, rY);
            
            //Creo y agrego el circulo a la variable global
            if(isOver(rX, rY))
            {
                Circulo pCirculo = new Circulo(rX, rY);
                pConstants.circulosList.add(pCirculo);
            }else{
                                //randoms
                rX = random.nextInt(600);
                rY = random.nextInt(600);
                validate(rX, rY);

                //Creo y agrego el circulo a la variable global
                if(isOver(rX, rY))
                {
                    Circulo pCirculo = new Circulo(rX, rY);
                    pConstants.circulosList.add(pCirculo);
                }
            }
            
            
        }
        //
        for (int i = 0; i < pConstants.circulosList.size(); i++) 
        {
            System.out.println("cordenadas>>"+pConstants.circulosList.get(i).getIndiceX()
                    +" "
                    +pConstants.circulosList.get(i).getIndiceY());
        }
        
    }

    /**
     * Validate
     */
    public void validate(int rX, int rY)
    {
        //1.rX no puede existir en el grafo y rY no puede ser rGlobal ni estar en grafo
        if(!pConstants.circulosList.isEmpty())
        {
            validarRandomNodosGrafo(rX, rY);  
        }

        //no deben ser iguales el x y y
        if(rY==rX)
        {
            rY = random.nextInt(600);
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
                    rY = random.nextInt(600);
                }
            }else{
                rX = random.nextInt(600);
                rY = random.nextInt(600);
            }
        }
    }

    /**
    * Indica si esta en el area del nodo, para que no caiga encima los nodos aleatorios.
    *
    * @param Punto actual de la iteracion por la que va evaluando si el aleatorio es valido.
    * @return bandera si es valida entonces las coordenadas no caeran sobre algun otro nodo existente.
    **/
    public boolean isOver(int x, int y)
    {
        //
        Rectangle figura = new Rectangle(x-Circulo.d/2, y - Circulo.d/2, Circulo.d,Circulo.d);
        //
        for(Circulo pCircle : pConstants.circulosList)
        {
            if(new Rectangle(pCircle.getIndiceX()-Circulo.d/2, pCircle.getIndiceY()-Circulo.d/2, Circulo.d, Circulo.d).intersects(figura))
            {
                return false;
            }
        }
        return true;
    }

    /**
     * Creat nodo and insert to the Grafo
     * 
     * @param Gafo
     */
    public void crearNodoCoordenadas(Grafo grafo)
    {
        int totalEst = (int)IConstants.cantEstaciones;
        contador = 0;
        for (Circulo coordenadas : IConstants.circulosList) {                
            contador += 1;
            System.out.println(totalEst);
            System.out.println(contador);
            if(contador < totalEst){
                NodoGrafo nodo = new NodoGrafo(contador);
                nodo.setPosX(coordenadas.getIndiceX());
                nodo.setPosY(coordenadas.getIndiceY());
                grafo.addNodo(nodo);
            }
        }
        
        System.out.println("......."+grafo.getNodos().size());
        
        for (int i = 0; i < grafo.getNodos().size(); i++) {
            System.out.println(grafo.getNodo(i).getPosX() + "-" + grafo.getNodo(i).getPosY());
        }
    }
    
    /**
     * 
     */
    public void setCantEstaciones()
    {
        int anchoPista = IConstants.anchoPistas;
        int anchoDrone = IConstants.anchutaDrone;
        IConstants.cantDronesPistaMax = anchoPista/anchoDrone;        
    }
    
    /**
     * Recorre el grafo y le va dando arcos de nodos aleatorios
     */
    public void setArcosRandom()
    {
        
    }
    
    /**
     * Obtengo de un trip el peso total 
     */
    public void getPesoTotal()
    {
        
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
