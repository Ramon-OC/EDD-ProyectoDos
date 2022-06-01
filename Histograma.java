import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
public class Histograma extends JPanel{

    static Frecuencia[] frecuencia;
    static int mayor;
    static Color[] coloresGei = {new Color(218, 0, 9),new Color(253, 121, 9),new Color(253, 236, 11),new Color(14, 112, 27),new Color(2,45, 254),new Color(98, 0, 118),new Color(0, 0, 0)};

    public static int getLargest(Frecuencia[] a, int total){  
        Frecuencia temp;  
        for (int i = 0; i < total; i++)   
                {  
                    for (int j = i + 1; j < total; j++)   
                    {  
                        if (a[i].getFricencia() > a[j].getFricencia())   
                        {  
                            temp = a[i];  
                            a[i] = a[j];  
                            a[j] = temp;  
                        }  
                    }  
                }  
            return a[total-1].getFricencia();  
        }  

    public int calculaAltura(int actual){
        System.out.println("Esta es la altura: "+ (actual*600)/Histograma.mayor);
        return (actual*600)/Histograma.mayor;

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        System.out.println("El largo de frecuencia: "+frecuencia.length);

        int ancho = 10;
        for(int x = 0; x <Histograma.frecuencia.length; x++){
            System.out.println(1);
            int height = calculaAltura(frecuencia[x].getFricencia());
            g.setColor(coloresGei[x]);

            g.drawRect(ancho,650-height,90,height);
            g.fillRect(ancho,650-height,90,height);
            ancho+=100;
        }
    }

    /*
    public static void main(String[] args){
        JFrame ventana = new JFrame( "Formas Básicas");
        Histograma objeto = new Histograma();
        ventana.add(objeto);
        ventana.setSize(710,700);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }*/

    public void creaHistogramas(Frecuencia[] frecuencia, String nombre){
        Histograma.frecuencia = frecuencia;
        Histograma.mayor = getLargest(Histograma.frecuencia,Histograma.frecuencia.length);
        JFrame ventana = new JFrame(nombre);
        Histograma objeto = new Histograma();
        ventana.add(objeto);
        int cantidad = (Histograma.frecuencia.length*100)+10;
        ventana.setSize(cantidad,700);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }




}
