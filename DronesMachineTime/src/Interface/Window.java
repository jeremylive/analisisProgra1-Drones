package Interface;

import Logic.Connection;
import Logic.Graph;
import Logic.GraphNode;
import Program.IConstants;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

/**
 *
 * █▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀█
 * █░░╦─╦╔╗╦─╔╗╔╗╔╦╗╔╗░░█ 
 * █░░║║║╠─║─║─║║║║║╠─░░█
 * █░░╚╩╝╚╝╚╝╚╝╚╝╩─╩╚╝░░█ 
 * █▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█
 *
 *
 */
public class Window extends JPanel implements MouseListener {

    private Graph graph;

    /**
     * Constructor.
     *
     *
     * @param pGraph
     */
    public Window(Graph pGraph) {
        graph = pGraph;
        addMouseListener(this);
    }

    /**
     * Pinto en la interfaz de modo dinamico, tiempo secuencial.
     *
     *
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        for (Circle circle : IConstants.CIRCLE_LIST) {
            circle.draw(g);
        }
        paintConnections(g);
    }

    private void paintConnections(Graphics g) {
        int circleRadius = IConstants.CIRCLE_DIAMETER / 2;
        for (Connection connection : graph.getConnections()) {
            int originID = connection.getOriginID();
            int destinationID = connection.getDestinationID();
            GraphNode originNode = graph.getNode(originID);
            GraphNode destinationNode = graph.getNode(destinationID);
            g.drawLine(originNode.getxPosition() + circleRadius, originNode.getyPosition() + circleRadius, destinationNode.getxPosition()
                    + circleRadius, destinationNode.getyPosition() + circleRadius);
        }
    }

    /**
     * Metodos mouse !!!!!!!!!!!!
     *
     */
    @Override
    public void mouseClicked(MouseEvent e) {
//        if(e.getButton() == 1){
//            getCirculosList().add(new Circle(e.getX()-30, e.getY()-30));
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
