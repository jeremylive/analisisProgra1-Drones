package Interfaz;

import Estructura.*;
import Programa.IConstants;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

/**
 *
 * █▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀█ █░░╦─╦╔╗╦─╔╗╔╗╔╦╗╔╗░░█ █░░║║║╠─║─║─║║║║║╠─░░█
 * █░░╚╩╝╚╝╚╝╚╝╚╝╩─╩╚╝░░█ █▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█
 *
 *
 */
public class Ventana extends JPanel implements MouseListener {

    //Variables globales
    private int contador;
    private Grafo graph;

    /**
     * Constructor.
     *
     * @param Variables del programa
    *
     */
    public Ventana(Grafo pGraph) {
        graph = pGraph;
        addMouseListener(this);
        this.contador = 0;
    }

    /**
     * Pinto en la interfaz de modo dinamico, tiempo secuencial.
     *
     * @param Objeto sobre el cual dibujo
    *
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        for (Circulo pCirculo : IConstants.circulosList) {
            pCirculo.draw(g);
        }
        paintConnections(g);
    }

    private void paintConnections(Graphics g) {
        int medida = Circulo.d / 2;
        for (Conexion connection : graph.getConexiones()) {
            int originID = connection.getIDOrigen();
            int destinationID = connection.getIDDestino();
            NodoGrafo originNode = graph.getNodo(originID);
            NodoGrafo destinationNode = graph.getNodo(destinationID);
            g.drawLine(originNode.getPosX() + medida, originNode.getPosY() + medida, destinationNode.getPosX() + medida, destinationNode.getPosY() + medida);
        }
    }

    /**
     * Metodos mouse !!!!!!!!!!!!
    *
     */
    @Override
    public void mouseClicked(MouseEvent e) {
//        if(e.getButton() == 1){
//            getCirculosList().add(new Circulo(e.getX()-30, e.getY()-30));
//       
//                 
//            for (int i = 0; i < getCirculosList().size(); i++) {
//                System.out.println("codigo>>" + getCirculosList().get(i).getIndiceX() + " " + 
//                    getCirculosList().get(i).getIndiceY());
//            }
//            
//        
//            
//            repaint();
//        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

//fin de la estructura del programa calculo de drones.................................................................100%   
}
