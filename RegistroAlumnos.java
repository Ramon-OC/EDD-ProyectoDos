import java.util.Collections;
import java.util.HashMap;
import javax.swing.*;
/**
* Clase principal del programa, se ejecuta el menú de registro.
* @author Chávez Zamora Mauro Emiliano - 111001079
* @author Ortiz Castañeda José Ramón - 318357115
* @version 1.0 Mayo 2022
* @since Estructuras de Datos 2022-1.
*/
public class RegistroAlumnos{

    /** Ordena de menor a mayor el arreglo de Frecuencias mediante Bubble Sort */
    static void bubbleSort(Frecuencia arr[], int n){                                       
        if(n == 1)
            return;
        for(int i=0; i<n-1; i++){
            if(arr[i].getFricencia() > arr[i+1].getFricencia()){ 
                Frecuencia temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
        bubbleSort(arr, n-1);
    }

    public static void main(String[] args){

        JFrame frame = new JFrame();
        /** Se almacenan los alumnos con un número de cuenta y su edad */
        HashMap<Integer, Integer> alumnos = new HashMap<Integer, Integer>();
        /** Cantidad de alumnos registrados por edad */
        Frecuencia[] auxUno = new Frecuencia[7];
        Arbol a = new Arbol();
        String[] opciones = new String[5];
        int opcionAElegir=1;
        int opcion;

        int n=0;
        while(opcionAElegir<=5) {
            opciones[n] = Integer.toString(opcionAElegir); 
            n++;
            opcionAElegir++;
        }

        while(true){
            String seleccion = (String)JOptionPane.showInputDialog(null, "Selecciona una opción\n"
                            +"  1. Registrar alumno\n"
                            +"  2. Ver gráfico de edades\n"
                            +"  3. Ver gráfico de edades ordenado\n"
                            +"  4. Ver árbol de inserciones\n"
                            +"  5. Salir", "Menú", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
            try{
                opcion = Integer.parseInt(seleccion);
            }catch(Exception e){
                opcion = 5;
            }
            if(opcion==1) {
                
                try{
                    
                    String numCuentaString = JOptionPane.showInputDialog(frame, "Escriba un número de cuenta:");
                    int numCuenta = Integer.parseInt(numCuentaString);
                    while((alumnos.containsKey(numCuenta)) || (numCuenta<100000000 || 500000000<numCuenta)){
                        numCuentaString = JOptionPane.showInputDialog(frame, "Ese número de cuenta no es válido o ya está registrado. Trata de nuevo.");
                        numCuenta = Integer.parseInt(numCuentaString);
                    }

                    String edadString = (String)JOptionPane.showInputDialog(frame, "Escriba la edad:");
                    int edad = Integer.parseInt(edadString);
                    while(edad<18 || 25<edad){
                        edadString = (String)JOptionPane.showInputDialog(frame, "Esa edad está fuera de rango. Trata de nuevo.");
                        edad = Integer.parseInt(edadString);
                    }

                    alumnos.put(numCuenta, edad);
                    a.insertarNodo(numCuenta);

                }catch(Exception e){
                    JOptionPane.showMessageDialog(frame, "¡Lo siento! Sólo puedes poner caracteres numéricos, no es posible poner cadenas de texto.");
                }
                
                /*alumnos.put(1, 18);
                alumnos.put(2, 18);
                alumnos.put(3, 19);
                alumnos.put(4, 20);
                alumnos.put(5, 20);
                alumnos.put(6, 20);
                alumnos.put(7, 21);
                alumnos.put(8, 22);
                alumnos.put(9, 22);
                alumnos.put(10, 23);
                alumnos.put(11, 23);
                alumnos.put(12, 24);
                alumnos.put(13, 24);
                alumnos.put(14, 24);*/

            }else if(opcion==2){ // Ver grafico de edades
                Frecuencia[] auxEdades = new Frecuencia[7]; 

                if(alumnos.isEmpty()){
                    JOptionPane.showMessageDialog(frame, "¡El registro de alumnos está vacío! No se puede generar el histograma.");
                    continue;
                }

                try{
                    int index = 0;
                    for(int i=18; i<=24; i++){
                        int occurrences = Collections.frequency(alumnos.values(), i);
                        auxEdades[index] = new Frecuencia(i,occurrences);
                        index++;
                    }
                    Histograma histogramHeight = new Histograma();
                    histogramHeight.creaHistogramas(auxEdades,"Edades Registradas");
                }catch(Exception e){
                    JOptionPane.showMessageDialog(frame, "Hubo un error creando el histograma, revise que haya al menos 1 alumno registrado.");
                }

                
            }else if(opcion==3){ // Ver grafico de edades ordenado

                if(alumnos.isEmpty()){
                    JOptionPane.showMessageDialog(frame, "¡El registro de alumnos está vacío! No se puede generar el histograma.");
                    continue;
                }

                try{
                    int index = 0;
                    for(int i=18; i<=24; i++){
                        int occurrences = Collections.frequency(alumnos.values(), i);
                        auxUno[index] = new Frecuencia(i,occurrences);
                        index++;
                    }
                    bubbleSort(auxUno, auxUno.length);
                    //System.out.println("El largo de frecuencia en main: "+auxUno.length);
                    Histograma histogramHeight = new Histograma();
                    histogramHeight.creaHistogramas(auxUno,"Edades Ordenadas por Frecuencias");
                }catch(Exception e){
                    JOptionPane.showMessageDialog(frame, "Hubo un error creando el histograma, revise que haya al menos 1 alumno registrado.");
                }

            }else if(opcion==4){
                try{
                    System.out.println(a.toString());
                    JOptionPane.showMessageDialog(frame, a.toString());
                }catch(Exception e){
                    JOptionPane.showMessageDialog(frame, "Hubo un error creando el árbol de inserciones, revise que haya al menos 1 alumno registrado.");
                }
            }else if(opcion==5){
                break;
            }else{
                JOptionPane.showMessageDialog(frame, "Esa opción no está diponible, por favor selecciona una opción válida.");
            }
        }
    }
}



