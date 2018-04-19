package Programa;

import Interfaz.Ventana;
import javax.swing.JFrame;

public class DroneStart 
{
    public static void main(String[] args) 
    {
    
        //Inicializar controladores
        
        //Inicializar interfaz
        JFrame pView = new JFrame("PROGRA_DRONES");
        pView.add(new Ventana());
        pView.setSize(600,600);
        pView.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        pView.setVisible(true);
    }
}
