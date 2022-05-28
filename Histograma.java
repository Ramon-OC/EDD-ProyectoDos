import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
public class Histograma extends JPanel{

    Frecuencia[] frecuencia;

    

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //g.drawLine(100,100,200,200);
        /*
        g.setColor(Color.RED);
        g.drawRect(10,550,90,100);
        g.setColor(Color.BLUE);
        g.drawRect(110,550,90,100);
        g.drawRect(210,550,90,100);
        g.drawRect(310,550,90,100);
        g.drawRect(410,550,90,100);
        g.drawRect(510,550,90,100);
        g.drawRect(610,550,90,100);*/

        for(int x = 10; x <frecuencia.length; x+=100){
            g.setColor(Color.RED);
            g.drawRect(x,550,90,100);
        }


    }

    public static void main(String[] args){
        JFrame ventana = new JFrame( "Formas Básicas");
        Histograma objeto = new Histograma();
        ventana.add(objeto);
        ventana.setSize(710,700);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void creaHistogramas(Frecuencia[] frecuencia){
        this.frecuencia = frecuencia;
        JFrame ventana = new JFrame( "Formas Básicas");
        Histograma objeto = new Histograma();
        ventana.add(objeto);
        int cantidad = (frecuencia.length*100)+10;
        ventana.setSize(cantidad,700);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setFrecuencia(Frecuencia[] f){
        this.frecuencia = f;
    }


}
