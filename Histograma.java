import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
/**
* Clase auxiliar para crar histogramas de frecuencias, muetsra la cantidad registrada en cada barra
* y su edad en la base de la gráfica.
* @author Chávez Zamora Mauro Emiliano - 111001079
* @author Ortiz Castañeda José Ramón - 318357115
* @version 1.0 Mayo 2022
* @since Estructuras de Datos 2022-1.
*/
public class Histograma extends JPanel{

    static Frecuencia[] frecuencia; // Arreglo de frecuencia de edades
    static int mayor; // Tiene un punto de referencia para las alturas
    static Color[] coloresGei = {new Color(218, 0, 9),new Color(253, 121, 9),new Color(253, 236, 11),new Color(14, 112, 27),new Color(2,45, 254),new Color(98, 0, 118),new Color(0, 0, 0)};

    /**
     * Obtener la edad con mayor número de alumnos
     * @param a arreglo de frecuencias
     * @param total número de edades que hay registradas (edades, no frecuencias)
     * @return número que más se repite
     */
    public static int obtenerMayor(Frecuencia[] a, int total){  
        Frecuencia temp;  
        for (int i = 0; i < total; i++){  
            for (int j = i + 1; j < total; j++){  
                if (a[i].getFricencia() > a[j].getFricencia()){  
                    temp = a[i];  
                    a[i] = a[j];  
                    a[j] = temp;  
                }  
            }  
        }  
            return a[total-1].getFricencia();  
    }  

    /**
     * Calcula la altura necesaria para una barra, toma como referencia a la más grande
     * @param actual cantidad de elementos en una edad
     * @return altura segun la frecuencia
     */
    public int calculaAltura(int actual){
        return (actual*600)/Histograma.mayor;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int ancho = 10;
        for(int x = 0; x <Histograma.frecuencia.length; x++){
            int height = calculaAltura(frecuencia[x].getFricencia());
            g.setColor(coloresGei[x]); // Toma un color Gei 
            g.drawRect(ancho,650-height,90,height); // Contorno
            g.fillRect(ancho,650-height,90,height); // Relleno
            g.drawString(frecuencia[x].getFricencia()+"",ancho+40,650-height-5); // Escribe la cantidad de alumnos con esa edad
            g.setColor(coloresGei[6]); // Cambiamos a negro
            g.drawString(frecuencia[x].getEdad()+"",ancho+40,665); // Escribe la edad
            ancho+=100;
        }
    }

    /**
     * Método para crear un histograma
     * @param frecuencia arreglo de frecuencias, almacenan una edad y la cantidad de alumnos registrados con esa
     * @param nombre nombre para la ventana
     */
    public void creaHistogramas(Frecuencia[] frecuencia, String nombre){
        Frecuencia[] auxMayor = frecuencia.clone();
        Histograma.frecuencia = frecuencia;
        Histograma.mayor = obtenerMayor(auxMayor,Histograma.frecuencia.length);
        JFrame ventana = new JFrame(nombre);
        Histograma objeto = new Histograma();
        ventana.add(objeto);
        int cantidad = (Histograma.frecuencia.length*100)+10;
        ventana.setSize(cantidad,700);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}